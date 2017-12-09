package com.albertopita.holamundo

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.constraint.ConstraintLayout
import android.support.design.widget.Snackbar
import android.support.v7.widget.Toolbar
import android.view.View
import android.widget.Button
import android.widget.Toast
import com.albertopita.holamundo.others.ControlFlow
import com.albertopita.holamundo.others.Nullable
import com.albertopita.holamundo.others.Operators
import com.albertopita.holamundo.others.Variables

class MainActivity : AppCompatActivity() {
    private lateinit var toolbar:Toolbar
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        toolbar = findViewById(R.id.toolbar)

        setSupportActionBar(toolbar)

        val btnLifeCycle = findViewById<Button>(R.id.button_to_cycle)
        val btnClickEvents = findViewById<Button>(R.id.button_to_click)
        val btnAndroidExt = findViewById<Button>(R.id.button_to_android_extensions)
        val btnPicasso = findViewById<Button>(R.id.button_to_picasso)
        val btnListView = findViewById<Button>(R.id.button_to_list)
        val btnIntents = findViewById<Button>(R.id.button_to_intents)
        val btnPermission = findViewById<Button>(R.id.button_to_permissions)
        val btnSharedPreferences = findViewById<Button>(R.id.button_to_shared_preferences)
        val btnExtensionFunctions = findViewById<Button>(R.id.button_to_extension_functions)

        btnLifeCycle.setOnClickListener {goToLifeCycleActivity()  }
        btnClickEvents.setOnClickListener {goToClickEventActivity()  }
        btnAndroidExt.setOnClickListener {goToKotlinAndroidExtActivity()  }
        btnPicasso.setOnClickListener {goToPicassoActivity()  }
        btnListView.setOnClickListener {goToListActivity()  }
        btnIntents.setOnClickListener {goToIntentsActivity()  }
        btnPermission.setOnClickListener {goToPermissionActivity()  }
        btnSharedPreferences.setOnClickListener {goToSharedPreferencesActivity()  }
        btnExtensionFunctions.setOnClickListener {goToFunctionsActivity()  }
        
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

    private fun goToLifeCycleActivity() =  startActivity(Intent(this,LifeCycleActivity::class.java))
    private fun goToClickEventActivity() =  startActivity(Intent(this,ClickEventsActivity::class.java))


    private fun goToKotlinAndroidExtActivity() =  startActivity(Intent(this,kotlinAndroidExtensionActivity::class.java))
    private fun goToPicassoActivity() =  startActivity(Intent(this,PicassoActivity::class.java))
    private fun goToListActivity() =  startActivity(Intent(this,ListViewActivity::class.java))
    private fun goToIntentsActivity() =  startActivity(Intent(this,IntentsActivity::class.java))
    private fun goToPermissionActivity() =  startActivity(Intent(this,PermissionsActivity::class.java))
    private fun goToSharedPreferencesActivity() =  startActivity(Intent(this,SharedPreferencesActivity::class.java))
    private fun goToFunctionsActivity() =  startActivity(Intent(this,ExtensionFunctionsActivity::class.java))
}
