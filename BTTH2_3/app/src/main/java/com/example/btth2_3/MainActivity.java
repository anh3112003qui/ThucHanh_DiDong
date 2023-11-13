package com.example.btth2_3;

import androidx.appcompat.app.AppCompatActivity;


import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RadioButton;


import com.example.btth2_3.model.employee;
import com.example.btth2_3.model.employeeFullTime;
import com.example.btth2_3.model.employeePartTime;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {


    EditText itxtMaNV, itxtTenNV;
    RadioButton radioBtnChinhThuc, radioBtnThoiVu;
    Button btnAddNV;
    ArrayList<String> listNV = new ArrayList<>();


    ListView listViewNV;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        addElement();
        addEvent();
    }


    private void addEvent() {
        ArrayAdapter<String> adapter = new
                ArrayAdapter<String>
                (this, android.R.layout.simple_list_item_1, listNV);
        btnAddNV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String id, name;
                int typeNV;
                employee e;
                id = itxtMaNV.getText().toString();
                name = itxtTenNV.getText().toString();
                typeNV = (radioBtnChinhThuc.isChecked())? 1 : 2;
                if(typeNV == 1){
                    e = new employeeFullTime(id, name);
                }
                else {
                    e = new employeePartTime(id, name);
                }
                listNV.add(e.toString());
                adapter.notifyDataSetChanged();
                listViewNV.setAdapter(adapter);
            }
        });
    }


    private void addElement() {
        itxtMaNV = findViewById(R.id.itxtMaNV);
        itxtTenNV = findViewById(R.id.itxtTenNV);
        radioBtnChinhThuc = findViewById(R.id.radioBtnChinhThuc);
        radioBtnThoiVu = findViewById(R.id.radioBtnThoiVu);
        btnAddNV = findViewById(R.id.btnAddNV);
        listViewNV = findViewById(R.id.listViewNV);
    }
}
