package com.zjq.aaademo.ui;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.view.MenuItem;

import com.zjq.aaademo.BaseActivity;
import com.zjq.aaademo.R;

public class MainActivity extends BaseActivity {

    private BottomNavigationView menu_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        menu_btn = findViewById(R.id.menu_btn);
        menu_btn.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.navigation_one:
                    break;
                    case R.id.navigation_two:
                        break;
                    case R.id.navigation_three:
                        break;
                }
                return true;
            }
        });
    }
}
