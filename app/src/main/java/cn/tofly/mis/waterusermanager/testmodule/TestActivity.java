package cn.tofly.mis.waterusermanager.testmodule;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.google.gson.Gson;

import javax.inject.Inject;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import cn.tofly.mis.waterusermanager.App;
import cn.tofly.mis.waterusermanager.R;
import cn.tofly.mis.waterusermanager.common.tools.LogUtils;
import cn.tofly.mis.waterusermanager.common.tools.SharedPrefUtils;
import cn.tofly.mis.waterusermanager.common.ui.BaseActivity;
import cn.tofly.mis.waterusermanager.data.entity.CheckCoder;
import cn.tofly.mis.waterusermanager.data.remote.IExampleNetService;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.schedulers.Schedulers;

public class TestActivity extends BaseActivity implements TestContract.View{

    private static final String TAG = "TestActivity";

    @Inject
    SharedPrefUtils mSharedPrefUtils;

    @Inject
    IExampleNetService mIExampleNetService;

    @Bind(R.id.txv)
    TextView mTxv;

    @Inject
    TestPresenter mTestPresenter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);

        ButterKnife.bind(this);

        DaggerTestComponent.builder().applicationComponent(((App) getApplication()).getApplicationComponent()).testModule(new TestModule(this)).build().inject(this);
    }

    void dump() {
        Gson gson = new Gson();
    }

    @OnClick(R.id.btn_read)
    void btnRead(View view) {
        LogUtils.w(TAG, "read.");
        mTestPresenter.loadCheckCoders();

    }

    @OnClick(R.id.btn_write)
    void btnWrite(View view) {
        LogUtils.w(TAG, "btnWrite.");
        mSharedPrefUtils.save("xxx", "settttttttt girl");
    }


    @Override
    public void showCoders(String item) {
        mTxv.setText(item);

    }
}
