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
                    // Coloca aquí los comandos para compilar tu proyecto
                    sh 'cat pom.xml'
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
}
