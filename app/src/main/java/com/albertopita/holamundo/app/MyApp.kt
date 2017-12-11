package com.albertopita.holamundo.app

import android.app.Application
import com.albertopita.holamundo.others.MySharedPreferences

/**
 * Created by pita on 11/12/17.
 */

val preferences: MySharedPreferences by lazy { MyApp.prefs!!} // se puede acceder globalmente by lazy si no se usan las preferencias nunca será ejecutrado
class MyApp : Application(){
    companion object {
        var prefs:MySharedPreferences? = null
    }

    override fun onCreate() {

        prefs = MySharedPreferences(applicationContext) // crear una instancia a sharedpreferences
    }
}