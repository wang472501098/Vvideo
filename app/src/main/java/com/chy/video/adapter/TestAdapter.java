package com.chy.video.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;


import com.chy.video.R;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;


/**
 * Created by 47250 on 2017/6/23.
 */
public class TestAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private Context mContext;
    private MyItemClickListener mMyItemClickListener;
    private List<String> mSweepRecordList;

    public TestAdapter(Context context) {
        this.mContext = context;
        mSweepRecordList = new ArrayList<>();
    }

    public void setmMyItemClickListener(MyItemClickListener mMyItemClickListener) {
        this.mMyItemClickListener = mMyItemClickListener;
    }

    public void setImageViewData(List<String> sweepRecordList) {
        mSweepRecordList.clear();
        mSweepRecordList.addAll(sweepRecordList);
        notifyItemRangeChanged(1, mSweepRecordList.size());
    }


    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.adapter_sweep_record_item, null);
        return new ImageViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        onBindImageViewHolder((ImageViewHolder) holder, position);
    }

    private void onBindImageViewHolder(ImageViewHolder holder, final int position) {
        WindowManager wm = (WindowManager) mContext.getSystemService(Context.WINDOW_SERVICE);
        int width = wm.getDefaultDisplay().getWidth();
        ViewGroup.LayoutParams lp;
        lp = holder.imageView.getLayoutParams();
        lp.width = width / 3;
        lp.height = width / 2;
        holder.imageView.setImageResource(R.mipmap.tab1_001);
    }

    @Override
    public int getItemCount() {
        return mSweepRecordList.size();
    }


    public class ImageViewHolder extends RecyclerView.ViewHolder {
        @Bind(R.id.iv)
        ImageView imageView;


        public ImageViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

    public interface MyItemClickListener {
        void onImageItemClick(View view, String path);

    }
}
