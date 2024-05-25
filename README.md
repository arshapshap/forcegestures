<div align="center">
  
[![](https://jitpack.io/v/arshapshap/forcegestures.svg)](https://jitpack.io/#arshapshap/forcegestures)
</div>

# <image src='https://github.com/arshapshap/forcegestures/assets/48681339/fd3e0a62-3174-458d-8450-a1b279a898a9' width=50 /> Force Gestures

  Android library that provides an API for processing gestures using touches with different pressure.

## Set Up

### Step 1. Add the JitPack repository to your build file:
<details open><summary>Kotlin</summary>
  
``` Kotlin
dependencyResolutionManagement {
  repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
  repositories {
      mavenCentral()
      maven("https://jitpack.io")
  }
}
```
</details>
<details><summary>Gradle</summary>
  
``` Gradle
dependencyResolutionManagement {
  repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
  repositories {
    mavenCentral()
    maven { url 'https://jitpack.io' }
  }
}
```
</details>

### Step 2. Add the dependency:
<details open><summary>Kotlin</summary>
  
``` Kotlin
dependencies {
  implementation("com.github.arshapshap:forcegestures:0.1.0")
}
```
</details>
<details><summary>Gradle</summary>
  
``` Gradle
dependencies {
  implementation 'com.github.arshapshap:forcegestures:0.1.0'
}
```
</details>
