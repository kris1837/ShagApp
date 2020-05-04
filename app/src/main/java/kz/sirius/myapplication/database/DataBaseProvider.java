package kz.sirius.myapplication.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Debug;
import android.provider.BaseColumns;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

public class DataBaseProvider {

    public static final String TAG = "DataBaseProvider";
    private static DataBaseProvider database = null;
    private UsersDBHelper dbHelper;

    DataBaseProvider(){}

    public static DataBaseProvider getInstance(Context context) {
        if (database == null) {
            database = new DataBaseProvider();
            database.dbHelper = new UsersDBHelper(context);
        }
        return database;
    }

    public void insertUser(String phone, String name) {
        SQLiteDatabase db = dbHelper.getWritableDatabase();

        // Create a new map of values, where column names are the keys
        ContentValues values = new ContentValues();
        values.put(DatabaseContracts.COLUMN_NAME_NAME, name);
        values.put(DatabaseContracts.COLUMN_NAME_PHONE_NUMBER, phone);

        // Insert the new row, returning the primary key value of the new row
        long newRowId = db.insert(DatabaseContracts.TABLE_NAME, null, values);
        Log.d(TAG, String.valueOf(newRowId));
    }

    public int getNumberOfUsers() {
        SQLiteDatabase db = dbHelper.getReadableDatabase();


        Cursor cursor = db.rawQuery("SELECT COUNT(*) FROM " + DatabaseContracts.TABLE_NAME, null);

        int count = 0;
        while (cursor.moveToNext()) {
            count = cursor.getInt(cursor.getColumnIndex(cursor.getColumnName(0)));
        }
        cursor.close();

        return count;
    }

    public List<User> getUsers() {
        SQLiteDatabase db = dbHelper.getReadableDatabase();

        String[] projection = {
                BaseColumns._ID,
                DatabaseContracts.COLUMN_NAME_NAME,
                DatabaseContracts.COLUMN_NAME_PHONE_NUMBER
        };

        // Filter results WHERE "title" = 'My Title'
        String selection = "*";

        Cursor cursor = db.query(
                DatabaseContracts.TABLE_NAME,   // The table to query
                projection,             // The array of columns to return (pass null to get all)
                null,              // The columns for the WHERE clause
                null,          // The values for the WHERE clause
                null,                   // don't group the rows
                null,                   // don't filter by row groups
                null               // The sort order
        );

        ArrayList users = new ArrayList<User>();
        while(cursor.moveToNext()) {
            String itemName = cursor.getString(
                    cursor.getColumnIndexOrThrow(DatabaseContracts.COLUMN_NAME_NAME));
            String itemPhone = cursor.getString(
                    cursor.getColumnIndexOrThrow(DatabaseContracts.COLUMN_NAME_PHONE_NUMBER));
            users.add(new User(itemName, itemPhone));
        }
        cursor.close();
        return users;
    }

}
