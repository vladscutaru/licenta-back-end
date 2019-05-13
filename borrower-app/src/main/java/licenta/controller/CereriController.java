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

import licenta.model.Cereri;
import licenta.service.CereriService;

@RestController
@RequestMapping("/cereri")

public class CereriController {
	
	@Autowired
	private CereriService cereriService;
	
	/*---Add new cerere---*/
	@PostMapping("")
	public ResponseEntity<?> save(@RequestBody Cereri cereri) {
		Cereri resp = cereriService.save(cereri);
		return ResponseEntity.ok().body(resp);
	}
	/*---Get a cerere by id---*/
	@GetMapping("/{id}")
	public ResponseEntity<Cereri> get(@PathVariable("id") int id) {
		Cereri cereri = cereriService.get(id);
		return ResponseEntity.ok().body(cereri);
	}
	/*---get all cereri---*/
	@GetMapping("")
	public ResponseEntity<List<Cereri>> list() {
		List<Cereri> cereri = cereriService.list();
		return ResponseEntity.ok().body(cereri);
	}
	/*---Update a cerere by id---*/
	@PutMapping("/{id}")
	public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody Cereri cereri) {
		cereriService.update(id, cereri);
		return ResponseEntity.ok().body("Cereri has been updated successfully.");
	}

	/*---Delete a cerere by id---*/
	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete(@PathVariable("id") int id) {
		cereriService.delete(id);
		return ResponseEntity.ok().body("Cereri has been deleted successfully.");
	}

}
