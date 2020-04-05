**** Download & run the Bst maven project ***
=============================================

The Bst application is a basic Binary-Search Tree application.

This is the target application example which we want to create the Model-Based testing for.

Please perform the following steps:
-----------------------------------
Download the Bst project that is attached with this page

found at: /Users/oferr/workspace/GraphWalker_workshop_resources/GraphWalker-Bst.zip

extract it in your workspace

CD into the Bst directory:
$ cd Bst

Enable assertions:
$ export MAVEN_OPTS="-ea"

compile and execute the Bst application:
$ mvn clean compile exec:java -Dexec.mainClass="com.cyberark.Bst"
