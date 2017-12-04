package com.albertopita.holamundo.others

import android.util.Log

/**
 * Created by pita on 28/11/17.
 */

/*
En kotlin todo es un objeto.
No hay tipos básicos, y no existe void. si algo no devuelve nada, está devolviendo Unit. object.
Las variables pueden ser mutables(var) e inmutables(val), es decir variables que pueden o no cambiar.
Los tipos son definidos después del nombre de la variable. con dos puntos y espacio (var nombre: tipo)


 */
class Variables {
    private var variable0=1
    private var variable1 = 1.toByte()
    private var variable2 = -123
    private var variable3 = 123123123123
    private var variable4 = 1.1.toFloat()
    private var variable5 = 1.9
    private var variable6 = 'a'
    private var variable7 = "a"
    private var variable8 = true
    private var variable9 = arrayOf(1,2,3,4,5)
    private var variable10 = arrayOfNulls<Int>(10) // [null,null] solo acepta int
    private val variable11 = "Esta variable es read-only/inmutable/constante"

    //show case para byte
    private fun  showCase1(){
        Log.w("Variable-0", "¿ES VARIABLE 0 un entero?"+(variable0 is Int)+ "¿Por qué no un byte?")
        Log.w("Variable-1", "¿ES VARIABLE 0 un BYTE?"+(variable1 is Byte))
    }

    //show case para Int
    private fun  showCase2(){
        Log.w("Variable-2","es un valor Integer");
        variable2 = Int.MAX_VALUE
    }

    //show case para Long
    private fun  showCase3(){
        Log.w("Variable-3","¿es un valor Long?" +(variable3 is Long))
    }
    //show case para Float
    private fun  showCase4(){
        Log.w("Variable-4","¿es un valor float?" +(variable4 is Float))
    }
    //show case para Float
    private fun  showCase5(){
        Log.w("Variable-5","¿es un valor Doble?" +(variable5 is Double))
    }

    //show case para Char
    private fun  showCase6(){
        Log.w("Variable-6","¿es un valor char?" +(variable6 is Char))
    }
    //show case para String
    private fun  showCase7(){
        Log.w("Variable-7","¿es un valor String?" +(variable7 is String))

        //String Literals
        //variable7 = "!Hola Mundo ! \n !Adiós Mundo!" //Java's style
        variable7 = """
            !Hola Mundo
            !Adiós Mundo
            """ //Kotlin's style

        //String Templates
        var points = 9
        var maxPoints = 10
        variable7 = "Hola, tengo $points puntos sobre $maxPoints"
        variable7 = "Hola, tengo ${points*10} puntos sobre ${maxPoints*10}"



    }
    //show case para Boolean
    private fun  showCase8(){
        Log.w("Variable-8","¿es un valor Boolean?" +(variable8 is Boolean))
    }
    //show case para Array
    private fun  showCase9(){
        Log.w("Variable-9","¿es un valor Array?" +(variable9 is Array<Int>))
    }
    //show case para Array<int?>
    private fun  showCase10(){
        Log.w("Variable-10","¿es un valor Array<int>?" +(variable10 is Array<Int?>))
        variable10= arrayOfNulls<Int>(3)
        variable10 = arrayOf(1,2,3,4,5)

        variable10[0]?.toFloat() // la ? significa que en caso de ser nulo regrese nulo
        variable10[0]?.toFloat() ?: "Error"// Elvis Operator -- en caso de ser null, devuelve "Error"
        variable10[0]!!.toFloat() //  El operador !! significa que tu infieres que nunca va ser nulo

    }
    public fun showCases(){
        showCase1()
        showCase2()
        showCase3()
        showCase4()
        showCase5()
        showCase6()
        showCase7()
        showCase8()
        showCase9()
        showCase10()
    }

}