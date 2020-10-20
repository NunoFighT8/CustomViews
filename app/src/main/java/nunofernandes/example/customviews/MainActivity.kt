package nunofernandes.example.customviews

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val textView = findViewById<TextView>(R.id.textViewValue)
        val lightBrightnesView = findViewById<LightBrightnesView>(R.id.lightBrightnesView)

        lightBrightnesView.setOnValueChange = {
            textView.setText(it.toInt().toString())
        }

    }
}