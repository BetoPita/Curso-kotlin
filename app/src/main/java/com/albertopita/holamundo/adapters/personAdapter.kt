package com.albertopita.holamundo.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView
import com.albertopita.holamundo.models.Person
import kotlinx.android.synthetic.main.list_view_person.view.*

/**
 * Created by pita on 05/12/17.
 */
class PersonAdapter(val context: Context, val layout:Int, val list: List<Person>):BaseAdapter(){
    private val mInflator :LayoutInflater = LayoutInflater.from(context)

    override fun getItem(position: Int): Any {
        //que item regresar
        return list[position]
    }

    override fun getItemId(position: Int): Long {
       return  position.toLong()
    }

    override fun getCount(): Int {
        // el número de items que existe en la lista
        return list.size
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val view : View
        val vh : PersonViewHolder

        //convertView representa cada fila del listView
        if(convertView==null){
            view = mInflator.inflate(layout,parent,false)
            //instancia del viewHolder
            vh = PersonViewHolder(view)
            view.tag = vh //tag inyecta un objeto
        }else{
            view = convertView
            vh = view.tag as PersonViewHolder
        }

        val fullName = "${list[position].firstName}, ${list[position].lastName}"
        vh.fullName.text = fullName
        vh.age.text = "${list[position].age}"
        return view
    }
}

private class PersonViewHolder(view: View){
    val fullName:TextView = view.textViewName
    val age : TextView = view.textViewAge
}