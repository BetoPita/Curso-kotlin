package com.albertopita.holamundo

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.albertopita.holamundo.others.goToActivity
import com.albertopita.holamundo.others.loadByURL
import com.albertopita.holamundo.others.snackBar
import com.albertopita.holamundo.others.toast
import kotlinx.android.synthetic.main.activity_extension_functions.*

class ExtensionFunctionsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_extension_functions)
        buttonToast.setOnClickListener { toast("Hola")}
        //buttonToast.setOnClickListener { toast(R.layout.activity_extension_functions)}
        buttonSnackBar.setOnClickListener { snackBar("I love extension functions!",action = "Undo"){toast("Undo!!")} }
        buttonloadByUrl.setOnClickListener {imageViewLoadedByURL.loadByURL("https://image.freepik.com/vector-gratis/fondo-de-texto-de-navidad-con-imagen-de-arbol-desenfocado_1048-7089.jpg")  }
        buttonGoToActivity.setOnClickListener { goToActivity<MainActivity>{putExtra("id",1)}}
    }
}
