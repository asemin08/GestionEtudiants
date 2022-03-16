pipeline {
    agent any

    parameters {
        booleanParam(name: 'destroy', defaultValue: false, description: 'Voulez vous détruire votre instance Terraform en cours ?')
    }

    environment {
        AWS_ACCESS_KEY_ID     = credentials('AWS_ACCESS_KEY_ID')
        AWS_SECRET_ACCESS_KEY = credentials('AWS_SECRET_ACCESS_KEY')
        MYRESTO_SSH           = credentials('MYRESTO_SSH')
        GIT_PATH = "https://github.com/asemin08/GestionEtudiants.git"
        GIT_BRANCH = "main"
    }

    stages {
	    stage('Suppression Credentials') {
            when {
                not {
                    equals expected: true, actual: params.destroy
                }
            }
            steps {
                script {
                    dir(".aws") {
                        deleteDir()
                    }
                    dir(".aws@tmp") {
                        deleteDir()
                    }
                }
            }
        }

        stage('récupération du code source et récupération de la bonne branch') {
	        when {
                not {
                    equals expected: true, actual: params.destroy
                }
            }
            steps {
                checkout([$class: 'GitSCM',
                    branches: [[name: "*/${GIT_BRANCH}"]],
                    doGenerateSubmoduleConfigurations: false,
                    extensions: [],
                    submoduleCfg: [],
                    userRemoteConfigs: [[
                        url: "${GIT_PATH}"
                    ]]
                ])
            }
        }

        stage('Terraform init') {
	        when {
                not {
                    equals expected: true, actual: params.destroy
                }
            }
            steps {
                dir(".aws"){
                    withCredentials([file(credentialsId: 'MYRESTO_SSH', variable: 'MyResto')]) {
                        sh 'cp $MyResto MyResto.pem'
                    }
                }
                dir("terraform/app") {
                        sh'terraform init'
                }
            }
        }

        stage('Terraform Plan') {
            when {
                not {
                    equals expected: true, actual: params.destroy
                }
            }

            steps {
                dir("terraform/app") {
                    sh 'terraform plan'
                }
            }
        }

        stage('Terraform Apply') {
            when {
                not {
                    equals expected: true, actual: params.destroy
                }
            }

            steps {
                dir("terraform/app") {
                    sh "terraform apply --auto-approve"
                }
            }
        }

        stage('Terraform Destroy') {
            when {
                equals expected: true, actual: params.destroy
            }

            steps {
                dir("terraform/app") {
                    sh "terraform destroy --auto-approve"
                }
            }
        }

        stage('read') {
           steps {
           dir("terraform/app") {
                 script {
                     def data = readFile(file: 'ip_connection.txt')
                     println(data)
                  }
               }
           }
        }

    }
}