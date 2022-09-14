package net.fpl.Tuvmph18579.DbHelper;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class dbHelper extends SQLiteOpenHelper {
    public static final String DB_NAME = "KhoaHoc1.db";
    public static final int DB_VERSION = 1;
    public dbHelper(@Nullable Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String cre_table_ky = "CREATE TABLE tb_ky (tenKy TEXT PRIMARY KEY)";
        db.execSQL(cre_table_ky);
        String cre_table_monhoc = "CREATE TABLE tb_monHoc (maMon integer PRIMARY KEY AUTOINCREMENT, tenMon TEXT NOT NULL, anh TEXT, hocPhi FLOAT, ngayBatDau DATE, ngayKetThuc DATE, tenKy TEXT NOT NULL REFERENCES tb_ky(tenKy))";
        db.execSQL(cre_table_monhoc);
        String cre_table_lichthi = "CREATE TABLE tb_lichThi (maLichThi integer PRIMARY KEY AUTOINCREMENT, thoiGian DATE, maMon integer REFERENCES tb_monHoc(maMon))";
        db.execSQL(cre_table_lichthi);
        String cre_table_mycourse = "CREATE TABLE tb_mycours (maMon integer PRIMARY KEY, tenMon TEXT NOT NULL, anh TEXT, hocPhi FLOAT, ngayBatDau DATE, ngayKetThuc DATE, tenKy TEXT)";
        db.execSQL(cre_table_mycourse);

        //them mot so du lieu de test
        cre_table_ky = "INSERT INTO tb_ky VALUES('FALL 2021')";
        db.execSQL(cre_table_ky);
        cre_table_ky = "INSERT INTO tb_ky VALUES('SPRING 2021')";
        db.execSQL(cre_table_ky);
        cre_table_ky = "INSERT INTO tb_ky VALUES('SUMMER 2021')";
        db.execSQL(cre_table_ky);


        cre_table_monhoc = "INSERT INTO tb_monHoc VALUES(NULL, 'JAVASCRIPT', 'javascript', '2200', '2021-08-05', '2021-10-05', 'FALL 2021')";
        db.execSQL(cre_table_monhoc);
        cre_table_monhoc = "INSERT INTO tb_monHoc VALUES(NULL, 'PHP', 'php', '3200', '2021-05-08', '2021-07-08', 'FALL 2021')";
        db.execSQL(cre_table_monhoc);
        cre_table_monhoc = "INSERT INTO tb_monHoc VALUES(NULL, 'JAVA 2', 'java', '2000', '2021-02-14', '2021-04-10', 'FALL 2021')";
        db.execSQL(cre_table_monhoc);
        cre_table_monhoc = "INSERT INTO tb_monHoc VALUES(NULL, 'KOTLIN', 'kotlin', '1500', '2021-03-07', '2021-05-20', 'SPRING 2021')";
        db.execSQL(cre_table_monhoc);
        cre_table_monhoc = "INSERT INTO tb_monHoc VALUES(NULL, 'LẬP TRINH C++', 'c', '2000', '2021-01-05', '2021-03-14', 'SPRING 2021')";
        db.execSQL(cre_table_monhoc);
        cre_table_monhoc = "INSERT INTO tb_monHoc VALUES(NULL, 'LẬP TRINHG C#', 'cc', '1200', '2021-06-04', '2021-07-25', 'SPRING 2021')";
        db.execSQL(cre_table_monhoc);
        cre_table_monhoc = "INSERT INTO tb_monHoc VALUES(NULL, 'BIG DATA', 'bigdata', '6000', '2021-10-05', '2021-11-20', 'SUMMER 2021')";
        db.execSQL(cre_table_monhoc);
        cre_table_monhoc = "INSERT INTO tb_monHoc VALUES(NULL, 'HTML/CSS', 'html', '800', '2021-05-07', '2021-07-01', 'SUMMER 2021')";
        db.execSQL(cre_table_monhoc);
        cre_table_monhoc = "INSERT INTO tb_monHoc VALUES(NULL, 'PHOTOSHOP', 'pts', '1500', '2021-07-12', '2021-09-24', 'SUMMER 2021')";
        db.execSQL(cre_table_monhoc);


        cre_table_lichthi = "INSERT INTO tb_lichThi VALUES(NULL, '2021-10-10', 1)";
        db.execSQL(cre_table_lichthi);
        cre_table_lichthi = "INSERT INTO tb_lichThi VALUES(NULL, '2021-07-12', 2)";
        db.execSQL(cre_table_lichthi);
        cre_table_lichthi = "INSERT INTO tb_lichThi VALUES(NULL, '2021-04-15', 3)";
        db.execSQL(cre_table_lichthi);


        cre_table_lichthi = "INSERT INTO tb_lichThi VALUES(NULL, '2021-05-22', 4)";
        db.execSQL(cre_table_lichthi);
        cre_table_lichthi = "INSERT INTO tb_lichThi VALUES(NULL, '2021-03-17', 5)";
        db.execSQL(cre_table_lichthi);
        cre_table_lichthi = "INSERT INTO tb_lichThi VALUES(NULL, '2021-07-26', 6)";
        db.execSQL(cre_table_lichthi);

        cre_table_lichthi = "INSERT INTO tb_lichThi VALUES(NULL, '2021-11-22', 7)";
        db.execSQL(cre_table_lichthi);
        cre_table_lichthi = "INSERT INTO tb_lichThi VALUES(NULL, '2021-07-03', 8)";
        db.execSQL(cre_table_lichthi);
        cre_table_lichthi = "INSERT INTO tb_lichThi VALUES(NULL, '2021-09-29', 9)";
        db.execSQL(cre_table_lichthi);


    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
