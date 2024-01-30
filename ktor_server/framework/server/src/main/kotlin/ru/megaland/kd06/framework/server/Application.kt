package ru.megaland.kd06.framework.server

import io.ktor.server.application.*
import io.ktor.server.engine.*
import io.ktor.server.netty.*
import ru.megaland.kd06.framework.server.plugins.*


fun main() {
    embeddedServer(Netty, port = 8080, host = "0.0.0.0", module = Application::main)
        .start(wait = true)
}

fun Application.main() {
    mainRouting()
    getAllCompaniesRouting()
    getAllVacanciesRouting()
    getCompanyByIdRouting()
    getVacancyByIdRouting()
    getCandidateByIdRouting()
    saveResumeRouting()
    getTagsRouting()
}
