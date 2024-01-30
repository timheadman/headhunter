package ru.megaland.headhunter.domain.model.candidate

data class CandidateInfo(
    val name: String,
    val profession: String,
    val sex: String,
    val birthDate: String,
    val contacts: Contacts,
    val relocation: String,
)



