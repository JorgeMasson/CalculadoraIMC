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

            if(imc < 18.5) {
                tv_range.setText("Bajo peso")
                tv_range.setBackgroundColor(getResources().getColor(R.color.colorBrown))
            } else if(imc >= 18.5 && imc <= 24.9) {
                tv_range.setText("Normal")
                tv_range.setBackgroundColor(getResources().getColor(R.color.colorGreenish))
            } else if(imc >= 25 && imc <= 29.9) {
                tv_range.setText("Sobrepeso")
                tv_range.setBackgroundColor(getResources().getColor(R.color.colorGreen))
            } else if(imc >=30 && imc <= 34.9) {
                tv_range.setText("Obesidad grado 1")
                tv_range.setBackgroundColor(getResources().getColor(R.color.colorYellow))
            } else if(imc >= 35 && imc <= 39.9) {
                tv_range.setText("Obesidad grado 2")
                tv_range.setBackgroundColor(getResources().getColor(R.color.colorOrange))
            } else {
                tv_range.setText("Obesidad grado 3")
                tv_range.setBackgroundColor(getResources().getColor(R.color.colorRed))
            }

        }
    }

    fun calcularIMC(peso: Float, altura: Float): Float {
        return peso / (altura * altura)
    }

}