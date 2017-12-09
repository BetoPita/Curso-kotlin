package com.albertopita.holamundo

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast

class ClickEventsActivity : AppCompatActivity(),  View.OnLongClickListener {

    // 1) Click en XML
    // 2) En línea
    // 3) Click by IDS en 'when'

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_click_events2)
        clickInLine()

        //metodo 3
        val btn1 = findViewById<Button>(R.id.buttonClickMulti1)
        val btn2 = findViewById<Button>(R.id.buttonClickMulti2)
        val btn3 = findViewById<Button>(R.id.buttonClickMulti3)

        btn1.setOnLongClickListener(this)
        btn2.setOnLongClickListener(this)
        btn3.setOnLongClickListener(this)
    }

    //Regla obligatoria para click en xml
    //El método tiee que ser público, nombres tienen que coincidir y recibe 1 sólo parametro (View)
    fun xmlClick(view: View){
        Toast.makeText(this,"Click desde xml click",Toast.LENGTH_LONG).show()
    }
    private  fun clickInLine(){
        val btn = findViewById<Button>(R.id.buttonClickInLine)
        btn.setOnClickListener {
            Toast.makeText(this,"Click in line",Toast.LENGTH_LONG).show()
        }
    }

    override fun onLongClick(view: View): Boolean {
        when(view.id){
            R.id.buttonClickMulti1 -> Toast.makeText(this,"Click desde multi 1",Toast.LENGTH_LONG).show()
            R.id.buttonClickMulti2 -> Toast.makeText(this,"Click desde multi 2",Toast.LENGTH_LONG).show()
            R.id.buttonClickMulti3 -> Toast.makeText(this,"Click desde multi 3",Toast.LENGTH_LONG).show()
        }
        return true
    }
}
