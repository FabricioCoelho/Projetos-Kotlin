package devandroid.fabricio.calculoaposentadoria
import android.app.Activity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import android.widget.TextView
import android.widget.ArrayAdapter

class MainActivity: Activity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //definindo o arquivo de layout
        setContentView(R.layout.activity_main)
        //acessando o spinner
        val spinnerSexo = findViewById<Spinner>(R.id.spinner_sexo)
        //acessando a caixa de idade
        val editTexteIdade = findViewById<EditText>(R.id.edit_text_idade)
        //acessando o botão de calcular
        val buttonCalcular = findViewById<Button>(R.id.button_calcular)
        //acessando o texto de resultado
        val textViewResultado = findViewById<TextView>(R.id.text_view_resultado)
        //criando os itens da lista de sexo
        val adapter = ArrayAdapter(
            this,
            android.R.layout.simple_spinner_dropdown_item,
            listOf("masculino", "feminino")
        )
        spinnerSexo.adapter = ArrayAdapter<String>(this, android.R.layout
            .simple_spinner_dropdown_item,
            listOf("masculino", "feminino"))
        spinnerSexo.adapter = adapter
        //Ação para o butão funcionar quando clicar 
        buttonCalcular.setOnClickListener {
            //aqui vai o código que será executado quando houver um clique do botão
            val sexoSelecionado = spinnerSexo.selectedItem as String

            val idade = editTexteIdade.text.toString().toInt()

            var resultado = 0
            if (sexoSelecionado == "masculino") {
                resultado = 65 - idade
            } else {
                resultado = 62 - idade
            }
            textViewResultado.text = "Faltam $resultado anos para você se aposentar."
        }
    }
}