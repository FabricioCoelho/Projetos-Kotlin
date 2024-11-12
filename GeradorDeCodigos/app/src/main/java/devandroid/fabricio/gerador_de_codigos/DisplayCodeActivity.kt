package devandroid.fabricio.gerador_de_codigos

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class DisplayCodeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_display_code)

        val shuffledCode = intent.getStringExtra("shuffledCode")

        val successMessageTextView = findViewById<TextView>(R.id.successMessageTextView)
        val generatedCodeTextView = findViewById<TextView>(R.id.generatedCodeTextView)
        val backToMainButton = findViewById<Button>(R.id.backToMainButton)

        generatedCodeTextView.text = shuffledCode

        backToMainButton.setOnClickListener {
            finish() // Retorna à MainActivity
        }
    }
}