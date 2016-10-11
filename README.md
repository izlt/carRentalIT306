## Project’s purpose and business requirements
 *  This project is for users to track information of employees, vehicles, and the employees’ customers. The program is required to have at least one administrative employee. The user, as either a regular or administrative employee, should select a type of vehicle classes for an individual vehicle. All input should be validated and create an error message if any invalid input is entered. All data are stored in text files and when an administrative employee tries to read any output, the program should be able to use the text file to retrieve the data.


## Project scope (including intended user population and product functionality)
 * Intended users are be for a manager of the car rental company. The manager, as an administrative employee, is be able to manage his or her employees while the administrative employee collects information about cars and customers for renting the vehicles. Functionality of this program differs in a role of either an administrative or regular employee. A regular employee has two options while an administrative user has more than 5 options of retrieving data.
  
## Discussion of project limitations or requirements defects
 * The limitation occurs when the user is not required to enter strong passwords with upper and lower cases and more complexities. This program has potential 
## Narrative of what users will be able to do with the product and a description of how the application will execute
 * A user enters a username and password for authentication. After authentication process, the program welcomes a user with a title, either an administrative or regular employee. 
 * Log-in information converted and stored in a text file can be later used to verify existing accounts.
  * How the program is run differs in two different roles.
     ** Users signed into an administrative employee account have privileges of not only entering information about vehicles, customers, and employees, but also observing reports of all input and calculation of total sales.
    ** Users signed into a regular employee has only two options, renting and returning vehicles and information of renters (customers).  
 * For adding a rented car software is ready for users to enter details of the vehicles.
 * The software stores various objects of different attributes about the vehicles.
 * The software alarms whether the users enter unexpected values and still continues to run after every error occurs.
 * When user wants to exit the program the program prompts users to exit the program.
 * After collecting regular employees’ details about vehicle and customers, the administrative employee collects their data and make them into a report.
## Usability
The application should have simple interface with ease in usability.  The instructions and menu must be clear to follow, so the employee of rental company can use without choosing wrong item.  For example, when user choose wrong choice, either null pointer exception or illigalArgument exception to provide retry. Also, the input type and format will be indicated as well as exception handling for retry. 
 * At the end of each chosen inputs, the temporary pop-up will ask to user for confirmation. If not, the user will be provided another set of input to ensure the quality and decrease the error rate. Finally, as a admin side, every input data will be organized and summarized in text file. 
 * Only an administrative employee should be able to handle the exclusive special menus such as reports of sales, employees, and customers. This program should not illegally or accidentally modify a user’s privilege to either an administrative or regular employee. To prevent such an incident, each employee has a private Boolean value of whether he or she is a regular or administrative employee.
