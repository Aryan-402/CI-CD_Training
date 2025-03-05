pipeline {
    agent any
    
    environment {
        // Set Maven path - Update this path if Maven is installed elsewhere
        MAVEN_HOME = 'C:\\Maven\\apache-maven-3.9.9-bin\\apache-maven-3.9.9'
        PATH = "${MAVEN_HOME}\\bin;${env.PATH}"
    }
    
    stages {
        stage('Checkout') {
            steps {
                script {
                    // Clone the repository from GitHub
                    // If repository is private, add 'credentialsId' for authentication
                    git branch: 'main', url: 'https://github.com/Aryan-402/CI-CD_Training.git'
                }
            }
        }
        
        stage('Build') {
            steps {
                script {
                    // Run Maven build - Ensure Maven is installed and accessible
                    bat "\"%MAVEN_HOME%\\bin\\mvn\" clean package"
                }
            }
        }
        
        stage('Deploy') {
            steps {
                script {
                    // Set Tomcat path - Update if Tomcat is installed in a different location
                    def TOMCAT_HOME = 'C:\\Program Files\\Apache Software Foundation\\Tomcat 9.0'
                    
                    // Ensure the target WAR file exists before copying
                    bat """
                        if exist target\\UserAuthWeb-1.0-SNAPSHOT.war (
                            echo Deploying WAR file...
                            xcopy /Y target\\UserAuthWeb-1.0-SNAPSHOT.war \"${TOMCAT_HOME}\\webapps\"
                        ) else (
                            echo WAR file not found! Build may have failed.
                            exit /b 1
                        )
                    """

                    // Start Tomcat Server - Ensure Tomcat is installed properly
                    bat "\"${TOMCAT_HOME}\\bin\\startup.bat\""
                }
            }
        }
        
        stage('Send Email') {
            steps {
                script {
                    // Ensure Jenkins Email plugin is configured before using 'emailext'
                    emailext(
                        subject: 'Deployment Report',
                        body: '''
                            Hi Team,
                            
                            Please find the attached emailable report for details of the deployment.
                            
                            Regards,
                            Jenkins
                        ''',
                        attachLog: true,
                        attachmentsPattern: '**\\target\\surefire-reports\\emailable-report.html',
                        to: 'aryanbhaskar003@gmail.com',
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
