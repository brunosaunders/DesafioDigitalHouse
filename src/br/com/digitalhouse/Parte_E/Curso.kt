package br.com.digitalhouse.Parte_E

import br.com.digitalhouse.Parte_A.Aluno
import br.com.digitalhouse.Parte_D.ProfessorAdjunto
import br.com.digitalhouse.Parte_D.ProfessorTitular

class Curso(
        val nome: String,
        val codigo: Int,
        val professorTitular: ProfessorTitular,
        val professorAdjunto: ProfessorAdjunto,
        val limiteDeAlunos: Int,
        ) {

    val listaAlunosMatriculados: List<Aluno> = mutableListOf()

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Curso

        if (codigo != other.codigo) return false

        return true
    }

    override fun hashCode(): Int {
        return codigo
    }
}