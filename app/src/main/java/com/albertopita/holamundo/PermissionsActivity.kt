package com.albertopita.holamundo

import android.Manifest
import android.app.Activity
import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.Bitmap
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.support.v4.app.ActivityCompat
import android.support.v4.content.ContextCompat
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_permissions.*

class PermissionsActivity : AppCompatActivity() {
    private val requestCameraPermission = 100
    private val requestCameraPicture = 200

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_permissions)
        //buttonPicture.setOnClickListener { getPictureFromCameraAskingPermissions() }
        buttonPicture.setOnClickListener { getPictureFromCamera() }
    }
    private fun getPictureFromCamera(){
        //Aseguramos que no hay permiso de camara en manifest
        //Crear intent para capturar la foto

        val pictureIntent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
        //Comprobar que podemos manejar la captura de fotos (Tenemos camara y app de camara)
        if(pictureIntent.resolveActivity(packageManager) != null){
            startActivityForResult(pictureIntent,requestCameraPicture)
        }else{
            //No hay camara o aplicación de camara para usar
            Toast.makeText(this,"Camera it's failed!",Toast.LENGTH_LONG).show()
        }
    }
    private fun getPictureFromCameraAskingPermissions(){
        //Añadir permiso al manifest
        //Comprobar el permiso de la cámara
        if(ContextCompat.checkSelfPermission(this, Manifest.permission.CAMERA) !=  PackageManager.PERMISSION_GRANTED){
            // SI NO HA SIDO ACEPTADO PREVIAMENTE (Para versiones desde la 6.0 (api 23) en adelante )
            ActivityCompat.requestPermissions(this, arrayOf(Manifest.permission.CAMERA),requestCameraPermission)
        }else{
            // Si ha sido aceptado previamente (para versiones inferiores a 6.0 (api 23)
            val intent = Intent(MediaStore.ACTION_IMAGE_CAPTURE) //Intent para acceder a la cámara
            startActivityForResult(intent,requestCameraPicture)
        }
    }

    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray) {
        //super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        when(requestCode) {
            requestCameraPermission -> {
                if (grantResults.size == 1 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    //Permiso aceptado
                    val intent = Intent(MediaStore.ACTION_IMAGE_CAPTURE) //Intent para acceder a la cámara
                    startActivityForResult(intent,requestCameraPicture)
                } else {
                    //Permiso denegado
                    Toast.makeText(this,"You can't take a picture if you don't allow it", Toast.LENGTH_LONG).show()
                }
            }
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        when(requestCode) {
            requestCameraPicture -> {
                //Comprobar si el resultado es bueno
                if(resultCode == Activity.RESULT_OK){
                    // Obtenemos los extras del intent recibidos por parámetros
                    val extras = data!!.extras //llegan por parámetros
                    // Formamos el bitmap a partir de los extras
                    val imageBittMap = extras.get("data") as Bitmap
                    //Cargamos la foto como bitmap en el imageview
                    imageViewPicture.setImageBitmap(imageBittMap)
                }else{
                    //La foto no ha sido tomada con éxito
                    Toast.makeText(this,"Picture failed",Toast.LENGTH_LONG).show()
                }
            }
        }

    }
}
