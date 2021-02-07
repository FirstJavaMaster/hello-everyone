package com.tong.helloandroid;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import org.apache.commons.lang3.RandomStringUtils;

import java.util.LinkedList;

/**
 * @author tongpc32380
 * @date 2021/2/7 13:25
 */
public class YetAdapter extends BaseAdapter {
    private final LinkedList<YetLanguage> mData = new LinkedList<>();
    private final Context mContext;

    public YetAdapter(Context mContext) {
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
            holder.checked = convertView.findViewById(R.id.checked);

            convertView.setTag(holder);   //将Holder存储到convertView中
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        YetLanguage yetLanguage = mData.get(position);
        holder.img_icon.setBackgroundResource(yetLanguage.getAIcon());
        holder.txt_aName.setText(position + ". " + yetLanguage.getAName());
        holder.txt_aDesc.setText(yetLanguage.getADesc());
        // change事件绑定要在check值设置之前
        holder.checked.setOnCheckedChangeListener((buttonView, isChecked) -> mData.get(position).setChecked(isChecked));
        holder.checked.setChecked(yetLanguage.isChecked());

        return convertView;
    }

    public void add() {
        mData.add(new YetLanguage(RandomStringUtils.randomAlphabetic(4), "", R.drawable.images, false));
        notifyDataSetChanged();
    }

    public void remove() {
        mData.remove();
        notifyDataSetChanged();
    }

    public void clear() {
        mData.clear();
        notifyDataSetChanged();
    }

    static class ViewHolder {
        ImageView img_icon;
        TextView txt_aName;
        TextView txt_aDesc;
        CheckBox checked;
    }
}
