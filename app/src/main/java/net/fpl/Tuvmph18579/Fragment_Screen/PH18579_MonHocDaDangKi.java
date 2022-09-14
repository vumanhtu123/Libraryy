package net.fpl.Tuvmph18579.Fragment_Screen;

import android.app.Dialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import net.fpl.Tuvmph18579.Adapter.MyCouresAdapter;
import net.fpl.Tuvmph18579.DAO.MyCoursesDAO;
import net.fpl.Tuvmph18579.DTO.MonHoc;
import net.fpl.Tuvmph18579.R;

import java.util.ArrayList;

public class PH18579_MonHocDaDangKi extends Fragment {
    public static MyCouresAdapter adapter;
    private RecyclerView recyclerView1;
    public static ArrayList<MonHoc> monHoc_ArrayList;
    MyCoursesDAO mycourseDAO;

    Dialog dialog;

    public PH18579_MonHocDaDangKi() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.activity_ph18579_mon_hoc_da_dang_ki, container, false);
        recyclerView1 = (RecyclerView) view.findViewById(R.id.recyclerView_monhoc_cuatoi);
        //khoi tao
        mycourseDAO = new MyCoursesDAO(getContext());
        //cap nhat list
        capNhatRecyclerView();
        return view;
    }


    private void capNhatRecyclerView() {
        monHoc_ArrayList = (ArrayList<MonHoc>) mycourseDAO.getAll();
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext());
        recyclerView1.setLayoutManager(layoutManager);
        adapter = new MyCouresAdapter(getActivity(), this, monHoc_ArrayList);
        adapter.notifyDataSetChanged();
        recyclerView1.setAdapter(adapter);
    }

    public void xoa(String id) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
        View view = LayoutInflater.from(getContext()).inflate(R.layout.dialog_delete, null);
        builder.setView(view);
        AlertDialog alertDialog = builder.create();
        alertDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        alertDialog.show();
        Button btn_delete = view.findViewById(R.id.btn_ok_delete);
        btn_delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                long result = mycourseDAO.delete(id);
                if (result > 0) {
                    Toast.makeText(getContext(), "Xóa Thành Công", Toast.LENGTH_SHORT).show();
                    capNhatRecyclerView();
                    alertDialog.dismiss();
                } else {
                    Toast.makeText(getContext(), "Xóa Thất Bại", Toast.LENGTH_SHORT).show();
                    alertDialog.dismiss();
                }
            }
        });
    }

}