package com.example.sqlexamplekotlin

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import java.sql.PreparedStatement
import java.sql.ResultSet

class MainActivity : AppCompatActivity() {


    private var connectSql = ConnectSql()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val buttonCon : Button = findViewById(R.id.buttonCon)
        buttonCon.setOnClickListener(){
            helper()
        }
    }


    fun helper(){
        try{
            val statement: PreparedStatement = connectSql.dbConn()?.prepareStatement("Select * from Customers")!!
            val rs : ResultSet =  statement.executeQuery()
            val name : TextView = findViewById(R.id.result_TextView)
            while(rs.next()){
                name.text = rs.getString("CustomerName")
            }
        }
        catch(e : Exception){

        }

    }

}