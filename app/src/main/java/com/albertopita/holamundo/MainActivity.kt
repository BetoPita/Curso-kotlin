package com.albertopita.holamundo

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.albertopita.holamundo.others.ControlFlow
import com.albertopita.holamundo.others.Nullable
import com.albertopita.holamundo.others.Operators
import com.albertopita.holamundo.others.Variables

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Variables().showCases()
        Nullable()
        Operators().showCases()
        ControlFlow().showCases()
    }
}
