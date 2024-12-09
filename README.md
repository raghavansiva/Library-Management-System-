# Library Management System in Java

## Overview
This is a simple Library Management System developed in Java, which allows users to log in, view their details, borrow and return books. The system includes the ability to track available books and manage borrowed books with a limit of 3 books per user.

## Features
1. **Login and Registration**: Users must log in to access the system. The login requires basic details like name, roll number, and department.
2. **View Student Details**: After logging in, users can view their details.
3. **Borrow Books**: Users can borrow books from the available list. They can borrow up to 3 books at a time.
4. **Return Books**: Users can return borrowed books.
5. **Book Availability Check**: The system displays the list of available books and allows the user to borrow a book if it is available.
6. **Limit on Borrowed Books**: Users can borrow a maximum of 3 books. If they reach the limit, they must return a book to borrow more.

## How to Use

### Step 1: Login
- When you run the program, it will ask you to log in.
- Enter your name, roll number, and department.

### Step 2: Main Menu
Once logged in, you will be presented with the following options:
1. **View Details**: View your registered information (Name, Roll Number, Department).
2. **Borrow Book**: Browse the available books and borrow one if it's available.
3. **Return Book**: Return any borrowed books.
4. **Logout**: Log out of the system.

### Step 3: Borrowing a Book
- Choose the **Borrow Book** option to view available books.
- Enter the book ID to borrow it. You can borrow up to 3 books at a time.
- If all the books are already borrowed, you can either choose to wait or exit.

### Step 4: Returning a Book
- Choose the **Return Book** option to return any borrowed books.
- After returning a book, you can borrow another one, or exit.

## Code Structure
The project is divided into 3 main classes:

1. **`Main` Class**: The entry point of the program, where the main menu and user interaction happen.
2. **`register` Class**: Handles user login, displaying student details, and logging out.
3. **`borrow` Class**: Manages the borrowing and returning of books using two hash maps (`hM` for available books and `hM2` for borrowed books).

### Example:

```java
register r = new register();
borrow b = new borrow();
b.addBook("1001", "Design of Computer Networks");
b.addBook("1002", "Object Oriented Analysis and Design");
// Continue adding books...
