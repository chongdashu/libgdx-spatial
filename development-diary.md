## April

### Mon, 01-May 2017

- The worker connection is blocking, causing the window the freeze up. Probably will need to async this up. Found something for libGDX here:
  https://gamedev.stackexchange.com/a/112391/18095

### Sun, 30-April 2017

- Refactored the worker and attribute requirement sets as it was rather confusing.

- Redid the game code to not put everything into the main class `GdxSpatialGame` and instead to use screens; this was done based on the reworked Super Jumper example:
  https://github.com/saltares/ashley-superjumper/blob/master/core/src/com/siondream/superjumper/MainMenuScreen.java

- Trying to think of a simple game that can be made. Looked at some demos.

- Worker was making connection to SpatialOS, but not appearing in the world viewer. Turns out that I forgot to make sure that the worker name was synced up in `default_launch.json` and `spatialos.LibGdxClient.worker.json`

- Also, handling the connection object was weird, because it was placed in a `try (Connection connection = ...)`. Just made it simpler now.

![Image showing the world viewer with the connected libGdx Java Worker client](docs/img/2017-04.-30-world-viewer-with-libgdx-client.png "World viewer with libGDX client")


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
