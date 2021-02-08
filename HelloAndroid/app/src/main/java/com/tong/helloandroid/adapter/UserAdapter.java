package com.tong.helloandroid.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.tong.helloandroid.R;
import com.tong.helloandroid.entity.User;

import java.util.List;

/**
 * @author tongpc32380
 * @date 2021/2/8 9:24
 */
public class UserAdapter extends BaseAdapter {
    private List<User> userList;
    private Context context;

    public UserAdapter(@NonNull List<User> userList, @NonNull Context context) {
        this.userList = userList;
        this.context = context;
    }

    public void updateUserList(@NonNull List<User> userList) {
        this.userList.clear();
        this.userList.addAll(userList);
        notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return userList.size();
    }

    @Override
    public Object getItem(int position) {
        return userList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return userList.get(position).getId();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;

        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.list_item, parent, false);

            holder = new ViewHolder();
            holder.icon = convertView.findViewById(R.id.icon);
            holder.firstName = convertView.findViewById(R.id.name);
            holder.lastName = convertView.findViewById(R.id.desc);
            convertView.setTag(holder);   //将Holder存储到convertView中
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        User user = userList.get(position);
        holder.icon.setBackgroundResource(R.drawable.images);
        holder.firstName.setText(user.getId() + "、" + user.getFirstName());
        holder.lastName.setText(user.getLastName());
        return convertView;
    }


    private static class ViewHolder {
        ImageView icon;
        TextView firstName;
        TextView lastName;
    }
}
