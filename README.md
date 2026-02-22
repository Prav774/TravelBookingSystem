Travel Booking Management System

Overview

The Travel Booking Management System is a Java-based web application developed using Servlets, JSP, JDBC, and Oracle Database. The application implements full CRUD functionality for managing travel bookings and follows the Model–View–Controller (MVC) architectural pattern.

This project demonstrates structured web application development using a layered architecture and database integration through JDBC.

Architecture

The system is built using the MVC design pattern:

Model
Represents the data structure through the Booking entity class.

View
JSP pages responsible for rendering user interfaces and displaying booking data.

Controller
Servlet classes that handle HTTP requests, process input, and coordinate between the view and the data layer.

DAO Layer
Implements database interaction logic using JDBC and isolates persistence operations from business logic.

Features

• Add new booking
• View all bookings
• Update existing booking
• Delete booking
• Oracle database integration
• Layered MVC architecture
• Clean and structured codebase

Technologies Used

Java (JDK 25)
JSP
Servlet API (javax.servlet)
JDBC
Oracle Database (XEPDB1)
Apache Tomcat 9
HTML5
CSS3

Project Structure

src/main/java/com/travel/model
Contains the Booking entity class.

src/main/java/com/travel/dao
Contains BookingDAO interface and BookingDAOImpl implementation.

src/main/java/com/travel/servlet
Contains all controller servlets for handling HTTP requests.

src/main/java/com/travel/util
Contains DBConnection utility class for database connectivity.

src/main/webapp
Contains JSP pages and CSS files.

src/main/webapp/WEB-INF
Contains web.xml configuration file and external libraries.

Database Schema

CREATE TABLE bookings (
bookingid NUMBER GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
customername VARCHAR2(100) NOT NULL,
destination VARCHAR2(100) NOT NULL,
traveldate DATE NOT NULL,
packageprice NUMBER(10,2) NOT NULL
);

Setup Instructions

Install Oracle Database and ensure XEPDB1 is running.

Create the bookings table using the schema provided above.

Place ojdbc17.jar inside src/main/webapp/WEB-INF/lib.

Configure Apache Tomcat 9 in Eclipse.

Deploy the project to Tomcat.

Access the application at:

http://localhost:8080/TravelBooking/

Learning Outcomes

• Implementation of MVC architecture in Java web applications
• Usage of DAO pattern for database abstraction
• JDBC integration with Oracle database
• Handling HTTP GET and POST requests
• Form processing and request forwarding in Servlets
• Layered application design and separation of concerns

Author

Developed as part of academic coursework in Java Web Application Development.
