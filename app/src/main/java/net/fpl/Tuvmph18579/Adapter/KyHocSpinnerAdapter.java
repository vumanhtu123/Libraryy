package net.fpl.Tuvmph18579.Adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;


import net.fpl.Tuvmph18579.DTO.KyHoc;
import net.fpl.Tuvmph18579.R;

import java.util.ArrayList;

public class KyHocSpinnerAdapter extends BaseAdapter {
    Context context;
    ArrayList<KyHoc> arrayList;

    public KyHocSpinnerAdapter(Context context, ArrayList<KyHoc> arrayList) {
        this.context = context;
        this.arrayList = arrayList;
    }

    @Override
    public int getCount() {
        return arrayList.size();
    }

    @Override
    public Object getItem(int position) {
        return arrayList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view;
        if (convertView==null){
            view = View.inflate(context, R.layout.activity_ki_item,null);
        }else {
            view= convertView;
        }
        TextView tvTen = view.findViewById(R.id.tv_tenky_sp);
        KyHoc ky = arrayList.get(position);
        tvTen.setText(ky.getTenKy());
        return view;
    }

    @Override
    public View getDropDownView(int position, View convertView, ViewGroup parent) {
        View view;
        if (convertView==null){
            view = View.inflate(context, R.layout.activity_kyhoc_item_dropspn,null);
        }else {
            view= convertView;
        }
        TextView tvTen = view.findViewById(R.id.tv_tenky_sp);
        KyHoc ky = arrayList.get(position);
        tvTen.setText(ky.getTenKy());
        return super.getDropDownView(position, view, parent);
    }
}
