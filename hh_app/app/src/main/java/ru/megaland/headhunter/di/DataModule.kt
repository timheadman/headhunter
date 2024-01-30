package ru.megaland.headhunter.di

import dagger.Module
import dagger.Provides
import ru.megaland.headhunter.data.repository.CandidateRepositoryImpl
import ru.megaland.headhunter.data.repository.CompanyRepositoryImpl
import ru.megaland.headhunter.data.repository.VacancyRepositoryImpl
import ru.megaland.headhunter.data.storage.CandidateRetrofitBuilder
import ru.megaland.headhunter.data.storage.CandidateStorageApiImpl
import ru.megaland.headhunter.data.storage.CompanyRetrofitBuilder
import ru.megaland.headhunter.data.storage.CompanyStorage
import ru.megaland.headhunter.data.storage.CompanyStorageApiImpl
import ru.megaland.headhunter.data.storage.VacancyRetrofitBuilder
import ru.megaland.headhunter.data.storage.VacancyStorage
import ru.megaland.headhunter.data.storage.VacancyStorageApiImpl
import ru.megaland.headhunter.domain.repository.CandidateRepository
import ru.megaland.headhunter.domain.repository.CompanyRepository
import ru.megaland.headhunter.domain.repository.VacancyRepository

@Module
class DataModule {

    @Provides
    fun provideCompanyStorage(): CompanyStorage {
        return CompanyStorageApiImpl(retrofitApi = CompanyRetrofitBuilder.apiService)
    }

    @Provides
    fun provideCompanyRepository(): CompanyRepository {
        return CompanyRepositoryImpl(companyStorage = CompanyStorageApiImpl(CompanyRetrofitBuilder.apiService))
    }

    @Provides
    fun provideVacancyStorage(): VacancyStorage {
        return VacancyStorageApiImpl(retrofitApi = VacancyRetrofitBuilder.apiService)
    }

    @Provides
    fun provideVacancyRepository(): VacancyRepository {
        return VacancyRepositoryImpl(vacancyStorage = VacancyStorageApiImpl(VacancyRetrofitBuilder.apiService))
    }

    @Provides
    fun provideCandidateRepository(): CandidateRepository {
        return CandidateRepositoryImpl(candidateStorage = CandidateStorageApiImpl(
            CandidateRetrofitBuilder.apiService)
        )
    }

}