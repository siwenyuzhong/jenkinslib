#!groovy

@Library('jenkinslib') _

//引用github创建的类
def tool = new org.devops.tools()

pipeline {
    agent any

    options {
        timestamps()
        skipDefaultCheckout()
        disableConcurrentBuilds()
        timeout(time: 1, unit: 'HOURS')
    }

    stages {
        //下载代码
        stage("GetCode"){
            when { environment name: 'test', value: 'abcd' }

            steps{
               timeout(time: 5, unit: 'MINUTES'){
                    script{
                        println('获取代码')
                        println("${test}")
                        input id: 'Test', message: '是否要继续？', ok: '是，继续吧！', parameters: [choice(choices: ['a', 'b'], name: 'test1')], submitter: 'cwy'
                    }
               }
            }
        }

        //将打包和扫描放在一起
        stage("01"){
          failFast true //第一个任务失败，后面的也失败
          parallel {
            //构建
            stage("Build"){
                steps{
                   timeout(time: 20, unit: 'MINUTES'){
                        script{
                            println('应用打包')

                            mvnHome = tool "maven3.5.2"
                            println(mvnHome)

                            sh "${mvnHome}/bin/mvn --version"
                        }
                   }
                }
            }

          //代码扫描
          stage("CodeScan"){
              steps{
                 timeout(time: 30, unit: 'MINUTES'){
                      script{
                          println('代码扫描')

                          tools.PrintMes("this is my jenkinslib")
                      }
                 }
              }
          }
        }
      }
    }

    //构建后操作
    post {
        always {
            script{
                println('always')
            }
        }

        success {
            script{
                currentBuild.description = "\n 构建成功"
            }
        }

        failure {
            script{
                currentBuild.description = "\n 构建失败"
            }
        }

        aborted {
            script{
                currentBuild.description = "\n 构建取消"
            }
        }

    }

}
