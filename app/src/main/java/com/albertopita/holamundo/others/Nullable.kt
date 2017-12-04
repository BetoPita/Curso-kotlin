package com.albertopita.holamundo.others

import android.util.Log


class Nullable {
    private lateinit var  variable1:String // como inicializar en null
    private var variable2:String? = null // siempre dejar null

    private fun  showCase1(){
        //1) Una llamada explícita al error NullPointerException
        throw NullPointerException();
    }
    private fun  showCase2(var1:String?){
        //Uso del operador !!
        var1.toString() //devuelve null en caaso de que var1 sea null
        var1!!.toString() // Si es null devuelve NPE
    }

    private fun  showCase3(){
        //Código externo de java
        Other.getNPE(); //Devuelve NPE
    }
    private fun  showCase4(){
        //Alguna inconsistencia de datos en relación a la inicialización
        variable1.length // Devuelve NPE por que variable 1 no ha sido lateinit
        variable2?.length
        variable2!!.length

    }

     fun showCases(){
        showCase1()
        showCase2("")
        showCase3()
        showCase4()
    }

}
