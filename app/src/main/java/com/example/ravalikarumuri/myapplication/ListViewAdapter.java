package com.example.ravalikarumuri.myapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.TextView;

import java.util.ArrayList;

public class ListViewAdapter extends ArrayAdapter<Visitor> {
    private final Context context;
    private final ArrayList<Visitor> values;

    public ListViewAdapter(Context context, ArrayList<Visitor> values) {
        super(context, -1, values);
        this.context = context;
        this.values = values;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowView = inflater.inflate(R.layout.adminview, parent, false);
        TextView textView = (TextView) rowView.findViewById(R.id.personFirstname);
        TextView textView2 = (TextView) rowView.findViewById(R.id.personMobileNumber);
        Visitor visitor = values.get(position);
        textView.setText(visitor.getFirstname() + visitor.getLastname());
        textView2.setText(visitor.getMobilenumber());
        return rowView;
    }
}

