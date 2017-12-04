package com.albertopita.holamundo.others

import android.util.Log

open class Interfaces {
    private var anonymousObjectImplementingInterface:Any? = null
    private fun showCase1(){
        anonymousObjectImplementingInterface = object :Interface1{
            override fun abstactMethod() {
               //Poner codigo es totalmente opcional
            }

        }
        //necesitamos castear ya que en la declaración lo hacemos como ANY y no puede inferir el tipo correctamente.
        (anonymousObjectImplementingInterface as Interface1).methodWithImplementationByDefault()
        (anonymousObjectImplementingInterface as Interface1).abstactMethod()
    }
    private fun showCase2(){
        val aoii = object : Interface2{
            override val propertyAbstract: Int
                get() = 10

        }
        //aquí no declaramos la variable como any, kotlin determina el tipo y automáticamente hace el cast.
        aoii.propertyAbstract
    }
    fun showCases(){
        showCase1();
        showCase2();
    }
}
interface Interface1{
    fun abstactMethod()
    fun methodWithImplementationByDefault(){

    }
}
interface Interface2{
    val propertyAbstract:Int
    var propertyWithImplementation:String
        get() ="ByDefault"
    set(value)  {this.propertyWithImplementation = value}

    fun hellow(){
        Log.w("Inferface-2","Is it working $propertyWithImplementation?, YAY! $propertyAbstract")
    }
}