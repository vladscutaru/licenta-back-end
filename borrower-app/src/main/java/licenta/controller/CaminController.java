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

import licenta.model.Camin;
import licenta.service.CaminService;

@RestController
@RequestMapping("/camin")

public class CaminController {
	
	@Autowired
	private CaminService caminService;
	
	/*---Add new camin---*/
	@PostMapping("")
	public ResponseEntity<?> save(@RequestBody Camin camin) {
		Camin resp = caminService.save(camin);
		return ResponseEntity.ok().body(resp);
	}
	/*---Get a camin by id---*/
	@GetMapping("/{id}")
	public ResponseEntity<Camin> get(@PathVariable("id") int id) {
		Camin camin = caminService.get(id);
		return ResponseEntity.ok().body(camin);
	}
	/*---get all camine---*/
	@GetMapping("")
	public ResponseEntity<List<Camin>> list() {
		List<Camin> camins = caminService.list();
		return ResponseEntity.ok().body(camins);
	}
	/*---Update a camin by id---*/
	@PutMapping("/{id}")
	public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody Camin camin) {
		caminService.update(id, camin);
		return ResponseEntity.ok().body("Camin has been updated successfully.");
	}

	/*---Delete a camin by id---*/
	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete(@PathVariable("id") int id) {
		caminService.delete(id);
		return ResponseEntity.ok().body("Camin has been deleted successfully.");
	}

}
