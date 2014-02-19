package Storage;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import model.Issue;

import java.util.ArrayList;
import java.util.List;


public class DataStorage extends SQLiteOpenHelper {
    private static final String TABLE_NAME = "issues";
    private static final String TITLE_COL = "title";
    private static final String DESCRIPTION_COL = "description";
    private static final String DB_NAME = "kranti.db";
    private static final String CREATE_TABLE_CS = "CREATE TABLE "+ TABLE_NAME + "(" + TITLE_COL + " TEXT NOT NULL, " + DESCRIPTION_COL + " TEXT NOT NULL);";


    public DataStorage(Context context) {
        super(context, DB_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) { //create your database
        db.execSQL(CREATE_TABLE_CS);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
    }


    public void store(Issue issue) { //insert into your database
      SQLiteDatabase db = getWritableDatabase();
        db.execSQL("INSERT INTO "+ TABLE_NAME + " ("+TITLE_COL+","+DESCRIPTION_COL+") VALUES ('" + issue.getTitle()+"','" + issue.getDescription()+"');");
    }

//    public List<Issue> get() {
//
//    }

}
