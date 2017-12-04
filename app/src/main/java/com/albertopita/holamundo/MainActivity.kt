package com.albertopita.holamundo

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.constraint.ConstraintLayout
import android.support.design.widget.Snackbar
import android.view.View
import android.widget.Toast
import com.albertopita.holamundo.others.ControlFlow
import com.albertopita.holamundo.others.Nullable
import com.albertopita.holamundo.others.Operators
import com.albertopita.holamundo.others.Variables

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        
    }

    fun showToast(){
        Toast.makeText(this,"Hello from Toast",Toast.LENGTH_LONG).show()
    }

    fun showSnackBar(){
        val layout = findViewById<ConstraintLayout>(R.id.constraint)
        //Snackbar.make(layout,"Hellow from Snackbar",Snackbar.LENGTH_LONG).show()
        Snackbar.make(layout,"Hellow from Snackbar",Snackbar.LENGTH_LONG).setAction("UNDO"){
            Snackbar.make(layout,"Email haz been restored",Snackbar.LENGTH_LONG).show()
        }.show()
    }
}
