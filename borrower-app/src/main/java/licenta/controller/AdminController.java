package licenta.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import licenta.model.Admin;
import licenta.service.AdminService;

@RestController
@RequestMapping("/admin")
public class AdminController {
	
	@Autowired
	private AdminService adminService;
	
	/*---Add new admin---*/
	@PostMapping("")
	public ResponseEntity<?> save(@RequestBody Admin admin) {
		Admin resp = adminService.save(admin);
		return ResponseEntity.ok().body(resp);
	}
	/*---Get a admin by id---*/
	@GetMapping("/{id}")
	public ResponseEntity<Admin> get(@PathVariable("id") int id) {
		Admin admin = adminService.get(id);
		return ResponseEntity.ok().body(admin);
	}
	/*---get all admins---*/
	@GetMapping("")
	public ResponseEntity<List<Admin>> list() {
		List<Admin> admins = adminService.list();
		return ResponseEntity.ok().body(admins);
	}
	/*---Update a admin by id---*/
	@PutMapping("/{id}")
	public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody Admin admin) {
		adminService.update(id, admin);
		return ResponseEntity.ok().body("Admin has been updated successfully.");
	}

	/*---Delete a admin by id---*/
	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete(@PathVariable("id") int id) {
		adminService.delete(id);
		return ResponseEntity.ok().body("Admin has been deleted successfully.");
	}
}
