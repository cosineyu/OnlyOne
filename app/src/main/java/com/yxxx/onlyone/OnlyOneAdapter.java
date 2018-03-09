package com.yxxx.onlyone;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by yns on 2018/2/28.
 */

public class OnlyOneAdapter extends BaseAdapter {

    private Context mContext;
    private ArrayList<OnlyOneBean> arrayList = new ArrayList<>();

    public OnlyOneAdapter(Context mContext, ArrayList<OnlyOneBean> arrayList) {
        this.mContext = mContext;
        this.arrayList = arrayList;
    }
    @Override
    public int getCount() {
        return arrayList.size();
    }

    @Override
    public Object getItem(int position) {
        return arrayList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        //复用convertView
        View view = null;
        if(convertView != null){
            view = convertView;
        }else {
            view =  View.inflate(mContext, R.layout.onlyone_listview_layout, null);
        }

        TextView textview_da = view.findViewById(R.id.textView_da);
        TextView textview_xiao = view.findViewById(R.id.textView_xiao);
        TextView textview_zhao = view.findViewById(R.id.textView_zhao);
        TextView textview_yu = view.findViewById(R.id.textView_yu);

        OnlyOneBean onlyOneBean = arrayList.get(position);

        textview_da.setText(onlyOneBean.da);
        textview_xiao.setText(onlyOneBean.xiao);
        textview_zhao.setText(onlyOneBean.zhao);
        textview_yu.setText(onlyOneBean.yu);


        return view;
    }
}
