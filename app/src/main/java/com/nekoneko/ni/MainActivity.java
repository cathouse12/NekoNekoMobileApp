package com.nekoneko.ni;

import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

import com.roughike.bottombar.BottomBar;
import com.roughike.bottombar.OnTabSelectListener;

public class MainActivity extends AppCompatActivity {

    private MapFragment mapFragment;
    private StarFragment starFragment;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mapFragment = new MapFragment();
        starFragment = new StarFragment();

        initFragment();

        BottomBar bottomBar = findViewById(R.id.bottomBar);
        bottomBar.setOnTabSelectListener(new OnTabSelectListener() {
            @Override
            public void onTabSelected(@IdRes int tabId) {
                FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();

                if (tabId == R.id.tab_star)
                    transaction.replace(R.id.contentContainer, mapFragment).commit();
                else if (tabId == R.id.tab_locate)
                    transaction.replace(R.id.contentContainer, starFragment).commit();
            }

        });
    }

    /*
     App 실행시 보여지는 Fragment 설정.
    */
    public void initFragment() {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.add(R.id.contentContainer, starFragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }
}
