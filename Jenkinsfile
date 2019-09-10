node {
    git url: 'https://github.com/nwdenton/starter-vue.git'
    def v = version()
    if (v) {
     echo "Building version ${v}"
    }

    stage('Quality Analysis') {
        withCredentials([string(credentialsId: 'SONARQUBE_LOGIN', variable: 'SECRET')]) {
            echo "My secret text is '${SECRET}'"
        }
    }

    stage('Build') {
      echo 'Building..'
      sh './gradlew build -x test'
    }

    stage('Test') {
      echo 'Testing..'
      sh './gradlew test'
    }

    stage('Deploy') {
     echo 'Deployed on PCF for real'
    }
 }
 def version() {
    def matcher = readFile('build.gradle') =~ '^version = \'.+\'$'
    matcher ? matcher[0][1] : null
 }