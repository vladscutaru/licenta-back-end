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

import licenta.model.Student;
import licenta.service.StudentService;

@CrossOrigin("http://localhost:4200")
@RestController
@RequestMapping("/student")
public class StudentController 
{
	@Autowired
	private StudentService studentService;
	
	/*---Add new student---*/
	@PostMapping("")
	public ResponseEntity<?> save(@RequestBody Student student) {
		Student resp = studentService.save(student);
		return ResponseEntity.ok().body(resp);
	}
	
	/*---Get a student by id---*/
	@GetMapping("/{id}")
	public ResponseEntity<Student> get(@PathVariable("id") int id) {
		Student student = studentService.get(id);
		return ResponseEntity.ok().body(student);
	}
	
	/*---Get a student by camin---*/
	@GetMapping("/getByCamin/{id}")
	public ResponseEntity<List<Student>> getByCamin(@PathVariable("id") int id) {
		List<Student> student = studentService.getByCamin(id);
		return ResponseEntity.ok().body(student);
	}

	/*---get all students---*/
	@GetMapping("")
	public ResponseEntity<List<Student>> list() {
		List<Student> students = studentService.list();
		return ResponseEntity.ok().body(students);
	}

	/*---Update a student by id---*/
	@PutMapping("/{id}")
	public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody Student student) {
		studentService.update(id, student);
		return ResponseEntity.ok().body("Student has been updated successfully.");
	}

	/*---Delete a student by id---*/
	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete(@PathVariable("id") int id) {
		studentService.delete(id);
		return ResponseEntity.ok().body("Student has been deleted successfully.");
	}
	
}
