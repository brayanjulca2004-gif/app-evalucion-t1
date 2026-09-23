package pe.edu.cibertec.app_evalucion_t1

import android.os.Bundle
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import pe.edu.cibertec.app_evalucion_t1.databinding.ActivityAppPregunta4Binding

class Pregunta4Activity : AppCompatActivity(), View.OnClickListener {

    private lateinit var binding: ActivityAppPregunta4Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        enableEdgeToEdge()
        binding = ActivityAppPregunta4Binding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnCalcular.setOnClickListener(this)
        binding.btnLimpiar.setOnClickListener(this)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.tvResultado)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    override fun onClick(v: View) {

        when (v.id) {

            binding.btnCalcular.id -> {

                val textoDatos = binding.etDatos.text.toString()

                if (textoDatos.isEmpty()) {

                    binding.tvResultado.text =
                        "Ingrese los GB consumidos."

                } else {

                    val datos = textoDatos.toDouble()

                    if (datos <= 30) {

                        binding.tvResultado.text =
                            "Consumo dentro de su plan contratado."

                    } else {

                        val exceso = datos - 30
                        val cobro = 25.00 + (exceso * 6.00)

                        binding.tvResultado.text =
                            "Datos consumidos: %.2f GB\n".format(datos) +
                                    "Exceso de GB: %.2f GB\n".format(exceso) +
                                    "Cobro adicional: S/ %.2f".format(cobro)
                    }
                }
            }

            binding.btnLimpiar.id -> {

                binding.etDatos.text?.clear()
                binding.tvResultado.text = ""
            }
        }
    }
}