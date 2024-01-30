plugins {
    id("org.gradle.toolchains.foojay-resolver-convention") version "0.5.0"
}
rootProject.name = "ktor_server"
include("domain")
include("data")
include("presentation")
include("framework")
include("framework:server")
findProject(":framework:server")?.name = "server"
