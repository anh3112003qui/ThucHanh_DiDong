package com.example.btth2_5;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;

import java.util.List;

public class DishAdapter extends ArrayAdapter<Dish> {
    private Activity context;
    public DishAdapter(@NonNull Context context, int resource, @NonNull List objects) {
        super(context, resource, objects);
        this.context = (Activity) context;
    }


    public View getView(final int position, View convertView, ViewGroup parent){
        if (convertView == null) {
            convertView =
                    LayoutInflater.from(context).inflate(R.layout.item_dish, null,
                            false);
        }


        Dish d = getItem(position);


        TextView tvName = (TextView)
                convertView.findViewById(R.id.dish_name);
        ImageView imgStar = (ImageView) convertView.findViewById(R.id.star_img);
        ImageView imgDish = (ImageView) convertView.findViewById(R.id.dish_img);


        if(d.getName() != null){
            tvName.setText(d.getName());
            tvName.setSelected(true);
        }
        else tvName.setText("");


        switch (d.getThumbnail()){
            case "Thumbnail1": imgDish.setImageResource(R.drawable.first_thumbnail);
                break;
            case "Thumbnail2": imgDish.setImageResource(R.drawable.second_thumbnail);
                break;
            case "Thumbnail3": imgDish.setImageResource(R.drawable.third_thumbnail);
                break;
            case "Thumbnail4": imgDish.setImageResource(R.drawable.fourth_thumbnail);
                break;
            default: break;
        }


        imgDish.setVisibility(View.VISIBLE);


        if(d.isPromotion()){
            imgStar.setVisibility(View.VISIBLE);
        }
        else imgStar.setVisibility(View.INVISIBLE);


        return convertView;
    }
}
