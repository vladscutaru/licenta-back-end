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

import licenta.model.Utilizator;
import licenta.service.UtilizatorService;

@RestController
@RequestMapping("/utilizator")

public class UtilizatorController {
	
	@Autowired
	private UtilizatorService utilizatorService;
	
	/*---Add new utilizator---*/
	@PostMapping("")
	public ResponseEntity<?> save(@RequestBody Utilizator utilizator) {
		Utilizator resp = utilizatorService.save(utilizator);
		return ResponseEntity.ok().body(resp);
	}
	/*---Get a utilizator by id---*/
	@GetMapping("/{id}")
	public ResponseEntity<Utilizator> get(@PathVariable("id") int id) {
		Utilizator utilizator = utilizatorService.get(id);
		return ResponseEntity.ok().body(utilizator);
	}
	/*---get all utilizators---*/
	@GetMapping("")
	public ResponseEntity<List<Utilizator>> list() {
		List<Utilizator> utilizators = utilizatorService.list();
		return ResponseEntity.ok().body(utilizators);
	}
	/*---Update a utilizator by id---*/
	@PutMapping("/{id}")
	public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody Utilizator utilizator) {
		utilizatorService.update(id, utilizator);
		return ResponseEntity.ok().body("Utilizator has been updated successfully.");
	}

	/*---Delete a utilizator by id---*/
	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete(@PathVariable("id") int id) {
		utilizatorService.delete(id);
		return ResponseEntity.ok().body("Utilizator has been deleted successfully.");
	}

}
