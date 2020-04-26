package be.ehb.proj.basicbfpapplication.tools;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class MySQLiteOpenHelper extends SQLiteOpenHelper {
// properties :  REAL => floating point value : 8byte
    private String creation = "create table profile ("
        + "datemMasure TEXT PRIMARY KEY," // no type Date so TEXT
        + "weight REAL NOT NULL,"
        + "height REAL NOT NULL,"
        + "age INTEGER NOT NULL,"
        + "sex INTEGER NOT NULL);";

    /**
     * Constructor
     * @param context
     * @param name
     * @param factory
     * @param version
     */
    public MySQLiteOpenHelper( Context context,  String name,  SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    //need 2abstract methods

    /**
     *onCreate -> if databses change
     *
     * @param db
     */
    @Override
    public void onCreate(SQLiteDatabase db) {
      //onCreate execute SQL defined in creation
        db.execSQL(creation);

    }

    /**
     * if version change
     * @param db
     * @param oldVersion
     * @param newVersion
     */
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}