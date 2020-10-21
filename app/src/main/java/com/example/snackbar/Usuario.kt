package com.example.snackbar

import java.io.Serializable

class Usuario(val id: Int, val nome: String, val senha: String) : Serializable {

    val email: String = "a"


    override fun toString(): String {
        return "Usuário: $nome, $senha"
    }


}



