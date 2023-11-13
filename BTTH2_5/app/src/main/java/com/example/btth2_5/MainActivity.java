package com.example.btth2_5;

import androidx.appcompat.app.AppCompatActivity;


import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.Spinner;


import java.util.ArrayList;
import java.util.Arrays;


public class MainActivity extends AppCompatActivity {


    EditText txtName;
    Spinner thumbnailSelect;
    Button btnAdd;
    CheckBox ckbPromotion;
    GridView grvDish;


    ArrayList<Dish> arrDish;


    DishAdapter dishAdapter;


    ThumbnailAdapter thumbnailAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        addComponent();
        thumbnailAdapter = new ThumbnailAdapter(this, R.layout.item_dish_spinner, Arrays.asList(Thumbnail.values()));


        thumbnailSelect.setAdapter(thumbnailAdapter);
        dishAdapter = new DishAdapter(this, R.layout.item_dish, arrDish);
        grvDish.setAdapter(dishAdapter);
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = txtName.getText().toString();
                String img = thumbnailSelect.getSelectedItem().toString();
                boolean promotion = ckbPromotion.isChecked();
                arrDish.add(new Dish(name, img, promotion));
                dishAdapter.notifyDataSetChanged();
                txtName.setText("");
            }
        });


    }


    private void addComponent() {
        txtName = findViewById(R.id.txt_name);
        thumbnailSelect = findViewById(R.id.thumbnail_spinner);
        ckbPromotion = findViewById(R.id.ck_promotion);
        btnAdd = findViewById(R.id.btn_add);
        grvDish = findViewById(R.id.grv_dish);
        arrDish = new ArrayList<Dish>();
    }
}
