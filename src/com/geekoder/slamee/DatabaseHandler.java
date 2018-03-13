package com.geekoder.slamee;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import java.util.ArrayList;
import java.util.List;


public class DatabaseHandler extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;

    private static final String DATABASE_NAME = "SlameeManager",
    TABLE_CONTACTS = "slamees",
    KEY_ID = "id",
    KEY_NAME = "name",
    KEY_NICK = "nick",
    KEY_DAY = "day",
    KEY_MONTH = "month",
    KEY_YEAR="year",
    KEY_BACK = "back",
    KEY_PHONE = "phone",
    KEY_FB = "fb",
    KEY_HOBBY = "hobby",
    KEY_DEAR   = "dear",
    KEY_PLACE = "place",
    KEY_SCRT = "scrt",
    KEY_LIVE = "live",
    KEY_LOVE = "love",
    KEY_DREAM = "dream",
    KEY_INSPIRE = "inspire",
    KEY_YOU = "you",
    KEY_MSG = "msg",
    //KEY_SIGN = "sign",
   KEY_IMAGE = "image";

    public DatabaseHandler(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE " + TABLE_CONTACTS + "(" + KEY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," + KEY_NAME + " TEXT," + KEY_NICK + " TEXT," + KEY_DAY + " TEXT," + KEY_MONTH + " TEXT,"+ KEY_YEAR + " TEXT,"+ KEY_BACK + " TEXT,"+ KEY_PHONE + " TEXT,"+ KEY_FB+ " TEXT,"+ KEY_HOBBY + " TEXT," + KEY_DEAR + " TEXT,"+ KEY_PLACE + " TEXT,"+ KEY_SCRT + " TEXT,"+ KEY_LIVE + " TEXT,"+ KEY_LOVE + " TEXT,"+ KEY_DREAM + " TEXT,"+ KEY_INSPIRE + " TEXT,"+ KEY_YOU + " TEXT,"+ KEY_MSG + " TEXT,"+  KEY_IMAGE + "  BLOB)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_CONTACTS);

        onCreate(db);
    }

    public void createContact(Slamee slam) {
        SQLiteDatabase db = getWritableDatabase();

        ContentValues values = new ContentValues();

        values.put(KEY_NAME, slam.getName());
        values.put(KEY_NICK, slam.getNick());
        values.put(KEY_DAY, slam.getday());
        values.put(KEY_MONTH, slam.getmonth());
        values.put(KEY_YEAR, slam.getyear());
        values.put(KEY_BACK, slam.getback());
        values.put(KEY_PHONE, slam.getPhone());
        values.put(KEY_FB, slam.getfb());
        values.put(KEY_HOBBY, slam.gethobby());
        values.put(KEY_DEAR, slam.getdear());
        values.put(KEY_PLACE, slam.getplace());
        values.put(KEY_SCRT, slam.getscrt());
        values.put(KEY_LIVE, slam.getlive());
        values.put(KEY_LOVE, slam.getlove());
        values.put(KEY_DREAM, slam.getdream());
        values.put(KEY_INSPIRE, slam.getinspire());
        values.put(KEY_YOU, slam.getyou());
        values.put(KEY_MSG, slam.getmsg());
        values.put(KEY_IMAGE, slam.getImage());
       // values.put(KEY_SIGN, slam.getSign());
        db.insert(TABLE_CONTACTS, null, values);
        db.close();
    }

    public Slamee getContact(int id) {
        SQLiteDatabase db = getReadableDatabase();

        Cursor cursor = db.query(TABLE_CONTACTS, new String[] { KEY_ID, KEY_NAME, KEY_NICK, KEY_DAY, KEY_MONTH, KEY_YEAR,KEY_BACK, KEY_PHONE, KEY_FB, KEY_HOBBY, KEY_DEAR, KEY_PLACE, KEY_SCRT, KEY_LIVE, KEY_LOVE, KEY_DREAM, KEY_INSPIRE, KEY_YOU, KEY_MSG, KEY_IMAGE}, KEY_ID + "=?", new String[] { String.valueOf(id) }, null, null, null, null );

        if (cursor != null)
            cursor.moveToFirst();

        Slamee contact = new Slamee(Integer.parseInt(cursor.getString(0)), cursor.getString(1), cursor.getString(2), cursor.getString(3), cursor.getString(4),cursor.getString(5), cursor.getString(6),  cursor.getString(7),  cursor.getString(8),  cursor.getString(9),  cursor.getString(10),  cursor.getString(11),  cursor.getString(12),  cursor.getString(13),  cursor.getString(14),  cursor.getString(15),  cursor.getString(16),  cursor.getString(17), cursor.getString(18), cursor.getBlob(19)); 
        db.close();
        cursor.close();
        return contact;
    }

    public void deleteContact(Slamee slam) {
        SQLiteDatabase db = getWritableDatabase();
        db.delete(TABLE_CONTACTS, KEY_ID + "=?", new String[] { String.valueOf(slam.getId()) });
        db.close();
    }

    public int getContactCount() {
        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM " + TABLE_CONTACTS, null);
        int count = cursor.getCount();
        db.close();
        cursor.close();

        return count;
    }

    public int updateContact(Slamee slam) {
        SQLiteDatabase db = getWritableDatabase();

        ContentValues values = new ContentValues();

        values.put(KEY_NAME, slam.getName());
        values.put(KEY_NICK, slam.getNick());
        values.put(KEY_DAY, slam.getday());
        values.put(KEY_MONTH, slam.getmonth());
        values.put(KEY_YEAR, slam.getyear());
        values.put(KEY_BACK, slam.getback());
        values.put(KEY_PHONE, slam.getPhone());
        values.put(KEY_FB, slam.getfb());
        values.put(KEY_HOBBY, slam.gethobby());
        values.put(KEY_DEAR, slam.getdear());
        values.put(KEY_PLACE, slam.getplace());
        values.put(KEY_SCRT, slam.getscrt());
        values.put(KEY_LIVE, slam.getlive());
        values.put(KEY_LOVE, slam.getlove());
        values.put(KEY_DREAM, slam.getdream());
        values.put(KEY_INSPIRE, slam.getinspire());
        values.put(KEY_YOU, slam.getyou());
        values.put(KEY_MSG, slam.getmsg());
        values.put(KEY_IMAGE, slam.getImage());
        int rowsAffected = db.update(TABLE_CONTACTS, values, KEY_ID + "=?", new String[] { String.valueOf(slam.getId()) });
        db.close();

        return rowsAffected;
    }

    public List<Slamee> getAllSlamees() {
        List<Slamee> slamees = new ArrayList<Slamee>();


        SQLiteDatabase db = getWritableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM "+  TABLE_CONTACTS, null);

        if (cursor.moveToFirst()) {
            do {
            	slamees.add(new Slamee(Integer.parseInt(cursor.getString(0)), cursor.getString(1), cursor.getString(2), cursor.getString(3), cursor.getString(4), cursor.getString(5), cursor.getString(6), cursor.getString(7), cursor.getString(8), cursor.getString(9), cursor.getString(10), cursor.getString(11), cursor.getString(12), cursor.getString(13), cursor.getString(14), cursor.getString(15), cursor.getString(16), cursor.getString(17), cursor.getString(18), cursor.getBlob(19)));
            
            }
            while (cursor.moveToNext());
        }
        cursor.close();
        db.close();
        return slamees;
    }
    
    public List<Slamee> getAllSlamees1() {
        List<Slamee> slamees = new ArrayList<Slamee>();

String a ="shiva";
int aa=1;
        SQLiteDatabase db = getWritableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM "+TABLE_CONTACTS,null);
      
        if (cursor.moveToFirst()) {
            do {
            	slamees.add(new Slamee(Integer.parseInt(cursor.getString(0)), cursor.getString(1), cursor.getString(2), cursor.getString(3), cursor.getString(4), cursor.getString(5), cursor.getString(6), cursor.getString(7), cursor.getString(8), cursor.getString(9), cursor.getString(10), cursor.getString(11), cursor.getString(12), cursor.getString(13), cursor.getString(14), cursor.getString(15), cursor.getString(16), cursor.getString(17), cursor.getString(18), cursor.getBlob(19)));
            
            }
            while (cursor.moveToNext());
        }
        cursor.close();
        db.close();
        return slamees;
    }
    
}
