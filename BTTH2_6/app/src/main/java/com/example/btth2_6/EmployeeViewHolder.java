package com.example.btth2_6;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;


public class EmployeeViewHolder extends RecyclerView.ViewHolder {
    private TextView tvFullName;
    private TextView tvPosition;
    private ImageView ivManager;
    public EmployeeViewHolder(View convertView) {
        super(convertView);
        tvFullName = convertView.findViewById(R.id.item_employee_tv_fullname);
        tvPosition = convertView.findViewById(R.id.item_employee_tv_position);
        ivManager = convertView.findViewById(R.id.item_employee_iv_manager);
    }

    public void bind(employee employee) {
        if (employee.getFullName()!=null) {
            tvFullName.setText(employee.getFullName());
        }  else tvFullName.setText("");
        if (employee.isManager())
        {
            ivManager.setVisibility(View.VISIBLE);
            tvPosition.setVisibility(View.GONE);
        }
        else
        {
            ivManager.setVisibility(View.GONE);
            tvPosition.setVisibility(View.VISIBLE);
            tvPosition.setText("Staff");
        }
    }
}