package net.fpl.Tuvmph18579.DAO;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import net.fpl.Tuvmph18579.DTO.LichThi;
import net.fpl.Tuvmph18579.DbHelper.dbHelper;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class LichThiDAO {
    dbHelper DbHelper;
    SQLiteDatabase db;
    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy");
    public LichThiDAO(Context context) {
        DbHelper = new dbHelper(context) ;
        db = DbHelper.getWritableDatabase();
    }

    //get data nhieu tham so
    private List<LichThi> getData(String sql, String... paramater){
        List<LichThi> list = new ArrayList<>();
        Cursor cursor = db.rawQuery(sql,paramater);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()){
            int maLichThi = cursor.getInt(cursor.getColumnIndex("maLichThi"));
            String  thoigian = cursor.getString(cursor.getColumnIndex("thoiGian"));
            int maMon = cursor.getInt(cursor.getColumnIndex("maMon"));
            LichThi lichThi = new LichThi(maLichThi,thoigian,maMon);
            list.add(lichThi);
            cursor.moveToNext();
        }
        cursor.close();
        return list;
    }

    public List<LichThi> getAllll() {
        String sql = "SELECT * FROM tb_lichThi";
        return getData(sql);
    }

    public LichThi getLichThi(String ma) {
        String sql = "SELECT * FROM tb_lichThi WHERE maMon=?";
        List<LichThi> lichThis = getData(sql,ma);
        return lichThis.get(0);
    }
}
