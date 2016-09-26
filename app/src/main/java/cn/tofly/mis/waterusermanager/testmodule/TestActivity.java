package cn.tofly.mis.waterusermanager.testmodule;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import javax.inject.Inject;

import butterknife.ButterKnife;
import butterknife.OnClick;
import cn.tofly.mis.waterusermanager.App;
import cn.tofly.mis.waterusermanager.R;
import cn.tofly.mis.waterusermanager.common.tools.LogUtils;
import cn.tofly.mis.waterusermanager.common.tools.SharedPrefUtils;

public class TestActivity extends AppCompatActivity {

    private static final String TAG = "TestActivity";

    @Inject
    SharedPrefUtils mSharedPrefUtils;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);

        ButterKnife.bind(this);

        DaggerTestComponent.builder().applicationComponent( ((App) getApplication() ).getApplicationComponent()).build().inject(this);
    }

    @OnClick(R.id.btn_read)
    void btnRead(View view) {
        LogUtils.w(TAG, "read.");
        String xxx = mSharedPrefUtils.getSharedPreferences().getString("xxx", "not set");
        LogUtils.toastShortMsg(this, xxx);
    }

    @OnClick(R.id.btn_write)
    void btnWrite(View view) {
        LogUtils.w(TAG, "btnWrite.");
        mSharedPrefUtils.save("xxx", "settttttttt girl");
    }


}
