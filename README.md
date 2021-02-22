# SpotifyTest

## Description

SpotifyTest is a simple aplication that consumes the services provided by the Spotify mobile API

The project was developed in Android Native with Kotlin using:

- Clean Architecture with 5 layers

- [x] Presentation: A layer that interacts with the UI.
- [x] Use cases: Sometimes called interactors. Defines actions the user can trigger.
- [x] Domain: Contains the business logic of the app.
- [x] Data: Abstract definition of all the data sources.
- [x] Framework: Implements interaction with the Android SDK and provides concrete implementations for the data layer.

![alt text](https://koenig-media.raywenderlich.com/uploads/2019/06/Android-Clean-Architecture.png)

- Model-View-Presenter as pattern for the presentation layer

![alt text](https://support.touchgfx.com/img/basic-concepts/software-architecture-mvp/mvp.png)

- Repository pattern for the data layer
- Coroutines for the async tasks
- Dagger Hilt for Dependency Injection
- Retrofit to consume the API Rest


### Dependencies used

- [x] Spotify Auth v1.2.3
- [x] Kotlin v1.4.21
- [x] Dagger Hilt v2.31-alpha
- [x] Retrofit2 v2.9.0
- [x] Coroutines v1.4.2
- [x] Glide v4.11.0
- [x] Android Navigation v2.3.3


## Requirements

- [x] Minimum version: Android 7 - API level 24

### Made by Brayan Arias - stevenson.arias@gmail.com - www.linkedin.com/in/bsav157
