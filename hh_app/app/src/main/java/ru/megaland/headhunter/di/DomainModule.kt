package ru.megaland.headhunter.di

import dagger.Module
import dagger.Provides
import ru.megaland.headhunter.domain.repository.CandidateRepository
import ru.megaland.headhunter.domain.repository.CompanyRepository
import ru.megaland.headhunter.domain.repository.VacancyRepository
import ru.megaland.headhunter.domain.usecase.GetAllCompaniesUseCase
import ru.megaland.headhunter.domain.usecase.GetAllVacanciesUseCase
import ru.megaland.headhunter.domain.usecase.GetCandidateByIdUseCase
import ru.megaland.headhunter.domain.usecase.GetCompanyByIdUseCase
import ru.megaland.headhunter.domain.usecase.GetVacancyByIdUseCase
import ru.megaland.headhunter.presentation.usecase.GetAllCompaniesUseCaseImpl
import ru.megaland.headhunter.presentation.usecase.GetAllVacanciesUseCaseImpl
import ru.megaland.headhunter.presentation.usecase.GetCandidateByIdUseCaseImpl
import ru.megaland.headhunter.presentation.usecase.GetCompanyByIdUseCaseImpl
import ru.megaland.headhunter.presentation.usecase.GetVacancyByIdUseCaseImpl

@Module
class DomainModule {

    @Provides
    fun provideGetAllCompaniesUseCase(companyRepository: CompanyRepository): GetAllCompaniesUseCase {
        return GetAllCompaniesUseCaseImpl(companyRepository = companyRepository)
    }

    @Provides
    fun provideGetCompanyByIdUseCase(companyRepository: CompanyRepository): GetCompanyByIdUseCase {
        return GetCompanyByIdUseCaseImpl(companyRepository = companyRepository)
    }

    @Provides
    fun provideGetAllVacanciesUseCase(vacancyRepository: VacancyRepository): GetAllVacanciesUseCase {
        return GetAllVacanciesUseCaseImpl(vacancyRepository = vacancyRepository)
    }

    @Provides
    fun provideGetVacancyByIdUseCase(vacancyRepository: VacancyRepository): GetVacancyByIdUseCase {
        return GetVacancyByIdUseCaseImpl(vacancyRepository = vacancyRepository)
    }

    @Provides
    fun provideGetCandidateByIdUseCase(candidateRepository: CandidateRepository): GetCandidateByIdUseCase {
        return GetCandidateByIdUseCaseImpl(candidateRepository = candidateRepository)
    }
}