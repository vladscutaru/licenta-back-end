package licenta.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import licenta.dao.ItemDao;
import licenta.model.Item;

@Service
@Transactional(readOnly = true)
public class ItemsServiceImp implements ItemsService {


	   @Autowired
	   private ItemDao itemDao;

	   @Transactional
	   @Override
	   public Item save(Item item) {
	      return itemDao.save(item);
	   }

	   @Override
	   public Item get(long id) {
	      return itemDao.get(id);
	   }

	   @Override
	   public List<Item> list() {
	      return itemDao.list();
	   }

	   @Transactional
	   @Override
	   public void update(long id, Item item) {
	      itemDao.update(id, item);
	   }

	   @Transactional
	   @Override
	   public void delete(long id) {
	      itemDao.delete(id);
	   }


}
