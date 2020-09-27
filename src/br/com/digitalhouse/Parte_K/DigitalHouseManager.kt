package br.com.digitalhouse.Parte_K

import br.com.digitalhouse.Parte_A.Aluno
import br.com.digitalhouse.Parte_D.Professor
import br.com.digitalhouse.Parte_D.ProfessorAdjunto
import br.com.digitalhouse.Parte_D.ProfessorTitular
import br.com.digitalhouse.Parte_H.Curso
import br.com.digitalhouse.Parte_F.Matricula

class DigitalHouseManager {
    val listaAlunos = mutableListOf<Aluno>()
    val listaProfessores = mutableListOf<Professor>()
    val listaCursos = mutableListOf<Curso>()
    val listaMatriculas = mutableListOf<Matricula>()

    fun registrarCurso(nome: String, codigoCurso: Int, limiteDeAlunos: Int) {
        val cursoDeMesmoCodigo = listaCursos.filter { it.codigo == codigoCurso }.firstOrNull()

        when (cursoDeMesmoCodigo) {
            null -> listaCursos.add(
                    Curso(nome, codigoCurso, null, null, limiteDeAlunos))

            else -> println("Já existe um curso de código $codigoCurso, tente novamente!")
        }
    }

    fun excluirCurso(codigoCurso: Int) {
        val curso = listaCursos.filter { it.codigo == codigoCurso }.firstOrNull()

        when (curso) {
            null -> println("Desculpe, o curso de código $codigoCurso não existe, tente novamente!")

            else -> listaCursos.remove(curso)
        }
    }

    fun registrarProfessorAdjunto(
            nome: String, sobrenome: String,
            codigoProfessor: Int, quantidadeDeHoras: Int,
    ) {
        val professorDeMesmoCodigo = listaProfessores
                .filter { it.codigoProfessor == codigoProfessor }
                .firstOrNull()

        when (professorDeMesmoCodigo) {
            null -> listaProfessores.add(ProfessorAdjunto(nome, sobrenome, 0,
                    codigoProfessor, quantidadeDeHoras))

            else -> println("Já existe um professor cadastrado com o código $codigoProfessor, tente novamente!")
        }
    }

    fun registrarProfessorTitular(
            nome: String, sobrenome: String,
            codigoProfessor: Int, especialidade: String,
    ) {
        val professorDeMesmoCodigo = listaProfessores
                .filter { it.codigoProfessor == codigoProfessor }
                .firstOrNull()

        when (professorDeMesmoCodigo) {
            null -> listaProfessores.add(ProfessorTitular(nome, sobrenome, 0,
                    codigoProfessor, especialidade))

            else -> println("Já existe um professor cadastrado com o código $codigoProfessor, tente novamente!")
        }
    }

    fun excluirProfessor(codigoProfessor: Int) {
        val professor = listaProfessores.filter { it.codigoProfessor == codigoProfessor }.firstOrNull()

        when (professor) {
            null -> println("O professor de código $codigoProfessor não existe, tente novamente!")

            else -> listaProfessores.remove(professor)
        }
    }

    fun registrarAluno(nome: String, sobrenome: String, codigoAluno: Int) {
        val alunoDeMesmoCodigo = listaAlunos.filter { it.codigo == codigoAluno }.firstOrNull()

        when (alunoDeMesmoCodigo) {
            null -> listaAlunos.add(Aluno(nome, sobrenome, codigoAluno))

            else -> println("Já existe um aluno utilizando o código $codigoAluno!")
        }
    }

    fun matricularAlunoEmCurso(codigoAluno: Int, codigoCurso: Int) {
        val aluno = listaAlunos.filter { it.codigo == codigoAluno }.firstOrNull()

        val curso = listaCursos.filter { it.codigo == codigoCurso }.firstOrNull()

        when {
            aluno == null -> println("Código de aluno $codigoAluno não encontrado")

            curso == null -> println("Código de curso $codigoCurso não encontrado")

            else -> if (curso.adicionarAluno(aluno)) {
                curso.listaAlunosMatriculados.add(aluno)

                listaMatriculas.add(Matricula(aluno, curso))

            } else println("Não foi possível matricular ${aluno.nome} pois o curso ${curso.nome} já está lotado.")
        }
    }

    fun alocarProfessores(codigoCurso: Int, codigoProfessorTitular: Int, codigoProfessorAdjunto: Int) {
        val curso = listaCursos.filter { it.codigo == codigoCurso }.firstOrNull()

        val professorTitular = listaProfessores
                .filter { it.codigoProfessor == codigoProfessorTitular }
                .filter { it is ProfessorTitular }
                .firstOrNull()

        val professorAdjunto = listaProfessores
                .filter { it.codigoProfessor == codigoProfessorAdjunto }
                .filter { it is ProfessorAdjunto }
                .firstOrNull()

        when {
            curso == null -> println("O curso de código $codigoCurso não existe!")

            professorAdjunto == null -> println("Professor Adjunto de código $codigoProfessorTitular não encontrado!")

            professorTitular == null -> println("Professor Titular de código $codigoProfessorAdjunto não encontrado!")

            else -> {
                curso.professorTitular = professorTitular as ProfessorTitular?
                curso.professorAdjunto = professorAdjunto as ProfessorAdjunto?
                println("Professores ${professorTitular.nome} e ${professorAdjunto.nome} alocados com sucesso no curso ${curso.nome}!")
            }
        }
    }

    fun consultarAluno(codigoAluno: Int) {
        println("Consulta iniciada!")

        val aluno = listaAlunos.filter { it.codigo == codigoAluno }.firstOrNull()

        when (aluno) {
            null -> println("Não existe um aluno de código $codigoAluno matriculado na DigitalHouse.")

            else -> {
                val cursosMatriculados = mutableListOf<Curso>()

                listaCursos.forEach { curso ->
                    if (curso.listaAlunosMatriculados.contains(aluno)) cursosMatriculados.add(curso)
                }

                if (cursosMatriculados.isNotEmpty()) {
                    cursosMatriculados.forEach {
                        println("${aluno.nome} está matriculado(a) em ${it.nome}")
                    }

                } else println("Esse(a) aluno(a) não está matriculado(a) em nenhum curso da DigitalHouse.")
            }
        }
    }
}
