package com.albertopita.holamundo

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.albertopita.holamundo.app.preferences
import kotlinx.android.synthetic.main.activity_shared_preferences.*

class SharedPreferencesActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_shared_preferences)
       buttonSave.setOnClickListener { setValuesSharedPreferences();cleanEditText();getValuesSharedPreferences() }
        getValuesSharedPreferences()
    }

    private fun getValuesSharedPreferences(){
        if (preferences.name.isNotEmpty() && preferences.age>=0){
            textViewSharedPreferences.text = "Welcome ${preferences.name}, your age is ${preferences.age}"
        }else{
            textViewSharedPreferences.text = "Welcome. Please save your name and your age "
        }
    }

    private fun setValuesSharedPreferences(){
        if(editTextName.text.toString().isNotEmpty() && editTextAge.text.isNotEmpty()){
            preferences.name = editTextName.text.toString()
            preferences.age = editTextAge.text.toString().toInt()
            Toast.makeText(this,"Datos guardados correctamente",Toast.LENGTH_LONG).show()
        }else{
            Toast.makeText(this,"Por favor rellena los datos antes de guardarlos",Toast.LENGTH_LONG).show()
        }
    }

    private fun cleanEditText(){
        editTextName.text.clear()
        editTextAge.setText("")
    }
}
