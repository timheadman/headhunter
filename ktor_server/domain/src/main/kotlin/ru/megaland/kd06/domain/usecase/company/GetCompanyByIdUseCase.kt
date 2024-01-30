package ru.megaland.kd06.domain.usecase.company

import ru.megaland.kd06.domain.model.company.Company

interface GetCompanyByIdUseCase {
    fun execute(companyId: String): Company?

}
