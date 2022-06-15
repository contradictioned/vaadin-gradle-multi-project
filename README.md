With gradle task `flowCopyFrontendResources` as registered in webapp/build.gradle.kts, the following steps bring a working productionMode:
1. `./gradlew clean`
2. `./gradlew webapp:vaadinBuildFrontend`
3. run main method in WebApp.kt

Without gradle task `flowCopyFrontendResources`, there's one of the following two cases:

### Case 1: Production from blank state 

1. `./gradlew clean` just to be sure; now webapp/build is non-existent
2. Make sure `webapp/build.gradle.kts` has `vaadin { productionMode = true }`
3. `./gradlew webapp:vaadinPrepareFrontend`, then observe the following:
    * `webapp/build/flow-frontend/styles` only contains `mybutton.css` but not `mytextfield.scss`
    * `webapp/build/resources` is non-existent
4. `./gradlew webapp:vaadinBuildFrontend` fails due to
    > Failed to find the following css files in the `node_modules` or `/Users/manuel/Repos/multiprojectgradletest/webapp/frontend` directory tree:
        - ./styles/mytextfield.scss

### Case 2: Production after DevMode

1. `./gradlew clean`
2. Make sure `webapp/build.gradle.kts` has `vaadin { productionMode = false }`
3. run WebApp to initiate building the frontend, then observe the following:
   * `build/flow-frontend/styles` contains `mybutton.css` and `mytextfield.scss`
   * `build/resources` only contains the `flow-build-info.json`
4. Make sure `webapp/build.gradle.kts` has `vaadin { productionMode = true }`
5. run `gradle webapp:vaadinBuildFrontend` and observe:
   * `build/resources` now contains some more files
7. (re)run WebApp, now the production mode seems to work