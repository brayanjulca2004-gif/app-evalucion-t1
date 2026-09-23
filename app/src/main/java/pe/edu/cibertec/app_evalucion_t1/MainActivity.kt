package pe.edu.cibertec.app_evalucion_t1

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import pe.edu.cibertec.app_evalucion_t1.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() , View.OnClickListener {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnpregunta1.setOnClickListener(this)
        binding.btnpregunta2.setOnClickListener(this)
        binding.btnpregunta3.setOnClickListener(this)
        binding.btnpregunta4.setOnClickListener(this)
        binding.btnpregunta7.setOnClickListener(this)


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.tvResultado)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    override fun onClick(v: View) {
        when (v.id) {
            R.id.btnpregunta1 -> pregunta1()
            R.id.btnpregunta2 -> pregunta2()
            R.id.btnpregunta3 -> pregunta3()
            R.id.btnpregunta4 -> pregunta4()
            R.id.btnpregunta7 -> pregunta7()
        }
    }
    fun pregunta1(){
        startActivity(Intent(this,
                Pregunta1Activity::class.java))
    }
    fun pregunta2(){
        startActivity(Intent(this,
            Pregunta2Activity::class.java))
    }
    fun pregunta3(){
        startActivity(Intent(this,
            Pregunta3Activity::class.java))
    }
    fun pregunta4(){
        startActivity(Intent(this,
            Pregunta4Activity::class.java))
    }
    fun pregunta7(){
        startActivity(Intent(this,
            Pregunta7Activity::class.java))
    }
}