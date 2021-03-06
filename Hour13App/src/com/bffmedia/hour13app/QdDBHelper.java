package com.bffmedia.hour13app;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteDatabase; 
import android.util.Log;

public class QdDBHelper extends SQLiteOpenHelper  {
	private static String DB_PATH = "";  
	private static String DB_NAME ="QLSV";// Database name
	private static String TABLE_NAME = "USER";
	
	//private final Context mContext;
	private final Context mContext; 
	SQLiteDatabase mDb;
	public QdDBHelper(Context context) {
		super(context, DB_NAME, null, 1);
		this.mContext=context;
		DB_PATH = "/data/data/" + context.getPackageName() + "/databases/";
		if(!checkDataBase()){
			try {
				createDataBase();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			//Toast.makeText(this, "database exist", Toast.LENGTH_LONG).show();
		}
	}
	public void open()
	{
		try {
			createDataBase();
			mDb = getWritableDatabase();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void createDataBase() throws IOException 
	{ 
	    //If database not exists copy it from the assets 
		boolean mDataBaseExist = checkDataBase(); 
	    if(!mDataBaseExist) 
	    { 
	        this.getReadableDatabase(); 
	        this.close(); 
	        try  
	        { 
	            //Copy the database from assests 
	            copyDataBase(); 
	            Log.e("TAG", "createDatabase database created"); 
	        }  
	        catch (IOException mIOException)  
	        { 
	            throw new Error("ErrorCopyingDataBase"); 
	        } 
	    } 
	} 
	private void copyDataBase() throws IOException 
    { 
		
        InputStream mInput = mContext.getAssets().open(DB_NAME); 
        String outFileName = DB_PATH + DB_NAME; 
        OutputStream mOutput = new FileOutputStream(outFileName); 
        byte[] mBuffer = new byte[1024]; 
        int mLength; 
        while ((mLength = mInput.read(mBuffer))>0) 
        { 
            mOutput.write(mBuffer, 0, mLength); 
        } 
        mOutput.flush(); 
        mOutput.close(); 
        mInput.close(); 
    } 
	public boolean checkDataBase() 
    { 
        File dbFile = new File(DB_PATH + DB_NAME); 
        //Log.v("dbFile", dbFile + "   "+ dbFile.exists()); 
        return dbFile.exists(); 
    } 
	@Override
	public void onCreate(SQLiteDatabase arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		// TODO Auto-generated method stub
	
	}
	public int add(User_Obj obj)
	{
		if(obj.username.equals(""))
		{
			return 0;
		}
		ContentValues tmp = new ContentValues();
		tmp.put("name", obj.username);
		tmp.put("pass", obj.password);
		return (int)mDb.insert(TABLE_NAME, null,tmp);
	}
	public int update(User_Obj obj)
	{
		ContentValues tmp = new ContentValues();
		tmp.put("name", obj.username);
		tmp.put("pass", obj.password);
		return mDb.update(TABLE_NAME, tmp, "name='"+obj.username+"'", null);
	}
	public int delete(User_Obj obj)
	{
		return mDb.delete(TABLE_NAME, "name='"+obj.username+"'", null);
	}
	public User_Obj get_obj(String name)
	{
		Cursor re =  mDb.query("USER", null, "name='"+name+"'", null, null, null, null);
		re.moveToFirst();
		return new User_Obj(
				re.getString(re.getColumnIndex("name")),
				re.getString(re.getColumnIndex("pass")));
	}
	public ArrayList<User_Obj> get_all_obj()
	{
		ArrayList<User_Obj> ree=new ArrayList<User_Obj>();
		Cursor re =  mDb.query("USER", null, null, null, null, null, null);
		if(re.moveToFirst())
		{
			for(int ii=0;ii<re.getCount();ii++)
			{
				re.moveToPosition(ii);
				User_Obj tmp = new User_Obj(
						re.getString(re.getColumnIndex("name")),
						re.getString(re.getColumnIndex("pass")));
				ree.add(tmp);
			}
		}
		return ree;
	}
	
}
