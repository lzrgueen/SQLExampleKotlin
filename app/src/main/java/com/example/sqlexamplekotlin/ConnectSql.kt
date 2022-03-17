package com.example.sqlexamplekotlin

import android.os.StrictMode
import android.util.Log
import java.sql.Connection
import java.sql.DriverManager

class ConnectSql {
    private val ip = "192.168.3.119:1433"
    private val db = "LearnCMD"
    private val username = "LTS"
    private val password = "lts114514"

    fun dbConn(): Connection?{
        val policy = StrictMode.ThreadPolicy.Builder().permitAll().build()
        StrictMode.setThreadPolicy(policy)
        var conn : Connection? = null
        val ConnString : String
        try{
            Class.forName("net.sourceforge.jtds.jdbc.Driver").newInstance()
            ConnString =  "jdbc:jtds:sqlserver://$ip;databasename=$db;user=$username;password=$password"
            conn = DriverManager.getConnection(ConnString)
        }
        catch(ex: Exception){
            Log.e("Error: ",ex.message!!)
        }
        return conn
    }
}