package tj.behruz.atlasofworld.domain.api

import retrofit2.Response
import retrofit2.http.GET
import tj.behruz.atlasofworld.domain.model.Country

interface CountryApi {
    @GET("all")
    suspend fun getCountries(): Response<List<Country>>
}