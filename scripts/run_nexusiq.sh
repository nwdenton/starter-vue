#!/usr/bin/env bash

export SCRIPT_DIR="$(dirname "$(stat -f "$0")")"
pushd $SCRIPT_DIR/..

./gradlew bootJar
java -jar $NEXUS_IQ_CLI_JAR_PATH -i smm-p -s https://nexusiq.dev.s2p.cloud/ -t develop build/libs/maestro-0.0.1-SNAPSHOT.jar -a $NEXUS_IQ_USERNAME:$NEXUS_IQ_PASSWORD

popd
