package com.mdw.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.mdw.ui.R;

import java.util.List;

/**
 * Created by Administrator on 2016/8/5.
 */
public class MyRecyclerViewAdapter extends RecyclerView.Adapter<MyRecyclerViewAdapter.MyViewHodler>{
    private Context mContext;
    private LayoutInflater mInflater;
    private List<String> mData;

    public void setOnItemClickListener(OnItemClickListener mListener) {
        this.mListener = mListener;
    }

    private OnItemClickListener mListener;

    public interface OnItemClickListener{
        void OnItemClick(View view,int position);
    }

    public MyRecyclerViewAdapter(Context mContext, List<String> data) {
        this.mContext = mContext;
        mData = data;
        mInflater = LayoutInflater.from(mContext);

;    }

    public class MyViewHodler extends RecyclerView.ViewHolder{
        TextView tv;
        View itemView;
        public MyViewHodler(View itemView) {
            super(itemView);
            this.itemView = itemView;
            tv = (TextView) itemView.findViewById(R.id.tv_item);
        }
    }

    int i;
    @Override
    public MyRecyclerViewAdapter.MyViewHodler onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = mInflater.inflate(R.layout.item_rv,parent,false);
        MyViewHodler holder = new MyViewHodler(itemView);

        return holder;
    }

    @Override
    public void onBindViewHolder(final MyRecyclerViewAdapter.MyViewHodler holder, final int position) {
        holder.tv.setText(mData.get(position));
        if(mListener != null){
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    mListener.OnItemClick(view,position);
                }
            });
        }
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }
}
