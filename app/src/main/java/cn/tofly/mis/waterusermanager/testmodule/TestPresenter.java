package cn.tofly.mis.waterusermanager.testmodule;

import javax.inject.Inject;

import cn.tofly.mis.waterusermanager.common.tools.LogUtils;
import cn.tofly.mis.waterusermanager.common.ui.BasePresenter;
import cn.tofly.mis.waterusermanager.data.entity.CheckCoder;
import cn.tofly.mis.waterusermanager.data.remote.IExampleNetService;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.schedulers.Schedulers;

/**
 * Created by hasee on 2016/9/26.
 */
public class TestPresenter implements TestContract.Presenter {


    private TestContract.View mView;

    private IExampleNetService mIExampleNetService;

    public TestPresenter(TestContract.View view, IExampleNetService service) {
        this.mView = view;
        this.mIExampleNetService = service;
    }

    @Override
    public void loadCheckCoders() {
        LogUtils.w("xxx", "loadCheckCoders()");

        mIExampleNetService.getCby("getYqlbList")
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


}
