package com.ambell.customlist;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.TextView;

public class CustomAdapter extends ArrayAdapter<String> {
    private Context context;
    public CustomAdapter(@NonNull Context context, String[] foods) {
        super(context,R.layout.list_adapter, foods);
        this.context = context;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(getContext());
        View customView = inflater.inflate(R.layout.list_adapter, parent, false);

        String singlefooditem = getItem(position);
        TextView listText = customView.findViewById(R.id.list_view_item_text);
        CheckBox cb = customView.findViewById(R.id.list_view_item_checkbox);
        listText.setText(singlefooditem);
        cb.setOnCheckedChangeListener((MainActivity)context);

        return customView;
    }
}
