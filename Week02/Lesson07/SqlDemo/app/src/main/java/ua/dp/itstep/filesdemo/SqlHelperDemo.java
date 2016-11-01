package ua.dp.itstep.filesdemo;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by max on 02.11.2016.
 */

public class SqlHelperDemo extends SQLiteOpenHelper {

    public SqlHelperDemo(Context context) {
        super(context, "database.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table db (id integer not null primary key autoincrement, data text)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop if exists db");
        onCreate(db);
    }
}
