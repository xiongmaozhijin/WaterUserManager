package cn.tofly.mis.waterusermanager.data.local.dbbiz;

import java.util.List;

import cn.tofly.mis.waterusermanager.data.local.daoimpl.TbTestDAOImpl;
import cn.tofly.mis.waterusermanager.data.local.gendao.TbTest;

/**
 * Created by hasee on 2016/10/8.
 */
public class DbTestBiz implements IDbBiz {

    private TbTestDAOImpl mDAOImpl;

    public DbTestBiz(TbTestDAOImpl daoImpl) {
        this.mDAOImpl = daoImpl;
    }

    //处理具体DB业务
    public long insert(TbTest item) {
        return mDAOImpl.insert(item);
    }

    public List<TbTest> loadAll() {
        return mDAOImpl.loadAll();
    }


}
