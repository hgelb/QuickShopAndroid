
package com.quickshop.activity;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.TextView;

import com.quickshop.activity.R;

import java.text.DecimalFormat;
import java.util.ArrayList;

public class CustomAdapter extends BaseAdapter implements ListAdapter {
    private ArrayList<ProductItem> list = new ArrayList<ProductItem>();
    private Context context;



    public CustomAdapter(Context context, ArrayList<ProductItem> list ) {
        this.list = list;
        this.context = context;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int pos) {
        return list.get(pos);
    }

    @Override
    public long getItemId(int pos) {
        return 0;
        //just return 0 if your list items do not have an Id variable.
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        View view = convertView;
        if (view == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.program_list, null);
        }

        //Handle TextView and display string from your list
        TextView name = (TextView) view.findViewById(R.id.name);
        name.setText(normalize(list.get(position).getProduct().getName()));

        TextView price = (TextView) view.findViewById(R.id.price);
        price.setText(normalize(String.valueOf(list.get(position).getProduct().getPrice())));

        TextView amount = (TextView) view.findViewById(R.id.amount);
        amount.setText(normalize(String.valueOf(list.get(position).getAmount())));

        //Handle buttons and add onClickListeners
        Button deleteBtn = (Button) view.findViewById(R.id.delete_btn);

        deleteBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //do something
                list.remove(position); //or some other task
                notifyDataSetChanged();

                double sum = CartContent.getInstance().updateTotalPrice();
                View rootView = ((Activity)context).getWindow().getDecorView().findViewById(android.R.id.content);

                TextView total = (TextView) rootView.findViewById(R.id.total);
                total.setText(" Total :      " + String.valueOf(new DecimalFormat("##.##").format(sum)));


            }
        });

        return view;
    }

    private String normalize(String word) {
        String res = word;
        while (res.length() < 10) {
            res += " ";
        }
        return res;
    }
    }