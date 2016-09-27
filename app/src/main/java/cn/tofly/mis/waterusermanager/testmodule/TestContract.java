package cn.tofly.mis.waterusermanager.testmodule;

import cn.tofly.mis.waterusermanager.common.ui.BasePresenter;
import cn.tofly.mis.waterusermanager.common.ui.BaseViewOperation;
import cn.tofly.mis.waterusermanager.data.entity.CheckCoder;

/**
 * Created by baoxing on 2016/9/26.
 */
public interface TestContract {

    /**
     * ui 响应回调
     */
    interface View extends BaseViewOperation {
        void showCoders(String info);

        void showWriteDbInfo(String info);
    }

    /**
     * 处理具体逻辑
     */
    interface Presenter extends BasePresenter {
        void loadCheckCoders();
        void insertDbItem();
        void loadDbItem();
    }

}
