package com.example.bazz.cevahirevyemekleri.SqlLiteDB;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.bazz.cevahirevyemekleri.Database.CorbalarDB;
import com.example.bazz.cevahirevyemekleri.Database.IceceklerDB;
import com.example.bazz.cevahirevyemekleri.Database.IzgaralarDB;
import com.example.bazz.cevahirevyemekleri.Database.MenulerDB;
import com.example.bazz.cevahirevyemekleri.Database.TatlilarDB;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;


public class CevahirSQLDB extends SQLiteOpenHelper {
    // Logcat tag
    private static final String LOG = "DBHelper";

    // Database Version
    private static final int DATABASE_VERSION = 1;

    // Database Name
    private static final String DATABASE_NAME = "CevahirSQLDB";

    // Table Names
    private static final String TABLE_CORBA = "corba";
    private static final String TABLE_ICECEK = "icecek";
    private static final String TABLE_MENU = "menu";
    private static final String TABLE_TATLI = "tatli";
    private static final String TABLE_IZGARA = "izgara";

    // Common column names
    private static final String KEY_ID = "id";
    private static final String KEY_CREATED_AT = "created_at";

    // CORBA Table - column nmaes
    private static final String KEY_CORBA_ADI = "corba_adi";
    private static final String KEY_CORBA_FIYATI= "corba_fiyati";

    // ICECEK Table - column nmaes
    private static final String KEY_ICECEK_ADI = "icecek_adi";
    private static final String KEY_ICECEK_FIYATI= "icecek_fiyati";


    // IZGARA Table - column nmaes
    private static final String KEY_IZGARA_ADI = "izgara_adi";
    private static final String KEY_IZGARA_FIYATI= "izgara_fiyati";

    // MENU Table - column nmaes
    private static final String KEY_MENU_ADI = "menu_adi";
    private static final String KEY_MENU_FIYATI= "menu_fiyati";


    // TATLI Table - column nmaes
    private static final String KEY_TATLI_ADI = "tatli_adi";
    private static final String KEY_TATLI_FIYATI= "tatli_fiyati";

    // Corba table create statement
    private static final String CREATE_TABLE_CORBA = "CREATE TABLE "
            + TABLE_CORBA + "(" + KEY_ID + " INTEGER PRIMARY KEY," + KEY_CORBA_ADI
            + " TEXT," + KEY_CORBA_FIYATI + " TEXT," + KEY_CREATED_AT
            + " DATETIME" + ")";

    // Icecek table create statement
    private static final String CREATE_TABLE_ICECEK = "CREATE TABLE " + TABLE_ICECEK
            + "(" + KEY_ID + " INTEGER PRIMARY KEY," + KEY_ICECEK_ADI + " TEXT,"
            + KEY_ICECEK_FIYATI + " TEXT," + KEY_CREATED_AT
            + " DATETIME" + ")";

    // Izgara table create statement
    private static final String CREATE_TABLE_IZGARA = "CREATE TABLE " + TABLE_IZGARA
            + "(" + KEY_ID + " INTEGER PRIMARY KEY," + KEY_IZGARA_ADI + " TEXT,"
            + KEY_IZGARA_FIYATI + " TEXT," + KEY_CREATED_AT
            + " DATETIME" + ")";

    // Izgara table create statement
    private static final String CREATE_TABLE_MENU = "CREATE TABLE " + TABLE_MENU
            + "(" + KEY_ID + " INTEGER PRIMARY KEY," + KEY_MENU_ADI + " TEXT,"
            + KEY_MENU_FIYATI + " TEXT," + KEY_CREATED_AT
            + " DATETIME" + ")";

    // Tatli table create statement
    private static final String CREATE_TABLE_TATLI = "CREATE TABLE " + TABLE_TATLI
            + "(" + KEY_ID + " INTEGER PRIMARY KEY," + KEY_TATLI_ADI + " TEXT,"
            + KEY_TATLI_FIYATI + " TEXT," + KEY_CREATED_AT
            + " DATETIME" + ")";

    public CevahirSQLDB(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        // creating required tables
        db.execSQL(CREATE_TABLE_CORBA);
        db.execSQL(CREATE_TABLE_ICECEK);
        db.execSQL(CREATE_TABLE_IZGARA);
        db.execSQL(CREATE_TABLE_MENU);
        db.execSQL(CREATE_TABLE_TATLI);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // on upgrade drop older tables
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_CORBA);
        db.execSQL("DROP TABLE IF EXISTS  " + TABLE_ICECEK);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_IZGARA);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_MENU);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_TATLI);
        // create new tables
        onCreate(db);

    }
    // ------------------------ "Cevahir" table methods ----------------//

    /*
     * Creating a corba
     */
    public long createCorba(CorbalarDB corba) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_CORBA_ADI, corba.getCorba_adi());
        values.put(KEY_CORBA_FIYATI, corba.getCorba_fiyati());
        values.put(KEY_CREATED_AT, getDateTime());

        // insert row
        long corba_id = db.insert(TABLE_CORBA, null, values);

        return corba_id;
    }
    /*
     * Creating a icecek
     */
    public long createIcecek(IceceklerDB icecek) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_ICECEK_ADI, icecek.getIcecek_adi());
        values.put(KEY_ICECEK_FIYATI, icecek.getIcecek_fiyati());
        values.put(KEY_CREATED_AT, getDateTime());

        // insert row
        long icecek_id = db.insert(TABLE_ICECEK, null, values);

        return icecek_id;
    }
    /*
     * Creating a izgara
     */
    public long createIzgara(IzgaralarDB izgara) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_IZGARA_ADI, izgara.getIzgara_adi());
        values.put(KEY_IZGARA_FIYATI, izgara.getIzgara_fiyati());
        values.put(KEY_CREATED_AT, getDateTime());

        // insert row
        long izgara_id = db.insert(TABLE_IZGARA, null, values);

        return izgara_id;
    }
    /*
     * Creating a menu
     */
    public long createMenu(MenulerDB menu) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_MENU_ADI, menu.getMenu_adi());
        values.put(KEY_MENU_FIYATI, menu.getMenu_fiyati());
        values.put(KEY_CREATED_AT, getDateTime());

        // insert row
        long menu_id = db.insert(TABLE_MENU, null, values);

        return menu_id;
    }
    /*
     * Creating a tatli
     */
    public long createTatli(TatlilarDB tatli) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_TATLI_ADI, tatli.getTatli_adi());
        values.put(KEY_TATLI_FIYATI, tatli.getTatli_fiyati());
        values.put(KEY_CREATED_AT, getDateTime());

        // insert row
        long tatli_id = db.insert(TABLE_TATLI, null, values);

        return tatli_id;
    }
    /*
	 * Updating a corba
	 */
    public int updateCorba(CorbalarDB corba) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_CORBA_FIYATI, corba.getCorba_fiyati());

        // updating row
        return db.update(TABLE_CORBA, values, KEY_ID + " = ?",
                new String[] { String.valueOf(corba.getCorba_id()) });
    }
    /*
	 * Updating a icecek
	 */
    public int updateIcecek(IceceklerDB icecek) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_ICECEK_FIYATI, icecek.getIcecek_fiyati());

        // updating row
        return db.update(TABLE_ICECEK, values, KEY_ID + " = ?",
                new String[] { String.valueOf(icecek.getIcecek_id()) });
    }
    /*
	 * Updating a izgara
	 */
    public int updateIzgara(IzgaralarDB izgara) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_IZGARA_FIYATI, izgara.getIzgara_fiyati());

        // updating row
        return db.update(TABLE_IZGARA, values, KEY_ID + " = ?",
                new String[] { String.valueOf(izgara.getIzgara_id()) });
    }
    /*
	 * Updating a menu
	 */
    public int updateMenu(MenulerDB menu) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_MENU_FIYATI, menu.getMenu_fiyati());

        // updating row
        return db.update(TABLE_MENU, values, KEY_ID + " = ?",
                new String[] { String.valueOf(menu.getMenu_id()) });
    }
    /*
	 * Updating a tatli
	 */
    public int updateTatli(TatlilarDB tatli) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_TATLI_FIYATI, tatli.getTatli_fiyati());

        // updating row
        return db.update(TABLE_TATLI, values, KEY_ID + " = ?",
                new String[] { String.valueOf(tatli.getTatli_id()) });
    }


    private String getDateTime() {
        SimpleDateFormat dateFormat = new SimpleDateFormat(
                "yyyy-MM-dd HH:mm:ss", Locale.getDefault());
        Date date = new Date();
        return dateFormat.format(date);
    }
    public void closeDB() {
        SQLiteDatabase db = this.getReadableDatabase();
        if (db != null && db.isOpen())
            db.close();
    }

    public CorbalarDB getCorba(int id) {
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.query(TABLE_CORBA, new String[] { KEY_ID,
                        KEY_CORBA_ADI, KEY_CORBA_FIYATI }, KEY_ID + "=?",
                new String[] { String.valueOf(id) }, null, null, null, null);
        if (cursor != null)
            cursor.moveToFirst();

        CorbalarDB corba = new CorbalarDB(Integer.parseInt(cursor.getString(0)),
                cursor.getString(1), cursor.getString(2));
        // return contact
        return corba;
    }
    public IceceklerDB getIcecek(int id) {
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.query(TABLE_ICECEK, new String[] { KEY_ID,
                        KEY_ICECEK_ADI, KEY_ICECEK_FIYATI }, KEY_ID + "=?",
                new String[] { String.valueOf(id) }, null, null, null, null);
        if (cursor != null)
            cursor.moveToFirst();

        IceceklerDB icecek = new IceceklerDB(Integer.parseInt(cursor.getString(0)),
                cursor.getString(1), cursor.getString(2));
        // return contact
        return icecek;
    }
    public IzgaralarDB getIzgara(int id) {
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.query(TABLE_IZGARA, new String[] { KEY_ID,
                        KEY_IZGARA_ADI, KEY_IZGARA_FIYATI }, KEY_ID + "=?",
                new String[] { String.valueOf(id) }, null, null, null, null);
        if (cursor != null)
            cursor.moveToFirst();

        IzgaralarDB izgara = new IzgaralarDB(Integer.parseInt(cursor.getString(0)),
                cursor.getString(1), cursor.getString(2));
        // return contact
        return izgara;
    }
    public MenulerDB getMenu(int id) {
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.query(TABLE_MENU, new String[] { KEY_ID,
                        KEY_MENU_ADI, KEY_MENU_FIYATI }, KEY_ID + "=?",
                new String[] { String.valueOf(id) }, null, null, null, null);
        if (cursor != null)
            cursor.moveToFirst();

        MenulerDB menu = new MenulerDB(Integer.parseInt(cursor.getString(0)),
                cursor.getString(1), cursor.getString(2));
        // return contact
        return menu;
    }
    public TatlilarDB getTatli(int id) {
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.query(TABLE_TATLI, new String[] { KEY_ID,
                        KEY_TATLI_ADI, KEY_TATLI_FIYATI }, KEY_ID + "=?",
                new String[] { String.valueOf(id) }, null, null, null, null);
        if (cursor != null)
            cursor.moveToFirst();

        TatlilarDB tatli = new TatlilarDB(Integer.parseInt(cursor.getString(0)),
                cursor.getString(1), cursor.getString(2));
        // return contact
        return tatli;
    }
}
