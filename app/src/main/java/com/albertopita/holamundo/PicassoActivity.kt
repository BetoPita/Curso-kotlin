package com.albertopita.holamundo

import android.content.Context
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.albertopita.holamundo.activities.CircleTransform
import com.squareup.picasso.Callback
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_picasso.*

class PicassoActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_picasso)

        buttonLoader.setOnClickListener { loadImages() }
        Picasso.with(this).load("https://cdn.pixabay.com/photo/2017/09/22/19/05/tomato-2776735_1280.jpg").fetch() //hacer el precacheco de las imagenes antes de renderizar


    }

    private fun loadImages() {

        Picasso .with(this)
                .load("https://cdn.pixabay.com/photo/2017/09/22/19/05/tomato-2776735_1280.jpg")
                .resize(400,400)
                .centerInside()
                .into(imageViewTop)

        //Picasso.with(this)
                // .load("https://cdn.pixabay.com/photo/2017/09/22/19/05/tomato-2776735_1280.jpg")
                //.fit() //para que llene el espacio
                //.into(imageViewBottom)

                // Picasso.with(this)
                //.load("https://cdn.pixabay.com/photo/2017/09/22/19/05/tomato-2776735_1280.jpg")
                // .fit() //para que llene el espacio
                //.transform(CircleTransform()) //renderizar la imagen
                //.into(imageViewBottom)

        val context:Context = this
         Picasso.with(this)
                .load( "https://cdn.pixabay.com/photo/2017/09/22/19/05/tomato-2776735_1280.jpg")
                .fetch(object : Callback{
                    override fun onSuccess() {
                        imageViewBottom.alpha = 0f
                        Picasso.with(context)
                                .load("https://cdn.pixabay.com/photo/2017/09/22/19/05/tomato-2776735_1280.jpg")
                                .fit()
                                .into(imageViewBottom)
                        imageViewBottom.animate().setDuration(300).alpha(1f).start()
                    }

                    override fun onError() {

                    }
                }) // para hacer animación

    }

}
