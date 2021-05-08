package com.zjq.aaademo.ui.menu;

import android.app.Fragment;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.view.MenuItem;

import com.zjq.aaademo.BaseActivity;
import com.zjq.aaademo.R;

public class MainActivity extends BaseActivity {

    private BottomNavigationView menu_btn;
    private FragmentTransaction transaction;
    private Fragment_one myFragment1;
    private Fragment_two myFragment2;
    private Fragment_three myFragment3;
    private Fragment oldFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        transaction = getFragmentManager().beginTransaction();
        myFragment1 = new Fragment_one();
        myFragment2 = new Fragment_two();
        myFragment3 = new Fragment_three();
        transaction.replace(R.id.fragment, myFragment1);
        oldFragment = myFragment1;
        transaction.commit();


        menu_btn = findViewById(R.id.menu_btn);
        menu_btn.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.navigation_one:
                        showFragment(myFragment1);
                        break;
                    case R.id.navigation_two:
                        showFragment(myFragment2);
                        break;
                    case R.id.navigation_three:
                        showFragment(myFragment3);
                        break;
                }
                return true;
            }
        });
    }

    void showFragment(Fragment fragment) {
        transaction = getFragmentManager().beginTransaction();
        if (fragment != oldFragment) {
            if (!fragment.isAdded()) {
                transaction.hide(oldFragment).add(R.id.fragment, fragment);
            } else {
                transaction.hide(oldFragment).show(fragment);
            }
            transaction.commit();
        }
        oldFragment = fragment;
    }
}
