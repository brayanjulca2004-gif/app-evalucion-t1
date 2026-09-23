package pe.edu.cibertec.app_evalucion_t1

import android.os.Bundle
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import pe.edu.cibertec.app_evalucion_t1.databinding.ActivityPregunta1Binding

class Pregunta1Activity : AppCompatActivity(), View.OnClickListener {

    private lateinit var binding: ActivityPregunta1Binding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        binding = ActivityPregunta1Binding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnCalcular.setOnClickListener(this)
        binding.btnLimpiar.setOnClickListener(this)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    override fun onClick(v: View?) {

        when (v?.id) {

            binding.btnCalcular.id -> {

                val textoConsumo = binding.etConsumo.text.toString()

                if (textoConsumo.isEmpty()) {

                    binding.tvResultado.text = "Ingrese el consumo de agua."

                } else {

                    val consumo = textoConsumo.toDouble()

                    if (consumo <= 20) {

                        binding.tvResultado.text =
                            "Consumo dentro de la asignación regular."

                    } else {

                        val exceso = consumo - 20
                        val recargo = 45.00 + (exceso * 8.50)

                        binding.tvResultado.text =
                            "Volumen consumido: %.2f m³\n".format(consumo) +
                                    "Exceso: %.2f m³\n".format(exceso) +
                                    "Monto total del recargo: S/ %.2f".format(recargo)
                    }
                }
            }

            binding.btnLimpiar.id -> {

                binding.etConsumo.text?.clear()
                binding.tvResultado.text = ""
            }
        }
    }
}