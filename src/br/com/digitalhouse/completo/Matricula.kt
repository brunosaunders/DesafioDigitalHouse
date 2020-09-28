package br.com.digitalhouse.completo

import java.util.*

class Matricula(
        val aluno: Aluno,
        val curso: Curso
) {

    val dataDeMatricula: Date = Date()

    init {
        println("Matrícula realizada com sucesso!")
        println("Nome: ${aluno.nome}; Curso: ${curso.nome}")
        println("------------------------------------")
    }
}
