*************************************************
***             setup Mac env              ***
*************************************************

JAVA
----

# You should have JDK 1.8 installed
# run the following command to see what Java versions you have
$ /usr/libexec/java_home -V

To install JDK 1.8 go either to Oracle:
https://www.oracle.com/java/technologies/javase/javase-jdk8-downloads.html

or to AdoptOpenJDK at: https://adoptopenjdk.net/

I am using the AdoptOpenJDK one.
I insalled it with Homebrew:
$ brew cask install adoptopenjdk8


When I run:
$ /usr/libexec/java_home -V
I get:
Matching Java Virtual Machines (2):
    13.0.2, x86_64:	"Java SE 13.0.2"	/Library/Java/JavaVirtualMachines/jdk-13.0.2.jdk/Contents/Home
    1.8.0_242, x86_64:	"AdoptOpenJDK 8"	/Library/Java/JavaVirtualMachines/adoptopenjdk-8.jdk/Contents/Home

Java is very sensitive to the version you use and therefore 
you have to either make your default jre and jdk to be 1.8 or 
you must remember to run the following command on evert shell/terminal that you work with, with this project:

$ export JAVA_HOME=`/usr/libexec/java_home -v 1.8`

to make java 1.8 as your system default you have to add the above export line to your .bash_profile file.

$ java -version
openjdk version "1.8.0_242"
OpenJDK Runtime Environment (AdoptOpenJDK)(build 1.8.0_242-b08)
OpenJDK 64-Bit Server VM (AdoptOpenJDK)(build 25.242-b08, mixed mode)


Maven
-----

You have to have Maven istalled on your Mac

I installed Maven using brew
$ brew install maven

when I run:
$ mvn -version
I get:
Apache Maven 3.6.3
Maven home: /usr/local/Cellar/maven/3.6.3
...

after install, when you run it for the first time it will take longer since at first run maven downloads the required dependencies


*************************************************
***             setup CentOS env              ***
*************************************************

yum -y update
reboot


java on CentOS7
===============

MUST RUN WITH JDK 1.8!!!

# list all the installed java versions
$ /usr/libexec/java_home -V

setup java:
-----------
$ yum search java | grep openjdk

$ yum install java-1.8.0-openjdk-headless.x86_64

$ yum install java-1.8.0-openjdk-devel.x86_64

# run and choose #1:
$ update-alternatives --config java #pick java 1.8

# run and choose #1:
$ update-alternatives --config javac #pick java 1.8

or switch to java 1.8 temporarily (no need if you did the above):
$ export JAVA_HOME=`/usr/libexec/java_home -v 1.8`


setup maven on CentOS7
======================

$ cd Downloads
$ wget https://www-us.apache.org/dist/maven/maven-3/3.6.3/binaries/apache-maven-3.6.3-bin.tar.gz
$ sudo tar xf apache-maven-3.6.3-bin.tar.gz -C /opt
$ sudo ln -s /opt/apache-maven-3.6.3 /opt/maven

$ sudo nano /etc/profile.d/maven.sh
    export M2_HOME=/opt/maven
    export MAVEN_HOME=/opt/maven
    export PATH=${M2_HOME}/bin:${PATH}

$ sudo chmod +x /etc/profile.d/maven.sh

$ source /etc/profile.d/maven.sh

$ mvn -version
Apache Maven 3.6.3
...

******************************************
***                yEd                 ***
******************************************

Download and install yEd at:
https://www.yworks.com/products/yed
******************************************
***                jq                  ***
****************************************** 

jq is a java json parser utility

LINUX:
------
# To setup a java json parser utility from: https://stedolan.github.io/jq/
Install jq on CentOS
$ cd /..../Bst_1graphml/lib
$ wget https://github.com/stedolan/jq/releases/download/jq-1.6/jq-linux64
$ chmod +x jq-linux64
Mac:
----
Install jq on Mac
$ brew install jq


******************************************
***          required utilities        ***
******************************************
wget on Mac:
------------
Install wget
$ brew install wget

******************************************
***            graphwalker             ***
******************************************
I recommend on creating a lib directory at your workspace level or project level to add the graphwalker jars
In my case the workspace is at: /Users/oferr/workspace
Download the GraphWalker jar files
$ pwd
 
/Users/oferr/workspace
 
$ mkdir lib
 
$ cd lib/
 
$ wget https://github.com/GraphWalker/graphwalker-project/releases/download/4.2.0/graphwalker-studio-4.2.0.jar
 
$ wget https://github.com/GraphWalker/graphwalker-project/releases/download/4.2.0/graphwalker-cli-4.2.0.jar




***                                             ***
***                 Done env setup              ***
***                                             ***
***************************************************

