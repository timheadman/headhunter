package ru.megaland.headhunter.di

import dagger.Module
import dagger.Provides
import ru.megaland.headhunter.domain.usecase.GetAllCompaniesUseCase
import ru.megaland.headhunter.domain.usecase.GetAllVacanciesUseCase
import ru.megaland.headhunter.domain.usecase.GetCandidateByIdUseCase
import ru.megaland.headhunter.domain.usecase.GetCompanyByIdUseCase
import ru.megaland.headhunter.domain.usecase.GetVacancyByIdUseCase
import ru.megaland.headhunter.presentation.ui.candidate.CandidateEditViewModelFactory
import ru.megaland.headhunter.presentation.ui.candidate.CandidateViewModelFactory
import ru.megaland.headhunter.presentation.ui.company.CompaniesViewModelFactory
import ru.megaland.headhunter.presentation.ui.company.CompanyDetailsViewModelFactory
import ru.megaland.headhunter.presentation.ui.vacancy.VacanciesViewModelFactory
import ru.megaland.headhunter.presentation.ui.vacancy.VacancyDetailsViewModelFactory

@Module
class AppModule {

    @Provides
    fun provideCompaniesViewModelFactory(
        getAllCompaniesUseCase: GetAllCompaniesUseCase
    ): CompaniesViewModelFactory {
        return CompaniesViewModelFactory(getAllCompaniesUseCase = getAllCompaniesUseCase)
    }

    @Provides
    fun provideCompanyDetailsViewModelFactory(
        getCompanyByIdUseCase: GetCompanyByIdUseCase
    ): CompanyDetailsViewModelFactory {
        return CompanyDetailsViewModelFactory(getCompanyByIdUseCase = getCompanyByIdUseCase)
    }

    @Provides
    fun provideVacanciesViewModelFactory(
        getAllVacanciesUseCase: GetAllVacanciesUseCase
    ): VacanciesViewModelFactory {
        return VacanciesViewModelFactory(getAllVacanciesUseCase = getAllVacanciesUseCase)
    }

    @Provides
    fun provideVacancyDetailsViewModelFactory(
        getVacancyByIdUseCase: GetVacancyByIdUseCase
    ): VacancyDetailsViewModelFactory {
        return VacancyDetailsViewModelFactory(getVacancyByIdUseCase = getVacancyByIdUseCase)
    }

    @Provides
    fun provideCandidateViewModelFactory(
        getCandidateByIdUseCase: GetCandidateByIdUseCase
    ): CandidateViewModelFactory {
        return CandidateViewModelFactory(getCandidateByIdUseCase = getCandidateByIdUseCase)
    }

    @Provides
    fun provideCandidateEditViewModelFactory(
        getCandidateByIdUseCase: GetCandidateByIdUseCase
    ): CandidateEditViewModelFactory {
        return CandidateEditViewModelFactory(getCandidateByIdUseCase = getCandidateByIdUseCase)
    }

}