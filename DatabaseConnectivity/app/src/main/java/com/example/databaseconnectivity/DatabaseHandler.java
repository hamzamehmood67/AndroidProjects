package com.example.databaseconnectivity;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by amogh on 29/5/17.
 */

public class DatabaseHandler extends SQLiteOpenHelper {


    private static final String DATABASE_NAME = "DataBase";

    private static final String TABLE_CONTACTS = "table_Users";


    private static final String KEY_ID  = "id";
    private static final String USER_NAME = "username";
    private static final String USER_PASS = "password";





    public DatabaseHandler(Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_TABLE_MESSAGE = "CREATE TABLE " + TABLE_CONTACTS + "(" + USER_NAME +
                " TEXT," + USER_PASS + " TEXT" + ")";

        db.execSQL(CREATE_TABLE_MESSAGE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_CONTACTS);

        onCreate(db);
    }

    public void insertUser(User user){
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(USER_NAME,user.getUserName());
        values.put(USER_PASS,user.getPassword());


        db.insert(TABLE_CONTACTS,null,values);
        db.close();
    }

//    public void insertUserDetails(UserDetails userDetails){
//        SQLiteDatabase db = this.getWritableDatabase();
//
//        ContentValues values = new ContentValues();
//        values.put(USER_NAME,userDetails.getName());
//        values.put(USER_STATUS,userDetails.getStatus());
//        values.put(USER_PICTURE,userDetails.getPicture());
//        values.put(USER_ID,userDetails.getId());
//
//        db.insert(TABLE_USER,null,values);
//        db.close();
//
//    }

//    public UserDetails getProfile(){
//        UserDetails userDetails = new UserDetails();
//
//        String selectProfileQuery = "SELECT NAME, STATUS, PICTURE, ID FROM " + TABLE_USER + " WHERE ( ID = " + Global.user.getId() + ")";
//
//        SQLiteDatabase db = this.getWritableDatabase();
//        Cursor cursor = db.rawQuery(selectProfileQuery,null);
//
//        if(cursor.moveToFirst()){
//            userDetails.setName(cursor.getString(0));
//            userDetails.setStatus(cursor.getString(1));
//            userDetails.setPicture(cursor.getBlob(2));
//            userDetails.setId(cursor.getInt(3));
//        }
//
//        cursor.close();
//        db.close();
//        return userDetails;
//
//    }
public String getPassword(String userName) {
    // Get readable database
    SQLiteDatabase db = this.getReadableDatabase();

    // Query the database to get the user with the given username
    Cursor cursor = db.query(TABLE_CONTACTS, new String[] { USER_PASS },
            USER_NAME + "=?", new String[] { userName },
            null, null, null, null);

    String password = null;

    // If a result is found, move to the first result and get the password
    if (cursor != null && cursor.moveToFirst()) {
        password = cursor.getString(cursor.getColumnIndexOrThrow(USER_PASS));
        cursor.close();
    }

    // Close the database connection
    db.close();

    // Return the password
    return password;
}

    public List<User> getAllUser() {
        List<User> userList = new ArrayList<>();

        // Select all users from the user table
        String selectQuery = "SELECT " + USER_NAME + ", " + USER_PASS + " FROM " + TABLE_CONTACTS;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        // Loop through the result set and create User objects
        if (cursor.moveToFirst()) {
            do {
                // Create a new User object and set its properties
                User user = new User();
                user.setUserName(cursor.getString(0));  // USER_NAME
                user.setPassword(cursor.getString(1));  // USER_PASS

                // Add the User object to the list
                userList.add(user);
            } while (cursor.moveToNext());
        }

        // Close the cursor and the database
        cursor.close();
        db.close();

        // Return the list of users
        return userList;
    }


//    public String getLatest(){
//        String selectLatest = "SELECT TIMESTAMP FROM " + TABLE_MESSAGE +
//                " ORDER BY TIMESTAMP DESC LIMIT 1";
//
//        SQLiteDatabase db = this.getWritableDatabase();
//        Cursor cursor = db.rawQuery(selectLatest,null);
//
//        if(cursor.moveToFirst()){
//            return cursor.getString(0);
//        }
//
//        return null;
//    }

//    public List<ChatMessage> getAllContacts(){
//        List<ChatMessage> contacts = new ArrayList<>();
//        List<Integer> ids = new ArrayList<>();
//
//        String selectContactIdQuery = "SELECT CASE " +
//                " WHEN SENDER_ID = " + Global.senderId + " THEN RECEIVER_ID " +
//                " WHEN RECEIVER_ID = " + Global.senderId + " THEN SENDER_ID " +
//                " ELSE -1" +
//                " END " +
//                " FROM "+ TABLE_MESSAGE + " ORDER BY TIMESTAMP DESC";
//        SQLiteDatabase db = this.getWritableDatabase();
//        Cursor cursor = db.rawQuery(selectContactIdQuery,null);
//
//        if(cursor.moveToFirst()){
//            do {
//                if(cursor.getInt(0) != -1) {
//                    if(!(ids.contains(cursor.getInt(0)))) {
//                        ids.add(cursor.getInt(0));
//                    }
//                }
//            }while (cursor.moveToNext());
//        }
//        cursor.close();
//
//        int i;
//        for (i = 0;i < ids.size();i++){
//            String selectContactQuery = "SELECT * FROM " + TABLE_MESSAGE +
//                    " WHERE SENDER_ID = " + ids.get(i) + " OR RECEIVER_ID = " + ids.get(i) + " ORDER BY TIMESTAMP DESC";
//            Cursor cursor1 = db.rawQuery(selectContactQuery,null);
//
//            if(cursor1.moveToFirst()){
//                ChatMessage contact = new ChatMessage(cursor1.getString(0),cursor1.getString(1),cursor1.getInt(2),cursor1.getInt(3),cursor1.getInt(4));
//                contacts.add(contact);
//            }
//            cursor1.close();
//        }
//        db.close();
//        return contacts;
//    }
//
//    public void deleteContact(int id){
//        String deleteContactQuery = "DELETE FROM " + TABLE_MESSAGE + " WHERE ( SENDER_ID = " + id + " OR RECEIVER_ID = " + id + " ) ) ";
//        SQLiteDatabase db = this.getWritableDatabase();
//        Cursor cursor = db.rawQuery(deleteContactQuery,null);
//        cursor.close();
//        db.close();
//        return;
//    }


}
