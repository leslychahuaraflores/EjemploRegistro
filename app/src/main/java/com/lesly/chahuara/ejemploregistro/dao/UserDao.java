package com.lesly.chahuara.ejemploregistro.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.lesly.chahuara.ejemploregistro.bean.User;
import com.lesly.chahuara.ejemploregistro.util.Commons;

import java.security.PublicKey;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Asus on 26/05/2017.
 */

public class UserDao extends SQLiteOpenHelper {

    private static final int VERSION=1;
    private static final String TABLE_USER="Usuario";

    public UserDao (Context context){
        super(context, Commons.DATABASE,null,VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db){
        String ddl="CREATE TABLE User("+
                " id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,"+
                " name TEXT,"+
                " lastName TEXT,"+
                " user TEXT,"+
                " pass TEXT"+
                ");";
        db.execSQL(ddl);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String ddl = "DROP TABLE IF EXISTS User";
        db.execSQL(ddl);
        this.onCreate(db);
    }

    public void saveUser(User user){
        ContentValues values = new ContentValues();
        values.put("name",user.getName());
        values.put("lastName",user.getLastName());
        values.put("user",user.getUser());
        values.put("pass",user.getPass());
        getWritableDatabase().insert(TABLE_USER,null,values);
    }

    public List<User> findUserAll(){
        List<User> listUser = new ArrayList<User>();
        String columns[]={"id","name","lastName","user","pass"};
        String where = null;
        Cursor cursor = getReadableDatabase().query(TABLE_USER,columns,where,null,null,null,null);
        User user = null;
        while (cursor.moveToNext()){
            user = new User();
            user.setId(cursor.getLong(0));
            user.setName(cursor.getString(1));
            user.setLastName(cursor.getString(3));
            user.setUser(cursor.getString(4));
            user.setPass(cursor.getString(5));
            listUser.add(user);
        }
        return listUser;
    }

    public void updatePerson(User user){
        ContentValues values = new ContentValues();
        values.put("name",user.getName());
        values.put("lastName",user.getLastName());
        values.put("user",user.getUser());
        values.put("pass",user.getPass());
        getWritableDatabase().update(TABLE_USER,values,"id="+user.getId(),null);
    }

    public  User findUserById(Long id){
        String columns[]={"id","name","lastName","user","pass"};
        String where = "id="+id;
        Cursor cursor = getReadableDatabase().query(TABLE_USER,columns,where,null,null,null,null);
        User user=null;
        while (cursor.moveToNext()) {
            user = new User();
            user.setId(cursor.getLong(0));
            user.setName(cursor.getString(1));
            user.setLastName(cursor.getString(2));
            user.setUser(cursor.getString(3));
            user.setPass(cursor.getString(4));
        }
        return  user;
    }
    public void deleteUserById(Long id){
        String where = "id="+id;
    }
}

