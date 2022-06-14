## Production from blank state 

1. `./gradlew clean` just to be sure; now webapp/build is non-existent
2. Make sure `webapp/build.gradle.kts` has `vaadin { productionMode = true }`
3. `./gradlew webapp:vaadinPrepareFrontend`, then observe the following:
    * `webapp/build/flow-frontend/styles` only contains `mybutton.css` but not `mytextfield.scss`
    * `webapp/build/resources` is non-existent
4. `./gradlew webapp:vaadinBuildFrontend` fails due to
    > Visiting class org.example.common.MyTextField failed with JAR entry org/example/common/MyTextField.class not found in PATH_TO_PROJECT/common/build/libs/common-1.0-SNAPSHOT.jar.
   This might be a broken class in the project.

## Production after DevMode

1. `./gradlew clean`
2. Make sure `webapp/build.gradle.kts` has `vaadin { productionMode = false }`
3. run WebApp to initiate building the frontend, then observe the following:
   * `build/flow-frontend/styles` contains `mybutton.css` and `mytextfield.scss`
   * `build/resources` only contains the `flow-build-info.json`
4. Make sure `webapp/build.gradle.kts` has `vaadin { productionMode = true }`
5. run `gradle webapp:vaadinBuildFrontend` normally, the above error comes
6. run `gradle webapp:vaadinBuildFrontend` with IntelliJ in debug mode, that works. Now observe:
   * `build/resources` now contains some more files
7. (re)run WebApp, now the production mode seems to work