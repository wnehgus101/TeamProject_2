package org.techtown.myapplication;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
public class DataBaseHandler {
    private final SQLiteDatabase db;

    public DataBaseHandler(Context context){
        DataBaseHelper db_helper = new DataBaseHelper(context);
        db = db_helper.getWritableDatabase();
    }

    //
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

    public long addExpertData(int number, String path, String career, String introduce, String price, String careable_pet){
        ContentValues values = new ContentValues();
        values.put("number", number);
        values.put("path", path);
        values.put("career", career);
        values.put("introduce", introduce);
        values.put("price", price);
        values.put("careable_pet", careable_pet);

        return db.insert("expert_table", null, values);
    }
}
