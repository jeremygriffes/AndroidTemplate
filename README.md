# AndroidTemplate

This is a basic template for Android projects configured to my preferences. All dependencies and
versions are defined in the `buildSrc` module. This keeps the dependencies organized and the gradle
files cleaner, but also requires a bit more hand-crafting when adding new modules.

The `core` module is independent of platform; no Android. This is where models and most business
logic should live. As a project grows, more modules like `core` would be built to encapsulate
features or other stand-alone components.

The `network` module, similarly, has no dependency on Android. This is a Ktor implementation
because I want to start building more modules with Kotlin MultiPlatform in mind. Note that `core` is
not KMP ready, due to its reliance on java imports, mainly for expediency. Future endeavors may
fully embrace KMP.

The `app` module ties everything together through dependency injection using Hilt.

## Frameworks included

* Hilt
* Coroutines
* Ktor
* Compose

## Android Studio config

Android Studio Electric Eel | 2022.1.1 Canary 9
Build #AI-221.5921.22.2211.8881706, built on July 28, 2022
Runtime version: 11.0.13+0-b1751.21-8125866 aarch64
VM: OpenJDK 64-Bit Server VM by JetBrains s.r.o.
macOS 12.5
GC: G1 Young Generation, G1 Old Generation
Memory: 2048M
Cores: 8
Registry:
external.system.auto.import.disabled=true
ide.text.editor.with.preview.show.floating.toolbar=false

## Java

$JAVA_HOME points to
/Library/Java/JavaVirtualMachines/temurin-11.jdk/Contents/Home
