package pe.edu.cibertec.app_evalucion_t1

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import pe.edu.cibertec.app_evalucion_t1.databinding.ActivityPregunta3Binding

class Pregunta3Activity : AppCompatActivity(), View.OnClickListener {

    private lateinit var binding: ActivityPregunta3Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityPregunta3Binding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnCalcular.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            binding.btnCalcular.id -> calcularEstacionamiento()
        }
    }

    private fun calcularEstacionamiento() {
        val strTiempo = binding.etTiempo.text.toString().trim()

        if (strTiempo.isEmpty()) {
            Toast.makeText(
                this,
                "Por favor ingrese el tiempo en minutos",
                Toast.LENGTH_SHORT
            ).show()
            return
        }

        val tiempo = strTiempo.toIntOrNull()

        if (tiempo == null || tiempo < 0) {
            Toast.makeText(
                this,
                "Ingrese un tiempo válido en minutos",
                Toast.LENGTH_SHORT
            ).show()
            return
        }

        if (tiempo <= 60) {
            binding.tvResultado.text =
                "Estacionamiento cubierto por periodo de cortesía."
        } else {
            val exceso = tiempo - 60
            val monto = 10.00 + (exceso * 0.50)

            binding.tvResultado.text = """
                Tiempo total registrado: $tiempo minutos
                Minutos de exceso: $exceso
                Monto total a pagar: S/ %.2f
            """.trimIndent().format(monto)
        }
    }
}