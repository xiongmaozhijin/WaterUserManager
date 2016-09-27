package cn.tofly.mis.waterusermanager.common.ui.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.FrameLayout;

import cn.tofly.mis.waterusermanager.R;
import in.srain.cube.views.ptr.PtrFrameLayout;
import in.srain.cube.views.ptr.PtrUIHandler;
import in.srain.cube.views.ptr.indicator.PtrIndicator;

/**
 * Created by hasee on 2016/8/22.
 */
public class InfoPtrHeader extends FrameLayout implements PtrUIHandler {

    RorationView mHeaderView;

    public InfoPtrHeader(Context context) {
        super(context);
        initView(context);
    }


    public InfoPtrHeader(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public InfoPtrHeader(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    private void initView(Context context) {
        LayoutInflater.from(context).inflate(R.layout.layout_ptr_header, this, true);
        mHeaderView = (RorationView) findViewById(R.id.ptrHeaderView);
    }

    @Override
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        if (layoutParams != null) {
            layoutParams.width = ViewGroup.LayoutParams.MATCH_PARENT;
            layoutParams.height = ViewGroup.LayoutParams.WRAP_CONTENT;
            setLayoutParams(layoutParams);
        }
    }

    @Override
    public void onUIReset(PtrFrameLayout frame) {
        if (mHeaderView != null) {
            mHeaderView.stopAnim();
        }
    }

    @Override
    public void onUIRefreshPrepare(PtrFrameLayout frame) {
        if (mHeaderView != null) {
            mHeaderView.stopAnim();
        }
    }

    @Override
    public void onUIRefreshBegin(PtrFrameLayout frame) {
        if (mHeaderView != null) {
            mHeaderView.startAnim();
        }
    }

    @Override
    public void onUIRefreshComplete(PtrFrameLayout frame) {
        if (mHeaderView != null) {
            mHeaderView.stopAnim();
        }
    }

    @Override
    public void onUIPositionChange(PtrFrameLayout frame, boolean isUnderTouch, byte status, PtrIndicator ptrIndicator) {

    }
}
