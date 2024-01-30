package ru.megaland.kd06.framework.server.plugins

import com.fasterxml.jackson.databind.SerializationFeature
import io.ktor.http.*
import io.ktor.serialization.jackson.*
import io.ktor.server.application.*
import io.ktor.server.plugins.contentnegotiation.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import ru.megaland.kd06.data.repository.candidate.CandidateRepositoryImpl
import ru.megaland.kd06.data.repository.company.CompanyRepositoryImpl
import ru.megaland.kd06.data.repository.company.VacancyRepositoryImpl
import ru.megaland.kd06.data.storage.candidate.FakeCandidateStorageImpl
import ru.megaland.kd06.data.storage.company.FakeCompanyStorageImpl
import ru.megaland.kd06.data.storage.company.FakeVacancyStorageImpl
import ru.megaland.kd06.domain.model.candidate.Candidate
import ru.megaland.kd06.domain.model.candidate.Tag
import ru.megaland.kd06.presentation.usecase.*

fun Application.mainRouting() {
    routing {
        get("/") {
            call.respondText("Kotlin Bootcamp")
        }
    }
}

fun Application.getAllCompaniesRouting() {
    routing {
        route("/companies") {
            get {
                val companyStorage = FakeCompanyStorageImpl()
                val companyRepository = CompanyRepositoryImpl(companyStorage)
                val listAllCompanies = GetAllCompaniesUseCaseImpl(companyRepository).execute()
                val jsonString = Json.encodeToString(listAllCompanies)
                call.respond(jsonString)
            }
        }
    }
}

fun Application.getCompanyByIdRouting() {
    routing {
        get("/company/{id}") {
            val companyId = call.parameters["id"] ?: ""
            val companyStorage = FakeCompanyStorageImpl()
            val companyRepository = CompanyRepositoryImpl(companyStorage)
            val shortListAllCompanies = GetCompanyByIdUseCaseImpl(companyRepository).execute(companyId)
            val jsonString = Json.encodeToString(shortListAllCompanies)
            call.respond(jsonString)
        }
    }
}

fun Application.getAllVacanciesRouting() {
    routing {
        route("/vacancies") {
            get {
                val vacancyStorage = FakeVacancyStorageImpl()
                val vacancyRepository = VacancyRepositoryImpl(vacancyStorage)
                val listVacancies = GetAllVacanciesUseCaseImpl(vacancyRepository).execute()
                val jsonString = Json.encodeToString(listVacancies)
                call.respond(jsonString)
            }
        }
    }
}

fun Application.getVacancyByIdRouting() {
    routing {
        get("/vacancy/{id}") {
            val vacancyId = call.parameters["id"] ?: ""
            val vacancyStorage = FakeVacancyStorageImpl()
            val vacancyRepository = VacancyRepositoryImpl(vacancyStorage)
            val shortListAllCompanies = GetVacancyByIdUseCaseImpl(vacancyRepository).execute(vacancyId)
            val jsonString = Json.encodeToString(shortListAllCompanies)
            call.respond(jsonString)
        }
    }
}

fun Application.getCandidateByIdRouting() {
    routing {
        get("/candidate/{id}") {
            val candidateId = call.parameters["id"] ?: ""
            val candidateStorage = FakeCandidateStorageImpl()
            val candidateRepository = CandidateRepositoryImpl(candidateStorage)
            val shortListAllCompanies = GetCandidateByIdUseCaseImpl(candidateRepository).execute(candidateId)
            val jsonString = Json.encodeToString(shortListAllCompanies)
            call.respond(jsonString)
        }
    }
}

fun Application.saveResumeRouting() {
    install(ContentNegotiation) {
        jackson {
            enable(SerializationFeature.INDENT_OUTPUT)
        }
    }
    routing {
        post("/save-resume") {
            try {
                val resume = call.receive<Candidate>()
                val candidateStorage = FakeCandidateStorageImpl()
                val candidateRepository = CandidateRepositoryImpl(candidateStorage)
                call.respond(SaveCandidateUseCaseImpl(candidateRepository).execute(resume))
                call.respond(HttpStatusCode.OK, "Resume saved successfully")
            } catch (e: Exception) {
                call.respond(HttpStatusCode.BadRequest, "Invalid request data. ${e.message}")
            }
        }
    }
}
fun Application.getTagsRouting() {
    routing {
        get("/resume-tags") {
            val tags = listOf(Tag("Java"), Tag("QA"), Tag("Fintech"))
            call.respond(tags)
        }
    }
}


