package com.albertopita.holamundo.others

import android.util.Log
import java.util.*


class CompanionObjects {


    private fun  showCase1(){
        //Normal Companion Object
        val value = MyClass1.flag
        MyClass1.welcome()
    }
    private fun  showCase2(){
        MyClass2.welcome()
    }


    fun showCases(){
        showCase1()
        showCase2()
    }

}
class MyClass1{
    companion object {
        val flag = 1

        fun welcome(){
            Log.w("Companion object-1","welcome companion object")
        }
    }
}
class MyClass2{
    companion object : welcome {
        override fun welcome() {
            Log.w("Companion object-2","welcome companion object + interface")
        }
    }
}

interface welcome{
    fun welcome()
}