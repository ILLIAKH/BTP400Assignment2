//@author Palak Chawla
package io.btp400.coursemanagement.person;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonService {
 
	@Autowired
	private PersonRepository userRepository;
	
	//GET ALL
	public List<Person> getAllpeople()
	{
		List<Person>users = new ArrayList<>();
		userRepository.findAll().forEach(users::add);
		return users;
	}
	//GET ONE
	public Person getPerson(String id)
	{
		return userRepository.findById(id).get();
	}
	
	//CREATE NEW
	public void addPerson(Person user)
	{
		userRepository.save(user);
	}
	
	//UPDATE
	public void updatePerson(Person user)
	{
		userRepository.save(user);
	}
	
	//DELETE
	public void deletePerson(String id)
	{
		userRepository.deleteById(id);
	}
	
	//DELETE ALL
	public void deleteAll()
	{
		userRepository.deleteAll();
	}
	
}
