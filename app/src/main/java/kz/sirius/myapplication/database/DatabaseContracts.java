package kz.sirius.myapplication.database;

import static android.provider.BaseColumns._ID;

public class DatabaseContracts {

    public static final String TABLE_NAME = "users_table";
    public static final String COLUMN_NAME_NAME = "name";
    public static final String COLUMN_NAME_PHONE_NUMBER = "phone_number";

    public static final String SQL_CREATE_ENTRIES =
            "CREATE TABLE " + TABLE_NAME + " (" +
                    _ID + " INTEGER PRIMARY KEY," +
                    COLUMN_NAME_NAME + " TEXT," +
                    COLUMN_NAME_PHONE_NUMBER + " TEXT)";

    public static final String SQL_DELETE_ENTRIES =
            "DROP TABLE IF EXISTS " + TABLE_NAME;


}
