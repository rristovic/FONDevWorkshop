package com.vectors.sokocalo.svg;


import android.app.Activity;
import android.content.Context;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

public class MyAdapter extends ArrayAdapter<MyData> {

    private Context context;
    private int resource;
    private MyData[] objects;
    public MyAdapter(Context context,
                     int resource,
                     MyData[] objects) {
        super(context, resource, objects);
        this.context=context;
        this.resource=resource;
        this.objects=objects;
    }

    @Override
    public View getView(int position,
                        View convertView,
                        ViewGroup parent) {
                LayoutInflater inflater = LayoutInflater.from(context);
        View row=inflater.inflate(resource,parent,false);
        TextView title=
                row.findViewById(R.id.title);
        TextView number=
                row.findViewById(R.id.number);
        title.setText((CharSequence)
                objects[position].myTitle);
        number.setText(Integer.toString(
                objects[position].myNum));
        return row;
    }
}
