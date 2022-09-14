package net.fpl.Tuvmph18579.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import net.fpl.Tuvmph18579.DAO.MyCoursesDAO;
import net.fpl.Tuvmph18579.DTO.MonHoc;
import net.fpl.Tuvmph18579.Fragment_Screen.PH18579_DangKiMonHoc;
import net.fpl.Tuvmph18579.Fragment_Screen.PH18579_MonHocDaDangKi;
import net.fpl.Tuvmph18579.PH18579_Courses;
import net.fpl.Tuvmph18579.R;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class DangKiAdapter extends RecyclerView.Adapter<DangKiAdapter.DangKyViewHolder> {
    Context context;
    ArrayList<MonHoc> arrayList;
    PH18579_DangKiMonHoc fragment;

    //Format dạng NGAY
    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
    //Format dạng tiền
    NumberFormat fm = new DecimalFormat("#,###");
    public DangKiAdapter(Context context, ArrayList<MonHoc> arrayList, PH18579_DangKiMonHoc fragment) {
        this.context = context;
        this.arrayList = arrayList;
        this.fragment = fragment;
    }
    //set view
    @Override
    public DangKyViewHolder onCreateViewHolder(@NonNull  ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.activity_dangki_item,null);
        Animation animation = AnimationUtils.loadAnimation(context,R.anim.anim_recycle);
        view.startAnimation(animation);
        return new DangKyViewHolder(view);
    }
    //đổ data
    @Override
    public void onBindViewHolder(@NonNull  DangKyViewHolder holder, int position) {
        //set data
        MonHoc monHoc = arrayList.get(position);
        holder.tvTenmom.setText(monHoc.getTenMon());
        holder.tvHocphi.setText("Học Phí: "+fm.format(monHoc.getHocPhi())+" VND");
        holder.tvNgaybatdau.setText("Ngày Học: "+monHoc.getNgayBatDau());
        holder.tvNgayketthuc.setText("Ngày Kết Thúc: "+monHoc.getNgayKetThuc());

        //lấy hình bằng tên trong thư mục drawable
        String tenHinh = arrayList.get(position).getAnh();
        int resImg = context.getResources().getIdentifier(tenHinh,"drawable",context.getPackageName());
        holder.ivMonhoc.setImageResource(resImg);
        //event dang ky hoc
        MyCoursesDAO mycourseDAO = new MyCoursesDAO(context);
        holder.tvDangkyhoc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ArrayList<MonHoc> arrayList = (ArrayList<MonHoc>) mycourseDAO.getAll();
                for (int i = 0; i < arrayList.size(); i++) {
                    if (arrayList.get(i).getTenKy().equals(monHoc.getTenKy())&&arrayList.get(i).getTenMon().equals(monHoc.getTenMon())){
                        Toast.makeText(context, "Môn học này bạn đã đăng ký rồi\n Bạn hãy đăng ký môn khác", Toast.LENGTH_SHORT).show();
                        return;
                    }
                }
                if (mycourseDAO.insert(monHoc)>0){
                    PH18579_MonHocDaDangKi.monHoc_ArrayList.clear();
                    PH18579_MonHocDaDangKi.monHoc_ArrayList.addAll(mycourseDAO.getAll());
                    PH18579_MonHocDaDangKi.adapter.notifyDataSetChanged();
                    PH18579_Courses.viewPager.setCurrentItem(1);
                    Toast.makeText(context, "Đăng ký môn học thành công", Toast.LENGTH_SHORT).show();
                }else {
                    Toast.makeText(context, "Đăng ký môn học thất bại", Toast.LENGTH_SHORT).show();
                }

            }
        });
    }
    //set count
    @Override
    public int getItemCount() {
        if (arrayList!=null){
            return  arrayList.size();
        }
        return 0;
    }

    public class DangKyViewHolder extends RecyclerView.ViewHolder{
        private ImageView ivMonhoc;
        private TextView tvTenmom;
        private TextView tvHocphi;
        private TextView tvNgaybatdau;
        private TextView tvNgayketthuc;
        private TextView tvDangkyhoc;


        public DangKyViewHolder(@NonNull  View itemView) {
            super(itemView);
            ivMonhoc = (ImageView) itemView.findViewById(R.id.iv_monhoc);
            tvTenmom = (TextView) itemView.findViewById(R.id.tv_tenmom);
            tvHocphi = (TextView) itemView.findViewById(R.id.tv_hocphi);
            tvNgaybatdau = (TextView) itemView.findViewById(R.id.tv_ngaybatdau);
            tvNgayketthuc = (TextView) itemView.findViewById(R.id.tv_ngayketthuc);
            tvDangkyhoc = (TextView) itemView.findViewById(R.id.tv_dangkyhoc);
        }
    }
}
