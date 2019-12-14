package cool.camerax.noteclockproject.utils;

import android.os.AsyncTask;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.MessageQueue;
import android.os.Process;
import android.support.annotation.NonNull;

import java.util.concurrent.Executor;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ThreadExecutor {
    private static Handler mHandler;

    private static Executor mExecutor;

    private static HandlerThreadExt mDedicatedThread;

    private static Handler mDedicatedHandler;

    private static MessageQueue mQueue;

    static {
        Executor publicExecutor = AsyncTask.THREAD_POOL_EXECUTOR;
        mExecutor = publicExecutor;
        if (publicExecutor instanceof ThreadPoolExecutor) {
            ThreadPoolExecutor executor = (ThreadPoolExecutor) publicExecutor;
            executor.setRejectedExecutionHandler(new RejectedExecutionHandler() {
                @Override
                public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
                    executeDedicated(r);
                }
            });
        }
    }

    public static boolean isMainThread() {
        return Looper.getMainLooper() == Looper.myLooper();
    }

    /**
     * Get handler of dedicated background thread.
     */
    public static Handler getDedicatedHandler() {
        if (mDedicatedHandler == null || mDedicatedThread == null || !mDedicatedThread.isValid()) {
            initDedicatedThread();
        }
        return mDedicatedHandler;
    }

    private synchronized static void initDedicatedThread() {
        if (mDedicatedHandler == null || mDedicatedThread == null || !mDedicatedThread.isValid()) {
            final HandlerThreadExt dedicatedThread = new HandlerThreadExt("DedicatedThread", WorkThread.DEFAULT_PRIORITY);
            dedicatedThread.setUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler() {
                @Override
                public void uncaughtException(Thread t, Throwable e) {
                    try {
                        dedicatedThread.quit();
                        dedicatedThread.join();
                    } catch (Exception e1) {
                        e1.printStackTrace();
                    } finally {
                        dedicatedThread.invalidate();
                        initDedicatedThread();
                    }
                }
            });
            dedicatedThread.start();
            mDedicatedThread = dedicatedThread;
            mDedicatedHandler = new Handler(dedicatedThread.getLooper());
        }
    }

    /**
     * Execute serially on dedicated background thread.
     */
    public static void executeDedicated(Runnable runnable) {
        getDedicatedHandler().post(runnable);
    }

    /**
     * Execute a runnable.
     */
    public static void execute(Runnable task) {
        mExecutor.execute(task);
    }

    /**
     * Submit a runnable.
     *
     * @return a Future representing pending completion of the task
     */
    public static Future<?> submit(Runnable task) {
        FutureTask<?> futureTask = new FutureTask<>(task, null);
        execute(futureTask);
        return futureTask;
    }

    /**
     * Execute a runnable on UI thread.
     */
    public static void executeOnUI(Runnable task) {
        getHandler().post(task);
    }

    /**
     * Execute a runnable on UI thread after a specify time.
     *
     * @param delay Time in milliseconds to before execution.
     */
    public static void executeOnUIDelay(Runnable task, long delay) {
        getHandler().postDelayed(task, delay);
    }

    /**
     * Execute a runnable on UI thread after a specify time.
     *
     * @param delay Time in milliseconds to before execution.
     */
    public static void schedule(Runnable task, long delay) {
        schedule(task, delay, TimeUnit.MILLISECONDS);
    }

    /**
     * Execute a runnable on UI thread after a specify time.
     */
    public static void schedule(Runnable task, long delay, TimeUnit timeUnit) {
        getDedicatedHandler().postDelayed(task, timeUnit.toMillis(delay));
    }

    /**
     * This will be called on ui thread.
     */
    public static void executeWhenIdle(final Runnable task) {
        if (mQueue != null) {
            mQueue.addIdleHandler(new MessageQueue.IdleHandler() {
                @Override
                public boolean queueIdle() {
                    task.run();
                    return false;
                }
            });
        } else {
            if (isMainThread()) {
                mQueue = Looper.myQueue();
                executeWhenIdle(task);
                return;
            }
            getHandler().post(new Runnable() {
                @Override
                public void run() {
                    if (mQueue == null) {
                        mQueue = Looper.myQueue();
                    }
                    executeWhenIdle(task);
                }
            });
        }
    }

    public static void removeTask(Runnable task) {
        if ((mExecutor instanceof ThreadPoolExecutor)) {
            if (((ThreadPoolExecutor) mExecutor).remove(task)) {
                return;
            }
        }
        if (mHandler != null) {
            mHandler.removeCallbacks(task);
        }
        if (mDedicatedHandler != null) {
            mDedicatedHandler.removeCallbacks(task);
        }
    }

    public static void removeHandlerTask(Runnable task) {
        if (mHandler != null) {
            mHandler.removeCallbacks(task);
        }
    }

    public static Executor getExecutor() {
        return mExecutor;
    }

    public static Handler getHandler() {
        if (mHandler == null) {
            synchronized (ThreadExecutor.class) {
                if (mHandler == null) {
                    mHandler = new Handler(Looper.getMainLooper());
                }
            }
        }
        return mHandler;
    }

    public static class WorkThread extends Thread {

        public static final int DEFAULT_PRIORITY = Process.THREAD_PRIORITY_BACKGROUND + 2 * Process.THREAD_PRIORITY_MORE_FAVORABLE;

        private int mPriority = DEFAULT_PRIORITY;

        public WorkThread() {
        }

        public WorkThread(Runnable target) {
            super(target);
        }

        public WorkThread(ThreadGroup group, Runnable target) {
            super(group, target);
        }

        public WorkThread(@NonNull String name) {
            super(name);
        }

        public WorkThread(ThreadGroup group, @NonNull String name) {
            super(group, name);
        }

        public WorkThread(Runnable target, String name) {
            super(target, name);
        }

        public WorkThread(ThreadGroup group, Runnable target, @NonNull String name) {
            super(group, target, name);
        }

        public WorkThread(ThreadGroup group, Runnable target, @NonNull String name, long stackSize) {
            super(group, target, name, stackSize);
        }

        /**
         * Different from {@link Thread#setPriority(int)}, this method used to set priority for
         * Android platform. See {@link Process}.THREAD_PRIORITY_xxx for more information.
         */
        public void setThreadPriority(int priority) {
            mPriority = priority;
        }

        @Override
        public void run() {
            Process.setThreadPriority(mPriority);
            super.run();
        }
    }

    public static class HandlerThreadExt extends HandlerThread {
        private MessageQueue mQueue;

        public HandlerThreadExt(String name) {
            super(name);
        }

        public HandlerThreadExt(String name, int priority) {
            super(name, priority);
        }

        @Override
        protected void onLooperPrepared() {
            super.onLooperPrepared();
            mQueue = Looper.myQueue();
        }

        @Override
        public void run() {
            super.run();
            mQueue = null;
        }

        public MessageQueue getQueue() {
            return mQueue;
        }

        /**
         * Invalidate
         */
        public void invalidate() {
            mQueue = null;
        }

        public boolean isValid() {
            return mQueue != null;
        }

    }

}
