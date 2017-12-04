package com.albertopita.holamundo.others

import android.util.Log


class Classes {

    private fun  showCase1(){
        //Clases en kotlin pueden tener un constructor PRIMARIO y uno o más constructores SECUNDARIOS
        //PRIMARIO se encuentra en la firma de la declaración de la clase
        //SECUNDARIO se encientra dentro de la declaración de la clase

        //CONSTRUCTORES PRIMARIOS
        class Person1
        class Person2 constructor (var firstName: String) // constructor primario
        class Person3 (var firstName: String)
        class Person4 (val firstName: String,val lastName:String, var age:Int){
            init{ //se ejectura después del primario y antes del secundario
                age = 10

            }
        }
        class Person5 (val firstName: String = "Luis",val lastName:String = "Pita", var age:Int=25)
        //para crear instancias de objeto no usamos la palabra "new"

        val p1 = Person1()
        val p2 = Person2("Luis")
        val p3 = Person3("Luis")
        val p4 = Person4("Luis","Pita",25)
        val p5_1 = Person5("Luis")
        val p5_2 = Person5("Luis","Pita")
        val p5_3 = Person5("Luis","Pita",27)
        val p5_4 = Person5(age = 20,firstName = "LuisAlberto",lastName = "Pita")

    }
    private fun  showCase2(){
        open class Person {
            constructor(firstName: String, lastName: String) {
                Log.w("Clases-2", "Welcome $firstName $lastName ")
            }
        }
        class Person1:Person{
            constructor(firstName:String):super(firstName,"Lora")
            constructor(firstName:String,lastName: String):super(firstName,lastName)
        }
        val p = Person1("Alejandro","Lora")
        //no tenemos acceso a person.firstName, ver showcase número 5

    }

    private fun  showCase3(){
        //Diferencia entre INIT Y CONSTRUCTOR secundario
        class Person1{
            //el init se va a ejecutar antes que el constructor secundario y después que el constructor primario.
            init {
                Log.w("Clases-3", "Welcome INIT ")
            }
            constructor(firstName:String,lastName:String){
                Log.w("Clases-3", "Welcome from secundary constructor ")
            }
        }
        class Person2(firstName:String,lastName:String){
            init {
                //aquí si podemos acceder a las propiedades conservando init y constructor secundario

            }
            constructor() : this("Alberto","Pita")
        }
        val p1 = Person1("Alberto","Pita")
        val p2 = Person2("Luis","Pita")   //p2 y p3 tiene dos constructor por eso puede que se los mandes (constructor primario) o no se los mandes y tome los defaults es "Alberto,Pita"
        val p3 = Person2() //Alberto Pita
    }
    private fun  showCase4(){
        //cuando usamos val, var o ninguno
        class Person1(firstName:String) // No puedes acceder a firstName cuando crees la instancia
        class Person2(var firstName:String) // puedes acceder a firstname cuando crees la instancia y puedes cambiar su valor
        class Person3(val firstName:String) // puedes acceder a firstname cuando crees la instancia y NO puedes cambiar su valor
        val p1 = Person1("")
        val p2 = Person2("")
        val p3 = Person3("")

        //p1.firstName // Error
        p2.firstName
        p3.firstName

    }
    private fun  showCase5(){
        //Propiedades getters y setters

        class Person1(var firstName:String)

        val p1 = Person1("Alberto")
        p1.firstName // sería el equivalente a getFirstName()
        p1.firstName = "Luis" // sería equivalente a setFirstName("Luis)

        /*class Person2{
            //field - representa a la propiedad, nunca usar this.propiedad
            var firstName : String
                get() = field.capitalize()
            set(value){
                field = value.capitalize()
            }
            constructor(firstName:String){
                this.firstName = firstName

            }
        } */

    }
    private fun showCase6(){
        open class Person1(var name:String)
        open class Person2(open var name:String)
        open class Person3(open var name:String)

        //Si heredamos de person1 las propiedades no se pueden llamar de igual forma entre padre e hijo
        //class person11(var name:String) : Person1(name)
        //podemos mantener ambas con el mismo nombre, pero tenemos que añadir open y override
        class Person22(override var name:String) : Person2(name)

        //lo que hace es sobreescribir la variable name de Person3 y la segunda variable le pertenece a extender la interface de Iperson
        class Person33(override var name:String, override var age:Int) : Person3(name),IPerson{
            //falta implementar/sobreescribir/inicializar hello
            override fun hello() {}

        }
    }
private fun showCase7(){
    abstract class  Person(open var firstName:String, open var lastName:String){
        abstract fun hello()

        open fun welcomeKotlin(){
            Log.w("Clases-7", "Welcome TO KOTLIN ")
        }
        open fun welcomDevelopers(){
            Log.w("Clases-7", "Welcome developer")
        }
    }
    class Man(override var firstName:String, override var lastName:String) :Person(firstName,lastName){
        override fun hello() {
            Log.w("Clases-7", "Hellow I am $firstName $lastName")
        }

        override fun welcomDevelopers() {
            super.welcomDevelopers()
            super.welcomeKotlin()
            Log.w("Clases-7", "Lo que sea")
        }
    }
    val man = Man("Luis","Pita")
    man.hello()
    man.welcomeKotlin()
    man.welcomDevelopers()

    //IMPORTANTE En las llamadas de arriba si el metodo es override (sobreescrito) agarra el que está sobreescribiendo no el principal

}
    private fun showCase8(){
        //DATA CLASSES
        //Segun la documentación oficial, para hacer uso correcto de Data Classes debe:
        //El constructor primario necesita tener al menos 1 parametro
        //Todos los parámetros del constructor primario deben ser marcados como "val" o "var"
        // Data Classes no pueden ser "abstract, open, sealed or inner"
        data class Person(var fistName : String, var lastName: String)

        val p = Person("luis","Pita")
        val p2 = p
        val personString = p.toString()
        val personCopy = p.copy()
        var clone = p.copy(fistName = "Antonio")
        val (firstName,lastName) = p // Destructuring

        Log.w("Clases-8", "Data class tostring() => $personString" )
        Log.w("Clases-8", "Data class copy() => $personCopy" )
        Log.w("Clases-8", "p must be same reference than p2 => ${p===p2}" ) //true, referential equality
        Log.w("Clases-8", "p must be different reference than personCopy => ${p !== personCopy}" ) //true, referential equality
        Log.w("Clases-8", "p must  have same property values than personCopy => ${p ==personCopy}" ) //true, Structural equality
        Log.w("Clases-8", "p must be different reference than clone => ${p != clone}" ) //true, referential equality
        Log.w("Clases-8", "p must have different property values than clone => ${p !== clone}" ) //true, Structural equality
        Log.w("Clases-8", "firstName by destructuring myst be Alejandro => $firstName" ) //true, Structural equality
        Log.w("Clases-8", "lastName by destructuring myst be Alejandro => $lastName" ) //true, Structural equality
    }
    private fun showCase9(){
        Log.i("Clases-9,", "El ENUM DayOfWeek.MONDAY should be MONDAY => ${DayOfWeek.MONDAY.name}") //MONDAY
        Log.i("Clases-9,", "El ENUM DayOfWeek.MONDAY should be MONDAY => ${DayOfWeek.MONDAY.ordinal}") // 0
    }
    fun showCases(){
        showCase1()
        showCase2()
        showCase3()
        showCase4()
        showCase5()
        showCase6()
        showCase7()
        showCase8()
    }

}

interface IPerson{
    var age:Int
    fun hello()
}

enum class DayOfWeek {MONDAY,TUESDAY,WEDNESDAY, THURSDAY, FRIDAY, SATURDAY,SUNDAY}