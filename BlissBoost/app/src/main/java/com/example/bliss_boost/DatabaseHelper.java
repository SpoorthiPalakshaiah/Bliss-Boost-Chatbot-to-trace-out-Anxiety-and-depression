package com.example.bliss_boost;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.widget.Toast;
import android.content.Intent;

public class DatabaseHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME;


    static {
        DATABASE_NAME = "new.db";
    }

    private Context con;


    public DatabaseHelper(Context context) {
        super(context,DATABASE_NAME,null,1);
        con=context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("Create table user(name text,phone text,email text primary key,password text)");
        db.execSQL("Create table IF NOT EXISTS mood_tab(email text,date text,mood String,CONSTRAINT fk foreign key(email) references user(email) )");




    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("Drop table if exists user");
        onCreate(db);
    }

    //Insertion

    public boolean insertData(String name,String phone,String email,String password){
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put("name",name);
        contentValues.put("phone",phone);
        contentValues.put("email",email);
        contentValues.put("password",password);



        long ins= db.insert("user",null,contentValues);
        if(ins==-1)return false;
        else
            return true;
    }


    public Boolean chkemail(String email){

        SQLiteDatabase db=this.getReadableDatabase();
        Cursor cursor=db.rawQuery("Select * from user where email=?",new String[]{email});
        if(cursor.getCount()>0)return false;
        else
            return true;
    }

    public Cursor getAllData(String email) {
        SQLiteDatabase db = this.getWritableDatabase();

        Cursor res = db.rawQuery("Select * from user where email=?",new String[]{email});
        return res;

    }

    public boolean insertDataintomood(String email,String date,String mood){
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put("email",email);
        contentValues.put("date",date);

        contentValues.put("mood",mood);



        long ins= db.insert("mood_tab",null,contentValues);
        if(ins==-1)return false;
        else
            return true;
    }


}

