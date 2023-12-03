package com.example.btth4_2_student;

import static java.lang.Integer.parseInt;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.database.Cursor;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    EditText edtName, edtCode, edtMark;
    Button btnAdd, btnUpdate, btnDelete;
    RecyclerView rcv_Student;
    ArrayList<Student> students;
    StudentAdapter adapter;
    DatabaseHelper myDB;
    Cursor cursor;
    private Parcelable recyclerViewState;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        myDB = new DatabaseHelper(this);

        edtCode = (EditText) findViewById(R.id.edtCode);
        edtName = (EditText) findViewById(R.id.edtName);
        edtMark = (EditText) findViewById(R.id.edtMark);
        btnAdd = (Button) findViewById(R.id.btnAdd);
        btnUpdate = (Button) findViewById(R.id.btnUpdate);
        btnDelete = (Button) findViewById(R.id.btnDelete);

        students = new ArrayList<Student>();

        rcv_Student = (RecyclerView) findViewById(R.id.rcvStudent);
        adapter = new StudentAdapter(this, R.layout.item_student, students);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        rcv_Student.setLayoutManager(linearLayoutManager);

        students = getData();
        showData(students);
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(edtCode.getText().toString().isEmpty() || edtName.getText().toString().isEmpty() ||edtMark.getText().toString().isEmpty()){
                    showMessage("Error","Please fill the all fields to Inserting");
                    return;
                }
                if(parseInt(edtMark.getText().toString()) < 0 && parseInt(edtMark.getText().toString()) > 10) {
                    showMessage("Error","Mark must in 0 to 10");
                    return;
                };
                boolean isInserted = myDB.insertData(edtCode.getText().toString(), edtName.getText().toString(), edtMark.getText().toString());

                // Show toast when data inserted successfully
                if(isInserted){
                    Toast.makeText(MainActivity.this, "Data Inserted", Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(MainActivity.this, "Data Not Inserted", Toast.LENGTH_SHORT).show();
                }

                // Update on RecyclerView

                students = getData();
                showData(students);
                myDB.ShowAllData();

                // After inserting make edit box empty
                edtCode.setText("");
                edtName.setText("");
                edtMark.setText("");
            }
        });
        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(edtCode.getText().toString().isEmpty() || edtName.getText().toString().isEmpty() ||edtMark.getText().toString().isEmpty()){
                    showMessage("Error","Please fill the all fields to Updating");
                    return;
                };
                if(parseInt(edtMark.getText().toString()) < 0 && parseInt(edtMark.getText().toString()) > 10) {
                    showMessage("Error","Mark must in 0 to 10");
                    return;
                };
                System.out.println(Integer.toString(adapter.row_index));


                boolean isUpdated = myDB.updateData(Integer.toString(getIdByIndex(adapter.row_index+1)) ,edtCode.getText().toString(), edtName.getText().toString(),  edtMark.getText().toString());

                if(isUpdated){
                    Toast.makeText(MainActivity.this, "Data Updated", Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(MainActivity.this, "Data Not Updated", Toast.LENGTH_SHORT).show();
                }
                students = getData();
                showData(students);
                myDB.ShowAllData();
            }
        });
        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String row_index = Integer.toString(adapter.row_index+1);
                if(row_index.isEmpty() ){
                    showMessage("Error","Please choose row to delte");
                    return;
                };
                Integer isDeleted  = myDB.deleteData(Integer.toString(getIdByIndex(adapter.row_index+1)));
                if(isDeleted > 0){
                    Toast.makeText(MainActivity.this, "Data Deleted", Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(MainActivity.this, "Data Not Deleted", Toast.LENGTH_SHORT).show();
                }
                students = getData();
                showData(students);
                myDB.ShowAllData();
            }
        });
    }

    private void showMessage(String title, String Message) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(Message);
        builder.show();
    }
    private void showData(ArrayList<Student> students) {
        rcv_Student = (RecyclerView) findViewById(R.id.rcvStudent);
        adapter = new StudentAdapter(this, R.layout.item_student, students);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        rcv_Student.setLayoutManager(linearLayoutManager);
        rcv_Student.setAdapter(adapter);
    }

    private ArrayList<Student> getData() {
        ArrayList<Student> students = new ArrayList<Student>();
        cursor = myDB.getAllData();
        while (cursor.moveToNext()) {
            String _code = cursor.getString(1);
            String _name = cursor.getString(2);
            String _mark = cursor.getString(3);

            if (_mark.equals(""))
            {
                _mark = "0";
            }
            students.add(new Student(_code,_name,parseInt(_mark)));
        }
        return students;
    }

    private int getIdByIndex(int index){
        ArrayList<Student> students = new ArrayList<Student>();
        cursor = myDB.getAllData();
        for(int i = 0; i<index; i++){
            cursor.moveToNext();
        }
        int id = cursor.getInt(0);
        return id;
    }
}