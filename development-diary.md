

## April

### Sat, 29-April 2017

- Made a new empty repository on GitHub.

- Found libGDX and Gradle and IntelliJ info: 
  https://github.com/libgdx/libgdx/wiki/Gradle-and-Intellij-IDEA

- Downloaded the setup tool for libGDX: 
  https://github.com/libgdx/libgdx/wiki/Project-Setup-Gradle

- Ended up downloading and installing the whole Android Studio.

- Followed instructions for using IntelliJ with libGDX:
  https://github.com/libgdx/libgdx/wiki/Gradle-and-Intellij-IDEA

- Particularly, the "Running Your Project" section for Desktop:
  https://github.com/libgdx/libgdx/wiki/Gradle-and-Intellij-IDEA#running-your-project

- Installed Grade as the SpatialOS docs mention the Gradle Wrapper (`gradlew`) is unsupported: https://gradle.org/install
  * Just installed the binary version.
  * Placed in `D:\Gradle\gradle-3.5-bin\gradle-3.5\bin`.
  * Added to PATH.

- Placed spatialos.json and added the spatialos.GdxSpatial.worker.json.

- Ran `spatial build GdxSpatial`:
  * It overwrote my `build.gradle` file!
  * It also failed.
  
  ```
  FAILURE: Build failed with an exception.

  * Where:
  Build file 'D:\Projects\libgdx-spatial\workers\libgdx\build.gradle' line: 7

  * What went wrong:
  A problem occurred evaluating root project 'libgdx'.
  > Project with path ':worker' could not be found in root project 'libgdx'.

  * Try:
  Run with --stacktrace option to get the stack trace. Run with --info or --debug option to get more log output.
  [2/2] x Build Gradle (3.3s)
  >>> Build (7.2s)
  ************************************
  Error: exit status 1
  ************************************
  ```

- Tried removing any SpatialOS stuff and leaving the previous `build.gradle`, got the following:

  ```
  [2/2] > Build Gradle
     |
  FAILURE: Build failed with an exception.

  * Where:
  Build file 'D:\Projects\libgdx-spatial\workers\libgdx\build.gradle' line: 52

  * What went wrong:
  A problem occurred evaluating root project 'libgdx'.
  > Failed to apply plugin [id 'android']
     > Gradle version 2.2 is required. Current version is 3.5. If using the gradle wrapper, try editing the distributionUrl in D:\Projects\libgdx-spatial\workers\libgdx\gradle\wrapper\gradle-wrapper.properties to gradle-2.2-all.zip

  * Try:
  Run with --stacktrace option to get the stack trace. Run with --info or --debug option to get more log output.
  [2/2] x Build Gradle (1.3s)
  >>> Build (1.4s)
  ************************************
  Error: exit status 1
  ************************************
  ```

- Had to add `"worker-sdk"` to `settings.gradle`.

- Got snapshot generation working. Hardest bit was setting up the worker attributes. Still unintuitive and rather complex.
