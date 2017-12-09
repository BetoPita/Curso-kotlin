package com.albertopita.holamundo

import android.support.v7.app.AppCompatActivity
import android.os.Bundle

import com.albertopita.holamundo.adapters.PersonAdapter
import com.albertopita.holamundo.models.Person
import kotlinx.android.synthetic.main.activity_list_view.*

class ListViewActivity : AppCompatActivity() {
    private lateinit var  adapter:PersonAdapter
    private lateinit var personList :List<Person>


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_view)


        personList = getPersons()
        adapter = PersonAdapter(this,R.layout.list_view_person,personList)
        ListView.adapter = adapter
    }
    private fun getPersons():List<Person>{
        return  listOf(
                Person("Luis","Alberto",25),
                Person("Thalia","Fernanda",32),
                Person("Juan","larios",27),
                Person("Luis","Avalos",27),
                Person("Rafa","Chávez",27),
                Person("Rafael","Contreras",27),
                Person("Edgar","Bertho",27),
                Person("Carlos","Pita",27),
                Person("Luis","Alberto",25),
                Person("Thalia","Fernanda",32),
                Person("Juan","larios",27),
                Person("Luis","Avalos",27),
                Person("Rafa","Chávez",27),
                Person("Rafael","Contreras",27),
                Person("Edgar","Bertho",27),
                Person("Carlos","Pita",27),
                Person("Luis","Alberto",25),
                Person("Thalia","Fernanda",32),
                Person("Juan","larios",27),
                Person("Luis","Avalos",27),
                Person("Rafa","Chávez",27),
                Person("Rafael","Contreras",27),
                Person("Edgar","Bertho",27),
                Person("Carlos","Pita",27),
                Person("Luis","Alberto",25),
                Person("Thalia","Fernanda",32),
                Person("Juan","larios",27),
                Person("Luis","Avalos",27),
                Person("Rafa","Chávez",27),
                Person("Rafael","Contreras",27),
                Person("Edgar","Bertho",27),
                Person("Carlos","Pita",27),
                Person("Luis","Alberto",25),
                Person("Thalia","Fernanda",32),
                Person("Juan","larios",27),
                Person("Luis","Avalos",27),
                Person("Rafa","Chávez",27),
                Person("Rafael","Contreras",27),
                Person("Edgar","Bertho",27),
                Person("Carlos","Pita",27)
        )

    }
}
