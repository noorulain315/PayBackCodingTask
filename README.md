<h1 align="center">PayBack Coding Challenge</h1>


PayBackCodingTask - A single activity based MVVM architecture with layer based modularization.

## Prerequisite (To Build Project)

- Android Studio
- Gradle 7.1.3

## Techstack & Libs

- JetPack
    - LiveData
    - Lifecycle
    - ViewModel
    - Android Navigation Component
- Hilt
- Retrofit
- Coroutines
- Architecture
    - MVVM Architecture
    - Repository pattern

## Modules

- Core (A simple library module to provide utility classes and extension functions. It contain
  global classes.)
- App (Main App module that contains UI(activities, fragments, adapters), VMs)
- Data (It contain remote models, repository implementations)
- Domain (It contain usecases, models)

## Note

In case, project don't build, Do the following. Sync project with Gradle files Build > Clean
project, Rebuild Project.