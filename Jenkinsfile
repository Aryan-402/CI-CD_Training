pipeline {
    agent any
    environment {
        MAVEN_HOME = 'C:\\Program Files\\maven\\apache-maven-3.9.9'  // Update this path for Windows Maven installation
        PATH = "${MAVEN_HOME}\\bin;${env.PATH}"
    }
    stages {
        stage('Checkout') {
            steps {
                // Clone the repository
                git branch: 'main', url: 'https://github.com/manojpapneja/CICD_Training.git'
        
            }
        }
        stage('Build') {
            steps {
                // Use Maven to package the project
                bat 'mvn clean package'
            }
        }
        stage('Deploy') {
            steps {
                // Deploy to Tomcat server (update with correct Tomcat path for Windows)
                bat 'xcopy target\\UserAuthWeb-1.0-SNAPSHOT.war C:\\Program Files\\apache-tomcat-9.0.98\\webapps'
                
                // Start Tomcat server on Windows (ensure Tomcat is set up properly)
                bat 'C:\\Program Files\\apache-tomcat-9.0.98\\bin\\startup.bat'                
            }
        }
        stage('Send Email') {
            steps {
                script {
                    // Email notification
                    emailext(
                        subject: 'Deployment Report',
                        body: '''
                            Hi Team, Please find the attached emailable report for details of the deployment.
                            Regards,
                            Jenkins
                        ''',
                        attachLog: true,
                        attachmentsPattern: '**\\target\\surefire-reports\\emailable-report.html',
                        to: 'manojpapneja@gmail.com',
                        from: 'jenkinsreport@gmail.com'
                    )
                }
            }
        }
    }
    post {
        success {
            echo 'Deployment successful!'
        }
        failure {
            echo 'Deployment failed!'
        }
    }
}
