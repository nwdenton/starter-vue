 node {
     stage('Preparation') {
         // Get some code from a GitHub repository
         git credentialsId: 'ndenton_maestro_github', url: 'ssh://github.com/nwdenton/starter-vue.git'
     }

     stages {
         stage('Build') {
             steps {
                 echo 'Building..'
             }
         }
         stage('Test') {
             steps {
                 echo 'Testing..'
             }
         }
         stage('Deploy') {
             steps {
                 echo 'Deploying....'
             }
         }
     }
 }