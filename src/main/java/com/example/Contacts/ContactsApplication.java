package com.example.Contacts;

import com.example.Contacts.services.ContactManager;
import java.util.InputMismatchException;
import java.util.Scanner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class ContactsApplication {
  @Autowired private ContactManager contactManager;

  public static void main(String[] args) {
    ApplicationContext context = SpringApplication.run(ContactsApplication.class, args);
    ContactsApplication app = context.getBean(ContactsApplication.class);
    app.run();
  }

  public void run() {
    try (Scanner scanner = new Scanner(System.in)) {
      boolean running = true;
      while (running) {
        displayMenu();
        int choice = getUserChoice(scanner);
        running = handleUserChoice(choice, scanner);
      }
    }
  }

  private void displayMenu() {
    System.out.println("1. Display Contacts");
    System.out.println("2. Add Contact");
    System.out.println("3. Remove Contact by Email");
    System.out.println("4. Save Contacts to File");
    System.out.println("5. Exit");
    System.out.print("Choose an option: ");
  }

  private int getUserChoice(Scanner scanner) {
    try {
      return scanner.nextInt();
    } catch (InputMismatchException e) {
      System.out.println("Invalid input. Please enter a number.");
      scanner.nextLine();
      return -1;
    }
  }

  private boolean handleUserChoice(int choice, Scanner scanner) {
    scanner.nextLine();
    switch (choice) {
      case 1:
        contactManager.displayContacts();
        break;
      case 2:
        addContact(scanner);
        break;
      case 3:
        removeContact(scanner);
        break;
      case 4:
        saveContacts();
        break;
      case 5:
        System.out.println("Exiting...");
        return false;
      default:
        System.out.println("Invalid choice.");
    }
    return true;
  }

  private void addContact(Scanner scanner) {
    System.out.print("Enter contact (Full name;phone number;email): ");
    String input = scanner.nextLine();
    String[] parts = input.trim().split(";");
    if (parts.length == 3) {
      contactManager.addContact(parts);
      System.out.println("Contact has been added.");
    } else {
      System.out.println("Invalid input format.");
    }
  }

  private void removeContact(Scanner scanner) {
    System.out.print("Enter email to remove: ");
    String email = scanner.nextLine();
    contactManager.removeContactByEmail(email);
    System.out.println("Contact has been deleted.");
  }

  private void saveContacts() {
    contactManager.saveContactToFile("src/main/resources/contacts.txt");
    System.out.println("Contacts have been saved.");
  }
}
