package tj.behruz.atlasofworld.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import tj.behruz.atlasofworld.data.repository.CountryRepositoryImpl
import tj.behruz.atlasofworld.domain.repositories.CountryRepository
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {
    @Binds
    @Singleton
    abstract fun bindCountryRepository(countryRepositoryImpl: CountryRepositoryImpl): CountryRepository
}