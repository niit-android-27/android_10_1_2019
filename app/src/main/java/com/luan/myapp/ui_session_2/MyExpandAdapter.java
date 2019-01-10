package com.luan.myapp.ui_session_2;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;

public class MyExpandAdapter extends BaseExpandableListAdapter{
    Context context;
    LayoutInflater inflater;
    ArrayList<String> groupName;
    HashMap<String,ArrayList<ModelUser>> users;
    public MyExpandAdapter(Context context,
                           ArrayList<String> groupName,
                           HashMap<String,ArrayList<ModelUser>> users
                           ){
        this.context=context;
        this.groupName =groupName;
        this.users=users;
        inflater=(LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getGroupCount() {
        return groupName.size();
    }

    @Override
    public int getChildrenCount(int i) {
        return users.get(groupName.get(i)).size();
    }

    @Override
    public Object getGroup(int i) {
        return groupName.get(i);
    }

    @Override
    public Object getChild(int i, int i1) {
        return users.get(groupName.get(i)).get(i1);
    }

    @Override
    public long getGroupId(int i) {
        return i;
    }

    @Override
    public long getChildId(int i, int i1) {
        return i1;
    }

    @Override
    public View getGroupView(int i, boolean b, View view, ViewGroup viewGroup) {
        if(view == null){
            view = inflater.inflate(R.layout.section_item, viewGroup, false);
        }
        TextView tvTitle =(TextView)view.findViewById(R.id.tvTitle);
        tvTitle.setText(groupName.get(i));
        return view;
    }

    @Override
    public View getChildView(int i, int i1, boolean b, View view, ViewGroup viewGroup) {
        if(view==null){
            view = inflater.inflate(R.layout.child_item, viewGroup, false);
        }
        TextView tvName = (TextView)view.findViewById(R.id.tvName);
        TextView tvAddress= (TextView)view.findViewById(R.id.tvAddress);
        tvName.setText(users.get(groupName.get(i)).get(i1).getName());
        tvAddress.setText(users.get(groupName.get(i)).get(i1).getAddress());
        return view;
    }

    @Override
    public boolean isChildSelectable(int i, int i1) {
        return false;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }
}
