package com.albertopita.holamundo.others
import android.app.Activity
import android.content.Intent
import android.support.design.widget.Snackbar
import android.view.DragEvent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.Toast
import com.albertopita.holamundo.R
import com.squareup.picasso.Picasso

/**
 * Created by pita on 11/12/17.
 */
fun Int.isNatural() = this >= 0

fun Activity.toast(message:CharSequence, duration:Int = Toast.LENGTH_SHORT) = Toast.makeText(this, message,duration).show()

fun Activity.toast(resourceId:Int, duration:Int = Toast.LENGTH_SHORT) = Toast.makeText(this, resourceId,duration).show()

fun Activity.snackBar(message: CharSequence, view:View? = findViewById(R.id.container), duration: Int = Snackbar.LENGTH_SHORT, action: String ? = null, actionEvent: (v: View) -> Unit = {}){
    if (view != null){
        val snackBar = Snackbar.make(view,message,duration)
        if(!action.isNullOrEmpty()){
            //existe el action, es la flechita
            snackBar.setAction(action,actionEvent)
        }
        snackBar.show()
    }
}
fun ViewGroup.inflate(layoutId:Int) = LayoutInflater.from(context).inflate(layoutId,this,false)!!

fun ImageView.loadByURL(url:String) = Picasso.with(context).load(url).into(this)

inline fun <reified T: Activity>Activity.goToActivity(noinline init:Intent.() -> Unit ={}) { // T es la clase que no sabemos que es pero llegará   init:Intent.() -> soli metódos de intent
    val intent = Intent(this,T::class.java)
    intent.init() //callback de la clase init la que se definicio como parametro
    startActivity(intent)

}

fun Activity.goToActivityResult(action:String,requesCode:Int,init:Intent.() -> Unit ={}){
    val intent = Intent(action)
    intent.init() //callback de la clase init la que se definicio como parametro
    startActivityForResult(intent,requesCode)
}