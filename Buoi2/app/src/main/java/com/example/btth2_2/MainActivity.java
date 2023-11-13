package com.example.btth2_2;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText editText;
        Button button;
        ListView listView;
        TextView textView;
        ArrayList<String> names;
        ArrayAdapter<String> adapter;

        editText = findViewById(R.id.editText);
        button = findViewById(R.id.button);
        listView = findViewById(R.id.listView);
        textView = findViewById(R.id.textView);

        names  = new ArrayList<>();
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, names);
        listView.setAdapter(adapter);

        button.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                String input = editText.getText().toString().trim();
                if (!input.isEmpty()) {
                    names.add(input);
                    adapter.notifyDataSetChanged();
                    editText.setText("");
                }
            }
        });
        listView.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String selectedItem = names.get(position);
                textView.setText("position: " + position + ", Value: " + selectedItem);
                view.setBackgroundColor(Color.rgb(141,238, 238));
                for(int i = 0; i < parent.getChildCount(); i++){
                    if(i != position){
                        parent.getChildAt(i).setBackgroundColor(Color.TRANSPARENT);
                    }
                }
            }
        });

        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                names.remove(position);
                adapter.notifyDataSetChanged();
                return true;
            }
        });
    }
}