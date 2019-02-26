package com.zyc.sideslipiinglistview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

/**
 * Created by zhaoyuanchao on 2019/2/26.
 */
public class ListAdapter extends BaseAdapter {
    private Context context;
    private List<String> strings;

    public ListAdapter(Context context, List<String> strings) {
        this.context = context;
        this.strings = strings;
    }

    @Override
    public int getCount() {
        return strings == null ? 0 : strings.size();
    }

    @Override
    public Object getItem(int position) {
        return strings.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final ConversationListHolder holder;
        if (convertView == null){
            convertView = LayoutInflater.from(context).inflate(R.layout.item_conv_list,parent,false);
            holder = new ConversationListHolder();
            holder.avatar = convertView.findViewById(R.id.iv_avatar);
            holder.title = convertView.findViewById(R.id.tv_title);
            holder.swipeLayout = convertView.findViewById(R.id.swp_layout);
            holder.imageView = convertView.findViewById(R.id.iv_dz);
            convertView.setTag(holder);
        }else{
            holder = (ConversationListHolder) convertView.getTag();
        }
        holder.swipeLayout.setSwipeEnabled(true);
        holder.swipeLayout.addSwipeListener(new SwipeLayout.SwipeListener() {
            @Override
            public void onStartOpen(SwipeLayout layout) {

            }

            @Override
            public void onOpen(SwipeLayout layout) {
                holder.imageView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(context,"删除",Toast.LENGTH_LONG).show();
                    }
                });
            }

            @Override
            public void onStartClose(SwipeLayout layout) {

            }

            @Override
            public void onClose(SwipeLayout layout) {

            }

            @Override
            public void onUpdate(SwipeLayout layout, int leftOffset, int topOffset) {

            }

            @Override
            public void onHandRelease(SwipeLayout layout, float xvel, float yvel) {

            }
        });


        return convertView;
    }
    private static class ConversationListHolder{
        ImageView avatar;
        TextView title;
        SwipeLayout swipeLayout;
        ImageView imageView;
    }
}
