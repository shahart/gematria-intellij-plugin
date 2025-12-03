# Copilot / AI Agent Instructions for gematria-intellij-plugin

Purpose
- **Goal**: Help contributors and AI agents quickly understand, build, test, and change this IntelliJ plugin that computes Hebrew gematria values.

Quick Setup & Build
- **Build (Gradle)**: use the included wrapper from project root: ``./gradlew build`` (runs compile, tests, packaging for the plugin).
- **Test (Gradle)**: ``./gradlew test``. Tests use JUnit4 and validate Unicode-based calculations in `src/test/java/edu/gematria/CalcTest.java`.
- **Alternate (Maven)**: there is a `pom.xml` for library-style tasks; basic commands: ``mvn test`` or ``mvn deploy`` (see README). Prefer Gradle for plugin lifecycle.

Project Big Picture
- **What this is**: a small IntelliJ editor plugin that adds an `EditorPopupMenu` action named "Gematria" (see `src/main/resources/META-INF/plugin.xml`).
- **Main logic**: `Calc.calc(String)` (in `src/main/java/edu/gematria/Calc.java`) implements gematria by checking Unicode code points for Hebrew letters and summing values.
- **Integration points**: the plugin registers `EditorIllustrationAction` (class at `src/main/java/edu/gematria/EditorIllustrationAction.java`) in `plugin.xml`. Changes to actions or IDs must be reflected in `plugin.xml` and may require updating the `patchPluginXml` configuration in `build.gradle.kts`.

Code & Conventions (concrete patterns)
- **Unicode handling**: The code uses literal code point ranges (e.g., 1488..). When refactoring `Calc`, preserve exact ranges and test expectations in `CalcTest.java` which use Hebrew strings.
- **Java version**: project targets Java 17 (see `pom.xml` and `build.gradle.kts`). Keep source/target compatibility when editing build files.
- **Action registration**: actions are declared in `plugin.xml` and reference fully-qualified class names. Search for `EditorPopupMenu` to find popup-menu actions.
- **Tests**: use `junit:4.x`. Tests are small unit tests focused on deterministic Unicode behavior — keep them fast and JVM-only.

Build nuances & known issues
- The README notes a prior Gradle IntelliJ plugin version problem. If the Gradle IntelliJ plugin or `patchPluginXml` causes build errors, try adjusting the `intellij { version.set(...) }` or plugin version in `build.gradle.kts`, and run `./gradlew --stacktrace build` to diagnose.
- Publishing/distribution: `pom.xml` contains `distributionManagement` and a custom wagon; publishing flows are not required for local development.

How to change features safely (recommended steps)
- Update behavior in `Calc.java` → run `./gradlew test` and add/adjust `CalcTest.java` cases using the Hebrew literals already present.
- If adding UI actions: add the class in `src/main/java/...`, register it in `src/main/resources/META-INF/plugin.xml`, then run the Gradle build.
- When editing `plugin.xml`, keep plugin `id` (`edu.gematria`) stable.

Search & navigation tips (examples)
- Find the main logic: ``rg "class Calc" -n`` or open ``src/main/java/edu/gematria/Calc.java``.
- Find action registrations: ``rg "EditorPopupMenu|EditorBasics.EditorIllustrationAction"``.

When to ask the human
- Ask before changing the plugin ID, publishing flow, or updating Java/IntelliJ target versions.
- Ask if you plan to change the Unicode-to-value mapping logic or the tests that assert exact numeric outputs.

If you update this file
- Preserve the concise, example-driven style and add any new commands or gotchas discovered while working on the codebase.

