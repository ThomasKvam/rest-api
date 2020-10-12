package no.mestergruppen.restapi.data

import com.fasterxml.jackson.annotation.JsonInclude
import javax.persistence.*

@Entity
@JsonInclude(JsonInclude.Include.NON_NULL)
data class NobbHovedgruppe(

        @Id
        val hovedgruppeNr: String,

        val beskrivelse: String? = null,

        @ManyToOne(fetch = FetchType.LAZY)
        @JoinColumn(name="nobb_overgruppe_nr")
        val nobbOvergruppe: NobbOvergruppe? = null,

        @OneToMany(mappedBy = "nobbHovedgruppe", fetch = FetchType.LAZY)
        val varegrupper: MutableList<NobbVaregruppe> = mutableListOf()
) {
        override fun toString(): String {
                return "${this::class.simpleName}(" +
                        "hovedgruppeNr=$hovedgruppeNr, " +
                        "beskrivelse=$beskrivelse, " +
                        "nobbOvergruppeNr=${nobbOvergruppe?.overgruppeNr})"
        }
}
