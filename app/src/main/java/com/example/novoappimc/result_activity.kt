package com.example.novoappimc

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.TextView

class result_activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        supportActionBar?.setHomeButtonEnabled(true)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val tvresult = findViewById<TextView>(R.id.textview_result)
        val tvclassificacao = findViewById<TextView>(R.id.textview_classificacao)

        val result: Float = intent.getFloatExtra("EXTRA_RESULT", 0.01f)
        tvresult.text = result.toString()

        var classificacao = if(result < 18.5f){
            tvresult.setBackgroundColor(getColor(R.color.blue))
            "ABAIXO DO PESO"
        }else if(result in 18.5f..22.9f){
            tvresult.setBackgroundColor(getColor(R.color.green2))
            "NORMAL"
        }else if (result in 23f..24.9f){
            tvresult.setBackgroundColor(getColor(R.color.yellow))
            "RISCO DE SOBREPESO"
        }else if (result in 25f..29.9f){
            tvresult.setBackgroundColor(getColor(R.color.red2))
            "SOBREPESO"
        }else{
            tvresult.setBackgroundColor(getColor(R.color.red))
            "OBESO "
        }

        tvclassificacao.text = classificacao


    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        finish()
        return super.onOptionsItemSelected(item)
    }
}

