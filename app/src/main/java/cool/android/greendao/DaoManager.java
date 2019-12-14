package cool.android.greendao;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import org.greenrobot.greendao.database.Database;

import cool.camerax.noteclockproject.base.CCApplication;


public class DaoManager {

    private DaoMaster mDaoMaster;
    private DaoSession mDaoSession;
    private static volatile DaoManager mInstance = null;
    public static final String DATABASE_NAME = "websocketclient-db";

    private DaoManager(Context context) {
        AppOpenHelper helper = new AppOpenHelper(CCApplication.getInstance().getApplicationContext(), DATABASE_NAME);
        Database db = helper.getWritableDb();
        mDaoMaster = new DaoMaster(db);
        mDaoSession = mDaoMaster.newSession();
    }

    public static DaoManager getInstance(Context context) {
        if (mInstance == null) {
            synchronized (DaoManager.class) {
                if (mInstance == null) {
                    mInstance = new DaoManager(context);
                }
            }
        }
        return mInstance;
    }

    public DaoMaster getMaster() {
        return mDaoMaster;
    }

    public DaoSession getSession() {
        return mDaoSession;
    }

    public DaoSession getNewSession() {
        mDaoSession = mDaoMaster.newSession();
        return mDaoSession;
    }

    private static class AppOpenHelper extends DaoMaster.OpenHelper {

        public AppOpenHelper(Context context, String name) {
            super(context, name);
        }

        public AppOpenHelper(Context context, String name, SQLiteDatabase.CursorFactory factory) {
            super(context, name, factory);
        }

        @Override
        public void onUpgrade(Database db, int oldVersion, int newVersion) {
            DaoSession daoSession = new DaoMaster(db).newSession();

            // TODO: do something before recreate tables
            DaoMaster.dropAllTables(db, true);
            onCreate(db);
        }

        @Override
        public void onCreate(Database db) {
            Log.i("greenDAO", "Creating tables for schema version " + DaoMaster.SCHEMA_VERSION);
            DaoMaster.createAllTables(db, true);
        }
    }
}

