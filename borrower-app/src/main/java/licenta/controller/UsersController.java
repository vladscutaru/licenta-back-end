package licenta.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import licenta.model.Item;
import licenta.model.User;
import licenta.service.UsersService;
import licenta.utils.KeyValue;

@CrossOrigin("http://localhost:4200")
@RestController
public class UsersController {

	@Autowired
	private UsersService userService;

	/*---Add new user---*/
	@PostMapping("/user")
	public ResponseEntity<?> save(@RequestBody User user) {
		long id = userService.save(user);
		return ResponseEntity.ok().body( user );
	}
	
	@PostMapping("/login")
	public ResponseEntity<?> login(@RequestBody KeyValue kv) {
		long id = userService.login(kv);
		return ResponseEntity.ok().body( id );
	}
	
	@PostMapping("/getEmail")
	public ResponseEntity<?> getByEmail(@RequestBody String email) {
		User success = userService.getByEmail(email);
		return ResponseEntity.ok().body( success );
	}
	
	
	@PostMapping("/email")
	public ResponseEntity<?> existEmail(@RequestBody String email) {
		boolean exists = userService.existEmail(email);
		return ResponseEntity.ok().body( exists );
	}

	/*---Get a user by id---*/
	@GetMapping("/user/{id}")
	public ResponseEntity<User> get(@PathVariable("id") long id) {
		User user = userService.get(id);
		return ResponseEntity.ok().body(user);
	}

	/*---get all users---*/
	@GetMapping("/user")
	public ResponseEntity<List<User>> list() {
		List<User> users = userService.list();
		return ResponseEntity.ok().body(users);
	}

	/*---Update a user by id---*/
	@PutMapping("/user/{id}")
	public ResponseEntity<?> update(@PathVariable("id") long id, @RequestBody User user) {
		User updatedUser=userService.update(id, user);
		return ResponseEntity.ok().body(updatedUser); 
	}

	/*---Delete a user by id---*/
	@DeleteMapping("/user/{id}")
	public ResponseEntity<?> delete(@PathVariable("id") long id) {
		userService.delete(id);
		return ResponseEntity.ok().body("User has been deleted successfully.");
	}

	@GetMapping("/getItemsByUser/{id}")
	public ResponseEntity<List<Item>> getItemsByUser(@PathVariable("id") long id) {
		List<Item> items = userService.getItemsByUser(id);
		return ResponseEntity.ok().body(items);
	}
	
	@GetMapping("/getAllEmails")
	public ResponseEntity<List<String>> getAllEmails() {
		List<String> emails = userService.getAllEmails();
		return ResponseEntity.ok().body(emails);
	}
	
}