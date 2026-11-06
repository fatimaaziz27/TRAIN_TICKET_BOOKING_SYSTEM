# Train Ticket Booking System

A console-based Train Ticket Booking System built using Java. This project demonstrates all four major Object-Oriented Programming (OOP) concepts through train management and ticket booking operations.

## About

This project allows users to view available train schedules, book train tickets, cancel bookings, and view passenger booking details.

The system provides three predefined trains with different routes, departure times, ticket prices, and available seats.

Users can book multiple seats, and the system automatically calculates the total fare and updates seat availability.

## Features

- View available train schedules
- Book train tickets
- Cancel existing bookings
- View passenger bookings
- Book multiple seats
- Automatically calculate total ticket fare
- Update available seats after booking
- Release seats after cancellation
- Generate unique booking IDs
- Validate train IDs
- Check seat availability
- Handle invalid menu choices

## Technologies Used

- Java
- Java Collections Framework

## OOP Concepts Used

### 1. Encapsulation
Private attributes are used in the `Train` and `Booking` classes. Getters provide access to these attributes.

### 2. Inheritance
The `TrainBooking` class extends the abstract `Booking` class using the `extends` keyword.

### 3. Polymorphism
Method overriding is used in the `TrainBooking` class to provide implementations of `calculateTotalFare()` and `displayBooking()`.

### 4. Abstraction
The `Booking` class is declared as an abstract class and contains abstract methods.

## Other Java Concepts Practiced

- Classes and objects
- Constructors
- Getters
- `private` access modifier
- Abstract classes and methods
- `extends` keyword
- `super()` keyword
- `@Override` annotation
- `ArrayList`
- `HashMap`
- `Scanner`
- `switch` statements
- `while` loops
- Enhanced `for` loops
- Conditional statements
- Exception handling
- `Integer.parseInt()`
- `NumberFormatException`

## How It Works

### 1. View Train Schedules
Displays all available trains with their IDs, routes, departure times, ticket prices, and remaining seats.

### 2. Book Ticket
Allows the user to select a train, enter the passenger name, and choose the number of seats. The system checks seat availability, calculates the total fare, and generates a booking ID.

### 3. Cancel Booking
Allows the user to cancel an existing booking using its booking ID. The cancelled seats are added back to the train's available seats.

### 4. View My Bookings
Displays all current bookings, including booking ID, passenger name, train route, departure time, number of seats, and total fare.

## Available Trains

| Train ID | Route | Departure Time | Ticket Price |
|---|---|---|---|
| 1 | Karachi - Lahore | 09:00 AM | Rs. 3,000 |
| 2 | Karachi - Islamabad | 12:00 PM | Rs. 4,000 |
| 3 | Lahore - Multan | 05:00 PM | Rs. 1,500 |

Each train starts with 50 available seats.

## Menu Options

| Option | Function |
|---|---|
| 0 | Exit |
| 1 | View Train Schedules |
| 2 | Book Ticket |
| 3 | Cancel Booking |
| 4 | View My Bookings |

## Fare Calculation

Total Fare = Ticket Price × Number of Seats

**Example:**

- Ticket Price = Rs. 4,000
- Number of Seats = 3
- Total Fare = Rs. 12,000

## Data Structures Used

- **ArrayList:** Stores train objects.
- **HashMap:** Stores booking records using booking IDs as keys.

## How to Run

1. Download or clone this repository.
2. Open the project folder in your code editor.
3. Make sure Java JDK is installed.
4. Open the terminal in the project folder.
5. Compile the program:

   ```bash
   javac Main.java
   ```

6. Run the program:

   ```bash
   java Main
   ```

## Data Storage

Train schedules and booking records are stored in an `ArrayList` and a `HashMap`. All data is stored in memory and resets when the program restarts.

## Purpose

This project is designed to practice Java programming and all four major OOP concepts through a practical train ticket booking application.

## Future Improvements

- Add train search functionality
- Add passenger contact information
- Add different seat categories
- Add payment processing
- Save booking records using file handling
- Connect the system to a database
- Add a graphical user interface

## Author

Fatima Aziz

GitHub: [fatimaaziz27](https://github.com/fatimaaziz27)
