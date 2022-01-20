package com.example.simplesqlitedb

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity(), View.OnClickListener {
    private var mFirstName: EditText? = null
    private var mLastName: EditText? = null
    private var mAge: EditText? = null
    private var mSave: Button? = null
    private var mShow: Button? = null
    private var mUpdate: Button? = null
    private var mDelete: Button? = null

    private var mHelper: DbHelper? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        init()

        mHelper = DbHelper(applicationContext)





        mSave!!.setOnClickListener(this)
        mShow!!.setOnClickListener(this)

    }
    override fun onClick(v: View?) = when (v!!.id) {
        R.id.addIntoDatabase -> {

            val passValue = mHelper!!.insertData(mFirstName?.text.toString(),mLastName?.text.toString(),mAge?.text.toString().toInt())

            Toast.makeText(this, "save button clicked", Toast.LENGTH_SHORT).show()

        }
        R.id.RetrieveDataDatabase -> {
            val cursor = mHelper!!.showData()
            if(cursor.moveToFirst()){
                do {
                    val fname = cursor.getString(cursor.getColumnIndex("First_NAME"))
                    val lage = cursor.getString(cursor.getColumnIndex("Last_Name"))
                    val age = cursor.getString(cursor.getColumnIndex("Age"))
                }
                while (cursor.moveToNext())
            }
            cursor.close()

        }
        R.id.updateDatabase -> {
            Toast.makeText(this, "Update button clicked", Toast.LENGTH_SHORT).show()


        }
        R.id.DeleteDatabase -> {
            Toast.makeText(this, "Delete button clicked", Toast.LENGTH_SHORT).show()

        }
        else -> { // Note the block
            print("x is neither 1 nor 2")
        }
    }
        fun init() {
            mFirstName = findViewById(R.id.firstName)
            mLastName = findViewById(R.id.lastName)
            mAge = findViewById(R.id.id)
            mSave = findViewById(R.id.addIntoDatabase)
            mShow = findViewById(R.id.RetrieveDataDatabase)
            mUpdate = findViewById(R.id.updateDatabase)
            mDelete = findViewById(R.id.DeleteDatabase)
        }
    }
