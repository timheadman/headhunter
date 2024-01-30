package ru.megaland.kd06.domain.usecase.candidate

import mu.KotlinLogging
import ru.megaland.kd06.domain.model.candidate.Candidate
import ru.megaland.kd06.domain.model.candidate.Tag
import java.time.LocalDate
import java.time.Period
import java.time.format.DateTimeFormatter


class TagsCandidateUseCase {
    private val logger = KotlinLogging.logger {}

    fun execute(candidate: Candidate, tags: MutableList<Tag>) {
        tags.add(Tag(candidate.candidateInfo.profession))
        tags.add(Tag(getSeniority(candidate)))
        logTags(candidate, tags)

    }

    private fun getSeniority(candidate: Candidate): String {
        var monthsDifference = 0
        for (job in candidate.jobExperience) {
            val dateStart = parseLocalDate(job.dateStart)
            val dateEnd = parseLocalDate(job.dateEnd)
            val period = Period.between(dateStart, dateEnd)
            monthsDifference += period.toTotalMonths().toInt()
        }

        return when {
            monthsDifference >= 6 -> {
                "senior"
            }

            monthsDifference >= 3 -> {
                "middle"
            }

            else -> {
                "junior"
            }
        }
    }

    private fun parseLocalDate(dateString: String): LocalDate {
        val formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy")
        return LocalDate.parse("01.$dateString", formatter)
    }

    private fun logTags(candidate: Candidate, tags: List<Tag>) {
        var tagsString = "Candidate tags: "
        for (tag in tags) {
            tagsString += tag.toString()
        }
        logger.debug(tagsString)
    }


}