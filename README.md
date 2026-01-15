# Sneik - Modern Java Snake Game

A modernized version of a 12-year-old Java snake game, updated to work with current Java versions.

## About

This is a snake-game type of game originally written as a Java beginners' course assignment. The game has been modernized to work with Java 17+ and includes:

- Modern Maven build system
- Updated audio system using Java Sound API
- Removed deprecated dependencies
- Executable JAR creation

## Requirements

- Java 17 or higher
- Maven 3.6 or higher

## How to Build and Run

### Using Maven

1. Clone the repository:
```bash
git clone https://github.com/lauri123/Sneik.git
cd Sneik
```

2. Build the project:
```bash
mvn clean package
```

3. Run the game:
```bash
java -jar target/sneik-1.0.0.jar
```

### Alternative: Compile and Run Directly

1. Compile the source:
```bash
javac -d target/classes src/ee/itcollege/llaidna/*.java src/ee/itcollege/llaidna/*/*.java
```

2. Run the game:
```bash
java -cp target/classes ee.itcollege.llaidna.Main
```

## Game Controls

- Arrow Keys: Control Player 1 (Blue snake)
- WASD: Control Player 2 (Green snake)
- ESC: Exit game

## Features

- Two-player snake game
- Food collection system
- Score tracking
- Background music (if audio files are present)
- Smooth graphics with anti-aliasing

## Modernization Changes

- ✅ Added Maven build system
- ✅ Replaced TinySound with Java Sound API
- ✅ Fixed deprecated imports
- ✅ Updated to Java 17 compatibility
- ✅ Created executable JAR with manifest
- ✅ Improved build configuration
- ✅ Added jpackage configuration for Windows standalone
- ✅ Set up GitHub Actions for automated Windows builds

## Windows Standalone Build

The project now supports creating standalone Windows executables that don't require Java installation.

### Automated Build via GitHub Actions

1. Push your code to the main/master branch
2. GitHub Actions will automatically build the Windows executable
3. Download the artifact from the Actions tab
4. The executable will be available as a Windows installer (.exe)

### Manual Windows Build (Windows only)

If you want to build locally on Windows:

1. Install Java 17 JDK
2. Install Maven 3.6+
3. Run the build:
```bash
mvn clean package jpackage:jpackage
```
4. Find the executable in `target/dist/`

### Requirements for Windows Build

- Windows 10/11
- Java 17 JDK (not just JRE)
- Maven 3.6+
- WiX Toolset (for Windows installer creation)

### Troubleshooting

- **jpackage not found**: Ensure you're using JDK 17, not JRE
- **WiX errors**: Install WiX Toolset v3.11+ from https://wixtoolset.org/
- **Memory errors**: Increase JVM memory with `-Xmx1024m`
- **Build fails**: Check that all dependencies are available and Maven build succeeds first

## Original

Java beginners' course assignment - write a Java program or a game. 
This is a snake-game type of game, running in JFrame.
