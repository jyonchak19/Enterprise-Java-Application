# Enterprise-Java-Application
This project creates a set of XHTML web pages that the user can visit in order to see a list of all movie theaters, see a list of movies, 
and to purchase a ticket to a showing of a movie. Cascading Style Sheets (CSS) were used to create a general format for each web page.
All of the movies, theaters, and showings are stored within a database. The included SQL script creates a sample database for use in this application. 
After a user purchases a ticket, all of the information regarding the ticket is persisted to the database and stored within it. 
Enterprise Java Beans, JSF CDI beans, and a set of Java entity classes are used to communicate with and process information from both the database and the web pages.
When the application first starts, the user will see a home page with option to see all movies, see all theaters, and search for a theater by zip code.
The show all theaters and show all movies buttons simply direct the user to a web page which shows information about all of the theaters and all of the movies in the database.
In order to purchase a ticket, the user must first search for a theater by entering a zip code. If the user enters an invalid zip, a message will be displayed.
After entering a valid zip, a list of theaters within the entered zip will be shown, and the user may choose one to view a list of movie showings at that theater.
The user may then select a showing that they would like purchase a ticket to, and will then be directed to enter the number of seats they would like to purchase.
Next, the user will be prompted to enter their first and last name, as well as their credit card number. If the credit card number entered is invalid, a message will be displayed.
After entering the aforementioned information and cliking the confirm ticket button, a confirmation of purchase will be displayed and the user will be prompted to return to the home page.
