Movie Database Project - Setup Guide
Requirements
Before you begin, ensure you have the following:

OpenJDK 23.0.1 (Pretty sure IntelliJ installed for me)
File --> Project Structure --> SDKs --> make sure JDK home path goes to openjdk-23.0.1

Apache Tomcat: Version 10.1.33 (You can use the video SP sent on discord for this)
Download the Smart Tomcat plugin, 
File --> Settings --> Plugins --> search 'smart tomcat' and install
On the setting screen, Tomcat Server should appear as an option, make sure location points to Tomcat root file, wherever you installed it.
Above the code somewhere should be an option for 'edit configurations...'. 
The path for Catalina base should look something like 'apache-tomcat-10.1.33\conf\Catalina'
The option 'Use classpath of module' should be set to 'MovieDatabase'
My Server port is set to '8080' and admin port '8005'    (not sure if this matters if we differ)

Maven: Version 3.9.9
Not sure how important it is to have this exact version

IntelliJ IDEA: Version 2024.3
Not sure how important it is to have this exact version