package com.example.snackbar

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.activity_cadastro.*
import kotlinx.android.synthetic.main.cadastro_body.*

class CadastroActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cadastro)

        //setando a toolbar nova
        setSupportActionBar(cadastro_toolbar)


        //evento de click - intent que volta para a tela de LoginActivity
        cadastro_toolbar.setNavigationOnClickListener {
            val intentVolta = Intent(this, LoginActivity::class.java)
            startActivity(intentVolta)
        }

        //evento de click no botao CADASTRAR confere senhas e mostra snakcbar
        cadastro_body_button.setOnClickListener {
           pegaInfoCadastro()
            val usuarioCriado = pegaInfoCadastro()
            val intentVaiParaMain = Intent(this, MainActivity::class.java)
            intentVaiParaMain.putExtra("chave", usuarioCriado)
            startActivity(intentVaiParaMain)


    }


}

    //incluindo o menu INFO que criei (ainda não tem ação nele)
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_info, menu)
        return true
    }

    //Como fazer pra não aceitar se algum campo estiver vazio?
    // pegando info para fazer cadastro
    fun pegaInfoCadastro() : Usuario {
        val userName = cadastro_user_name.text.toString()
        val email = cadastro_email.text.toString()
        val password = cadastro_password.text.toString()
        val passwordConfirma = cadastro_password_confirma.text.toString()

        if (password == passwordConfirma) {
            showSnack("Cadastro efetuado")

        } else {
            showSnack("Repita a senha")
        }

        return Usuario(1, userName, password)
    }


    fun showSnack(msg: String) {
        val snack = Snackbar.make(cadastro_coordinator, msg, Snackbar.LENGTH_LONG)

        snack.setAction("ok", View.OnClickListener {
            Toast.makeText(this, msg, Toast.LENGTH_SHORT).show()
        })
        snack.show()
    }


}