# :movie_camera:movie-reservation-webapp
Movie booking web application built using <img src="https://img.shields.io/badge/JPA(Java%20Persistence%20API)-white?logo=spring">, <img src="https://img.shields.io/badge/Spring%20Framework-white?logo=spring">, and <img src="https://img.shields.io/badge/MySQL-white?logo=mysql"> <br/>
This project was built under alternative username `ldc-bootcamp01` during the En-core Playdata bootcamp.

## Overview
This Movie booking web application is a website that assists in movie reservations. You can:
- Make reservations searching by date and time
- Do not need to purchase ticket on-site and reserve online with seat availability information

## Domain Definitions
- `Movie` : Basic movie information
  - id : Movie ID
  - name : Movie name
  - price : Movie price

- `Auditorium` : Screening room (Cinema 1, Cinema 2, ...) Holds information about screening rooms and movies
  - id : Auditorium ID
  - `Movie` : Movie screened in current auditorium
  - maxSeatCount : Maximum number of seats

- `Seat` : Seat (Seat A1, A2, B1, ...) Holds information about seats, auditoriums, and movies
  - id : Seat ID
  - name : Seat name
  - `Auditorium` : Auditorium where the seat is located

- `User` : Basic user information
  - id : User ID
  - password : User password

- `Ticket` : Reservation ticket, seat, auditorium, movie, and user information
  - id : Ticket ID value (since there is one ticket per seat, it is the same as the seat ID)
  - timeStamp : Ticket issuance time and date
  - `Seat` : Seat information for the ticket
  - `User` : User information for the ticket

## Requirements

To add initial DB data, copy the SQL statements from the src/main/webapp/sql/table.sql file and paste them into MySQL 8.0 Command Line Client and execute the SQL statements.

![MySQL 8.0 Command Line Client Screenshot](/images/movie-sql1.png "MySQL Screenshot")

## Entity Relationship Diagram
![ER Diagram for movie reservation project](/images/movie-erd1.png "ER Diagram")
