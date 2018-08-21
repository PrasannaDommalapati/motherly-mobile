package com.prasannakc.dissertation;

/**
 * Created by PrasannaKC on 29/04/2015.
 */
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.provider.BaseColumns;
import android.util.Log;

public class DatabaseHandler extends SQLiteOpenHelper {

    static final String TAG = "DbHelper";
    static  final String DB_NAME = "MoMS.db";
    static final int DB_VERSION = 1;
    static final String TABLE_NAME = "login";
    static final String C_ID = BaseColumns._ID;
    static final String C_USER_NAME = "username";
    static final String C_PASSWORD = "password";
    static final String C_EMAIL = "email";


    public DatabaseHandler(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = "CREATE TABLE " + TABLE_NAME +"(" + C_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                + C_USER_NAME + " TEXT,"
                + C_PASSWORD + " TEXT,"
                + C_EMAIL +" TEXT)";

        db.execSQL(sql);
        Log.d(TAG, "on Created SQL:" + sql);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL("DROP TABLE IF EXISTS"+TABLE_NAME);
        onCreate(db);
    }

    //operations CRUD implementation
    public void createUser(Users user){

        SQLiteDatabase db = getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(C_USER_NAME,user.get_username());
        cv.put(C_PASSWORD,user.get_password());
        cv.put(C_EMAIL,user.get_email());

        db.insert(TABLE_NAME, null, cv);
        db.close();
    }

    public int getUsersCount(){
        SQLiteDatabase db = getReadableDatabase();


        Cursor cs = db.rawQuery(" SELECT * FROM " + TABLE_NAME  ,null);
        int i = cs.getCount();


        db.close();
        cs.close();

        return i;
    }

    public Cursor getInformation(DatabaseHandler dbh){

        SQLiteDatabase db =  getReadableDatabase();
        String[]columns = {C_USER_NAME,C_PASSWORD};
        Cursor cur = db.query(TABLE_NAME,columns,null,null,null,null,null);
        return cur;

    }
}
