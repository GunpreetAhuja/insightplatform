
pipeline {
  agent any
  stages {
    stage('Build services') {
      steps {
        script {
          sh 'for d in user-service project-service finance-service notification-service; do (cd $d && ./gradlew clean build -x test) || exit 1; done'
        }
      }
    }
    stage('Docker Build') {
      steps { sh 'docker compose build' }
    }
    stage('Deploy Compose') {
      steps { sh 'docker compose up -d --force-recreate' }
    }
  }
  post { always { echo 'Pipeline finished' } }
}
