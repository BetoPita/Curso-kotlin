package com.albertopita.holamundo.others

import android.util.Log


class Operators {

    private fun  showCase1(){
        var a=5
        var b = 5

        Log.w("Operators-1","Referential equality. es 'a' igual a 'b'? ${a===b}") //
        Log.w("Operators-1","Structural equality. es 'a' igual a 'b'? ${a==b}") //
    }
    private fun  showCase2(){
        val pn1 = PersonNormal();
        val pn2 = PersonNormal();
        Log.w("Operators-2","Referential equality. es 'pn1' igual a 'pn2'? ${pn1===pn2}") //false
        Log.w("Operators-2","Structural equality. es 'pn1' igual a 'pn2'? ${pn1==pn2}") // false por que no sobreescribe equal
    }

    private fun  showCase3(){
        val pn1 = PersonEqualOverride()
        val pn2 = PersonEqualOverride()
        Log.w("Operators-3","Referential equality. es 'pn1' igual a 'pn2'? ${pn1===pn2}") //false
        Log.w("Operators-3","Structural equality. es 'pn1' igual a 'pn2'? ${pn1==pn2}") // true
    }
    private fun  showCase4(){
        val pn1 = PersonDataClass()
        val pn2 = PersonDataClass()
        val pn3 = PersonDataClass("Roberto");
        Log.w("Operators-4","Referential equality. es 'pn1' igual a 'pn2'? ${pn1===pn2}") //false
        Log.w("Operators-4","Structural equality. es 'pn1' igual a 'pn2'? ${pn1==pn2}") // true
        Log.w("Operators-4","Structural equality. es 'pn2' igual a 'pn3'? ${pn2==pn3}") // false
    }

    fun showCases(){
        showCase1()
        showCase2()
        showCase3()
        showCase4()
    }
    class PersonNormal { val name="Luis"}

    class PersonEqualOverride {
        val name="Luis"
        override fun equals(other:Any?):Boolean{
            if(other===null) return false
            if(other is PersonEqualOverride){
                return other.name===this.name
            }
            return false
        }
    }
    data class PersonDataClass(val name: String ="Luis",val age:Int = 25)

}
