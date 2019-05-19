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

import licenta.model.Item;
import licenta.service.ItemsService;

@CrossOrigin("http://localhost:4200")
@RestController
@RequestMapping("/item")
public class ItemsController {

	@Autowired
	private ItemsService itemService;

	/*---Add new item---*/
	@PostMapping("")
	public ResponseEntity<?> save(@RequestBody Item item) {
		Item resp = itemService.save(item);
		return ResponseEntity.ok().body(resp);
	}
	
	/*---Get an item by id---*/
	@GetMapping("/{id}")
	public ResponseEntity<Item> get(@PathVariable("id") long id) {
		Item item = itemService.get(id);
		return ResponseEntity.ok().body(item);
	}

	/*---get all items---*/
	@GetMapping("")
	public ResponseEntity<List<Item>> list() {
		List<Item> items = itemService.list();
		return ResponseEntity.ok().body(items);
	}

	/*---Update a item by id---*/
	@PutMapping("/{id}")
	public ResponseEntity<?> update(@PathVariable("id") long id, @RequestBody Item item) {
		itemService.update(id, item);
		return ResponseEntity.ok().body("Item has been updated successfully.");
	}

	/*---Delete a item by id---*/
	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete(@PathVariable("id") long id) {
		itemService.delete(id);
		return ResponseEntity.ok().body("Item has been deleted successfully.");
	}


}