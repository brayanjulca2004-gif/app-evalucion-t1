package pe.edu.cibertec.app_evalucion_t1

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import pe.edu.cibertec.app_evalucion_t1.databinding.ActivityPregunta2Binding

class Pregunta2Activity : AppCompatActivity(), View.OnClickListener {

    // Instancia de ViewBinding
    private lateinit var binding: ActivityPregunta2Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Inicialización de ViewBinding
        binding = ActivityPregunta2Binding.inflate(layoutInflater)
        setContentView(binding.root)

        // Inicializar el evento click mediante la interfaz View.OnClickListener
        binding.btnCalcular.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            binding.btnCalcular.id -> calcularRecargo()
        }
    }

    private fun calcularRecargo() {
        val strConsumo = binding.etConsumo.text.toString().trim()

        if (strConsumo.isEmpty()) {
            Toast.makeText(this, "Por favor ingrese el consumo en kWh", Toast.LENGTH_SHORT).show()
            return
        }

        val consumo = strConsumo.toDouble()

        if (consumo <= 150) {
            binding.tvResultado.text = "Consumo eficiente sin sobrecosto."
        } else {
            val exceso = consumo - 150
            val recargo = 60.00 + (exceso * 1.80)

            binding.tvResultado.text = """
                Consumo ingresado: %.2f kWh
                Exceso: %.2f kWh
                Monto total a pagar por recargo: S/ %.2f
            """.trimIndent().format(consumo, exceso, recargo)
        }
    }
}