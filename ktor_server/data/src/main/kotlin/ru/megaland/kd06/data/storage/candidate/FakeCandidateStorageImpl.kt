package ru.megaland.kd06.data.storage.candidate

import ru.megaland.kd06.data.storage.model.candidate.*

class FakeCandidateStorageImpl : CandidateStorage {
    private val candidate = listOf(
        CandidateData(
            id = "1",
            CandidateInfoData(
                "Tim Omarov",
                "Android Developer",
                "male",
                "01.03.1976",
                ContactsData(
                    "+79167240000",
                    "example@edu.com"
                ),
                "no"
            ),
            education = listOf(
                EducationData(
                    "Univercity",
                    2003,
                    2007,
                    "Bachelor's Degree in Information Technology Engineering",
                ),
                EducationData(
                    "High School",
                    1998,
                    2008,
                    "Secondary Education - Basic General Education",
                ),
            ),
            jobExperience = listOf(
                JobExperienceData(
                    "2006.11",
                    "2011.12",
                    "MegaSegaDrive7",
                    "In the heart of innovation, our company thrives as a pioneer in cutting-edge technology. With a dynamic team of experts, we're committed to pushing boundaries and delivering solutions that redefine industries. Our culture fosters creativity, collaboration, and a relentless pursuit of excellence. Join us on this exciting journey, where every day presents new opportunities to make an impact and shape the future.",
                ),
                JobExperienceData(
                    "2012.05",
                    "2014.02",
                    "SonsIT",
                    "At the core of our company's success is a dedication to customer satisfaction. With a rich history of delivering quality products and services, we've earned the trust of our global clientele. Our diverse and talented workforce is united by a shared passion for innovation and a customer-centric approach. Join us as we continue to set new standards, providing unparalleled value and solutions that exceed expectations.",
                ),
            ),
            description = "Привет! Я кандидат на должность разработчика с богатым опытом в создании инновационных веб-приложений. В свободное время я увлекаюсь исследованием искусственного интеллекта, а также разработкой собственных игр. Мое хобби также включает в себя путешествия по миру и коллекционирование винтажных фотокамер. Я стремлюсь к постоянному обучению и развитию, чтобы приносить максимальную ценность в мире технологий.",
            tags = listOf(
                TagData(
                    "developer"
                ),
                TagData(
                    "android"
                ),
            )
        ),
    )

    override fun getCandidateById(candidateId: String): CandidateData? {
        return candidate.find { it.id == candidateId }
    }
}