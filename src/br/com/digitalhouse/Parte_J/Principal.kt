package br.com.digitalhouse.Parte_J

import br.com.digitalhouse.Parte_I.DigitalHouseManager

fun main() {
    val digital = DigitalHouseManager()

    digital.apply{
        registrarProfessorTitular("Rogério", "Sena", 152, "Javascript")
        registrarProfessorTitular("Veruska", "Ratts", 821, "DataBinding")
        registrarProfessorAdjunto("Mônica", "Geller", 25, 15)
        registrarProfessorAdjunto("Ken", "Adams", 89, 25)

        registrarCurso("Full Stack", 20001, 3)
        registrarCurso("Android", 20002, 2)

        alocarProfessores(20001, 152, 25)
        alocarProfessores(20002, 821, 89)

        registrarAluno("Joey", "Tribianni", 251)
        registrarAluno("Chandler", "Bing", 562)
        registrarAluno("Phoebe", "Buffay", 912)
        registrarAluno("Rachel", "Green", 53)
        registrarAluno("Ross", "Geller", 97)

        matricularAlunoEmCurso(251, 20001)
        matricularAlunoEmCurso(97, 20001)
        matricularAlunoEmCurso(562, 20002)
        matricularAlunoEmCurso(912, 20002)
        matricularAlunoEmCurso(53, 20002)
    }
}