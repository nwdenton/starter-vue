#!/usr/bin/env bash

export SCRIPT_DIR="$(dirname "$(stat -f "$0")")"
pushd $SCRIPT_DIR/..

./gradlew sonarqube \
  -Dsonar.projectKey=Maestro \
  -Dsonar.host.url=https://sonarqube.dev.s2p.cloud \
  -Dsonar.login=$SONARQUBE_LOGIN

popd
