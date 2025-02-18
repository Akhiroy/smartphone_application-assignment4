package com.example.simplelistapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.HashMap;
import java.util.List;

public class CustomExpandableListAdapter extends BaseExpandableListAdapter {

    private Context context;
    private List<String> groupList; // Group titles
    private HashMap<String, List<String>> childMap; // Mapping of group -> children
    private List<Integer> groupImages; // List of group images

    public CustomExpandableListAdapter(Context context, List<String> groupList,
                                       HashMap<String, List<String>> childMap,
                                       List<Integer> groupImages) {
        this.context = context;
        this.groupList = groupList;
        this.childMap = childMap;
        this.groupImages = groupImages;
    }

    @Override
    public int getGroupCount() {
        return groupList.size();
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        return childMap.get(groupList.get(groupPosition)).size();
    }

    @Override
    public Object getGroup(int groupPosition) {
        return groupList.get(groupPosition);
    }

    @Override
    public Object getChild(int groupPosition, int childPosition) {
        return childMap.get(groupList.get(groupPosition)).get(childPosition);
    }

    @Override
    public long getGroupId(int groupPosition) {
        return groupPosition;
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return childPosition;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.item_parent, parent, false);
        }

        TextView groupTitle = convertView.findViewById(R.id.group_title);
        ImageView groupImage = convertView.findViewById(R.id.group_image);

        groupTitle.setText(groupList.get(groupPosition));
        groupImage.setImageResource(groupImages.get(groupPosition)); // Set the image for each group

        return convertView;
    }

    @Override
    public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.item_child, parent, false);
        }

        TextView childTitle = convertView.findViewById(R.id.text_child);
        childTitle.setText((String) getChild(groupPosition, childPosition));

        return convertView;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return true;
    }
}
