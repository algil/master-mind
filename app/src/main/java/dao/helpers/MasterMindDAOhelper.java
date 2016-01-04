package dao.helpers;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import dao.constants.ConstantsDb;

/**
 * Created by LENOVO on 04/01/2016.
 */
public class MasterMindDAOhelper extends SQLiteOpenHelper {
    private static final String SQL_CREATE_ENTRIES =
            "CREATE TABLE " + ConstantsDb.RANKING_TABLE_NAME
                    + "("
                    + ConstantsDb.DB_MASTERMIND_TABLE_FIELD_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                    + ConstantsDb.DB_MASTERMIND_TABLE_FIELD_PLAYERNAME + " TEXT,"
                    + ConstantsDb.DB_MASTERMIND_TABLE_FIELD_POINTS +  " INTEGER,"
                    + ConstantsDb.DB_MASTERMIND_TABLE_FIELD_REGISTER_DATE +  " TEXT"
                    + ")";

    private static final String SQL_DELETE_ENTRIES =
            "DROP TABLE IF EXISTS " + ConstantsDb.RANKING_TABLE_NAME;

    public MasterMindDAOhelper(Context context) {
        super(context, ConstantsDb.DATABASE_NAME, null, ConstantsDb.DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SQL_CREATE_ENTRIES);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(SQL_DELETE_ENTRIES);
        onCreate(db);
    }

}
