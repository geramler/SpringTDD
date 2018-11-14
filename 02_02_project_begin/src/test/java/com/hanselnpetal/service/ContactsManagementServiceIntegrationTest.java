package com.hanselnpetal.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.context.junit4.SpringRunner;

import com.hanselnpetal.domain.CustomerContact;

// instruct JUnit that we are testing a Spring application
@RunWith(SpringRunner.class)
// this is a spring boot application, bootstrap all of the required components, ignore web ones
@SpringBootTest(webEnvironment = WebEnvironment.NONE)
public class ContactsManagementServiceIntegrationTest {

	@Autowired
	private ContactsManagementService contactsManagementService;

	@Test
	public void testAddContactHappyPath() {

		// Create a contact
		CustomerContact aContact = new CustomerContact();
		aContact.setFirstName("Jenny");
		aContact.setLastName("Johnson");

		// Test adding the contact
		CustomerContact newContact = contactsManagementService.add(aContact);

		// Verify the addition
		assertNotNull(newContact);
		assertNotNull(newContact.getId());
		assertEquals("Jenny", newContact.getFirstName());

	}
}
