package com.albertopita.holamundo.others

import android.util.Log
import java.util.*


class Functions {


    private fun  showCase1(){
        //Funciones, parametros y Unit
        fun function(){}
        val result1 = function()

        fun function2():Unit{}
        val result2:Unit = function2()

        // los parámetros de las funciones necesitan específicar su tipo, siempre
        fun function3(param1:String,param2:String):String{
            return "$param1,$param2"
        }
        val result3 = function3("hola","mundo")

        fun function4(param:Int = 5){}
        fun function5(param:Int?){} //parametro nullo o entero

    }
    private fun  showCase2(){
        fun printSum(num1:Int,num2:Int,printer:(result:Int) -> Unit){
            printer(num1+num2)
        }

        //usar la funcion atrávez de expresiones landa
        printSum(5,5){ result ->
            Log.e("Function2","Lambda expression printing the sum result(10) => $result")
        }

        //Si el callback recibe sólo un parametro podemos omitir ese "result" ->it
        printSum(12,12){
            Log.e("Function2","Lambda expression printing the sum result(10) => $it")
        }

        fun printSum2(num1:Int,num2:Int,printer:(result:Int,param1:Int,param2:Int) -> Unit){
            printer(num1+num2,num1,num2)
        }

        //el it no funciona con los parametros
        printSum2(7,7){ result,param1,param2 ->
            Log.e("Function2","Lambda expression printing the sum result(10) => $result")
        }

        printSum2(7,7){ result,_,_ ->
            Log.e("Function2","Lambda expression printing the sum result(10) => $result")
        }
    }

    private fun  showCase3(){
        fun function(firstName:String, lastName:String,age:Int, city:String,dateOfBirth:Date) {}

        function("","",25,"",Date())
        function(age = 27,dateOfBirth = Date(),firstName = "Alejandro",city = "México",lastName = "Pita")
    }
    private fun  showCase4(){
        //Single- Expression functions
        fun sum(param1:Int,param2:Int) = param1+param2

        //A diferencia de:
        fun sum2(param1:Int,param2:Int):Int{
            return param1+param2;
        }
    }
    private fun  showCase5(){
        //Variable number of arguments (Varargs)
        /*fun SumaAll(vararg numbers:Int) = numbers.sum()

        val result = SumaAll(1,2,3,4,5,6,7,8,9,10) */
    }
    private fun  showCase6(){
        //Extension function
        //si es declarada la extensión function dentro de este método, solo tenemos acceso a el en este mismo contexto de función
        fun String.welcome(){
            Log.e("Function-6","Welcome extendido de la clase kotlin")
        }

        "".welcome()

    }

    fun showCases(){
        showCase1()
        showCase2()
        showCase3()
        showCase4()
        showCase5()
        showCase6()
        "".welcome()
    }

}

//añadir metodo welcome a la clase string de kotlin // si es declarada aquí extiende de toda la app GLOBAL
fun String.welcome(){
    Log.e("Function-7","Welcome extendido de la clase kotlin GLOBAL")
}
