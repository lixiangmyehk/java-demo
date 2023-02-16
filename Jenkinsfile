pipeline {
    agent any

    tools{
        maven 'maven_3.8.4'
    }
    stages {
        stage('拉取代码') {
            steps {
                git credentialsId: '93f024b8-6456-4c98-a131-9a5ee9f42027', url: 'https://gitee.com/i-dont-recognize-you/school-page.git'
                echo '拉取成功'
            }
        }
        
        stage('执行构建') {
            steps {
            //    sh "mvn --version"
                sh "mvn clean package"
                echo '构建完成'
            }
        }
        
        stage('把jar包构建为docker镜像并运行') {
            steps {
                sh '''#!/bin/bash
                        # 服务名称
                        SERVER_NAME=test2
                        
                        # 源jar名称，mvn打包之后，target目录下的jar包名称
                        JAR_NAME= "School-0.0.1-SNAPSHOT"
                        
                        # jenkins下的目录
                        JENKINS_HOME= "/var/jenkins_home/workspace/test2"
                        
                        # 等待三秒
                        echo sleep 3s
                        sleep 1
                        echo sleep 2s
                        sleep 1
                        echo sleep 1s
                        sleep 1
                              
                        echo "结束进程完成"
                        
                        # JENKINS_HOME
                        cd /var/jenkins_home/workspace/test2/target
                        
                        # JENKINS_HOME
                        cp /var/jenkins_home/workspace/test2/Dockerfile /var/jenkins_home/workspace/test2/target
                        
                        # 修改文件权限  JAR_NAME
                        chmod 755 School-0.0.1-SNAPSHOT.jar
                        
                        echo "看看docker能不能用"
                        docker -v
                        
                        echo "停止容器"
                        # 停止容器
                        docker stop test2
                        
                        echo "删除容器"
                        # 删除容器
                        docker rm test2
                        echo "删除镜像"
                        # 删除镜像
                        docker rmi test2
                        echo "打包镜像"
                        # 打包镜像
                        docker build -t test2 -f Dockerfile .
                        echo "运行镜像"
                        # 运行镜像
                        docker run -d -p 9999:9600 --name test2 test2
                '''
                echo '运行成功'
            }
        }
    }
}
