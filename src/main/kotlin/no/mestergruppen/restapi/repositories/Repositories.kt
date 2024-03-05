package no.mestergruppen.restapi.repositories

import no.mestergruppen.restapi.data.NobbHovedgruppe
import no.mestergruppen.restapi.data.NobbOvergruppe
import no.mestergruppen.restapi.data.NobbProduct
import no.mestergruppen.restapi.data.NobbVaregruppe
import org.springframework.data.repository.PagingAndSortingRepository

interface NobbProductRepository : PagingAndSortingRepository<NobbProduct, Int> {}

interface NobbOvergruppeRepository : PagingAndSortingRepository<NobbOvergruppe, String> {}

interface NobbVaregruppeRepository : PagingAndSortingRepository<NobbVaregruppe, String> {}

interface NobbHovedgruppeRepository : PagingAndSortingRepository<NobbHovedgruppe, String> {}