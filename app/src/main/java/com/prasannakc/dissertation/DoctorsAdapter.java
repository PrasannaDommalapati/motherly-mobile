package com.prasannakc.dissertation;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;


/**
 * Created by PrasannaKC on 28/04/2015.
 */
public class DoctorsAdapter extends ArrayAdapter<Doctors> {

    public DoctorsAdapter(Context context, int resource,ArrayList<Doctors> objects)
    {
        super(context,resource,objects);

    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        return super.getView(position, convertView, parent);
    }
    static class ViewHolder{
        public ImageView imageView;
        public TextView tvName;
        public TextView tvDescription;
        public TextView tvDOB;
        public TextView tvCountry;
        public TextView tvHeight;
        public TextView tvSpouse;
        public TextView tvChildren;
    }
}
