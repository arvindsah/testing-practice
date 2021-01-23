# testing-practice

To clone the project into your local -
--> git clone https://github.com/arvindsah/testing-practice.git
--> cd testing-practive
--> mvn clean install // this should then all the script which are mentioned as part of the of the textng.xml file

1. To run this project you need to below items 
		1. Maven 3.3.6+
		2. Java 8+

2. To run any of the test script the below command in the directry of the project
	-> "mvn clean install -Dbrowser=chrome -Denv=qa"
	
	
if you want to run the suite for any other than default testng.xml then create your own .xml file and 
give the relative path under pom.xml file 
 	-> "<suiteXmlFiles><suiteXmlFile>./testng.xml</suiteXmlFile>"

3. Tests are running in parallel if you do not want them to then update the textng.xml file acccordingly 	
 
 As of the test below scenarios are tested and same test are availabel under com.company.tests.HomePageTest.java - 
 1. checkUserAbleToSearchFlights
 2. checkFlightConfirmationMessage
 3. checkBookingConfirmationAmountEqualToTotalAmount
 
4. Test scripts which are marked as to do 
	1. CheckSelectedFlightDetailsMatch
	2. checkTotalCostOfFlight
	3. checkUserAbleToEnterAllValues
	4. checkUserAbleToSelectRememberMeOption 
 
 
 
 
***********************************************************************

# Regarding the api assingment
one folder is created "postan space x api" which contains the collection and environment json file
please import the json files (collection and environment) to run the api which consist the text. 
 
						
						
