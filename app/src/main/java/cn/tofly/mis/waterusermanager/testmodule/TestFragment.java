package cn.tofly.mis.waterusermanager.testmodule;


import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import javax.inject.Inject;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import cn.tofly.mis.waterusermanager.App;
import cn.tofly.mis.waterusermanager.R;
import cn.tofly.mis.waterusermanager.common.tools.LogUtils;
import cn.tofly.mis.waterusermanager.common.tools.SharedPrefUtils;
import cn.tofly.mis.waterusermanager.common.ui.BaseFragment;

/**
 * A simple {@link Fragment} subclass.
 */
public class TestFragment extends BaseFragment implements TestContract.View {

    @Inject
    TestPresenter mPresenter;

    @Inject
    SharedPrefUtils mSharedPrefUtils;

    @Bind(R.id.txv)
    TextView mTxv;


    private TestActivity mActivity;

    public TestFragment() {
    }


    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        this.mActivity = (TestActivity) activity;
    }

    public static TestFragment newInstance() {

        Bundle arguments = new Bundle();
        //...
        TestFragment fragment = new TestFragment();
        fragment.setArguments(arguments);

        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        // Inflate the layout for this fragment
        View inflate = inflater.inflate(R.layout.fragment_test, container, false);
        Activity activity = getActivity() == null ? mActivity : getActivity();

        ButterKnife.bind(this, inflate);
        DaggerTestComponent.builder().applicationComponent(((App) activity.getApplication()).getApplicationComponent()).testModule(new TestModule(this)).build().inject(this);

        return inflate;
    }


    @Override
    public void onResume() {
        super.onResume();
        mPresenter.onResume();
    }

    @OnClick(R.id.btn_read)
    void btnRead(View view) {
        LogUtils.w("xxx", "read()");
        String xxx = mSharedPrefUtils.getSharedPreferences().getString("xxx", "not setting");
        LogUtils.toastShortMsg(mActivity, xxx);

//        mPresenter.loadCheckCoders();
        mPresenter.loadDbItem();
    }

    @OnClick(R.id.btn_write)
    void btnWrite(View view) {
        LogUtils.w("xxx", "btnWrite()");
//        mSharedPrefUtils.save("xxx", "girl yessss");
        mPresenter.insertDbItem();
    }


    @Override
    public void showCoders(String info) {
        mTxv.setText(info);
    }

    @Override
    public void showWriteDbInfo(String info) {
        mTxv.setText(info);
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menu_edit:
                LogUtils.toastShortMsg(mActivity, "edit");

                return true;
            case R.id.menu_setting45:
                LogUtils.toastShortMsg(mActivity, "setting45");

                return true;
            case android.R.id.home:
                LogUtils.toastShortMsg(mActivity, "home");

                return true;
            default:
        }

        return false;
    }


    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.menu_test, menu);
    }


}
