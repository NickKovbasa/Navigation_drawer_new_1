package com.example.kolyakb.navigation_drawer_1.Adapter;

import android.content.Context;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.TextView;

import com.example.kolyakb.navigation_drawer_1.R;

import java.util.List;
import java.util.Map;

public class CustomExpandableListAdapter extends BaseExpandableListAdapter {

    private Context context;
    private List<String> listTitle;
    private Map<String, List<String>> listItem;

    public CustomExpandableListAdapter(Context context, List<String> listTitle, Map<String, List<String>> listItem) {
        this.context = context;
        this.listTitle = listTitle;
        this.listItem = listItem;
    }

    @Override
    public int getGroupCount() {
        return listTitle.size();
    }

    @Override
    public int getChildrenCount(int groupPosition) {
       // return listItem.size();
        return listItem.get(listTitle.get(groupPosition).toString()).size();
    }

    @Override
    public Object getGroup(int groupPosition) {
        return listTitle.get(groupPosition);
    }

    @Override
    public Object getChild(int groupPosition, int childPosition) {
        return listItem.get(listTitle.get(groupPosition)).get(childPosition);
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
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public View getGroupView(int i, boolean b, View view, ViewGroup viewGroup) {
        String title = (String) getGroup(i);
        if (view == null){
            view = LayoutInflater.from(context).inflate(R.layout.list_group, null);
        }

        TextView txtTitle = (TextView) view.findViewById(R.id.listTitle);
        txtTitle.setTypeface(null, Typeface.BOLD);
        txtTitle.setText(title);
        return view;
    }

    @Override
    public View getChildView(int i, int i1, boolean b, View view, ViewGroup viewGroup) {
        String title = (String) getChild(i, i1);
        if (view == null){
            view = LayoutInflater.from(context).inflate(R.layout.list_item, null);
        }

        TextView txtChild = (TextView) view.findViewById(R.id.expandabledListItem);
        txtChild.setText(title);
        return view;
    }

    @Override
    public boolean isChildSelectable(int i, int i1) {
        return true;
    }
}
