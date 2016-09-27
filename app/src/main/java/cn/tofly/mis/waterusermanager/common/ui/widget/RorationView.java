package cn.tofly.mis.waterusermanager.common.ui.widget;

import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView;

/**
 * Created by baoxing on 2016/8/4.
 */
public class RorationView extends ImageView {

    ObjectAnimator anim;

    public RorationView(Context context) {
        super(context);
    }

    public RorationView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public RorationView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }


    @Override
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        startAnim();
    }

    public void startAnim() {
        anim = ObjectAnimator.ofFloat(this, "rotation", 0, 359).setDuration(800);
        anim.setRepeatCount(ValueAnimator.INFINITE);
        anim.start();
    }

    public void stopAnim() {
        anim.setRepeatCount(1);
        anim.setDuration(1);
        anim.cancel();
    }


}

