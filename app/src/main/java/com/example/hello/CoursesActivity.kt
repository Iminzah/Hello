package com.example.hello

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.row_courses_item.*

data class Courses(val course_id: Int, val course_name: String, val course_code: Int, val instructor:String, val description:String)


class CoursesActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_courses)

        rvCourses.layoutManager = LinearLayoutManager(baseContext)
        val coursesRecyclerViewAdapter = CoursesRecyclerViewAdapter(coursesList = listOf(

            Courses(34,"Python",113,"James Mwai","Excellent"),
            Courses(35,"Kotlin",112,"John Owuor","Excellent"),
            Courses(36,"Javascript",111,"Purity Maina","Excellent"),
            Courses(37,"UI/UX Development",110,"Jeff Muthondu","Excellent"),
            Courses(38,"React",109,"Purity maina","Excellent"),
            Courses(39,"Navigating",108,"Vero Thamaini","Excellent"),
            Courses(40,"Proffessional development",107,"Rodgers Owoko","Excellent"),
            Courses(41,"UI/UX Design",106,"Nyandia Kamawe","Excellent"),
            Courses(42,"Entreprenuership",105,"Kelly Murungi","Excellent"),
            Courses(43,"Hardware Design",104,"Barre Yasin","Excellent"),
            Courses(44,"Hardware Electronics",103,"Barre Yasin","Excellent")


        ))
        rvCourses.adapter=coursesRecyclerViewAdapter
    }
}