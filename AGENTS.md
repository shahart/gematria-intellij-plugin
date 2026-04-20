# Repository Guidelines

## Project Structure & Module Organization
Core code lives under `src/main/java/edu/gematria/` and currently includes both Java (`Calc.java`) and Kotlin (`CalcKt.kt`). Tests mirror that layout in `src/test/java/edu/gematria/` with `*Test.java` and `*Test.kt` files. Supporting materials live in `docs/`, IntelliJ live-plugin experiments live in `live-plugins/`, and the VS Code prototype is in `vscode/`. Build metadata exists in multiple formats: `build.gradle`, `build.gradle.kts`, `pom.xml`, and `build.xml`.

## Build, Test, and Development Commands
Use the Gradle wrapper as the default path because GitHub Actions runs `build` through Gradle.

- `./gradlew build` or `gradlew.bat build`: compile Java/Kotlin and run JUnit tests.
- `./gradlew test`: run the JVM test suite only.
- `mvn test`: alternate Maven test path for the published `edu.gematria` artifact setup.
- `python -m unittest calc`: run the Python helper test path used by `.github/workflows/python.yml`.
- `ant dist`: create the legacy jar in `dist/lib/`.

## Coding Style & Naming Conventions
Follow the existing style in `src/`: 4-space indentation, braces on the same line in Java, and standard Kotlin formatting. Keep packages under `edu.gematria`. Use `PascalCase` for classes, `camelCase` for methods, and name tests after the target class, for example `CalcTest` and `CalcKtTest`. No formatter or linter is checked in, so keep changes small and consistent with nearby code.

## Testing Guidelines
JVM tests use JUnit 4 (`org.junit.Test`). Add or update tests in `src/test/java/edu/gematria/` whenever gematria logic changes, especially for Hebrew character ranges and boundary values. Prefer deterministic assertions over shared fixtures. Run `./gradlew test` before opening a PR; run the Python command too if you touched `calc.py`.

## Commit & Pull Request Guidelines
Recent commits are short and direct, for example `typo`, `python`, and `Kotlin/ Gradle`. Keep commit subjects brief, imperative, and focused on one change. Pull requests should include a short summary, list of commands you ran, and linked issues when relevant. Add screenshots or GIFs for IntelliJ or VS Code UI changes.

## Configuration Tips
`build.gradle` can read GitHub Packages credentials from `gpr.key` or the `TOKEN` environment variable. Do not commit secrets, generated output, or local IDE state.
