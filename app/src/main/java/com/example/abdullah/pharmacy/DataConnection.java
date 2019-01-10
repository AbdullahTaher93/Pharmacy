package com.example.abdullah.pharmacy;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import java.util.ArrayList;

public class DataConnection extends SQLiteOpenHelper {

        public static final String namedb="clint.db";
        public static final int version=1;


        public DataConnection( Context context) {
            super(context, namedb, null, version);
        }

        @Override
        public void onCreate(SQLiteDatabase db) {
            db.execSQL("create table if not exists cus(id INTEGER PRIMARY KEY,name,surename,birthday,email,password,ccard)");
         //   db.execSQL("create table if not exists phrmacyprduct(pharmacyid,productid,quantity)");


        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int i, int i1) {
            db.execSQL("drop table if exists cus");
           // db.execSQL("drop table if exists phrmacyprduct");
        }
        private String CREATE_USER_TABLE = "CREATE TABLE TABLE_USER (COLUMN_USER_ID  INTEGER PRIMARY KEY AUTOINCREMENT, COLUMN_USER_NAME  TEXT,COLUMN_USER_EMAIL TEXT,COLUMN_USER_PASSWORD  TEXT, COLUMN_USER_CREDIT_CARD TEXT)";

        public void insertvalue(String name,String surename ,String birthday,String email,String password,String ccard){
            SQLiteDatabase db=this.getWritableDatabase();
            ContentValues contentValues=new ContentValues();
            // if(viewdata(email,password)==false)

            contentValues.put("name",name);
            contentValues.put("surename",surename);
            contentValues.put("birthday",birthday);
            contentValues.put("email",email);
            contentValues.put("password",password);
            contentValues.put("ccard",ccard);
            db.insert("cus",null,contentValues);


        }


  /*  public void insertvalueofpharmacy(String pharmacyid,String productid,String quantity){
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        // if(viewdata(email,password)==false)

        contentValues.put("pharmacyid",pharmacyid);
        contentValues.put("productid",productid);
        contentValues.put("quantity",quantity);

        db.insert("phrmacyprduct",null,contentValues);


    }*/

        public boolean viewdata(String email,String password){
            ArrayList arrayList=new ArrayList();
            SQLiteDatabase db=getReadableDatabase();
            Cursor cursor;

            cursor= db.rawQuery("select email from cus where email='"+email+"' and password='"+password+"' ",null);
            if(cursor.getCount()!=0)
                return true;
            else
                return false;



        }




    }

