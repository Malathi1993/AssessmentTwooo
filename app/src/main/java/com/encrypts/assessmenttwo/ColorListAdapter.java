package com.encrypts.assessmenttwo;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.ShapeDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.CursorAdapter;
import android.widget.TextView;

import androidx.core.content.ContextCompat;

import java.util.ArrayList;

public class ColorListAdapter extends BaseAdapter
{
    ArrayList<ColorItemDTO> colorsList;

    Context context;
    public ColorListAdapter(Context ctx, ArrayList<ColorItemDTO> colorItemDTOS)
    {
        this.colorsList = colorItemDTOS;
        this.context = ctx;
    }

    @Override
    public int getCount() {
        return colorsList.size();
    }

    @Override
    public Object getItem(int i) {
        return colorsList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup)
    {
        ColorItemDTO bean= colorsList.get(i);
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        view=layoutInflater.inflate(R.layout.list_row, null);
        TextView txtname= (TextView)view.findViewById(R.id.txtname);
        txtname.setText(bean.colorCode+"****"+bean.colorName);
        Button btnColor = (Button) view.findViewById(R.id.btnColor);
        GradientDrawable buttonBg = (GradientDrawable) btnColor.getBackground();
        buttonBg.setColor(Color.parseColor(bean.colorCode));

       // btnColor.setBackgroundColor(Color.parseColor(bean.colorCode));
        return view;
    }
}
