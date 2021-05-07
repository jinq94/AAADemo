package com.zjq.aaademo.myview;

import android.app.ProgressDialog;
import android.content.Context;
import android.support.v4.view.ViewCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.animation.Animation;
import android.view.animation.Transformation;
import android.widget.RelativeLayout;

import com.zjq.aaademo.R;


/**
 * @author zjq
 */
public class SuccinctProgress {

    private static ProgressDialog pd;
    private static Animation mScaleDownToStartAnimation;
    private static View progressBar;
    static float mStartingScale;



    public static void showSuccinctProgress(Context context, boolean isCanceledOnTouchOutside, boolean isCancelable) {

        // 创建ProgressDialog对象
        pd = new ProgressDialog(context, R.style.succinctProgressDialog);
        // false 设置点击外边距不可取消,true 可取消
        pd.setCanceledOnTouchOutside(isCanceledOnTouchOutside);
        // 设置点击back键不可取消
        pd.setCancelable(isCancelable);
        // 加载自定义的ProgressDialog
        RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(
                LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
        View view = LayoutInflater.from(context).inflate(
                R.layout.succinct_progress_content, null);
        progressBar = view.findViewById(R.id.progress_dialog);
        // 显示
        pd.show();
        // 必须先显示，在设置自定义的View
        pd.setContentView(view, params);
        if (mScaleDownToStartAnimation == null) {
            setAnim();
        }
    }

    /**
     * @return true即现实中，false为不在显示
     */
    public static boolean isShowing() {

        return pd != null && pd.isShowing();

    }

    /**
     * 取消Dialog
     */
    public static void dismiss() {
        if (isShowing()) {
            progressBar.startAnimation(mScaleDownToStartAnimation);

        }

    }


    static void setAnim() {
        mStartingScale = 1.0f;
        mScaleDownToStartAnimation = new Animation() {
            @Override
            public void applyTransformation(float interpolatedTime, Transformation t) {
                float targetScale = (mStartingScale + (-mStartingScale * interpolatedTime));
                setAnimationProgress(targetScale);
            }
        };
        mScaleDownToStartAnimation.setDuration(150);

        mScaleDownToStartAnimation.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                pd.dismiss();
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
    }

    static void setAnimationProgress(float progress) {
        ViewCompat.setScaleX(progressBar, progress);
        ViewCompat.setScaleY(progressBar, progress);

    }
}
