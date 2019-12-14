package cool.camerax.noteclockproject.utils;

import android.content.Context;

import java.util.List;

import cool.android.greendao.DaoManager;
import cool.android.greendao.NoteBeanDao;
import cool.camerax.noteclockproject.bean.NoteBean;


public class DBNoteUtils {

    private NoteBeanDao diaryBeanDao;
    private static DBNoteUtils dbDiaryUtils = null;

    public DBNoteUtils(Context context) {
        diaryBeanDao = DaoManager.getInstance(context).getNewSession().getNoteBeanDao();
    }

    public static DBNoteUtils getInstance() {
        return dbDiaryUtils;
    }

    public static void Init(Context context) {
        if (dbDiaryUtils == null) {
            dbDiaryUtils = new DBNoteUtils(context);
        }
    }

    /**
     * 完成对数据库中插入一条数据操作
     */
    public void insertOneData(NoteBean dbUserInvestment) {
        diaryBeanDao.insertOrReplace(dbUserInvestment);
    }

    /**
     * 完成对数据库中插入多条数据操作
     */
    public boolean insertManyData(List<NoteBean> dbUserInvestmentList) {
        boolean flag = false;
        try {
            diaryBeanDao.insertOrReplaceInTx(dbUserInvestmentList);
            flag = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return flag;
    }

    /**
     * 完成对数据库中删除一条数据操作
     */
    public boolean deleteOneData(NoteBean dbUserInvestment) {
        boolean flag = false;
        try {
            diaryBeanDao.delete(dbUserInvestment);
            flag = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return flag;
    }

    public boolean deleteAllData() {
        boolean flag = false;
        try {
            diaryBeanDao.deleteAll();
            flag = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return flag;
    }

    /**
     * 完成对数据库中删除一条数据 ByKey操作
     */
    public boolean deleteOneDataByKey(long id) {
        boolean flag = false;
        try {
            diaryBeanDao.deleteByKey(id);
            flag = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return flag;
    }

    /**
     * 完成对数据库中批量删除数据操作
     */
    public boolean deleteManData(List<NoteBean> dbUserInvestmentList) {
        boolean flag = false;
        try {
            diaryBeanDao.deleteInTx(dbUserInvestmentList);
            flag = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return flag;
    }

    /**
     * 完成对数据库更新数据操作
     */
    public boolean updateData(NoteBean dbUserInvestment) {
        boolean flag = false;
        try {
            diaryBeanDao.update(dbUserInvestment);
            flag = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return flag;
    }

    /**
     * 完成对数据库批量更新数据操作
     */
    public boolean updateManData(List<NoteBean> dbUserInvestmentList) {
        boolean flag = false;
        try {
            diaryBeanDao.updateInTx(dbUserInvestmentList);
            flag = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return flag;
    }

    /**
     * 完成对数据库查询数据操作
     */
    public NoteBean queryOneData(long id) {
        return diaryBeanDao.load(id);
    }

    /**
     * 完成对数据库查询所有数据操作
     */
    public List<NoteBean> queryALLData() {
        return diaryBeanDao.loadAll();
    }
}

