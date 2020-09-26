package br.com.digitalhouse.Parte_D

class ProfessorTitular(
        override val nome: String,
        override val sobrenome: String,
        override var tempoDeCasa: Int,
        override val codigoProfessor: Int,
        val especialidade: String,

) : Professor {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as ProfessorTitular

        if (codigoProfessor != other.codigoProfessor) return false

        return true
    }

    override fun hashCode(): Int {
        return codigoProfessor
    }
}