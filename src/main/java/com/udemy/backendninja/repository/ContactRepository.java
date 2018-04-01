package com.udemy.backendninja.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.udemy.backendninja.entity.Contact;

// TODO: Auto-generated Javadoc
/**
 * The Interface ContactRepository.
 */
@Repository("contactRepository")
public interface ContactRepository extends JpaRepository<Contact, Serializable> {

	/**
	 * Find by id.
	 *
	 * @param id the id
	 * @return the contact
	 */
	public abstract Contact findById(int id);
}
