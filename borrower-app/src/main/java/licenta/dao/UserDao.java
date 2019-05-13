package licenta.dao;

import java.util.List;

import licenta.model.User;
import licenta.utils.KeyValue;

public interface UserDao {

	long save(User user);

	User get(long id);

	List<User> list();

	User update(long id, User user);

	void delete(long id);

	int getEmail(String email);

	User getByEmail(String email);

	long login(KeyValue kv);

	List<String> getAllEmails();
}
