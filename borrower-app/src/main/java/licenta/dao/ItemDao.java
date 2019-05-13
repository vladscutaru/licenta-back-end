package licenta.dao;

import java.util.List;

import licenta.model.Item;
import licenta.model.User;

public interface ItemDao {

	Item save(Item item);

	Item get(long id);

	List<Item> list();

	void update(long id, Item item);

	void delete(long id);

	List<Item> getItemsByUser(User user);

}
