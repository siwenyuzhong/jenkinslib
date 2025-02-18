#!groovy

@Library('jenkinslib') _

//func from shareibrary
def build = new org.devops.build()
def deploy = new org.devops.deploy()
def tools = new org.devops.tools()

String buildType = "${env.buildType}"
String buildShell = "${env.buildShell}"
String deployHosts = "${env.deployHosts}"
String srcUrl = "${env.srcUrl}"
String branchName = "${env.branchName}"
String artifactUrl = "${env.artifactUrl}"




//pipeline
pipeline{
    agent any

    stages{

        stage("CheckOut"){
            steps{
                script{


                    println("${branchName}")

                    tools.PrintMes("获取代码","green")
                    checkout scmGit(branches: [[name: '*/${branchName}']], extensions: [], userRemoteConfigs: [[credentialsId: 'ad5b148e-12de-4b6c-8163-737e1732828b', url: '${srcUrl}']])
                }
            }
        }

        stage("Build"){
            steps{
                script{
                    tools.PrintMes("执行打包","green")
                    build.Build(buildType,buildShell)
                }
            }
       }
    }
}
