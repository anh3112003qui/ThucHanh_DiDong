package com.example.btth2_4;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ListView;
import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {


    EditText itxtID;
    EditText itxtName;
    CheckBox ckbManager;
    Button btnAdd;
    ListView lvStaffManager;
    ArrayList<employee> employeeArrayList = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        itxtID = findViewById(R.id.itxtID);
        itxtName = findViewById(R.id.itxtName);
        ckbManager = findViewById(R.id.ckbManager);
        btnAdd = findViewById(R.id.btnAdd);
        lvStaffManager = findViewById(R.id.lvStaffManager);
        EmployeeAdapter employeeAdapter = new EmployeeAdapter(this, R.layout.item_employee, employeeArrayList);
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String ID = itxtID.getText().toString();
                String name = itxtName.getText().toString();
                boolean isManager = ckbManager.isChecked();
                employee e = new employee(ID, name, isManager);
                employeeArrayList.add(e);
                employeeAdapter.notifyDataSetChanged();
                lvStaffManager.setAdapter(employeeAdapter);
            }
        });
    }
}
