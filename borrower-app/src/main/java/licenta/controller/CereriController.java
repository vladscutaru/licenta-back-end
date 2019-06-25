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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import licenta.model.Cerere;
import licenta.service.CereriService;

@CrossOrigin("http://localhost:4200")
@RestController
@RequestMapping("/cerere")
public class CereriController {
	
	@Autowired
	private CereriService cereriService;
	
	/*---Adaugă o nouă cerere---*/
	@PostMapping("")
	public ResponseEntity<?> save(@RequestBody Cerere cerere) {
		Cerere resp = cereriService.save(cerere);
		return ResponseEntity.ok().body(resp);
	}
	/*---Obține o cerere după id-ul ei---*/
	@GetMapping("/{id}")
	public ResponseEntity<Cerere> get(@PathVariable("id") int id) {
		Cerere admin = cereriService.get(id);
		return ResponseEntity.ok().body(admin);
	}
	
	/*---Obține o cerere în funcție de idStudent---*/
	@GetMapping("/getByIdStudent/{id}")
	public ResponseEntity<List<Cerere>> getByIdStudent(@PathVariable("id") int id) {
		List<Cerere> cereri = cereriService.getByIdStudent(id);
		return ResponseEntity.ok().body(cereri);
	}
	
	/*---Obține toate cererile---*/
	@GetMapping("")
	public ResponseEntity<List<Cerere>> list() {
		List<Cerere> cereri = cereriService.list();
		return ResponseEntity.ok().body(cereri);
	}
	
	/*---Obține o cerere în funcție de status---*/
	@GetMapping("/getByIdCamin/{id}")
	public ResponseEntity<List<Cerere>> getByIdCamin(@PathVariable("id") int id) {
		List<Cerere> cereri = cereriService.getByIdCamin(id);
		return ResponseEntity.ok().body(cereri);
	}
		
	/*---Actualizează o cerere după id---*/
	@PutMapping("/{id}")
	public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody Cerere cerere) {
		cereriService.update(id, cerere);
		return ResponseEntity.ok().body("The request has been updated successfully.");
	}

	/*---Șterge o cerere după id---*/
	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete(@PathVariable("id") int id) {
		cereriService.delete(id);
		return ResponseEntity.ok().body("The request has been deleted successfully.");
	}
}
