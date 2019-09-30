#!/usr/bin/env bash

./gradlew sonarqube \
  -Dsonar.projectKey=Maestro \
  -Dsonar.host.url=https://sonarqube.dev.s2p.cloud \
  -Dsonar.login=$SONARQUBE_LOGIN

