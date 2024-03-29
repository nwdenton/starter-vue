node {
    git url: 'https://github.com/nwdenton/starter-vue.git'
    def v = version()
    if (v) {
     echo "Building version ${v}"
    }

    stage('Build FrontEnd') {
        echo 'Building FrontEnd...'
        sh 'pushd frontend; npm install; npm run build; popd;'
    }

    stage('Build Backend') {
      echo 'Building Backend..'
      sh './gradlew build -x test'
    }

    stage('Deploy') {
        cfPush(
            target: 'api.sys.manual.smsf.s2p.cloud',
            organization: 'SMMP',
            cloudSpace: 'dev',
            credentialsId: 'PCF_LOGIN'
        )
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
 }
 def version() {
    def matcher = readFile('build.gradle') =~ '^version = \'.+\'$'
    matcher ? matcher[0][1] : null
 }