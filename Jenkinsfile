pipeline {
    agent any

    stages {
        stage('Build') {
            steps {
                // Pasos de construcción
                echo 'Building...'
            }
        }
    }

    post {
        success {
            // Pasos a realizar en caso de éxito
            echo 'Build successful!'
        }

        failure {
            // Pasos a realizar en caso de fallo
            echo 'Build failed!'
        }
    }
}
