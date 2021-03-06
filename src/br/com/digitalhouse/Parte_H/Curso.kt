package br.com.digitalhouse.Parte_H

import br.com.digitalhouse.Parte_A.Aluno
import br.com.digitalhouse.Parte_D.ProfessorAdjunto
import br.com.digitalhouse.Parte_D.ProfessorTitular
import br.com.digitalhouse.Parte_E.Curso

class Curso(
        val nome: String,
        val codigo: Int,
        var professorTitular: ProfessorTitular?,
        var professorAdjunto: ProfessorAdjunto?,
        val limiteDeAlunos: Int,
) {

    val listaAlunosMatriculados = mutableListOf<Aluno>()

    fun adicionarAluno(aluno: Aluno): Boolean {
        return listaAlunosMatriculados.size < limiteDeAlunos
    }

    fun excluirAluno(aluno: Aluno) {
        when {
            listaAlunosMatriculados.contains(aluno) -> listaAlunosMatriculados.remove(aluno)
            else -> println("Aluno não encontrado")
        }
    }

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