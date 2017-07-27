package com.chy.video.ui;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;

import com.chy.video.R;
import com.chy.video.adapter.SimpleFragmentPagerAdapter;

/**
 * Created by 47250 on 2017/7/19.
 */
public class HomeActivity  extends FragmentActivity {
    TabLayout mTabLayout;
    ViewPager pagerAdapter;
    private SimpleFragmentPagerAdapter fAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        initTableLayout();
    }

    /**
     * 初始化各控件
     */
    private void initTableLayout() {
        fAdapter = new SimpleFragmentPagerAdapter(getSupportFragmentManager());
        pagerAdapter = (ViewPager) findViewById(R.id.vp_pager);
        pagerAdapter.setAdapter(fAdapter);
        mTabLayout = (TabLayout) findViewById(R.id.tabLayout);
        mTabLayout.setupWithViewPager(pagerAdapter);
      //  mTabLayout.setTabMode(TabLayout.MODE_SCROLLABLE);
    }

}
