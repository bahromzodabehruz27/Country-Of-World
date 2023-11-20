package tj.behruz.atlasofworld.domain.repositories

import retrofit2.Response
import tj.behruz.atlasofworld.domain.model.Country

interface CountryRepository {
    suspend fun getAllCountries(): Response<List<Country>>
}