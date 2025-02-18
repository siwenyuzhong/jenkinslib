package org.devops

//ansible
//def AnsibleDeploy(hosts,func){
//    sh "ansible ${func} ${hosts}"
//}

def AnsibleDeploy(func){
    sh "ansible ${func}"
}
