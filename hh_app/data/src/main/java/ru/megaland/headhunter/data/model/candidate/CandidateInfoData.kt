package ru.megaland.headhunter.data.model.candidate

data class CandidateInfoData(
    val name: String,
    val profession: String,
    val sex: String,
    val birthDate: String,
    val contacts: ContactsData,
    val relocation: String,
)



