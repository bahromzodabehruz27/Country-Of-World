package tj.behruz.atlasofworld.data.repository

import android.util.Log
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import retrofit2.Response
import tj.behruz.atlasofworld.domain.api.CountryApi
import tj.behruz.atlasofworld.domain.model.Country
import tj.behruz.atlasofworld.domain.model.CountryResponse
import tj.behruz.atlasofworld.domain.model.Result
import tj.behruz.atlasofworld.domain.repositories.CountryRepository
import javax.inject.Inject

class CountryRepositoryImpl @Inject constructor(private val countryApi: CountryApi) : CountryRepository {

    override suspend fun getAllCountries(): Response<List<Country>> {
        return countryApi.getCountries()
    }
}