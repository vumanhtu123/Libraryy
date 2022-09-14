package net.fpl.Tuvmph18579.Adapter;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import net.fpl.Tuvmph18579.DAO.LichThiDAO;
import net.fpl.Tuvmph18579.DTO.LichThi;
import net.fpl.Tuvmph18579.DTO.MonHoc;
import net.fpl.Tuvmph18579.Fragment_Screen.PH18579_MonHocDaDangKi;
import net.fpl.Tuvmph18579.R;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class MyCouresAdapter extends RecyclerView.Adapter<MyCouresAdapter.MonHocCuaTuiViewHolDer> {
    Context context;
    PH18579_MonHocDaDangKi fragment;
    ArrayList<MonHoc> arrayList;
    Dialog dialog;
    private TextView tvTitle;
    private TextView tvNgaybd;
    private TextView tvNgayhoc;
    private TextView tvNgaykt;
    private TextView tvLichthi;
    //Format dạng NGAY
    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
    //Format dạng tiền
    NumberFormat fm = new DecimalFormat("#,###");

    public MyCouresAdapter(Context context, PH18579_MonHocDaDangKi fragment, ArrayList<MonHoc> arrayList) {
        this.context = context;
        this.fragment = fragment;
        this.arrayList = arrayList;
    }

    @Override
    public MonHocCuaTuiViewHolDer onCreateViewHolder(@NonNull  ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.activity_mycourse_item,null);
        Animation animation = AnimationUtils.loadAnimation(context,R.anim.anim_recycle);
        view.startAnimation(animation);
        return new MonHocCuaTuiViewHolDer(view);
    }

    @Override
    public void onBindViewHolder(@NonNull  MonHocCuaTuiViewHolDer holder, int position) {
        MonHoc monHoc = arrayList.get(position);
        //set data
        holder.tvTenmom.setText(monHoc.getTenMon());
        holder.tvHocphi.setText("Học Phí: "+fm.format(monHoc.getHocPhi())+" VND");
        holder.tvNgaybatdau.setText("Ngày Học: "+monHoc.getNgayBatDau());
        holder.tvNgayketthuc.setText("Ngày Kết Thúc: "+monHoc.getNgayKetThuc());

        //lấy hình bằng tên trong thư mục drawable
        String tenHinh = arrayList.get(position).getAnh();
        int resImg = context.getResources().getIdentifier(tenHinh,"drawable",context.getPackageName());
        holder.ivMonhoc.setImageResource(resImg);


        //huy môm học đã đưng ký
        holder.tvHuyhoc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fragment.xoa(monHoc.getMaMon()+"");
            }
        });

        //thong tin ve mon hoc khi click
        holder.cardview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openDialog(monHoc);
            }
        });

    }



    //tra count
    @Override
    public int getItemCount() {
        if (arrayList!=null){
            return  arrayList.size();
        }
        return 0;
    }

    public class MonHocCuaTuiViewHolDer extends RecyclerView.ViewHolder{
        private ImageView ivMonhoc;
        private TextView tvTenmom;
        private TextView tvHocphi;
        private TextView tvNgaybatdau;
        private TextView tvNgayketthuc;
        private TextView tvHuyhoc;
        private CardView cardview;

        public MonHocCuaTuiViewHolDer(@NonNull  View itemView) {
            super(itemView);
            ivMonhoc = (ImageView) itemView.findViewById(R.id.iv_monhoc);
            tvTenmom = (TextView) itemView.findViewById(R.id.tv_tenmom);
            tvHocphi = (TextView) itemView.findViewById(R.id.tv_hocphi);
            tvNgaybatdau = (TextView) itemView.findViewById(R.id.tv_ngaybatdau);
            tvNgayketthuc = (TextView) itemView.findViewById(R.id.tv_ngayketthuc);
            tvHuyhoc = (TextView) itemView.findViewById(R.id.tv_huyhoc);
            cardview = (CardView) itemView.findViewById(R.id.cardview);

        }
    }


    private void openDialog(MonHoc monHoc) {
        dialog = new Dialog(context);
        dialog.setContentView(R.layout.activity_chitiet_monhoc);
        //ẩn background dialog
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        //anh xa
        tvTitle = (TextView) dialog.findViewById(R.id.tv_title);
        tvNgaybd = (TextView) dialog.findViewById(R.id.tv_ngaybd);
        tvNgayhoc = (TextView) dialog.findViewById(R.id.tv_ngayhoc);
        tvNgaykt = (TextView) dialog.findViewById(R.id.tv_ngaykt);
        tvLichthi = (TextView) dialog.findViewById(R.id.tv_lichthi);
        //set data
        tvTitle.setText(monHoc.getTenMon());
        tvNgaybd.setText("Ngày Bắt Đầu: "+monHoc.getNgayBatDau());
        tvNgaykt.setText("Ngày Kết Thúc: "+monHoc.getNgayKetThuc());

        if (monHoc.getTenMon().equals("JAVASCRIPT")){
            tvNgayhoc.setText("Ngày Học: Thứ 2 - 4 - 6 hằng tuần");
        }
        if (monHoc.getTenMon().equals("PHP")){
            tvNgayhoc.setText("Ngày Học: Thứ 3 - 5 - 7 hằng tuần");
        }
        if (monHoc.getTenMon().equals("JAVA 2")){
            tvNgayhoc.setText("Ngày Học: Thứ  2 - 3 - 4 hằng tuần");
        }
        if (monHoc.getTenMon().equals("KOTLIN")){
            tvNgayhoc.setText("Ngày Học: Thứ  5 - 6 - 7 hằng tuần");
        }

        LichThiDAO lichThiDAO = new LichThiDAO(context);
        LichThi lichThi = lichThiDAO.getLichThi(monHoc.getMaMon()+"");
        tvLichthi.setText("Ngày Thi: "+lichThi.getThoiGian());
        dialog.show();
    }
}
