#!/user/bin/env groovy

def call() {
    echo "building the docker image"
    withCredentials ([usernamePassword(credentialsId: 'docker-hub-repo', passwordVariable: 'PASS', usernameVariable: 'USER')]) {
        sh 'docker build -t karentrasporte/demo-app:1.2'
        sh 'echo $PASS | docker login -u $USER --password-stdin'
        sh 'docker push karentrasporte/demo-app:1.2'
    }
}