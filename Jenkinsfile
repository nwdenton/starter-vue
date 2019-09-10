node {
    git url: 'https://github.com/nwdenton/starter-vue.git'
    def v = version()
    if (v) {
     echo "Building version ${v}"
    }

    stage('Build') {
      echo 'Building..'
    }
    stage('Test') {
      echo 'Testing..'
    }
    stage('Deploy') {
      echo 'Deploying....'
    }
 }
 def version() {
    def matcher = readFile('build.gradle') =~ '^version = \'.+\'$'
    matcher ? matcher[0][1] : null
 }