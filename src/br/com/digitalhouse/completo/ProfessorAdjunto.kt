package br.com.digitalhouse.completo

class ProfessorAdjunto(
        override val nome: String,
        override val sobrenome: String,
        override var tempoDeCasa: Int,
        override val codigoProfessor: Int,
        var horasDeMonitoria: Int,

        ) : Professor {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as ProfessorAdjunto

        if (codigoProfessor != other.codigoProfessor) return false

        return true
    }

    override fun hashCode(): Int {
        return codigoProfessor
    }
}