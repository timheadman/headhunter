package ru.megaland.headhunter.di

import dagger.Component
import ru.megaland.headhunter.presentation.ui.candidate.CandidateEditFragment
import ru.megaland.headhunter.presentation.ui.candidate.CandidateFragment
import ru.megaland.headhunter.presentation.ui.company.CompaniesFragment
import ru.megaland.headhunter.presentation.ui.company.CompanyDetailsFragment
import ru.megaland.headhunter.presentation.ui.vacancy.VacanciesFragment
import ru.megaland.headhunter.presentation.ui.vacancy.VacancyDetailsFragment

@Component(modules = [AppModule::class, DataModule::class, DomainModule::class])
interface AppComponent {
    fun inject(companiesFragment: CompaniesFragment)

    fun inject(companyDetailsFragment: CompanyDetailsFragment)

    fun inject(vacanciesFragment: VacanciesFragment)

    fun inject(vacancyDetailsFragment: VacancyDetailsFragment)

    fun inject(candidateFragment: CandidateFragment)

    fun inject(candidateEditFragment: CandidateEditFragment)
}
