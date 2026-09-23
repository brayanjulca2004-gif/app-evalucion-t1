package pe.edu.cibertec.app_evalucion_t1

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import pe.edu.cibertec.app_evalucion_t1.databinding.ActivityAppPregunta4Binding
import pe.edu.cibertec.app_evalucion_t1.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() , View.OnClickListener {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnpregunta4.setOnClickListener(this)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.tvResultado)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    override fun onClick(v: View) {
        when (v.id) {
            R.id.btnpregunta4 -> pregunta4()
        }
    }
    fun pregunta4(){
        startActivity(Intent(this,
                app_pregunta_4Activity::class.java))
    }
}