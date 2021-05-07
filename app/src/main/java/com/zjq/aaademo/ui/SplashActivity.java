package com.zjq.aaademo.ui;

import android.content.Intent;
import android.os.Bundle;

import com.zjq.aaademo.BaseActivity;
import com.zjq.aaademo.R;
import com.zjq.aaademo.tools.StatusBarUtil;

import me.wangyuwei.particleview.ParticleView;

public class SplashActivity extends BaseActivity {

    private ParticleView particleView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        StatusBarUtil.setTranslucentForCoordinatorLayout(this,0);
        particleView = findViewById(R.id.particleview);
        particleView.startAnim();
        particleView.setOnParticleAnimListener(new ParticleView.ParticleAnimListener() {
            @Override
            public void onAnimationEnd() {
                startActivity(new Intent(SplashActivity.this,MainActivity.class));
            }
        });
    }
}
