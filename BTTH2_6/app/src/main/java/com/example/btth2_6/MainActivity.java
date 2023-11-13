package com.example.btth2_6;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    EditText itxtID;
    EditText itxtName;
    CheckBox ckbManager;
    Button btnAdd;
    RecyclerView recyclerView;
    EmployeeAdapter employeeAdapter;
    ArrayList<employee> employeeArrayList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        itxtID = findViewById(R.id.itxtID);
        itxtName = findViewById(R.id.itxtName);
        ckbManager = findViewById(R.id.ckbManager);
        btnAdd = findViewById(R.id.btnAdd);
        recyclerView = findViewById(R.id.lvStaffManager);

        employeeAdapter = new EmployeeAdapter(this, employeeArrayList);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(employeeAdapter);

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String ID = itxtID.getText().toString();
                String name = itxtName.getText().toString();
                boolean isManager = ckbManager.isChecked();

                employee e = new employee(ID, name, isManager);
                employeeArrayList.add(e);
                employeeAdapter.notifyDataSetChanged();
            }
        });
    }
}