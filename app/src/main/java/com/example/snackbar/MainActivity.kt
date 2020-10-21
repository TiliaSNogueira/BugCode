package com.example.snackbar

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        //pegando o usuario serializable que veio do Login
        var usuario = intent.getSerializableExtra("Chave") as? Usuario

        if (usuario != null) {
            //mostrar nome no textview
            main_username.setText(usuario.nome)
        }

        if (usuario != null) {
            //mostrar usuario no toast
           // Toast.makeText(this, "${usuario.toString()}", Toast.LENGTH_LONG).show()
        }


        //pegando o usuario criado no Cadastro
        var usuarioCadastrado = intent.getSerializableExtra("chave") as? Usuario
        if (usuarioCadastrado != null){
            main_username.setText(usuarioCadastrado.nome)
            main_email.setText(usuarioCadastrado.email.toString())
        }


    }
}