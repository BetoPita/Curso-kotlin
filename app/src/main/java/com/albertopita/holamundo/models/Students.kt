package com.albertopita.holamundo.models

import android.os.Parcel
import android.os.Parcelable

/**
 * Created by pita on 07/12/17.
 */

//Parcel es un contenedor para un mensaje.
// puede ser usado para mandar un objecto serializado a través de Intent
// tiene mejor rendicimento que Serializer.
data class Student(var name:String,var lastName: String, var age:Int, var isDeveloper:Boolean = true) : Parcelable {
    //Leer en el mismo orden que declaramos las propiedades.
    constructor(parcel: Parcel) : this(
            parcel.readString(),
            parcel.readString(),
            parcel.readInt(),
            parcel.readByte() != 0.toByte()) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        //los valores en el mismo orden en el que leemos en el constructor
        parcel.writeString(name)
        parcel.writeString(lastName)
        parcel.writeInt(age)
        parcel.writeByte(if (isDeveloper) 1 else 0)
    }
    //Describe el tipo de contenido del objeto parcelable
    //0 siempre se usa, el otro valor es 1 o CONTENTS_FILE_DESCRIPTOR, PARA TIPOS DE OBJETOS QUE IMPLEMENTAN UN FILE DESCRIPTOR
    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Student> {
        //Esto creará el objeto desde el parcel llamando al constructor secundario
        override fun createFromParcel(parcel: Parcel): Student {
            return Student(parcel)
        }
        // esto ayudará a serializar arrays objetos del mismo tipo que esta clase ( Student )
        override fun newArray(size: Int): Array<Student?> {
            return arrayOfNulls(size)
        }
    }
}