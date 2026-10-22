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
            description: 'Run the application'
        )
    }

    stages {
        stage('Checkout') {
            steps {
                deleteDir()
                checkout scm
            }
        }

        stage('Verify') {
            steps {
                bat 'git --version'
                bat 'java -version'
                bat 'mvn -version'
            }
        }

        stage('Build') {
            steps {
                bat 'mvn clean package'
            }
        }

        stage('Run App') {
            when {
                expression { params.RUN_APP }
            }
            steps {
                bat 'java -jar target/student-calculator-1.0.jar'
            }
        }
    }

    post {
        success {
            archiveArtifacts artifacts: 'target/*.jar',
                fingerprint: true
        }
        failure {
            echo 'Pipeline failed'
        }
        always {
            echo 'Build completed'
        }
    }
}