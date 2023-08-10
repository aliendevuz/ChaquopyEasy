package uz.alien.easychaquopy.activity


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import com.chaquo.python.Python
import uz.alien.easychaquopy.databinding.ActivityMainBinding


class ActivityChaquopy : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private lateinit var etEditor: EditText
    private lateinit var bRunner: Button
    private lateinit var tvOutput: TextView

    private val handler = Handler(Looper.getMainLooper())

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        etEditor = binding.etEditor
        bRunner = binding.bRunner
        tvOutput = binding.tvOutput

        val module = Python.getInstance().getModule("main")

        bRunner.setOnClickListener {
            tvOutput.text = ""
            Thread { module.callAttr("run_code", ::print, etEditor.text.toString()) }.start()
        }
    }

    private fun print(text: String) {
        handler.post { tvOutput.append(text) }
    }
}