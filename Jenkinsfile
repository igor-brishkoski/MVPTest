node {
    stage('Checkout') {
        checkout scm
    }

    stage('Test') {

        echo "Starting tests"
        sh "./gradlew test"
    }

    stage('Start Avd'){
        echo "${HOME}"
        sh "${ANDROID_HOME}/tools/emulator -avd Nexus_5X_API_25"
    }

    stage('Build') {
        sh "./gradlew clean assembleDevDebug"
    }

    stage('Install') {
        echo pwd
        //this is the only way to get the branch name with jenkins pipelines
        //https://issues.jenkins-ci.org/browse/JENKINS-35230
        String gitCommit = sh(returnStdout: true, script: 'git rev-parse HEAD').trim()
        String branchName = sh(returnStdout: true, script: 'git rev-parse --abbrev-ref HEAD').trim()
        echo "This is with string ${gitCommit}"
        echo "This is with method ${branchName}"

        if (branchName == 'master'){
            echo "Building prod"
        }else if(branchName == 'develop'){
            echo "Building dev"
        }

        sh "${ANDROID_HOME}/platform-tools/adb install -r ${WORKSPACE}/app/build/outputs/apk/app-dev-debug.apk"
    }
}