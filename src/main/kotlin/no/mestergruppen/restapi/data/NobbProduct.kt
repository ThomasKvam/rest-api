package no.mestergruppen.restapi.data

import com.fasterxml.jackson.annotation.JsonInclude
import java.time.LocalDateTime
import javax.persistence.*

@Entity
@JsonInclude(JsonInclude.Include.NON_NULL)
data class NobbProduct(
        @Id
        val nobbNr: Int,

        var varetekst: String? = null,

        @Column(length = 1000)
        var langVaretekst: String? = null,

        var prisEnhet: String? = null,

        val created: LocalDateTime? = null,

        var updated: LocalDateTime? = null,

        var vareType: String? = null,

        @ManyToOne()
        @JoinColumn(name="nobb_varegruppe_nr")
        val nobbVaregruppe: NobbVaregruppe? = null

){
        override fun toString(): String {
                return "${this::class.simpleName}(" +
                        "nobbNr=$nobbNr, " +
                        "varetekst=$varetekst, " +
                        "langVaretekst=$langVaretekst, " +
                        "prisEnhet=$prisEnhet, " +
                        "created=$created, " +
                        "updated=$updated, " +
                        "updated=$updated, " +
                        "vareType=$vareType)"
        }
}

