package com.example.kotlinprueba

import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.FirebaseDatabase

class RegistroActivity : AppCompatActivity() {

    private lateinit var editTextUsername: EditText
    private lateinit var editTextPassword: EditText
    private lateinit var editTextEmail: EditText
    private lateinit var editTextBirthdate: EditText
    private lateinit var buttonRegister: Button
    private lateinit var auth: FirebaseAuth
    private lateinit var database: FirebaseDatabase

    private val TAG = "RegistroActivity"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registro)

        editTextUsername = findViewById(R.id.editTextUsername)
        editTextPassword = findViewById(R.id.editTextPassword)
        editTextEmail = findViewById(R.id.editTextEmail)
        editTextBirthdate = findViewById(R.id.editTextBirthdate)
        buttonRegister = findViewById(R.id.buttonRegister)

        auth = FirebaseAuth.getInstance()
        database = FirebaseDatabase.getInstance()

        buttonRegister.setOnClickListener {
            registerUser()
        }
    }

    private fun registerUser() {
        val username = editTextUsername.text.toString()
        val password = editTextPassword.text.toString()
        val email = editTextEmail.text.toString()
        val birthdate = editTextBirthdate.text.toString()

        if (username.isNotEmpty() && password.isNotEmpty() && email.isNotEmpty() && birthdate.isNotEmpty()) {
            auth.createUserWithEmailAndPassword(email, password).addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    Log.d(TAG, "Usuario autenticado con éxito")
                    val user = auth.currentUser
                    val userRef = database.reference.child("usuarios").push()
                    val userId = userRef.key

                    val userMap = hashMapOf(
                        "id" to userId,
                        "n_usuario" to username,
                        "contrasena" to password,
                        "email" to email,
                        "fecha_nacimiento" to birthdate
                    )

                    if (userId != null) {
                        userRef.setValue(userMap).addOnCompleteListener { dbTask ->
                            if (dbTask.isSuccessful) {
                                Log.d(TAG, "Usuario registrado con éxito: $userMap")
                                Toast.makeText(this, "Usuario registrado con éxito", Toast.LENGTH_SHORT).show()
                            } else {
                                Log.e(TAG, "Error al registrar usuario en la base de datos: ${dbTask.exception?.message}")
                                Toast.makeText(this, "Error al registrar usuario", Toast.LENGTH_SHORT).show()
                            }
                        }
                    } else {
                        Log.e(TAG, "Error al obtener el ID del usuario")
                        Toast.makeText(this, "Error al registrar usuario", Toast.LENGTH_SHORT).show()
                    }
                } else {
                    Log.e(TAG, "Error al registrar usuario: ${task.exception?.message}")
                    Toast.makeText(this, "Error al registrar usuario: ${task.exception?.message}", Toast.LENGTH_SHORT).show()
                }
            }
        } else {
            Log.w(TAG, "Por favor, complete todos los campos")
            Toast.makeText(this, "Por favor, complete todos los campos", Toast.LENGTH_SHORT).show()
        }
    }
}
