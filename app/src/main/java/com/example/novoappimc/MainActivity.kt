package com.example.novoappimc

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btncalcular: Button = findViewById(R.id.button)
        val edtpeso: EditText = findViewById(R.id.editTextPeso)
        val edtaltura: EditText = findViewById(R.id.editTextAltura)

        btncalcular.setOnClickListener {
        val alturaStr = edtaltura.text.toString()
        val pesoStr = edtpeso.text.toString()

        if(alturaStr.isNotEmpty() && pesoStr.isNotEmpty()){
                val peso: Float = pesoStr.toFloat()
                val altura: Float = alturaStr.toFloat()
                val alturafinal: Float = altura * altura
                val imc: Float = peso / alturafinal

                val intent = Intent(this, result_activity:: class.java)
                    .apply {
                        putExtra("EXTRA_RESULT", imc)
                    }
                    startActivity(intent)
                    }else{
                Toast.makeText(this, "Preencher todos os campos", Toast.LENGTH_SHORT).show()

            }

        }

    }
}

