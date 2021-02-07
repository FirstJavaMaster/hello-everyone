package com.tong.helloandroid;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.LinkedList;

/**
 * @author tongpc32380
 * @date 2021/2/7 13:25
 */
public class YetAdapter extends BaseAdapter {
    private LinkedList<YetLanguage> mData;
    private Context mContext;

    public YetAdapter(LinkedList<YetLanguage> mData, Context mContext) {
        this.mData = mData;
        this.mContext = mContext;
    }

    @Override
    public int getCount() {
        return mData.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        convertView = LayoutInflater.from(mContext).inflate(R.layout.list_item, parent, false);

        ImageView img_icon = convertView.findViewById(R.id.icon);
        TextView txt_aName = convertView.findViewById(R.id.name);
        TextView txt_aDesc = convertView.findViewById(R.id.desc);

        img_icon.setBackgroundResource(mData.get(position).getAIcon());
        txt_aName.setText(mData.get(position).getAName());
        txt_aDesc.setText(mData.get(position).getADesc());

        return convertView;
    }
}
