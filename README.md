# 2016 UBot Concept "Rosie"

[![Travis](https://img.shields.io/travis/keplersj/rosie.svg?style=flat-square)](https://travis-ci.org/keplersj/rosie)
[![Codecov](https://img.shields.io/codecov/c/github/keplersj/rosie.svg?style=flat-square)](https://codecov.io/gh/keplersj/rosie)

This repository contains the source code and RobotBuilder schematic used to create JudgeMent Call's 2016 FIRST Competition robot.

## Building and Deploying to Robot

There are two ways in which the robots code may be built and deployed to robots.

### Gradle Build System

The first and preferred method uses the Gradle Build System - thanks to [OpenRIO](https://github.com/Open-RIO)'s [GradleRIO](https://github.com/Open-RIO/GradleRIO). To deploy with this method run the commands below:

On Windows Systems:
```
gradlew.bat toastDeploy deploy
```

On Linux, OS X, or other Unix-like Systems:
```
./gradlew toastDeploy deploy
```
