package com.example.Contacts.services;

import com.example.Contacts.dto.Contact;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class ContactManager {
  private List<Contact> contacts = new ArrayList<>();

  public void addContact(String[] parts) {
    contacts.add(new Contact(parts[0], parts[1], parts[2]));
  }

  public void removeContactByEmail(String email) {
    contacts.removeIf(contact -> Objects.equals(contact.getEmail(), email));
  }

  public void displayContacts() {
    if (contacts.isEmpty()) System.out.println("No contacts");
    contacts.forEach(System.out::println);
  }

  public void loadContactsFromFile(String path) {
    try (BufferedReader reader = new BufferedReader(new FileReader(path))) {
      String line;
      while (Objects.nonNull(line = reader.readLine())) {
        String[] parts = line.trim().split(";");
        if (parts.length == 3) addContact(parts);
      }
    } catch (IOException e) {
      System.out.println("Error loading contacts from file: " + e.getMessage());
    }
  }

  public void saveContactToFile(String path) {
    try (BufferedWriter writer = new BufferedWriter(new FileWriter(path))) {
      for (Contact contact : contacts) {
        writer.write(
            String.join(";", contact.getFullName(), contact.getPhoneNumber(), contact.getEmail()));
        writer.newLine();
      }
    } catch (IOException e) {
      System.out.println("Error saving contacts to file: " + e.getMessage());
    }
  }
}
