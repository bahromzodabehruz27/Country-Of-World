package tj.behruz.atlasofworld.domain.repositories

import kotlinx.coroutines.flow.Flow
import retrofit2.Response
import tj.behruz.atlasofworld.domain.model.Country
import tj.behruz.atlasofworld.domain.model.CountryResponse
import tj.behruz.atlasofworld.domain.model.Result

interface CountryRepository {

    suspend fun getAllCountries(): Response<List<Country>>

}