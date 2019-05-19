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

import licenta.model.Camera;
import licenta.service.CameraService;

@CrossOrigin("http://localhost:4200")
@RestController
@RequestMapping("/camera")

public class CameraController {
	
	@Autowired
	private CameraService cameraService;

	/*---Add new camera---*/
	@PostMapping("")
	public ResponseEntity<?> save(@RequestBody Camera camera) {
		Camera resp = cameraService.save(camera);
		return ResponseEntity.ok().body(resp);
	}
	/*---Get a camera by id---*/
	@GetMapping("/{id}")
	public ResponseEntity<Camera> get(@PathVariable("id") int id) {
		Camera camera = cameraService.get(id);
		return ResponseEntity.ok().body(camera);
	}
	
	/*---Get a camera by camin---*/
	@GetMapping("/getByCamin/{id}")
	public ResponseEntity<List<Camera>> getByCamin(@PathVariable("id") int id) {
		List<Camera> camera = cameraService.getByCamin(id);
		return ResponseEntity.ok().body(camera);
	}
	
	/*---get all cameras---*/
	@GetMapping("")
	public ResponseEntity<List<Camera>> list() {
		List<Camera> cameras = cameraService.list();
		return ResponseEntity.ok().body(cameras);
	}
	/*---Update a camera by id---*/
	@PutMapping("/{id}")
	public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody Camera camera) {
		cameraService.update(id, camera);
		return ResponseEntity.ok().body("Camera has been updated successfully.");
	}

	/*---Delete a camera by id---*/
	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete(@PathVariable("id") int id) {
		cameraService.delete(id);
		return ResponseEntity.ok().body("Camera has been deleted successfully.");
	}
}
