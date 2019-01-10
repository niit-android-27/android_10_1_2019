package com.luan.myapp.ui_session_2;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class MyBaseAdapter extends BaseAdapter {
    public static final int VIEW_SECTION = 0;
    public static final int VIEW_CHILD_ITEM = 1;
    Context context;
    LayoutInflater inflater;
    ArrayList<ModelSection> users;
    public MyBaseAdapter(Context context,
                         ArrayList<ModelSection> users) {
      this.context=context;
      this.users=users;
      this.inflater=(LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return users.size();
    }

    @Override
    public Object getItem(int i) {
        return users.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public int getItemViewType(int position) {
        if(users.get(position).isSection()){
          return VIEW_SECTION; ///0
        }
        return VIEW_CHILD_ITEM; ///1
    }

    @Override
    public int getViewTypeCount() {
        return 2;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        int type = getItemViewType(i);
        ViewHolder viewHolder;
        if(view==null){
            viewHolder= new ViewHolder();
            if(type == VIEW_SECTION){
               view = inflater.inflate(R.layout.section_item, viewGroup, false);
               viewHolder.tvTitle = (TextView)view.findViewById(R.id.tvTitle);
            }else{
               view = inflater.inflate(R.layout.child_item, viewGroup, false);
               viewHolder.tvName=(TextView)view.findViewById(R.id.tvName);
               viewHolder.tvAddress = (TextView)view.findViewById(R.id.tvAddress);
            }
            view.setTag(viewHolder);
        }else{
            viewHolder=(ViewHolder)view.getTag();
        }

        if(viewHolder.tvTitle == null){
            viewHolder.tvName.setText( ((ModelUser)users.get(i)).getName() );
            viewHolder.tvAddress.setText( ((ModelUser)users.get(i)).getAddress() );
        }else{
            viewHolder.tvTitle.setText(users.get(i).getTitle());
        }
        return view;
    }

    class ViewHolder{
        TextView tvName;
        TextView tvAddress;
        TextView tvTitle;
    }
}
