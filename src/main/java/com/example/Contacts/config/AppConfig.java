package com.example.Contacts.config;

import com.example.Contacts.services.ContactManager;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
public class AppConfig {
  @Value("${default.contacts.file.path}")
  private String filePath;

  @Bean
  @Profile("init")
  public ContactManager contactManagerWithInit() {
    ContactManager contactManager = new ContactManager();
    contactManager.loadContactsFromFile(filePath);
    return contactManager;
  }

  @Bean
  @Profile("default")
  public ContactManager contactManager() {
    return new ContactManager();
  }
}
