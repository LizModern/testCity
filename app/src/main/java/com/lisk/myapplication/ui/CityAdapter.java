package com.lisk.myapplication.ui;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.lisk.myapplication.entity.City;

/**
 * Created by e.kazimirova on 23.12.2015.
 */
public class CityAdapter extends ArrayAdapter<City> {

    public CityAdapter(Context context, City[] cittList) {
        super(context, android.R.layout.simple_list_item_2, cittList);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        City city = getItem(position);

        if (convertView == null) {
            convertView = LayoutInflater.from(getContext())
                    .inflate(android.R.layout.simple_list_item_2, null);
        }
        TextView name = ((TextView) convertView.findViewById(android.R.id.text1));
        name.setTextColor(Color.BLACK);

        name.setText(city.getName());
        TextView id = ((TextView) convertView.findViewById(android.R.id.text2));

        id.setTextColor(Color.BLACK);
        id.setText(String.valueOf(city.getId()));
        return convertView;
    }
}