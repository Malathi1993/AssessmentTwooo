package com.encrypts.assessmenttwo;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.ShapeDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    //String[] colors = {"Green","Blue","White","Black","Red","Orange","Purple",};
    ListView listView;
    TextView tvcolor;
    Button btnColor;
    ArrayList<ColorItemDTO> colorItemDTOS;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView = (ListView)findViewById(R.id.listview);
         tvcolor= (TextView) findViewById(R.id.tvcolor);
        btnColor = (Button) findViewById(R.id.btnColor);

        colorItemDTOS=new ArrayList<>();
        String[] colorNames = getResources().getStringArray(R.array.color_name);
        String[] colorCode =  getResources().getStringArray(R.array.color_code);


        for (int i = 0; i < colorNames.length; i++) {
            colorItemDTOS.add(new ColorItemDTO(colorNames[i],colorCode[i]));
        }

       ColorListAdapter customAdapter = new ColorListAdapter(MainActivity.this,colorItemDTOS);

        listView.setAdapter(customAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
//                tvcolor.setText(colorItemDTOS.get(i).colorName);
                GradientDrawable buttonBg = (GradientDrawable) btnColor.getBackground();
                buttonBg.setColor(Color.parseColor(colorItemDTOS.get(i).colorCode));
            }
        });

    }
}
