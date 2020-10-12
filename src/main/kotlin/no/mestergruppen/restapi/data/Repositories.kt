package no.mestergruppen.restapi.data

import org.springframework.data.repository.PagingAndSortingRepository

interface NobbProductRepository : PagingAndSortingRepository<NobbProduct, Int> {}

interface NobbOvergruppeRepository : PagingAndSortingRepository<NobbOvergruppe, String> {}

interface NobbVaregruppeRepository : PagingAndSortingRepository<NobbVaregruppe, String> {}

interface NobbHovedgruppeRepository : PagingAndSortingRepository<NobbHovedgruppe, String> {}