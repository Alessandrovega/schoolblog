pipeline {
    agent any

    stages {
        stage('Declarative: Checkout SCM') {
            steps {
                checkout scm
            }
        }

        stage('Declarative: Too Install') {
            steps {
                script {
                    // Coloca aquí los comandos para instalar dependencias
                    echo 'Instalando dependencias...'
                }
            }
        }

        stage('Compile Stage') {
            steps {
                script {
                    // Imprime el contenido del archivo pom.xml
                    echo 'Contenido del pom.xml:'
                    sh 'cat pom.xml'

                    // Intenta compilar el proyecto
                    echo 'Compilando...'
                    try {
                        // Coloca aquí los comandos para compilar tu proyecto
                        sh 'tu_comando_de_compilacion'
                    } catch (Exception e) {
                        // Captura la excepción en caso de fallo de compilación
                        currentBuild.result = 'FAILURE'
                        error("Error durante la compilación: ${e.message}")
                    }
                }
            }
        }

        stage('Testing Stage') {
            steps {
                script {
                    // Coloca aquí los comandos para ejecutar pruebas
                    echo 'Ejecutando pruebas...'
                    try {
                        // Coloca aquí los comandos para ejecutar pruebas
                        sh 'tu_comando_de_pruebas'
                    } catch (Exception e) {
                        // Captura la excepción en caso de fallo en las pruebas
                        currentBuild.result = 'FAILURE'
                        error("Error durante la ejecución de pruebas: ${e.message}")
                    }
                }
            }
        }
    }

    post {
        always {
            // Archivo para almacenar el contenido del pom.xml
            archiveArtifacts 'pom.xml'
        }
        success {
            // Archivo para mostrar como un enlace en la interfaz de Jenkins
            archiveArtifacts artifacts: 'pom.xml', allowEmptyArchive: true

            // Publica un informe HTML en la interfaz de Jenkins
            publishHTML([allowMissing: false, alwaysLinkToLastBuild: true, keepAll: true, reportDir: '.', reportFiles: 'pom.xml', reportName: 'Last Successful Artifacts'])
        }
    }
}
