package net.fpl.Tuvmph18579.DAO;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;


import net.fpl.Tuvmph18579.DTO.KyHoc;
import net.fpl.Tuvmph18579.DbHelper.dbHelper;

import java.util.ArrayList;
import java.util.List;

public class KyHocDAO {
    dbHelper DbHelper;
    SQLiteDatabase sqLiteDatabase;
    public KyHocDAO(Context context){
        //context laf thành phần trong ứng dụng android
        //nó cung cấp các tài nguyên như activity service, fragment ảnh ...
        DbHelper = new dbHelper(context);
        sqLiteDatabase = DbHelper.getWritableDatabase();
    }
    //get data nhieu tham so
    private List<KyHoc> getData(String sql, String...paramater){
        //Ba dấu chấm sau kiểu của tham số cuối cùng chỉ ra rằng đối số cuối cùng có
        // thể được truyền dưới dạng một mảng hoặc dưới dạng một chuỗi các đối số.
        // Varargs chỉ có thể được sử dụng ở vị trí đối số cuối cùng
        //Chưa tìm thấy giới hạn tối đa về số lượng đối số mà varargs có thể nhận,
        // nhưng chắc chắn là nhiều hơn ba
        List<KyHoc> kyHocs = new ArrayList<>();
        Cursor cursor = sqLiteDatabase.rawQuery(sql,  paramater);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()){
            String ten = cursor.getString(cursor.getColumnIndex("tenKy"));
            KyHoc kyHoc = new KyHoc(ten);
            kyHocs.add(kyHoc);
            cursor.moveToNext();
        }
        cursor.close();
        return kyHocs;
    }
    public List<KyHoc> getAll(){
        String sql = "SELECT * FROM tb_ky";
        return getData(sql);
    }
}
