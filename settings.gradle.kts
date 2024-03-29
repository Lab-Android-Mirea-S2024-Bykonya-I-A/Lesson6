pluginManagement {
    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
}

rootProject.name = "ru.mirea.Bykonya.Lesson6"
include(":app")
include(":app:task_2_1")
include(":app:securesharedpreferences")
include(":app:internalfilestorage")
include(":app:notebook")
include(":app:employeedb")
include(":app:mireaproject")
