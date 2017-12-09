package com.albertopita.holamundo

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.widget.Toast

class LifeCycleActivity : AppCompatActivity() {
    private var exitEnable = false
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_life_cycle3)
    }

    override fun onBackPressed() {
        if(exitEnable){
            super.onBackPressed()
        }
        exitEnable = true
        Toast.makeText(this,"Click otra vez para salir",Toast.LENGTH_LONG).show()
        Handler().postDelayed(Runnable { exitEnable = false },2000) // creas una acción para que cuando pasen dos segundos se corra la acción  (da a back y si no clickea en dos segundos va volver a ser false la variable)


    }
}
