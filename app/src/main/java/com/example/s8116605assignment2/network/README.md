# NIT3213 Final Assignment

An Android application for the NIT3213 final assignment. The app authenticates a
student against the unit's REST API, retrieves a list of entities for the
authenticated session, and displays the full details of any entity the user
selects.

## Screens

1. **Login** – the student enters their student ID and first name, which are sent
   to the authentication endpoint. On success the API returns a keypass.
2. **Dashboard** – using the keypass, the app fetches a list of entities and shows
   a summary of each (excluding the description) in a RecyclerView.
3. **Details** – tapping an entity opens a screen showing its full information,
   including the description.

## Architecture

The app follows the MVVM pattern with a single Activity that hosts all three
screens as fragments, navigated with the Jetpack Navigation Component.

- **Fragment** – displays the UI and observes state from the ViewModel.
- **ViewModel** – holds the screen logic and exposes results as LiveData.
- **Repository** – the single point of contact with the network layer.
- **Retrofit API** – defines the endpoints the repositories call.

## Tech stack

- Kotlin
- MVVM with Android ViewModel and LiveData
- Jetpack Navigation Component (single-Activity, fragment-based)
- Retrofit and Moshi for networking and JSON parsing
- OkHttp logging interceptor
- Kotlin Coroutines for asynchronous calls
- Koin for dependency injection
- RecyclerView for the entity list

## Dependency injection

Dependencies are provided through a single Koin module (`di/AppModule.kt`), which
supplies Retrofit, the API, both repositories and both ViewModels. Koin is started
in the Application class, registered in the manifest. ViewModels receive their
repository through the constructor and are resolved in fragments with
`by viewModel()`.

## Testing

Unit tests cover the ViewModel logic in isolation, using a mocked repository so no
real network calls are made.

- **JUnit** – test framework
- **MockK** – mocks the repositories
- **kotlinx-coroutines-test** – drives the viewModelScope coroutines
- **core-testing** – InstantTaskExecutorRule for LiveData

Run the tests from the `test` source set


## Building and running

1. Open the project in Android Studio.
2. Let Gradle sync the dependencies.
3. Run the app on an emulator or device (minimum SDK 27).
4. Log in with your student ID and first name to reach the dashboard.

## Author

Louis Houghton