package devandroid.fabricio.gerador_de_codigos

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import kotlin.random.Random

class MainActivity : AppCompatActivity() {

    private lateinit var inputCodeEditText: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        inputCodeEditText = findViewById(R.id.inputCodeEditText)
        val generateButton = findViewById<Button>(R.id.generateButton)
        val topImageView = findViewById<ImageView>(R.id.topImageView)
        // Configurar a imagem na ImageView
        topImageView.setImageResource(R.drawable.oi_imagem)

        generateButton.setOnClickListener {
            val inputCode = inputCodeEditText.text.toString()
            // Verificar se o código é válido
            if (inputCode.isEmpty()) {
                // Exibir mensagem de erro se o campo estiver vazio
                Toast.makeText(this, "Por favor, insira um código válido.", Toast.LENGTH_SHORT)
                    .show()
            } else if (inputCode.length < 3) {
                // Exibir mensagem de erro se o código tiver menos de 1 caractere
                Toast.makeText(
                    this,
                    "O código deve ter pelo menos 3 caracteres.",
                    Toast.LENGTH_SHORT
                ).show()
            } else {
                val shuffledCode = shuffleCode(inputCode)
                val intent = Intent(this, DisplayCodeActivity::class.java)
                intent.putExtra("shuffledCode", shuffledCode)
                startActivity(intent)
            }
        }
    }

    private fun shuffleCode(input: String): String {
        val charArray = input.toCharArray()
        charArray.shuffle()
        return String(charArray)
    }

    override fun onResume() {
        super.onResume()

        // Limpar o texto do EditText ao retomar a MainActivity
        inputCodeEditText.text.clear()
    }
}