# Command-Line Game Store Application

A Java-based command-line application simulating a game store where users can browse, purchase games, manage friends, and interact with game communities. Admins, developers, and sellers have dedicated menus for managing content and users.

## Features

### User Features
- **Sign Up/Login**: Users can create accounts and log in with validation for email, password, and phone number.
- **Store**: Browse games, view details, and purchase games using a wallet system with dynamic discounts based on playtime score.
- **Library**: Access purchased games, view communities, leave comments, and rate games.
- **Friends**: Send/accept friend requests, view friends' game libraries, and manage friend lists.
- **Profile**: Edit personal info (username, password, email, phone number) and charge their wallet.

### Admin Features
- **Games Management**: Add, delete, or edit games (name, genre, price, description).
- **Users Management**: View, search, add, or delete users; edit user details and wallets.
- **Admins Management** (Head Admin only): Add or remove admins.
- **Developers Management**: Add/remove developers and assign them to games.
- **Sellers Management**: Manage sellers and their accessories (controllers, monitors).

### Developer Features
- **Games Management**: Add, edit, or delete games they develop.
- **Game Details**: Edit game names, genres, prices, and descriptions.

### Seller Features
- **Accessories Management**: Add, delete, or edit controllers and monitors (e.g., price, quantity, specifications).

### Additional Features
- **Playtime Tracking**: Users earn scores based on playtime, unlocking discounts.
- **Rating & Comments**: Users can rate games and leave comments visible to others.
- **Data Persistence**: Uses serialization to save user, admin, game, developer, and seller data.

## Class Structure Overview

### Core Classes
- **Main**: Entry point; initializes data and displays the welcome menu.
- **User**: Represents a user with personal info, games, friends, and wallet.
- **Admin**: Manages system content (games, users, developers, sellers).
- **Developer**: Creates and manages games.
- **Seller**: Sells gaming accessories (controllers, monitors).
- **Game**: Stores game details (name, genre, price, ratings, comments).
- **DataBase**: Handles serialization for data persistence.

### Menu Classes
- **UserMenu***: Handles user interactions (store, library, friends, profile).
- **AdminMenu***: Manages admin operations (games, users, admins, etc.).
- **DeveloperMenu**: Allows developers to manage their games.
- **SellerMenu**: Lets sellers manage accessories.

## How to Run
1. Compile & Execute:  
   Ensure all `.java` files are in the same directory. Compile and run `Main.java`:
   ```bash
   javac Main.java
   java Main
2. Use Default Credentials:

Head Admin: Username ASO82, Password Abolfazl1383
