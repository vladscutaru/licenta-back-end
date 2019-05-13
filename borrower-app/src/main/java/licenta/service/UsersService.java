package licenta.service;

import java.util.List;

import licenta.model.Item;
import licenta.model.User;
import licenta.utils.KeyValue;

public interface UsersService {

	long save(User user);

	User get(long id);

	List<User> list();

	User update(long id, User user);

	void delete(long id);

	boolean existEmail(String email);

	User getByEmail(String email);

	long login(KeyValue kv);

	List<Item> getItemsByUser(long id);

	List<String> getAllEmails();
}
