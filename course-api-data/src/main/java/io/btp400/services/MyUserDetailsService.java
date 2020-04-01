//@author Palak Chawla
package io.btp400.services;

import java.util.ArrayList;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import io.btp400.coursemanagement.person.Person;

@Service
public class MyUserDetailsService implements UserDetailsService{

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		//Person person;
		//new User(person.getName(),person.getPassword(),new ArrayList<>()
		return new User("admin","123",new ArrayList<>());
	}

}
