package com.example.actividad

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val etNombre = findViewById<EditText>(R.id.etNombre)
        val etNota1 = findViewById<EditText>(R.id.etNota1)
        val etNota2 = findViewById<EditText>(R.id.etNota2)
        val etNota3 = findViewById<EditText>(R.id.etNota3)
        val btnCalcular = findViewById<Button>(R.id.btnCalcular)
        val tvResultado = findViewById<TextView>(R.id.tvResultado)

        btnCalcular.setOnClickListener {
            val nombre = etNombre.text.toString().trim()
            val txtNota1 = etNota1.text.toString()
            val txtNota2 = etNota2.text.toString()
            val txtNota3 = etNota3.text.toString()

            if (nombre.isEmpty() || txtNota1.isEmpty() || txtNota2.isEmpty() || txtNota3.isEmpty()) {
                Toast.makeText(this, "Por favor complete todos los campos", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val n1 = txtNota1.toDouble()
            val n2 = txtNota2.toDouble()
            val n3 = txtNota3.toDouble()

            if (n1 !in 0.0..20.0 || n2 !in 0.0..20.0 || n3 !in 0.0..20.0) {
                Toast.makeText(this, "Las notas deben estar entre 0 y 20", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val promedio = (n1 + n2 + n3) / 3

            val estado = if (promedio >= 11) "APROBADO" else "DESAPROBADO"

            tvResultado.text = "Estudiante: $nombre\nPromedio: %.2f\nEstado: $estado".format(promedio)
        }
    }
}