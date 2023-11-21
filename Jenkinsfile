pipeline {
    agent any

    stages {
        stage('Declarative: Too Install') {
            steps {
                script {
                    // Coloca aquí los comandos para instalar dependencias
                    echo 'Instalando dependencias...'
                    checkout scm
                }
            }
        }

        stage('Compile Stage') {
            steps {
                script {
                    // Imprime el contenido del archivo pom.xml
                    echo 'Contenido del pom.xml:'
                    sh 'cat pom.xml > pom_content.txt'
                    echo 'Compilando...'
                }
            }
        }

        stage('Testing Stage') {
            steps {
                script {
                    // Coloca aquí los comandos para ejecutar pruebas
                    echo 'Ejecutando pruebas...'
                }
            }
        }
    }

    post {
        always {
            // Archivo para almacenar el contenido del pom.xml
            archiveArtifacts 'pom_content.txt'
        }
        success {
            // Archivo para mostrar como un enlace en la interfaz de Jenkins
            archiveArtifacts artifacts: 'pom_content.txt', allowEmptyArchive: true

            // Publica un informe HTML en la interfaz de Jenkins
            publishHTML([allowMissing: false, alwaysLinkToLastBuild: true, keepAll: true, reportDir: '.', reportFiles: 'pom_content.txt', reportName: 'Last Successful Artifacts'])
        }
    }
}

