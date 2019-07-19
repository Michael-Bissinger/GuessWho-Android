package yip.guesswhoihate.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

public class DbHelper extends SQLiteOpenHelper {


    private static final String _DB_FILE_NAME = "hate_score.db";
    private static final int _DB_VERSION = 1;
    private static final String _CREATE_TABLE = "CREATE TABLE \"hate_score\" (\n" +
            "\t\"_id\"\tINTEGER,\n" +
            "\t\"win\"\tINTEGER,\n" +
            "\t\"fail\"\tINTEGER,\n" +
            "\tPRIMARY KEY(\"_id\")\n" +
            ")";


    public DbHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        //Toast.makeText(this, "Db created!", Toast.LENGTH_LONG).show();
        db.execSQL(_CREATE_TABLE);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
