package com.example.btth2_4;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;


public class EmployeeAdapter extends ArrayAdapter<employee> {
    private Activity context;
    public EmployeeAdapter(Activity context, int layoutID, List<employee>
            objects) {
        super(context, layoutID, objects);
        this.context = context;
    }
    @Override
    public View getView(final int position, View convertView, ViewGroup parent)
    {
        if (convertView == null) {
            convertView =
                    LayoutInflater.from(context).inflate(R.layout.item_employee, null,
                            false);
        }
        employee employee = getItem(position);
        TextView tvFullName = (TextView)
                convertView.findViewById(R.id.item_employee_tv_fullname);
        TextView tvPosition = (TextView)
                convertView.findViewById(R.id.item_employee_tv_position);
        ImageView ivManager = (ImageView)
                convertView.findViewById(R.id.item_employee_iv_manager);
        LinearLayout llParent = (LinearLayout)
                convertView.findViewById(R.id.item_employee_ll_parent);
        if (employee.getFullName()!=null) {
            tvFullName.setText(employee.getFullName());
        }
        else tvFullName.setText("");
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
        // Show different color backgrounds for 2 continuous employees
        if (position%2==0)
        {
            llParent.setBackgroundResource(R.color.white);
        }
        else
        {
            llParent.setBackgroundResource(R.color.light_blue);
        }
        return convertView;
    }
}

