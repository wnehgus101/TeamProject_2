package org.techtown.myapplication;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DataBaseHelper extends SQLiteOpenHelper{
    private static final String DATABASE_NAME = "pet_center_database"; //데이터베이스 이름
    private static final int DATABASE_VERSION = 1;

    //유저 정보 저장 테이블
    private static final String TABLE_USERS = "users"; //테이블 이름
    private static final String COLUNM_USER_NUMBER = "number"; //유저 number (외부키로 사용됨)
    private static final String COLUNM_USER_ID = "ID"; //유저 id
    private static final String COLUNM_USER_PW = "password"; //유저 비밀번호
    private static final String COLUNM_USERNAME = "username"; //이름
    private static final String COLUNM_CONTACT = "contact"; //연락처
    private static final String COLUNM_GENDER = "gender"; //성별
    private static final String COLUNM_ROLE = "role"; //전문가, 이용자 구분

    //유저 정보 저장 테이블 구조
    private static final String CREATE_TABLE_USERS = "CREATE TABLE IF NOT EXISTS " + TABLE_USERS + " (" +
            COLUNM_USER_NUMBER + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
            COLUNM_USER_ID + " TEXT, " +
            COLUNM_USER_PW + " TEXT, " +
            COLUNM_USERNAME + " TEXT, " +
            COLUNM_CONTACT + " TEXT, " +
            COLUNM_GENDER + " TEXT, " +
            COLUNM_ROLE + " TEXT);";

    //생성자
    public DataBaseHelper(Context context){
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db){
        db.execSQL(CREATE_TABLE_USERS); //유저 정보 테이블 생성
    }

    //테이블 정보 갱신
    @Override
    public void onUpgrade(SQLiteDatabase db, int old_version, int new_version){
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_USERS);
        onCreate(db);
    }

    //사용자 정보를 테이블에 저장하는 메서드
    public long insertUser(String user_id, String user_pw, String user_name, String user_contact, String gender, int role){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put(COLUNM_USER_ID, user_id);
        values.put(COLUNM_USER_PW, user_pw);
        values.put(COLUNM_USERNAME, user_name);
        values.put(COLUNM_CONTACT, user_contact);
        values.put(COLUNM_GENDER, gender);
        values.put(COLUNM_ROLE, role);

        long result = db.insert(TABLE_USERS, null, values);
        return result;
    }
}
