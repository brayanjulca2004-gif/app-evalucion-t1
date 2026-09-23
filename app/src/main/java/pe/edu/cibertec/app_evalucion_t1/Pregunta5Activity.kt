package pe.edu.cibertec.app_evalucion_t1

import android.os.Bundle
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import pe.edu.cibertec.app_evalucion_t1.databinding.ActivityPregunta5Binding

class Pregunta5Activity : AppCompatActivity(), View.OnClickListener {

    private lateinit var binding: ActivityPregunta5Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        enableEdgeToEdge()

        binding = ActivityPregunta5Binding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnCalcular.setOnClickListener(this)
        binding.btnLimpiar.setOnClickListener(this)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.tvResultado)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(
                systemBars.left,
                systemBars.top,
                systemBars.right,
                systemBars.bottom
            )
            insets
        }
    }

    override fun onClick(v: View) {

        when (v.id) {

            binding.btnCalcular.id -> {

                val textoBolsas = binding.etBolsas.text.toString()

                if (textoBolsas.isEmpty()) {

                    binding.tvResultado.text =
                        "Ingrese la cantidad de bolsas."

                } else {

                    val bolsas = textoBolsas.toInt()

                    if (bolsas <= 5) {

                        binding.tvResultado.text =
                            "Carga permitida sin costo adicional."

                    } else {

                        val exceso = bolsas - 5
                        val cobro = 80.00 + (exceso * 15.00)

                        binding.tvResultado.text =
                            "Cantidad ingresada: $bolsas bolsas\n" +
                                    "Exceso: $exceso bolsas\n" +
                                    "Total a abonar: S/ %.2f".format(cobro)
                    }
                }
            }

            binding.btnLimpiar.id -> {

                binding.etBolsas.text?.clear()
                binding.tvResultado.text = ""
            }
        }
    }
}