package org.techtown.myapplication;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DataBaseHelper extends SQLiteOpenHelper{
    private static final String DATABASE_NAME = "pet_center_database"; //데이터베이스 이름
    private static final int DATABASE_VERSION = 1;

    //생성자
    public DataBaseHelper(Context context){
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db){
        //user table 생성
        String create_user_table_query = "CREATE TABLE user_table ("
                + "number INTEGER PRIMARY KEY AUTOINCREMENT,"
                + "id TEXT,"
                + "pw TEXT,"
                + "username TEXT,"
                + "contact TEXT,"
                + "gender TEXT,"
                + "role INTEGER)";
        db.execSQL(create_user_table_query);

        //expert table 생성
        String create_expert_table_query = "CREATE TABLE expert_table ("
                + "number INTEGER PRIMARY KEY,"
                + "image_path TEXT,"
                + "career TEXT,"
                + "introduce TEXT,"
                + "price TEXT,"
                + "careable_pet TEXT)";
        db.execSQL(create_expert_table_query);
    }

    //테이블 정보 갱신
    @Override
    public void onUpgrade(SQLiteDatabase db, int old_version, int new_version){
        db.execSQL("DROP TABLE IF EXISTS user_table");
        db.execSQL("DROP TABLE IF EXISTS expert_table");
        onCreate(db);
    }
}
