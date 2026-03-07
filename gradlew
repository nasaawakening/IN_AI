#!/usr/bin/env sh

DIR="$(cd "$(dirname "$0")" && pwd)"

CLASSPATH=$DIR/gradle/wrapper/gradle-wrapper.jar

JAVA_CMD="java"

if [ -n "$JAVA_HOME" ]; then
  JAVA_CMD="$JAVA_HOME/bin/java"
fi

exec "$JAVA_CMD" -classpath "$CLASSPATH" org.gradle.wrapper.GradleWrapperMain "$@"