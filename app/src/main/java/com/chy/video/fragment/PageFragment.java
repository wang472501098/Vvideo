package com.chy.video.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.chy.video.R;
import com.chy.video.adapter.TestAdapter;
import com.chy.video.widget.GridSpacingItemDecoration;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 47250 on 2017/7/19.
 */
public class PageFragment extends Fragment {
    public static final String ARG_PAGE = "ARG_PAGE";
    private int mPage;
    RecyclerView rvHomeList;
    private TestAdapter testAdapter;
    public static PageFragment newInstance(int page) {
        Bundle args = new Bundle();
        args.putInt(ARG_PAGE, page);
        PageFragment pageFragment = new PageFragment();
        pageFragment.setArguments(args);
        return pageFragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mPage = getArguments().getInt(ARG_PAGE);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment1_layout, container, false);
        rvHomeList=(RecyclerView)view.findViewById(R.id.rv_HomeList);
        initView();
        return view;
    }
    private void initView() {
        testAdapter = new TestAdapter(getActivity());
        GridLayoutManager mgr = new GridLayoutManager(getActivity(), 3);
        rvHomeList.setLayoutManager(mgr);
        // mChooseImageAdapter.setmMyItemClickListener(this);
        rvHomeList.addItemDecoration(new GridSpacingItemDecoration(3,18,true));
        rvHomeList.setAdapter(testAdapter);
        List<String> list=new ArrayList<>();
        list.add(mPage+"");
        list.add(mPage+"");
        list.add(mPage+"");
        list.add(mPage+"");
        list.add(mPage+"");
        list.add(mPage+"");
        list.add(mPage+"");
        list.add(mPage+"");
        list.add(mPage+"");
        list.add(mPage+"");
        testAdapter.setImageViewData(list);

    }

}
