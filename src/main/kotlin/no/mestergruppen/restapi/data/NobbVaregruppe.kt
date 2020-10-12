package no.mestergruppen.restapi.data

import com.fasterxml.jackson.annotation.JsonInclude
import javax.persistence.*

@Entity
@JsonInclude(JsonInclude.Include.NON_NULL)
data class NobbVaregruppe(

        @Id
        val varegruppeNr: String,

        val beskrivelse: String? = null,

        @ManyToOne()
        @JoinColumn(name="nobb_hovedgruppe_nr")
        val nobbHovedgruppe: NobbHovedgruppe? = null//,

) {
        override fun toString(): String {
                return "${this::class.simpleName}(" +
                        "varegruppeNr=$varegruppeNr, " +
                        "beskrivelse=$beskrivelse, " +
                        "nobbHovedgruppeNr=${nobbHovedgruppe?.hovedgruppeNr})"

        }
}
