package com.chy.video.ui;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.widget.LinearLayout;

import com.ashokvarma.bottomnavigation.BottomNavigationBar;
import com.ashokvarma.bottomnavigation.BottomNavigationItem;
import com.chy.video.R;
import com.chy.video.fragment.Fragment1;
import com.chy.video.fragment.Fragment2;
import com.chy.video.fragment.Fragment3;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by 47250 on 2017/7/25.
 */
public class HActivity extends FragmentActivity implements BottomNavigationBar.OnTabSelectedListener {
    @Bind(R.id.tb)
    LinearLayout tb;
    @Bind(R.id.bottom_navigation_bar)
    BottomNavigationBar bottomNavigationBar;
    private Fragment1 fragment1;
    private Fragment2 fragment2;
    private Fragment3 fragment3;
    int lastSelectedPosition = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_h);
        ButterKnife.bind(this);
        bottomNavigationBar = (BottomNavigationBar) findViewById(R.id.bottom_navigation_bar);

        bottomNavigationBar
                .addItem(new BottomNavigationItem(R.mipmap.ic_launcher, "位置").setActiveColor(R.color.colorAccent))
                .addItem(new BottomNavigationItem(R.mipmap.ic_launcher, "发现").setActiveColor(R.color.colorAccent))
                .addItem(new BottomNavigationItem(R.mipmap.ic_launcher, "爱好").setActiveColor(R.color.colorAccent))
                .setFirstSelectedPosition(lastSelectedPosition)
                .initialise();

        bottomNavigationBar.setTabSelectedListener(this);
        setDefaultFragment();
    }

    /**
     * 设置默认的
     */
    private void setDefaultFragment() {
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction transaction = fm.beginTransaction();
        fragment1 = Fragment1.newInstance("位置");
        transaction.replace(R.id.tb, fragment1);
        transaction.commit();
    }

    @Override
    public void onTabSelected(int position) {
        FragmentManager fm = this.getSupportFragmentManager();
        //开启事务
        FragmentTransaction transaction = fm.beginTransaction();
        switch (position) {
            case 0:
                if (fragment1 == null) {
                    fragment1 = Fragment1.newInstance("位置");
                }
                transaction.replace(R.id.tb, fragment1);
                break;
            case 1:
                if (fragment2 == null) {
                    fragment2 = Fragment2.newInstance("发现");
                }
                transaction.replace(R.id.tb, fragment2);
                break;
            case 2:
                if (fragment3 == null) {
                    fragment3 = Fragment3.newInstance("爱好");
                }
                transaction.replace(R.id.tb, fragment3);
                break;
            default:
                break;
        }
        // 事务提交
        transaction.commit();
    }

    @Override
    public void onTabUnselected(int position) {

    }

    @Override
    public void onTabReselected(int position) {

    }
}
