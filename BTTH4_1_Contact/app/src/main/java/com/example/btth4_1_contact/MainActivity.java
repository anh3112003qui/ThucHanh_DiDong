package com.example.btth4_1_contact;

import android.annotation.SuppressLint;
import android.database.Cursor;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;


import androidx.appcompat.app.AppCompatActivity;


import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity {
    private Cursor cursor;
    DatabaseHandler db = new DatabaseHandler(this);
    private List<String> contactsStr;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        db.deleteAllContacts();


        // Inserting Contacts
        Log.d("Insert: ", "Inserting ..");
        db.addContact(new Contact("Ravi", "9100000000"));
        db.addContact(new Contact("Srinivas", "9199999999"));
        db.addContact(new Contact("Tommy", "9522222222"));
        db.addContact(new Contact("Karthik", "9533333333"));


        // Reading all contacts
        Log.e("Reading: ", "Reading all contacts..");
        List<Contact> contacts = db.getAllContacts();


        for (Contact cn : contacts) {
            String log = "Id: " + cn.getId() + " ,Name: " + cn.getName() + ",Phone: " + cn.getPhoneNumber();
            // Writing Contacts to log
            Log.e("Name: ", log);
        }


        contactsStr = getData();
        showData();
    }


    @SuppressLint("Range")
    private List<String> getData() {
        List<String> contacts = new ArrayList<>();
        cursor = db.getAllContactsCursor();
        while (cursor.moveToNext()) {
            String name = cursor.getString(cursor.getColumnIndex(DatabaseHandler.KEY_NAME));
            String phoneNumber = cursor.getString(cursor.getColumnIndex(DatabaseHandler.KEY_PH_NO));
            contacts.add(name + ", " + phoneNumber);
        }
        return contacts;
    }
    private void showData() {
        ListView lvContacts = (ListView) findViewById(R.id.lv_contact);
        ArrayAdapter<String> contactsAdapter = new
                ArrayAdapter<String>(MainActivity.this, R.layout.item_user, contactsStr);
        lvContacts.setAdapter(contactsAdapter);


        lvContacts.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                Contact contact = db.getAllContacts().get(position);
                db.deleteContact(contact);
                contactsStr.remove(position);
                contactsAdapter.notifyDataSetChanged();
                return true;
            }
        });
    }
}
