package org.techtown.myapplication;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
public class DataBaseHandler extends DataBaseHelper{
    private final SQLiteDatabase db;

    //생성자.
    public DataBaseHandler(Context context){
        super(context);
        db = getWritableDatabase();
    }

    //유저 정보 저장 함수
    public long addUserData(String id, String pw, String name, String contact, String gender, int role){
        ContentValues values = new ContentValues();
        values.put("id", id);
        values.put("pw", pw);
        values.put("username", name);
        values.put("contact", contact);
        values.put("gender", gender);
        values.put("role", role);

        return db.insert("user_table", null, values);
    }

    //전문가 정보 추가 저장 함수
    public long addExpertData(String path, String career, String introduce, String price, String careable_pet,int number){
        ContentValues values = new ContentValues();
        values.put("image_path", path);
        values.put("career", career);
        values.put("introduce", introduce);
        values.put("price", price);
        values.put("careable_pet", careable_pet);
        values.put("confirm", 0);
        values.put("user_number", number);

        return db.insert("expert_table", null, values);
    }

    //아이디 중복 확인 함수.
    public boolean isIDExists(String id){
        Cursor cursor = db.query("user_table", new String[]{"id"},
                "id=?", new String[]{id}, null, null, null);

        boolean exists = cursor != null && cursor.getCount() > 0;

        if (cursor != null){
            cursor.close();
        }
        return exists;
    }
}
