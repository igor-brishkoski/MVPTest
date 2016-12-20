node {
   stage 'Checkout'
   checkout scm
   
   stage 'Build'
   echo "My branch is: ${env.BRANCH_NAME}"

    sh "./gradlew clean assembleDevDebug"
  
   stage 'Install'
   echo pwd

   sh "${ANDROID_HOME}/platform-tools/adb install ${pwd}/workspace/MVPTest/app/build/outputs/apk/app-dev-debug.apk"
}
