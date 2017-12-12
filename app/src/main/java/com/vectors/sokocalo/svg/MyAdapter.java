package com.vectors.sokocalo.svg;


import android.app.Activity;
import android.content.Context;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MyAdapter extends ArrayAdapter<MyData> implements View.OnClickListener{

    public static final String BUNDLE_NOTE_KEY = "Note view content";
    public static final String BUNDLE_NUMBER_KEY = "Note number content";

    private Context context;
    private int resource;
    private ArrayList<MyData> objects;
    public MyAdapter(Context context,
                     int resource,
                     ArrayList<MyData> objects) {
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
                objects.get(position).getMyTitle());
        number.setText(Integer.toString(
                objects.get(position).getMyNum()));
        return row;
    }

    @Override
    public void onClick(View view) {


      /*  switch (view.getId())
        {
            case R.id.title:

                Snackbar.make(v, "Release date " +dataModel.getFeature(), Snackbar.LENGTH_LONG)
                        .setAction("No action", null).show();
                break;
        }*/
    }
}
