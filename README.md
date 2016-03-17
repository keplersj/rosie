# 2016 UBot Concept "Rosie"

This repository contains the source code and RobotBuilder schematic used to create JudgeMent Call's 2016 FIRST Competition robot.

## Building and Deploying to Robot

There are two ways in which the robots code may be built and deployed to robots.

### Gradle Build System

The first and preferred method uses the Gradle Build System - thanks to [OpenRIO](https://github.com/Open-RIO)'s [GradleRIO](https://github.com/Open-RIO/GradleRIO). To deploy with this method run the commands below:

On Windows Systems:
```
gradlew.bat deploy
```

On Linux, OS X, or other Unix-like Systems:
```
./gradlew deploy
```

### WPILib Eclipse Plugin

The second method uses WPILib's Eclipse plugin to build and deploy to the robot, WPI maintains the [documentation for this method](https://wpilib.screenstepslive.com/s/4485/m/13810/l/145320-building-and-downloading-a-robot-project-to-the-roborio).
