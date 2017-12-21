package classification.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wow on 12/20/17.
 */

public class ClassifySQLiteOpenHelper extends SQLiteOpenHelper {

    private static Integer DB_VERSION = 1;

    private static final String SQL_CREATE_TABLE = "CREATE TABLE ";

    private static final String[][] CREATE_CLASSIFY = {
            {ClassifyProvider.Classify._ID, "INTEGER PRIMARY KEY AUTOINCREMENT"},
            {ClassifyProvider.Classify.PATH, "TEXT NOT NULL"},
            {ClassifyProvider.Classify.CLASS, "TEXT"},
            {ClassifyProvider.Classify.LABEL, "TEXT"},
            {ClassifyProvider.Classify.PROB, "REAL"},
            {ClassifyProvider.Classify.DATE_UPDATE, "INTEGER"},
    };

    protected List<String[]> getClassifyTableDefinition() {
        return tableCreationStrings(CREATE_CLASSIFY);
    }

    protected static List<String[]> tableCreationStrings(String[][] createTable) {
        ArrayList<String[]> create = new ArrayList<String[]>(createTable.length);
        for (String[] line : createTable) {
            create.add(line);
        }
        return create;
    }

    public ClassifySQLiteOpenHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    public ClassifySQLiteOpenHelper(Context context,String name,int version)
    {
        super(context,name,null,version);
    }

    public ClassifySQLiteOpenHelper(Context context,String name)
    {
        super(context, name, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        createTable(db, ClassifyProvider.Classify.TABLE, getClassifyTableDefinition());
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        recreate(db);
    }

    @Override
    public void onDowngrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        recreate(db);
    }

    protected static void createTable(SQLiteDatabase db, String table, List<String[]> columns) {
        StringBuilder create = new StringBuilder(SQL_CREATE_TABLE);
        create.append(table).append('(');
        boolean first = true;
        for (String[] column : columns) {
            if (!first) {
                create.append(',');
            }
            first = false;
            for (String val: column) {
                create.append(val).append(' ');
            }
        }
        create.append(')');
        db.beginTransaction();
        try {
            db.execSQL(create.toString());
            db.setTransactionSuccessful();
        } finally {
            db.endTransaction();
        }
    }

    private void recreate(SQLiteDatabase db) {
        dropTable(db, ClassifyProvider.Classify.TABLE);
        onCreate(db);
    }

    protected static void dropTable(SQLiteDatabase db, String table) {
        db.beginTransaction();
        try {
            db.execSQL("drop table if exists " + table);
            db.setTransactionSuccessful();
        } finally {
            db.endTransaction();
        }
    }
}
