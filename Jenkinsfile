pipeline {
    agent any

    environment {
        registryCredential = 'ecr:us-east-1:awscreds'
        AWS_REGION = 'us-east-1'
        ECR_REPO = 'vprofilerepo'
        IMAGE_TAG = "${BUILD_NUMBER}"
        ACCOUNT_ID = '355877360751'
        ECR_URI = "${ACCOUNT_ID}.dkr.ecr.${AWS_REGION}.amazonaws.com/${ECR_REPO}"
    }

    tools {
        maven "MAVEN3.9"
        jdk "JDK17"
    }

    stages {

        stage('Fetch Code') {
            steps {
                git branch: 'main', url: 'https://github.com/anushasatish-19/quote-app.git'
            }
        }

        stage('Build') {
            steps {
                sh 'mvn -B clean verify -DskipTests'
            }
        }

        stage('Checkstyle Analysis') {
            steps{
                sh 'mvn checkstyle:checkstyle'
            }
        }
/*
        stage('SonarQube Analysis') {
            steps {
                withSonarQubeEnv('sonarserver') {
                    sh 'mvn sonar:sonar'
                }
            }
        }

        stage("Quality Gate") {
            steps {
              timeout(time: 1, unit: 'HOURS') {
                waitForQualityGate abortPipeline: true
              }
            }
          }
*/
        stage('Build App Image') {
            steps {
                 script {
                     dockerImage = docker.build("${ECR_URI}:${BUILD_NUMBER}", ".")
                }
            }
    }

        stage('Login to ECR') {
            steps {
                 sh """
                 aws ecr get-login-password --region ${AWS_REGION} | \
                 docker login --username AWS --password-stdin ${ACCOUNT_ID}.dkr.ecr.${AWS_REGION}.amazonaws.com
                 """
            }
    }

    stage('Push App Image to ECR') {
        steps {
             sh """
             docker push ${ECR_URI}:${BUILD_NUMBER}
             """
         }
    }

     stage('Remove container images'){
          steps{
            sh 'docker image prune -af'
          }
    }
/*
        stage('Deploy to ECS') {
            steps {
                sh """
                aws ecs update-service \
                --cluster quote-app-cluster \
                --service quote-app-service \
                --force-new-deployment \
                --region ${AWS_REGION}
                """
            }
        }  */
    }

    post {
        success {
            echo '✅ Pipeline executed successfully!'
        }
        failure {
            echo '❌ Pipeline failed!'
        }
    }
}
