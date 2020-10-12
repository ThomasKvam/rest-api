package no.mestergruppen.restapi.data

import com.fasterxml.jackson.annotation.JsonIgnore
import com.fasterxml.jackson.annotation.JsonInclude
import java.time.LocalDateTime
import javax.persistence.*

@Entity
@JsonInclude(JsonInclude.Include.NON_NULL)
data class NobbProduct(
        @Id
        val nobbNr: Int,

        val varetekst: String? = null,

        @Column(length = 1000)
        val langVaretekst: String? = null,

        val prisEnhet: String? = null,

        val created: LocalDateTime? = null,

        val updated: LocalDateTime? = null,

        val vareType: String? = null,

        @ManyToOne(fetch = FetchType.LAZY)
        @JoinColumn(name="nobb_varegruppe_nr")
        @JsonIgnore
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

