package licenta.service;

import java.security.NoSuchAlgorithmException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import licenta.dao.ItemDao;
import licenta.dao.UserDao;
import licenta.model.Item;
import licenta.model.User;
import licenta.utils.KeyValue;
import licenta.utils.SecurityUtils;

@Service
@Transactional(readOnly = true)
public class UsersServiceImp implements UsersService {


	   @Autowired
	   private UserDao userDao;

	   @Autowired
	   private ItemDao itemDao;
	   
	   @Transactional
	   @Override
	   public long save(User user) {
		  try {
			user.setPassword(
					SecurityUtils.getMD5Hash(
							user.getPassword()));
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
			return -1;
			
		}
	      return userDao.save(user);
	   }

	   @Override
	   public User get(long id) {
	      return userDao.get(id);
	   }
	   
	   

	   @Override
	   public List<User> list() {
	      return userDao.list();
	   }

	   @Transactional
	   @Override
	   public User update(long id, User user) {
	      return userDao.update(id, user);
	   }

	   @Transactional
	   @Override
	   public void delete(long id) {
	      userDao.delete(id);
	   }

	@Override
	public boolean existEmail(String email) {
		int resultNo=userDao.getEmail(email);
		if(resultNo==0){
			return false;
		}
		return true;
		
	}

	@Override
	public long login(KeyValue kv) {
		return userDao.login(kv);
	
	}

	@Override
	public User getByEmail(String email) {
		return userDao.getByEmail(email);
	}

	@Override
	public List<Item> getItemsByUser(long id) {
		User user= userDao.get(id); 
		return itemDao.getItemsByUser(user);
	}

	@Override
	public List<String> getAllEmails() {
		return userDao.getAllEmails();
	}

}
