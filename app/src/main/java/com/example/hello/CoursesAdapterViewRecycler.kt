package com.example.hello

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_courses.view.rvCourses
import kotlinx.android.synthetic.main.row_courses_item.view.*

class CoursesRecyclerViewAdapter(val coursesList: List<Courses>
) :
    RecyclerView.Adapter<CoursesRecyclerViewAdapter.NamesViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NamesViewHolder {
        var itemView = LayoutInflater.from(parent.context).inflate(R.layout.row_courses_item, parent, false)
        return NamesViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return coursesList.size
    }


    override fun onBindViewHolder(holder: NamesViewHolder, position: Int) {
        holder.rowView.rvCourses.text = coursesList[position].toString()
    }

    class NamesViewHolder(val rowView: View) : RecyclerView.ViewHolder(rowView)
}