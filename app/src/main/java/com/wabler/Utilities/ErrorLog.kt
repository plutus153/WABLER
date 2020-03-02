package com.wabler.Utilities

import android.annotation.SuppressLint
import android.util.Log
import java.lang.Exception
import java.time.LocalDateTime

const val FILTER: String = "WABLER"

class ErrorLog {

    companion object {

        @SuppressLint("NewApi")
        fun WriteErrorLog(e: Exception){

            //https://www.baeldung.com/kotlin-dates

            val current = LocalDateTime.now()

            Log.d(FILTER, "\r\n" +
                    "Time: " + "$current" + "\r\n" +
                    "Method Name: " + e.stackTrace.get(0).methodName + "\r\n" +
                    "Err Num: " + e.stackTrace.get(0).lineNumber + "\r\n" +
                    "Err Desc: " + e.message + "\r\n" +
                    "FileName: " + e.stackTrace.get(0).fileName + "\r\n" +
                    "")
        }

        @SuppressLint("NewApi")
        fun WriteErrorLog(e: Exception, addMsg: String){

            val current = LocalDateTime.now()

            Log.d(FILTER, "\r\n" +
                    "Time: " + "$current" + "\r\n" +
                    "Method Name: " + e.stackTrace.get(0).methodName + "\r\n" +
                    "Err Num: " + e.stackTrace.get(0).lineNumber + "\r\n" +
                    "Err Desc: " + e.message + "\r\n" +
                    "addMsg: " + "$addMsg" + "\r\n" +
                    "")
        }

        fun WriteDebugLog(msg: String){
            Log.d(FILTER, msg)
            Log.d(FILTER, "")
        }
    }
}