package com.prasannakc.dissertation;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by PrasannaKC on 05/05/2015.
 */
public class MyCustomBaseAdapter extends BaseAdapter {

    private static ArrayList<Hospitals_list> hospitals;

    private LayoutInflater mInflater;

    public MyCustomBaseAdapter(Context context, ArrayList<Hospitals_list> results) {
        hospitals = results;
        mInflater = LayoutInflater.from(context);
    }
    @Override
    public int getCount() {
        return hospitals.size();
    }

    @Override
    public Object getItem(int position) {
        return hospitals.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if (convertView == null) {
            convertView = mInflater.inflate(R.layout.hospital_layout, null);
            holder = new ViewHolder();
            holder.txtName = (TextView) convertView.findViewById(R.id.name);
            holder.txtCityState = (TextView) convertView.findViewById(R.id.cityState);
            holder.txtPhone = (TextView) convertView.findViewById(R.id.phone);

            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        holder.txtName.setText(hospitals.get(position).getName());
        holder.txtCityState.setText(hospitals.get(position).getCityState());
        holder.txtPhone.setText(hospitals.get(position).getPhone());

        return convertView;
    }

    static class ViewHolder {
        TextView txtName;
        TextView txtCityState;
        TextView txtPhone;
    }
}
