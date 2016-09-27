package cn.tofly.mis.waterusermanager.testmodule;

import android.app.Activity;
import android.content.Context;

import cn.tofly.mis.waterusermanager.R;
import cn.tofly.mis.waterusermanager.common.ui.widget.InfoPtrHeader;
import in.srain.cube.views.ptr.PtrClassicFrameLayout;
import in.srain.cube.views.ptr.PtrDefaultHandler;
import in.srain.cube.views.ptr.PtrFrameLayout;
import in.srain.cube.views.ptr.header.MaterialHeader;
import in.srain.cube.views.ptr.util.PtrLocalDisplay;

/**
 * Created by hasee on 2016/9/27.
 */
public class Dump {

    /**
     * 常规下拉
     *
     * @param context
     * @param activity
     */
    void refresh(Context context, Activity activity) {
        final PtrFrameLayout mPtrFrameLayout = (PtrFrameLayout) activity.findViewById(R.id.material_style_ptr_frame);

        // header
        final MaterialHeader header = new MaterialHeader(context);
        int[] colors = context.getResources().getIntArray(R.array.google_colors);
        header.setColorSchemeColors(colors);
        header.setLayoutParams(new PtrFrameLayout.LayoutParams(-1, -2));
        header.setPadding(0, PtrLocalDisplay.dp2px(15), 0, PtrLocalDisplay.dp2px(10));
        header.setPtrFrameLayout(mPtrFrameLayout);

        mPtrFrameLayout.setLoadingMinTime(1000);
        mPtrFrameLayout.setDurationToCloseHeader(1500);
        mPtrFrameLayout.setHeaderView(header);
        mPtrFrameLayout.addPtrUIHandler(header);

        mPtrFrameLayout.setPtrHandler(new PtrDefaultHandler() {
            @Override
            public void onRefreshBegin(PtrFrameLayout frame) {

            }
        });
    }

    /**
     * 自定义头部
     *
     * @param context
     * @param activity
     * @param mPtr
     */
    void refresh2(Context context, Activity activity, PtrClassicFrameLayout mPtr) {
        InfoPtrHeader header = new InfoPtrHeader(activity);
        mPtr.setHeaderView(header);
        mPtr.addPtrUIHandler(header);

        mPtr.setPtrHandler(new PtrDefaultHandler() {
            @Override
            public void onRefreshBegin(PtrFrameLayout frame) {
                //load data
//                loadData();
            }
        });
    }


}
