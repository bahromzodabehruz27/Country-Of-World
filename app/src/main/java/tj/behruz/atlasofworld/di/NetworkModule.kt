package tj.behruz.atlasofworld.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import tj.behruz.atlasofworld.domain.api.CountryApi
import tj.behruz.atlasofworld.util.Constants
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class NetworkModule {

    @Provides
    @Singleton
    fun provideHttpLogger(): HttpLoggingInterceptor {
        return HttpLoggingInterceptor().apply {
            level = HttpLoggingInterceptor.Level.BODY
        }
    }

    @Singleton
    @Provides
    fun provideOkHttpClient(httpLoggingInterceptor: HttpLoggingInterceptor): OkHttpClient {
        return OkHttpClient().newBuilder().addInterceptor(httpLoggingInterceptor).build()
    }

    @Singleton
    @Provides
    fun provideMoshiConvertor(): MoshiConverterFactory {
        return MoshiConverterFactory.create()
    }

    @Singleton
    @Provides
    fun provideRetrofit(okHttpClient: OkHttpClient, moshi: MoshiConverterFactory): Retrofit {
        return Retrofit.Builder().client(okHttpClient).baseUrl(Constants.BASE_URL)
            .addConverterFactory(moshi).build()
    }

    @Singleton
    @Provides
    fun provideCountryApi(retrofit: Retrofit): CountryApi {
        return retrofit.create(CountryApi::class.java)
    }
}