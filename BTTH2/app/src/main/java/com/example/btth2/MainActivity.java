package com.example.btth2;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView lvPerson = (ListView) findViewById(R.id.lv_person);
        TextView tvSelection = (TextView) findViewById(R.id.tvSelection);
        final String arr[] = {"Teo", "Ty", "Bin", "Bo"};
        ArrayAdapter<String> adapter = new ArrayAdapter<String> (this, android.R.layout.simple_list_item_1, arr);

        lvPerson.setAdapter(adapter);
        lvPerson.setOnItemClickListener(
                new AdapterView.OnItemClickListener() {
                    public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
                        tvSelection.setText("position :" + arg2 + "; value =" + arr[arg2]);
                        arg1.setBackgroundColor(Color.rgb(141,238, 238));
                        for (int i = 0; i < arg0.getChildCount(); i++) {
                            if (i != arg2) {
                                arg0.getChildAt(i).setBackgroundColor(Color.TRANSPARENT);
                            }
                        }
                    }
                });

    }
}