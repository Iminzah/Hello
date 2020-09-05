package com.example.hello

import ke.co.hello.models.Course

interface CourseClickListener {
    fun onItemClick(course: Course)
}