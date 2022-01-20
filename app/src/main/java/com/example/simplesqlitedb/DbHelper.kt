package com.example.simplesqlitedb

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.util.Log
import android.widget.Toast
import org.w3c.dom.Text
import kotlin.math.log

const val DATABASE_NAME: String= "mydb"

class DbHelper(context: Context) : SQLiteOpenHelper(context,DATABASE_NAME,null,1) {
    override fun onCreate(db: SQLiteDatabase?) {


        db?.execSQL("CREATE TABLE PRODUCTS (id INTEGER primary key autoincrement,First_NAME TEXT,Last_Name TEXT,Age INTEGER)")

        // insert data also

    }

    fun insertData(mFirstName:String, mLastName :String, mAge: Int){
        val db = this.writableDatabase
        val values = ContentValues()
        values.put("First_NAME",mFirstName)
        values.put("Last_Name",mLastName)
        values.put("Age",mAge)

        db.insert("PRODUCTS", null, values)
        Log.d("check", "insertData:  data saved")


    }
    fun showData():Cursor{
        val db = this.readableDatabase
        return  db.rawQuery("SELECT * FROM PRODUCTS",null)
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        TODO("Not yet implemented")
    }
}