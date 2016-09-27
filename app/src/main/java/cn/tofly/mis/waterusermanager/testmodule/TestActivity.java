package cn.tofly.mis.waterusermanager.testmodule;

import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.google.gson.Gson;

import junit.framework.Test;

import javax.inject.Inject;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import cn.tofly.mis.waterusermanager.App;
import cn.tofly.mis.waterusermanager.R;
import cn.tofly.mis.waterusermanager.common.tools.ActivityUtils;
import cn.tofly.mis.waterusermanager.common.tools.LogUtils;
import cn.tofly.mis.waterusermanager.common.tools.SharedPrefUtils;
import cn.tofly.mis.waterusermanager.common.ui.BaseActivity;
import cn.tofly.mis.waterusermanager.data.entity.CheckCoder;
import cn.tofly.mis.waterusermanager.data.remote.IExampleNetService;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.schedulers.Schedulers;

public class TestActivity extends BaseActivity {

    private static final String TAG = "TestActivity";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);

        ButterKnife.bind(this);

        //set up the toolbar
        setUpToolbar();
        setUpFragment();
        restoreData(savedInstanceState);
    }

    private void restoreData(Bundle savedInstanceState) {
        if (savedInstanceState != null) {

        }
    }

    @Override
    public void onSaveInstanceState(Bundle outState, PersistableBundle outPersistentState) {
        super.onSaveInstanceState(outState, outPersistentState);

    }



    private void setUpFragment() {
        TestFragment fragment = (TestFragment) getSupportFragmentManager().findFragmentById(R.id.fragment_container);
        if (fragment == null) {
            fragment = TestFragment.newInstance();
            ActivityUtils.addFragmentToActivity(getSupportFragmentManager(), fragment, R.id.fragment_container);
        }
    }

    private void setUpToolbar() {

    }


}
