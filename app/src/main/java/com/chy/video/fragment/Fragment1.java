package com.chy.video.fragment;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.chy.video.R;
import com.chy.video.adapter.SimpleFragmentPagerAdapter;

/**
 * Created by 47250 on 2017/7/25.
 */
public class Fragment1 extends Fragment {
    private String TAG="Fragment1";
    TabLayout mTabLayout;
    ViewPager pagerAdapter;
    private SimpleFragmentPagerAdapter fAdapter;

    public static Fragment1 newInstance(String param1) {
        Fragment1 fragment = new Fragment1();
        Bundle args = new Bundle();
        args.putString("agrs1", param1);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_1, container, false);
        Log.e(TAG,"onCreateView");
        initTableLayout(view);
        return view;
    }

    /**
     * 初始化各控件
     */
    private void initTableLayout(View view) {
        fAdapter = new SimpleFragmentPagerAdapter(getActivity().getSupportFragmentManager());
        pagerAdapter = (ViewPager) view.findViewById(R.id.vp_pager);
        pagerAdapter.setAdapter(fAdapter);
        mTabLayout = (TabLayout) view.findViewById(R.id.tabLayout);
        mTabLayout.setupWithViewPager(pagerAdapter);
        //  mTabLayout.setTabMode(TabLayout.MODE_SCROLLABLE);
    }
}
