package pe.edu.cibertec.app_evalucion_t1

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import pe.edu.cibertec.app_evalucion_t1.databinding.ActivityPregunta7Binding

class Pregunta7Activity : AppCompatActivity(), View.OnClickListener {

    // Instancia de ViewBinding siguiendo el estándar del proyecto
    private lateinit var binding: ActivityPregunta7Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Inicialización de ViewBinding
        binding = ActivityPregunta7Binding.inflate(layoutInflater)
        setContentView(binding.root)

        // Inicializar el evento click mediante la interfaz View.OnClickListener
        binding.btnCalcular.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            binding.btnCalcular.id -> calcularSancion()
        }
    }

    private fun calcularSancion() {
        val strTemperatura = binding.etTemperatura.text.toString().trim()

        // Validación de ingreso de datos
        if (strTemperatura.isEmpty()) {
            Toast.makeText(this, "Por favor ingrese la temperatura en °C", Toast.LENGTH_SHORT).show()
            return
        }

        val temperatura = strTemperatura.toDouble()

        // Evaluación de la condición según el requerimiento
        if (temperatura <= 35.0) {
            binding.tvResultado.text = "Parámetro térmico en norma ambiental."
        } else {
            val exceso = temperatura - 35.0
            val sancion = 3200.00 + (exceso * 450.00)

            // Salida estructurada usando formato multilínea
            binding.tvResultado.text = """
                Temperatura registrada: %.2f °C
                Exceso térmico: %.2f °C
                Sanción total calculada: S/ %.2f
            """.trimIndent().format(temperatura, exceso, sancion)
        }
    }
}