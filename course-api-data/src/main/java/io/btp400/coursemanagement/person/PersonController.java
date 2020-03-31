package io.btp400.coursemanagement.person;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.btp400.coursemanagement.course.Course;
import io.btp400.models.AuthenticationRequest;
import io.btp400.models.AuthenticationResponse;
import io.btp400.services.MyUserDetailsService;
import io.btp400.util.JwtUtil;

@RestController
public class PersonController {
	
	@Autowired
	private PersonService personService;
	
	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private JwtUtil jwtTokenUtil;

	@Autowired
	private MyUserDetailsService userDetailsService;

	@RequestMapping({ "/hello" })
	public String firstPage() {
		return "<h1>Hello World</h1>";
	}

	@RequestMapping(value = "/authenticate", method = RequestMethod.POST)
	public ResponseEntity<?> createAuthenticationToken(@RequestBody AuthenticationRequest authenticationRequest) throws Exception {

		try {
			authenticationManager.authenticate(
					new UsernamePasswordAuthenticationToken(authenticationRequest.getUsername(), authenticationRequest.getPassword())
			);
		}
		catch (BadCredentialsException e) {
			throw new Exception("Incorrect username or password", e);
		}


		final UserDetails userDetails = userDetailsService
				.loadUserByUsername(authenticationRequest.getUsername());

		final String jwt = jwtTokenUtil.generateToken(userDetails);

		return ResponseEntity.ok(new AuthenticationResponse(jwt));
	}

	
	//GET ALL
	@RequestMapping("/users")
	public List<Person> getAllTopics()
	{
		return personService.getAllpeople();
	}	
	
	//GET ONE
	@RequestMapping("/users/{id}")
	public Person getOneTopic(@PathVariable String id)
	{
		return personService.getPerson(id);
	}
	
	//CREATE NEW
	@RequestMapping(method = RequestMethod.POST, value = "/users/{courseId}/{topicId}")
	public void addCourse(@PathVariable String topicId, @PathVariable String courseId, @RequestBody Person person)
	{
		person.setCourse(new Course(courseId, "", "", topicId));
		personService.addPerson(person);
	}
	
	//UPDATE
	@RequestMapping(method = RequestMethod.PUT, value = "/users/{courseId}/{topicId}/update")
	public void updateCourse(@RequestBody Person person, @PathVariable String topicId, @PathVariable String courseId)
	{
		person.setCourse(new Course(courseId, "", "", topicId));
		personService.updatePerson(person);
	}
	
	//DELETE
	@RequestMapping(method = RequestMethod.DELETE, value = "/users/{id}")
	public void deleteTopic(@PathVariable String id)
	{
		personService.deletePerson(id);
	}
	
}
