package com.hanselnpetal.service;

import static org.junit.Assert.assertEquals;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;

import com.hanselnpetal.data.repos.CustomerContactRepository;
import com.hanselnpetal.domain.CustomerContact;

// instruct JUnit that we will be using the Mockito framework
@RunWith(MockitoJUnitRunner.class)
// this is a spring boot application, bootstrap all of the required components, ignore web ones
@SpringBootTest(webEnvironment = WebEnvironment.NONE)
public class ContactsManagementServiceUnitTest {

	@Mock
	private CustomerContactRepository customerContactRepository;

	@InjectMocks
	private ContactsManagementService contactsManagementService;

	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void testAddContactHappyPath() {

		// Create a contact
		CustomerContact aMockContact = new CustomerContact();
		aMockContact.setFirstName("Jenny");
		aMockContact.setLastName("Johnson");

		when(customerContactRepository.save(any(CustomerContact.class))).thenReturn(aMockContact);

		// Test adding the contact
		CustomerContact newContact = contactsManagementService.add(null);

		// Verify the addition
		assertEquals("Jenny", newContact.getFirstName());

	}

}
