package classification.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteOpenHelper;
import android.net.Uri;
import android.provider.BaseColumns;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.android.libs.src_pd.photos.data.PhotoProviderAuthority;
import com.android.photos.data.SQLiteContentProvider;

import static classification.database.ClassifyDBUtil.DB_NAME;

/**
 * Created by wow on 12/20/17.
 */

public class ClassifyProvider extends SQLiteContentProvider {

//    protected static final String DB_NAME = "classify.db";
    public static final String AUTHORITY = PhotoProviderAuthority.AUTHORITY;
    static final Uri BASE_CONTENT_URI = new Uri.Builder().scheme("content").authority(AUTHORITY)
            .build();

    public static interface Classify extends BaseColumns {
        public static final String TABLE = "classification";
        public static final  Uri CONTENT_URI = Uri.withAppendedPath(BASE_CONTENT_URI, TABLE);

        public static final String PATH = "path";
        public static final String LABEL = "label";
        public static final String PROB = "probability";
        public static final String DATE_UPDATE = "date_update";
    }

    @Override
    public SQLiteOpenHelper getDatabaseHelper(Context context) {
        return new ClassifySQLiteOpenHelper(context, DB_NAME);
    }

    @Override
    public Uri insertInTransaction(Uri uri, ContentValues values, boolean callerIsSyncAdapter) {
        return null;
    }

    @Override
    public int updateInTransaction(Uri uri, ContentValues values, String selection, String[] selectionArgs, boolean callerIsSyncAdapter) {
        return 0;
    }

    @Override
    public int deleteInTransaction(Uri uri, String selection, String[] selectionArgs, boolean callerIsSyncAdapter) {
        return 0;
    }

    @Nullable
    @Override
    public Cursor query(@NonNull Uri uri, @Nullable String[] projection, @Nullable String selection, @Nullable String[] selectionArgs, @Nullable String sortOrder) {
        return null;
    }

    @Nullable
    @Override
    public String getType(@NonNull Uri uri) {
        return null;
    }
}
