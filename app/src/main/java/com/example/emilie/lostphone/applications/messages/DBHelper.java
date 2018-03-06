package com.example.emilie.lostphone.applications.messages;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by Emilie on 06-03-18.
 */

public class DBHelper extends SQLiteOpenHelper {

    private final static String DATABASE_NAME = "contact";
    private final static int VERSION = 1;

    public DBHelper(Context c){
        super(c, DATABASE_NAME,null,VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        StringBuilder sb = new StringBuilder();
        sb.append("CREATE TABLE ");
        sb.append(ContactContract.TABLE_NAME);
        sb.append(" (");
        sb.append(ContactContract._ID);
        sb.append(" INTEGER PRIMARY KEY AUTOINCREMENT, ");
        sb.append(ContactContract.NAME);
        sb.append(" TEXT NOT NULL, ");
        sb.append(ContactContract.IMAGE);
        sb.append(" TEXT, ");
        sb.append(ContactContract.CONVERSATION);
        sb.append(" TEXT, ");
        sb.append(ContactContract.HIDDEN);
        sb.append(" INTEGER);");
        db.execSQL(sb.toString());
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS "+ContactContract.TABLE_NAME);
        onCreate(db);
    }

    public void addAllContact(SQLiteDatabase db, JSONArray res){
        try{
            //if(getCursorContact(db).getColumnCount()==0){

                for(int i=0;i<res.length();i++){
                    JSONObject obj = res.getJSONObject(i);
                    ContentValues cv = new ContentValues();
                    cv.put(ContactContract.NAME,obj.getString("contactName"));
                    cv.put(ContactContract.IMAGE,obj.getString("contactFace"));
                    String conv = obj.getJSONArray("conversation").toString();
                    cv.put(ContactContract.CONVERSATION,conv);
                    if(obj.getBoolean("hidden"))
                        cv.put(ContactContract.HIDDEN,1);
                    else
                        cv.put(ContactContract.HIDDEN,0);
                    db.insert(ContactContract.TABLE_NAME,null,cv);
                }
            //}
        }catch (JSONException e){
            e.printStackTrace();
        } catch(Exception e){
            Log.wtf("",e.getMessage());
        }
    }

    public Cursor getCursorContact(SQLiteDatabase db){
        String query = "SELECT * FROM "+ ContactContract.TABLE_NAME+" ORDER BY "+ ContactContract._ID+" ASC";
        return db.rawQuery(query,null);
    }
}
