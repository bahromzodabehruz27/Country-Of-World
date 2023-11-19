package tj.behruz.atlasofworld.data.usecases

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import tj.behruz.atlasofworld.domain.model.CountryResponse
import tj.behruz.atlasofworld.domain.model.Result
import tj.behruz.atlasofworld.domain.repositories.CountryRepository
import javax.inject.Inject

class CountryUseCase @Inject constructor(
    private val countryRepository: CountryRepository
) {
    suspend operator fun invoke(): Flow<Result<CountryResponse>> = flow {
        emit(Result.Loading)
        val countries = countryRepository.getAllCountries()
        if (countries.isSuccessful && countries.body()!=null){
            emit(Result.Success(CountryResponse(items = countries.body()!!)))
        } else {
            emit(Result.Error("Error while fetching data"))
        }
    }.catch {
        emit(Result.Error("Error while fetching data"))
    }.flowOn(Dispatchers.IO)
}