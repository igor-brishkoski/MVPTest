node {
   stage 'Checkout'
   checkout scm
   
   stage 'Build'
   echo "My branch is: ${env.BRANCH_NAME}"

    sh "./gradlew clean assembleDevDebug"
  
   stage 'Install'
   echo "Installing to device"

   $ANDROID_HOME/platform-tools/adb install app-dev-debug.apk
}
