package ke.co.hello

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.hello.Courses
import com.example.hello.CoursesAdapterViewRecycler
import com.example.hello.R
import kotlinx.android.synthetic.main.activity_courses.*

class CoursesActivity<Courses> : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_courses)
        var courseList = listOf<com.example.hello.Courses>(
            Courses("34", "UI/UX", "1000", "NYANDIA", "Design"),
            Courses("15", "JavaScript", "45678", "Purity", "React"),
            Courses(
                "36",
                "Entrepreneurship",
                "500234",
                "Gatwiri",
                "Problem Space"
            ),
            Courses("56", "Html/css", "6789", "Jeff", "Wireframes"),
            Courses("90", "Kotlin", "6543", "John", "mobile dev"),
            Courses("34", "Nav", "1234", "Vero", "Life"),
            Courses("89", "professional", "0987", "Owoko", "CV")

        )
        rvCourses.layoutManager = LinearLayoutManager(baseContext)
        rvCourses.adapter = CoursesAdapterViewRecycler(courseList)
    }
}

