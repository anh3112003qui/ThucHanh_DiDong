package com.example.btth2_5;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;


import androidx.annotation.NonNull;
import androidx.annotation.Nullable;


import java.util.List;


public class ThumbnailAdapter extends ArrayAdapter<Thumbnail> {
    public ThumbnailAdapter(@NonNull Context context, int resource, @NonNull List<Thumbnail> objects) {
        super(context, resource, objects);
    }


    public View getView(int position, View convertView, ViewGroup parent){
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(android.R.layout.simple_list_item_1, parent, false);
        }
        Thumbnail thumbnail = getItem(position);
        if (thumbnail != null) {
            TextView textView = (TextView) convertView.findViewById(android.R.id.text1);
            textView.setText(thumbnail.getName());
        }
        return convertView;
    }
    @Override
    public View getDropDownView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.item_dish_spinner, parent, false);
        }
        Thumbnail thumbnail = getItem(position);
        if (thumbnail != null) {
            TextView tvThumbnailName = (TextView) convertView.findViewById(R.id.thumbnail_name);
            ImageView imgThumbnailImg = (ImageView) convertView.findViewById(R.id.thumbnail_img);
            tvThumbnailName.setText(thumbnail.getName());
            imgThumbnailImg.setImageResource(thumbnail.getImg());
        }
        return convertView;
    }
}
