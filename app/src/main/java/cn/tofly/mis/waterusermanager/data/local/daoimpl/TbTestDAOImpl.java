package cn.tofly.mis.waterusermanager.data.local.daoimpl;

import java.util.List;

import cn.tofly.mis.waterusermanager.data.local.gendao.DaoSession;
import cn.tofly.mis.waterusermanager.data.local.gendao.TbTest;
import cn.tofly.mis.waterusermanager.data.local.gendao.TbTestDao;

/**
 * 可以这样实现
 * 也可以根据需要实现为<b>RxJava</b>的形式<br/>
 * Created by baoxing on 2016/9/27.
 */
public class TbTestDAOImpl implements IDbCurl<TbTest, Long> {

    private TbTestDao mDAO;

    public TbTestDAOImpl(DaoSession daoSession) {
        this.mDAO = daoSession.getTbTestDao();
    }


    @Override
    public long insert(TbTest item) {
        return mDAO.insert(item);
    }

    @Override
    public long update(TbTest item) {
        mDAO.update(item);
        return 0;
    }

    @Override
    public long insertOrReplace(TbTest item) {
        return mDAO.insertOrReplace(item);
    }

    @Override
    public long delete(TbTest item) {
        mDAO.delete(item);
        return 0;
    }

    @Override
    public TbTest load(Long key) {
        return mDAO.load(key);
    }

    @Override
    public List<TbTest> loadAll() {
        return mDAO.loadAll();
    }

}
