package pe.edu.cibertec.app_evalucion_t1

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(
                systemBars.left,
                systemBars.top,
                systemBars.right,
                systemBars.bottom
            )
            insets
        }

        val etHoras = findViewById<EditText>(R.id.etHoras)
        val btnCalcular = findViewById<Button>(R.id.btnCalcular)
        val tvResultado = findViewById<TextView>(R.id.tvResultado)

        btnCalcular.setOnClickListener {

            val horas = etHoras.text.toString().toIntOrNull()

            if (horas == null) {
                tvResultado.text =
                    "Ingrese una cantidad de horas válida."
            } else if (horas <= 8) {
                tvResultado.text =
                    "Horas totales: $horas\n" +
                            "Horas excedentes: 0\n" +
                            "Horas cubiertas por la membresía mensual."
            } else {
                val horasExcedentes = horas - 8
                val monto = 50.00 + (35.00 * horasExcedentes)

                tvResultado.text =
                    "Horas totales: $horas\n" +
                            "Horas excedentes: $horasExcedentes\n" +
                            "Monto a pagar: S/ %.2f".format(monto)
            }
        }
    }
}