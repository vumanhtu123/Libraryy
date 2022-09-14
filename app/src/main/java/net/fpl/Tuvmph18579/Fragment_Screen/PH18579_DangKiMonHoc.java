package net.fpl.Tuvmph18579.Fragment_Screen;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Spinner;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import net.fpl.Tuvmph18579.Adapter.DangKiAdapter;
import net.fpl.Tuvmph18579.Adapter.KyHocSpinnerAdapter;
import net.fpl.Tuvmph18579.DAO.KyHocDAO;
import net.fpl.Tuvmph18579.DAO.MonHocDAO;
import net.fpl.Tuvmph18579.DAO.MyCoursesDAO;
import net.fpl.Tuvmph18579.DTO.KyHoc;
import net.fpl.Tuvmph18579.DTO.MonHoc;
import net.fpl.Tuvmph18579.R;

import java.util.ArrayList;

public class PH18579_DangKiMonHoc extends Fragment {
    private Spinner spKyhoc;
    KyHocDAO kyDAO;
    ArrayList<KyHoc> ky_ArrayList;
    KyHocSpinnerAdapter adapter_sp;
    private RecyclerView recyclerView_dangky;
    ArrayList<MonHoc> monHoc_ArrayList;
    DangKiAdapter dangKyAdapter;
    MonHocDAO monHocDAO;
    String tenKy;
    MyCoursesDAO mycourseDAO;

    public PH18579_DangKiMonHoc() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.activity_ph18579_dang_ki_mon_hoc, container, false);
        spKyhoc = (Spinner) view.findViewById(R.id.sp_kyhoc);
        recyclerView_dangky = (RecyclerView) view.findViewById(R.id.recyclerView_dangki);

        kyDAO = new KyHocDAO(getContext());
        monHocDAO = new MonHocDAO(getContext());
        mycourseDAO = new MyCoursesDAO(getContext());
        //get data spinner
        capNhatSpinner();


        // lay tenky khi chon sp
        spKyhoc.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                tenKy = ky_ArrayList.get(position).getTenKy();
                capNhatRecyclerView();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


        return view;
    }

    private void capNhatRecyclerView() {
        monHoc_ArrayList = (ArrayList<MonHoc>) monHocDAO.getMonHocTheoKy(tenKy);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext());
        recyclerView_dangky.setLayoutManager(layoutManager);
        dangKyAdapter = new DangKiAdapter(getActivity(), monHoc_ArrayList, this);
        dangKyAdapter.notifyDataSetChanged();
        recyclerView_dangky.setAdapter(dangKyAdapter);
    }

    private void capNhatSpinner() {
        ky_ArrayList = (ArrayList<KyHoc>) kyDAO.getAll();
        adapter_sp = new KyHocSpinnerAdapter(getActivity(), ky_ArrayList);
        adapter_sp.notifyDataSetChanged();
        spKyhoc.setAdapter(adapter_sp);


    }
}