# Contacts Console Application

## Overview

The Contacts Console Application allows users to manage a list of contacts through a command-line interface. Users can
display, add, remove, and save contacts to a file.

## How to Run

1. **Compile the Project**: Ensure all dependencies are resolved and the project is compiled.
2. **Run the Application**: Execute the application using your preferred method (e.g., IDE, command line).
3. **Use Profiles**:
    - Use the `init` profile to load default contacts from `contacts.txt`.

## Features

- **Display Contacts**: View all contacts currently stored in the application.
- **Add Contact**: Add a new contact by providing a full name, phone number, and email.
- **Remove Contact**: Remove an existing contact by specifying their email.
- **Save Contacts**: Save the current list of contacts to a file for persistence.

## Configuration

- **Default Contacts File Path**: The path to the default contacts file is specified in `application.properties`. Ensure
  this file is correctly configured to point to your desired contacts file.

## Usage

- **Profiles**:
    - `init`: Loads contacts from the specified file path.
    - `default`: Starts the application without loading any contacts.

## Additional Information

- Ensure that the `contacts.txt` file is formatted correctly, with each contact on a new line in the format:
  `Full name;phone number;email`.
- The application requires Java and Spring Boot to be installed and configured on your system.

## Troubleshooting

- If you encounter issues with loading contacts, verify that the file path in `application.properties` is correct and
  accessible.
- For input errors, ensure that the contact details are entered in the correct format.

## Contact

For further assistance, please contact the development team or refer to the project's documentation.