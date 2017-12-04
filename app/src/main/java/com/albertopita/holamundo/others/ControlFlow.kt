package com.albertopita.holamundo.others

import android.util.Log


class ControlFlow {

    private fun  showCase1(){
        //if
        val num1 = 5
        val num2 = 10

        if(num1>num2){
            Log.w("Control-FLOW-1", "El número 1 es mayor al 2");
        }

        if(num2>num1){
            Log.w("Control-FLOW-1", "El número 2 es mayor al 1");
        }
    }
    private fun  showCase2(){
        //If else
        //if
        val num1 = 5
        val num2 = 10

        if(num1>num2){
            Log.w("Control-FLOW-1", "El número 1 es mayor al 2");
        }else{
            Log.w("Control-FLOW-1", "El número 2 es mayor al 1");
        }
        //utilizar como expresión
        if(num1>num2)   Log.w("Control-FLOW-1", "El número 1 es mayor al 2") else  Log.w("Control-FLOW-1", "El número 2 es mayor al 1")
    }

    private fun  showCase3(){
        //when
        val x =1
        //Con argumentos (x)
        when (x){
            1 ->  Log.w("Control-FLOW-1", "x==1")
            2 ->  Log.w("Control-FLOW-2", "x==2")
            else -> Log.w("Control-FLOW-3", "x es otro número")
        }

        when(x){
            0,1 -> Log.w("Control-FLOW-4", "x==0 o x = 1")
        }
        when{
            (x % 2 == 0)-> Log.w("Control-FLOW-5", "el número es par")
            (x % 2 == 1)-> Log.w("Control-FLOW-5", "el número es impar")
        }

        //sin argumento y devolviendo valor
        val esPar = when{
            (x % 2 == 0)-> true
            else -> false
        }



    }
    private fun  showCase4(){
        //bucle for
        var numbers = arrayOf(1,2,3,4,5,6)
        for (number in numbers) Log.w("Control-FLOW-6", "el número es ${number.toString()}")

        //especificando el tipo
        for (number:Int in numbers){
            Log.w("Control-FLOW-7", "el número es ${number.toString()}")
        }

        //for ((index,number) in numbers.withIndex()){

        //}

    }
    private fun  showCase5(){
        // while y do while
        var x = 10

        while(x>0){
            Log.w("Control-FLOW-6",  x--.toString())
        }

        do {
            Log.w("Control-FLOW-6", "Primera y única operación")
        }while (x>0)
    }

    fun showCases(){
        showCase1()
        showCase2()
        showCase3()
        showCase4()
        showCase5()
    }

}
