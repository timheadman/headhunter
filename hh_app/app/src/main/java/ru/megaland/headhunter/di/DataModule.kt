package ru.megaland.headhunter.di

import dagger.Module
import dagger.Provides
import ru.megaland.headhunter.data.repository.CandidateRepositoryImpl
import ru.megaland.headhunter.data.repository.CompanyRepositoryImpl
import ru.megaland.headhunter.data.repository.VacancyRepositoryImpl
import ru.megaland.headhunter.data.storage.candidate.CandidateRetrofitBuilder
import ru.megaland.headhunter.data.storage.candidate.CandidateStorage
import ru.megaland.headhunter.data.storage.candidate.CandidateStorageApiImpl
import ru.megaland.headhunter.data.storage.company.CompanyRetrofitBuilder
import ru.megaland.headhunter.data.storage.company.CompanyStorage
import ru.megaland.headhunter.data.storage.company.CompanyStorageApiImpl
import ru.megaland.headhunter.data.storage.vacancy.VacancyRetrofitBuilder
import ru.megaland.headhunter.data.storage.vacancy.VacancyStorage
import ru.megaland.headhunter.data.storage.vacancy.VacancyStorageApiImpl
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
    fun provideCompanyRepository(companyStorage: CompanyStorage): CompanyRepository {
        return CompanyRepositoryImpl(companyStorage = companyStorage)
    }

    @Provides
    fun provideVacancyStorage(): VacancyStorage {
        return VacancyStorageApiImpl(retrofitApi = VacancyRetrofitBuilder.apiService)
    }

    @Provides
    fun provideVacancyRepository(vacancyStorage: VacancyStorage): VacancyRepository {
        return VacancyRepositoryImpl(vacancyStorage = vacancyStorage)
    }

    @Provides
    fun provideCandidateStorage(): CandidateStorage {
        return CandidateStorageApiImpl(retrofitApi = CandidateRetrofitBuilder.apiService)
    }

    @Provides
    fun provideCandidateRepository(candidateStorage: CandidateStorage): CandidateRepository {
        return CandidateRepositoryImpl(candidateStorage = candidateStorage)
    }

}