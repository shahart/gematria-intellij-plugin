# My first Intellij plugin (and vsCode extension) #

a Proof of Concept for gematria. Based on https://github.com/JetBrains/intellij-sdk-code-samples/tree/main/editor_basics

See also https://en.wikipedia.org/wiki/Gematria#Other_methods_in_Hebrew

![](idea-plugin.JPG)


# IntelliJ's Live Plugin

Install https://github.com/dkandalov/live-plugin

import from Gist https://gist.github.com/shahart/e1182d7707631cac9ef06c4290db7aa3


# Utility jar to be available via https://github.com/shahart/maven-repo #

Export the utility to a jar with `mvn deploy` to use git-wagon.

Or (not tested) via `mvn install:install-file -DgroupId=GROUP -DartifactId=ARTIFACT-NAME -Dversion=ARTIFACT-VERSION -Dfile=PATH-TO-THE-JAR -Dpackaging=jar -DlocalRepositoryPath=. -DcreateChecksum=true -DgeneratePom=true`

[![JavaCI](https://github.com/shahart/gematria-intellij-plugin/workflows/JavaCI/badge.svg)](https://github.com/shahart/gematria-intellij-plugin/actions)
