package com.albertopita.holamundo.others

import android.content.Context

/**
 * Created by pita on 11/12/17.
 */
class MySharedPreferences(context:Context){
    //Nombre fichero shared preferences
    private val fileName = "mis_preferencias"
    //Intancia de ese fichero
    private val prefs = context.getSharedPreferences(fileName,Context.MODE_PRIVATE)

    // Por cada una de las variables que vamos a guardar en nuestro fichero shared preferences
    var name : String
    get() = prefs.getString("name","")
    set(value) = prefs.edit().putString("name",value).apply()

    var age : Int
        get() = prefs.getInt("age",-1)
        set(value) = prefs.edit().putInt("age",value).apply()
}