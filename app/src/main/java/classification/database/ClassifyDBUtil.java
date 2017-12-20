package classification.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.android.gallery3d.app.Log;

import java.util.ArrayList;

/**
 * Created by wow on 12/20/17.
 */

public class ClassifyDBUtil {

    public static final String DB_NAME = "classify.db";

    private static String[] ClassifyColumnsFull = new String[]{
            ClassifyProvider.Classify._ID,
            ClassifyProvider.Classify.PATH,
            ClassifyProvider.Classify.LABEL,
            ClassifyProvider.Classify.PROB,
            ClassifyProvider.Classify.DATE_UPDATE};


    public static ArrayList<ContentValues> queryFullColumns(Context context) {

        ArrayList<ContentValues> list = new ArrayList<>();
        ClassifySQLiteOpenHelper dbHelper = new ClassifySQLiteOpenHelper(context, DB_NAME);
        SQLiteDatabase sqLiteDatabase = dbHelper.getReadableDatabase();

        Cursor cursor = sqLiteDatabase.query(ClassifyProvider.Classify.TABLE,
                ClassifyColumnsFull,
                null,
                null,
                null, null, null);

        while (cursor.moveToNext()) {
            ContentValues cv = new ContentValues();
            cv.put(ClassifyProvider.Classify._ID,
                    cursor.getInt(cursor.getColumnIndex(ClassifyProvider.Classify._ID)));
            cv.put(ClassifyProvider.Classify.PATH,
                    cursor.getString(cursor.getColumnIndex(ClassifyProvider.Classify.PATH)));
            cv.put(ClassifyProvider.Classify.LABEL,
                    cursor.getString(cursor.getColumnIndex(ClassifyProvider.Classify.LABEL)));
            cv.put(ClassifyProvider.Classify.PROB,
                    cursor.getDouble(cursor.getColumnIndex(ClassifyProvider.Classify.PROB)));
            cv.put(ClassifyProvider.Classify.DATE_UPDATE,
                    cursor.getLong(cursor.getColumnIndex(ClassifyProvider.Classify.DATE_UPDATE)));

            list.add(cv);
            Log.d("WOW", "id:" + cursor.getInt(cursor.getColumnIndex(ClassifyProvider.Classify._ID)));
            Log.d("WOW", "path:" + cursor.getString(cursor.getColumnIndex(ClassifyProvider.Classify.PATH)));
            Log.d("WOW", "label:" + cursor.getString(cursor.getColumnIndex(ClassifyProvider.Classify.LABEL)));
            Log.d("WOW", "prob:" + cursor.getDouble(cursor.getColumnIndex(ClassifyProvider.Classify.PROB)));
            Log.d("WOW", "date:" + cursor.getLong(cursor.getColumnIndex(ClassifyProvider.Classify.DATE_UPDATE)));

        }
        return list;
    }

    public static int deleteByPath(Context context, String path) {
        ClassifySQLiteOpenHelper dbHelper = new ClassifySQLiteOpenHelper(context, DB_NAME);
        SQLiteDatabase sqLiteDatabase = dbHelper.getWritableDatabase();

        int deleteValue = sqLiteDatabase.delete(ClassifyProvider.Classify.TABLE, ClassifyProvider.Classify.PATH + "=\"" + path + "\"", null);

        sqLiteDatabase.close();
//        Log.d("WOW", "delete " + deleteValue);
        return deleteValue;
    }

}
