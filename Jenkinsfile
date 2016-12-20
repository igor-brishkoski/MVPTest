node {
    stage('Checkout') {
        checkout scm
    }

    stage('Test') {

        echo "Starting tests"
        sh "./gradlew test"
    }

    stage('Build') {
        sh "./gradlew clean assembleDevDebug"
    }

    stage('Install') {
        echo pwd

        sh "${ANDROID_HOME}/platform-tools/adb install -r ${pwd}/workspace/MVPTest/app/build/outputs/apk/app-dev-debug.apk"
    }
}
