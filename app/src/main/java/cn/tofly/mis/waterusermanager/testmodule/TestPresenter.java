package cn.tofly.mis.waterusermanager.testmodule;

import java.util.List;

import cn.tofly.mis.waterusermanager.common.tools.LogUtils;
import cn.tofly.mis.waterusermanager.data.entity.CheckCoder;
import cn.tofly.mis.waterusermanager.data.local.DBInstance;
import cn.tofly.mis.waterusermanager.data.local.gendao.TbTest;
import cn.tofly.mis.waterusermanager.data.remote.IExampleNetService;
import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

/**
 * Created by hasee on 2016/9/26.
 */
public class TestPresenter implements TestContract.Presenter {

    private TestContract.View mView;

    private IExampleNetService mService;

    private DBInstance mDbInstance;

    public TestPresenter(TestContract.View view, IExampleNetService service, DBInstance dbInstance) {
        this.mView = view;
        this.mService = service;
        this.mDbInstance = dbInstance;
    }

    @Override
    public void loadCheckCoders() {
        LogUtils.w("xxx", "loadCheckCoders()");

        mService.getCby("getYqlbList")
                .doOnNext(new Action1<CheckCoder>() {
                    @Override
                    public void call(CheckCoder checkCoder) {
                        try {
                            Thread.sleep(3000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();

                        }
                    }
                })
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<CheckCoder>() {
                    @Override
                    public void onCompleted() {
//                        mView.showCoders("onCompleted");
                    }

                    @Override
                    public void onError(Throwable e) {
                        LogUtils.e("TAG", "error");
                        mView.showCoders(e.getLocalizedMessage());
                        e.printStackTrace();
                    }

                    @Override
                    public void onNext(CheckCoder checkCoder) {
                        mView.showCoders(checkCoder.toString());
                    }
                });
    }

    @Override
    public void insertDbItem() {
        if (mDbInstance == null ){
            throw new RuntimeException("mDbInstance null");
        }

        if (mDbInstance.getTbTestDAO() == null) {
            throw new RuntimeException("DAO null");
        }

        mDbInstance.getTbTestDAO().insert(new TbTest(null, "hell girl" + System.currentTimeMillis()));
    }

    @Override
    public void loadDbItem() {
        Observable.from(mDbInstance.getTbTestDAO().loadAll())
                .toList()
                .map(new Func1<List<TbTest>, String>() {
                    @Override
                    public String call(List<TbTest> tbTests) {
                        String info = "";
                        info += "size = " + tbTests.size() + "\n";
                        for (TbTest item : tbTests) {
                            info += "id=" + item.getTestId() + "\tcontent=" + item.getContent() + " \n";

                        }

                        return info;
                    }
                })
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<String>() {
                    @Override
                    public void onCompleted() {
                        LogUtils.w("xxx", "onCompleted()");
                    }

                    @Override
                    public void onError(Throwable e) {
                        e.printStackTrace();
                        mView.showWriteDbInfo(e.getLocalizedMessage());
                    }

                    @Override
                    public void onNext(String s) {
                        mView.showWriteDbInfo(s);
                    }
                });

    }


    @Override
    public void onResume() {
        LogUtils.w("xxx", "onResume()");
    }

}
