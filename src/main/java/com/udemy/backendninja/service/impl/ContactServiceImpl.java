package com.udemy.backendninja.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.udemy.backendninja.component.ContactConverter;
import com.udemy.backendninja.entity.Contact;
import com.udemy.backendninja.model.ContactModel;
import com.udemy.backendninja.repository.ContactRepository;
import com.udemy.backendninja.service.ContactService;

// TODO: Auto-generated Javadoc
/**
 * The Class ContactServiceImpl.
 */
@Service("contactServiceImpl")
public class ContactServiceImpl implements ContactService{
	
	/** The contact repository. */
	@Autowired
	@Qualifier("contactRepository")
	private ContactRepository contactRepository;

	/** The contact converter. */
	@Autowired
	@Qualifier("contactConverter")
	private ContactConverter contactConverter;
	
	/* (non-Javadoc)
	 * @see com.udemy.backendninja.service.ContactService#addContact(com.udemy.backendninja.model.ContactModel)
	 */
	@Override
	public ContactModel addContact(ContactModel contactModel) {
		Contact contact = contactRepository.save(contactConverter.convertContactModel2Contact(contactModel));
		return contactConverter.convertContact2ContactModel(contact);
	}

	/* (non-Javadoc)
	 * @see com.udemy.backendninja.service.ContactService#listAllContacts()
	 */
	@Override
	public List<ContactModel> listAllContacts() {
		List<Contact> contacts = contactRepository.findAll();
		List<ContactModel> contactsModel = new ArrayList<ContactModel>();
		for(Contact contact : contacts) {
			contactsModel.add(contactConverter.convertContact2ContactModel(contact));
		}
		return contactsModel;
	}

	/* (non-Javadoc)
	 * @see com.udemy.backendninja.service.ContactService#findContactById(int)
	 */
	@Override
	public Contact findContactById(int id) {
		return contactRepository.findById(id);

	}

	/* (non-Javadoc)
	 * @see com.udemy.backendninja.service.ContactService#removeContact(int)
	 */
	@Override
	public void removeContact(int id) {
		Contact contact = findContactById(id);
		if(null != contact) {
			contactRepository.delete(contact);
		}
	}

	/* (non-Javadoc)
	 * @see com.udemy.backendninja.service.ContactService#findContactByIdModel(int)
	 */
	public ContactModel findContactByIdModel(int id) {
		return contactConverter.convertContact2ContactModel(findContactById(id));
	}

}
