#! /bin/bash

# move execute script on /bin directory
sudo cp fennec /bin/

# build jar and copy to /bin directory
./gradlew jar
sudo cp ./build/libs/fennec-git-1.0-SNAPSHOT.jar /bin/fennec.jar

# give permissions
sudo chmod 777 /bin/fennec
sudo chmod 666 /bin/fennec.jar