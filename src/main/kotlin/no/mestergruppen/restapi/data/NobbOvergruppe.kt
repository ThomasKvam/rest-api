package no.mestergruppen.restapi.data

import com.fasterxml.jackson.annotation.JsonIgnore
import com.fasterxml.jackson.annotation.JsonInclude
import javax.persistence.Entity
import javax.persistence.FetchType
import javax.persistence.Id
import javax.persistence.OneToMany

@Entity
@JsonInclude(JsonInclude.Include.NON_NULL)
data class NobbOvergruppe(

        @Id
        val overgruppeNr: String,

        val beskrivelse: String? = null,

        @OneToMany(mappedBy = "nobbOvergruppe")
        @JsonIgnore
        val hovedgrupper: MutableList<NobbHovedgruppe> = mutableListOf()
)
