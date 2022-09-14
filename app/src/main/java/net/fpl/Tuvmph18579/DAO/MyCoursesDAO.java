package net.fpl.Tuvmph18579.DAO;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;


import net.fpl.Tuvmph18579.DTO.MonHoc;
import net.fpl.Tuvmph18579.DbHelper.dbHelper;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class MyCoursesDAO {
    SQLiteDatabase db;
    dbHelper DbHelper;
    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy");
    public MyCoursesDAO(Context context) {
        DbHelper = new dbHelper(context) ;
        db = DbHelper.getWritableDatabase();
    }

    //get data nhieu tham so
    private List<MonHoc> getData(String sql, String... paramater){
        List<MonHoc> list = new ArrayList<>();
        Cursor cursor = db.rawQuery(sql,paramater);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()){
            int maMon = cursor.getInt(cursor.getColumnIndex("maMon"));
            String tenMon = cursor.getString(cursor.getColumnIndex("tenMon"));
            String anh = cursor.getString(cursor.getColumnIndex("anh"));
            Float hocPhi = cursor.getFloat(cursor.getColumnIndex("hocPhi"));


            String  ngayBatDau = cursor.getString(cursor.getColumnIndex("ngayBatDau"));


            String ngayKetThuc = cursor.getString(cursor.getColumnIndex("ngayKetThuc"));

            String tenKy = cursor.getString(cursor.getColumnIndex("tenKy"));

            MonHoc monHoc = new MonHoc(maMon,tenMon,anh,hocPhi,ngayBatDau,ngayKetThuc,tenKy);
            list.add(monHoc);
            cursor.moveToNext();
        }
        cursor.close();
        return list;
    }

    public List<MonHoc> getAll() {
        String sql = "SELECT * FROM tb_mycours";
        return getData(sql);
    }


    public List<MonHoc> getMonHocTheoKy(String tenKy){
        String sql = "SELECT * FROM tb_mycours WHERE tenKy=?";
        List<MonHoc> list = getData(sql,tenKy);

        return list;
    }

    public long insert(MonHoc monHoc){
        ContentValues contentValues = new ContentValues();
        contentValues.put("maMon",monHoc.getMaMon());
        contentValues.put("tenMon",monHoc.getTenMon());
        contentValues.put("anh",monHoc.getAnh());
        contentValues.put("hocPhi",monHoc.getHocPhi());
        contentValues.put("ngayBatDau",monHoc.getNgayBatDau());
        contentValues.put("ngayKetThuc",monHoc.getNgayKetThuc());
        contentValues.put("tenKy",monHoc.getTenKy());
        return db.insert("tb_mycours",null,contentValues);
    }
    public long delete(String id){
        int result=db.delete("tb_mycours","maMon=?",new String[]{id});
        return result;
    }
}
