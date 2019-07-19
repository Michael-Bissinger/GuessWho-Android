package yip.guesswhoihate.db;

import android.database.sqlite.SQLiteDatabase;

final class HateScoreTable {

    private static final String _CREATE_TABLE = "CREATE TABLE \"hate_score\" (\n" +
            "\t\"_id\"\tINTEGER,\n" +
            "\t\"win\"\tINTEGER,\n" +
            "\t\"fail\"\tINTEGER,\n" +
            "\tPRIMARY KEY(\"_id\")\n" +
            ")";

    static void createTable(SQLiteDatabase db) {
        db.execSQL((_CREATE_TABLE));
    }

}
