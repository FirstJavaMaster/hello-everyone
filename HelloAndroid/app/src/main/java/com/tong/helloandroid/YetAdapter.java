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
        ViewHolder holder;

        if (convertView == null) {
            convertView = LayoutInflater.from(mContext).inflate(R.layout.list_item, parent, false);

            holder = new ViewHolder();
            holder.img_icon = convertView.findViewById(R.id.icon);
            holder.txt_aName = convertView.findViewById(R.id.name);
            holder.txt_aDesc = convertView.findViewById(R.id.desc);

            convertView.setTag(holder);   //将Holder存储到convertView中
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        holder.img_icon.setBackgroundResource(mData.get(position).getAIcon());
        holder.txt_aName.setText(position + ". " + mData.get(position).getAName());
        holder.txt_aDesc.setText(mData.get(position).getADesc());

        return convertView;
    }

    static class ViewHolder {
        ImageView img_icon;
        TextView txt_aName;
        TextView txt_aDesc;
    }
}
