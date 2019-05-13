package licenta.service;

import java.util.List;

import licenta.model.Item;

public interface ItemsService {

	Item save(Item item);

	Item get(long id);

	List<Item> list();

	void update(long id, Item item);

	void delete(long id);
}
