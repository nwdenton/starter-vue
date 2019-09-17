node {
    git url: 'https://github.com/nwdenton/starter-vue.git'
    def v = version()
    if (v) {
     echo "Building version ${v}"
    }

    stage('Build') {
      echo 'Building..'
      sh './gradlew build -x test'
    }

    stage('Test') {
      echo 'Testing..'
      sh './gradlew test'
    }

    stage('Nexus Policy Evaluation') {
       nexusPolicyEvaluation advancedProperties: '', failBuildOnNetworkError: true, iqApplication: selectedApplication('smm-p'), iqScanPatterns: [[scanPattern: '**/*.jar']], iqStage: 'develop', jobCredentialsId: 'nexus-iq-global'
    }

    stage('Quality Analysis') {
        withCredentials([string(credentialsId: 'SONARQUBE_LOGIN', variable: 'SONARQUBE_LOGIN')]) {
            sh './scripts/run_sonarqube.sh'
        }
    }


    stage('Deploy') {
     echo 'Deployed on PCF for real'
    }
 }
 def version() {
    def matcher = readFile('build.gradle') =~ '^version = \'.+\'$'
    matcher ? matcher[0][1] : null
 }