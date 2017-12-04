package com.albertopita.holamundo.others

import android.util.Log

//Para hacer una clase extendible o heredable tenemos que marcarla como open
//en llava es open por defecto y en kotlin es final por defecto, así que no puede ser extendida sin el uso de open
  open class AccessModifiers {
    //private -- solo visible dentro de la misma clase
    //protected // solo visible dentro de la clase y de subclases ( herencia )
    //public -- visible desde dentro de la clase, sus subclases y desde fuera

     val prop1 = "Public by default" //por default son public por eso se le quita
    private val prop2 = "Marked as private"
    protected val prop3 = "Marked as protected"

    protected fun showCase(){
        val test = AccessModifiers()

        test.prop1

    }
}

class AccessModifiersChild : AccessModifiers(){
    private fun showCaseChild(){
        super.showCase();
        prop1
        //por ser privada prop2 no puede ser accesible
        this.prop3

    }
}

class AnotherClass {
    private fun showCase(){
        val test = AccessModifiers();
    }
}