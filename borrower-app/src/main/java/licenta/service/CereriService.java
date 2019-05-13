package licenta.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import licenta.dao.CereriDao;
import licenta.model.Cereri;

@Service
@Transactional(readOnly = true)
public class CereriService {

	@Autowired
	private CereriDao cereriDao;

	@Transactional
	public Cereri save(Cereri cereri) {
		return cereriDao.save(cereri);
	}

	public Cereri get(int id) {
		return cereriDao.get(id);
	}

	public List<Cereri> list() {
		return cereriDao.list();
	}

	@Transactional
	public void update(int id, Cereri cereri) {
		cereriDao.update(id, cereri);
		
	}

	@Transactional
	public void delete(int id) {
		cereriDao.delete(id);
		
	}

}
