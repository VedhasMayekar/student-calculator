
pipeline {
    agent any

    options {
        skipDefaultCheckout(true)
        timeout(time: 10, unit: 'MINUTES')
    }

    parameters {
        booleanParam(
            name: 'RUN_APP',
            defaultValue: true,
            description: 'Run the calculator application'
        )
    }

    stages {
        stage('Verify') {
            steps {
                deleteDir()
                checkout scm

                bat 'git --version'
                bat 'java -version'
                bat 'mvn -version'

                bat 'mvn clean test'

                script {
                    if (params.RUN_APP) {
                        bat 'mvn package'
                        bat 'mvn exec:java -Dexec.mainClass=com.student.App'
                    }
                }
            }
        }
    }

    post {
        success {
            echo 'Build completed successfully!'
        }
        failure {
            echo 'Build failed. Check the console output.'
        }
        always {
            echo 'Pipeline execution finished.'
        }
    }
}
