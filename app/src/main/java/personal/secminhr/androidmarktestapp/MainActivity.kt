package personal.secminhr.androidmarktestapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import personal.secminhr.androidmark.AndroidMark

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val mark = AndroidMark()
        val markdown = """
            kdkdkdklsldl  
            ***kdka;sdlkfj***
            
            alskdfjsad;lkjfkc,
        """.trimIndent()
        mark.render(markdown, main, this)
    }
}
