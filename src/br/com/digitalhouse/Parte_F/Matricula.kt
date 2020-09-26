package br.com.digitalhouse.Parte_F

import br.com.digitalhouse.Parte_A.Aluno
import br.com.digitalhouse.Parte_H.Curso
import java.util.*
import javax.print.attribute.standard.DateTimeAtCreation

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
