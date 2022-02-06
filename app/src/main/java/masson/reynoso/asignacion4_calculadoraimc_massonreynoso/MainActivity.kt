package masson.reynoso.asignacion4_calculadoraimc_massonreynoso

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val et_weight: EditText = findViewById(R.id.weight) as EditText
        val et_height: EditText = findViewById(R.id.height) as EditText
        val btn_calcular: Button = findViewById(R.id.btn_calcular) as Button
        val tv_imc : TextView = findViewById(R.id.imc) as TextView
        val tv_range: TextView = findViewById(R.id.range) as TextView


        btn_calcular.setOnClickListener {
            var peso: Float = et_weight.text.toString().toFloat()
            var altura: Float = et_height.text.toString().toFloat()
            var imc: Float

            imc = calcularIMC(peso, altura)

            tv_imc.setText(imc.toString())
            tv_range.setText(rango(imc))
        }
    }

    fun calcularIMC(peso: Float, altura: Float): Float {
        return peso / (altura * altura)
    }

    fun rango(imc: Float): String {
        var range: String = ""

        if(imc < 18.5) {
            range = "Bajo peso"

        }

        return range
    }
}