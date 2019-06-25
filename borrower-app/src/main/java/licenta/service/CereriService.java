package licenta.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import licenta.dao.CereriDao;
import licenta.model.Cerere;

@Service
@Transactional(readOnly = true)
public class CereriService {

	@Autowired
	private CereriDao cereriDao;

	@Transactional
	public Cerere save(Cerere cerere) {
		return cereriDao.save(cerere);
	}

	public Cerere get(int id) {
		return cereriDao.get(id);
	}
	
	public List<Cerere> list() {
		return cereriDao.list();
	}
	
	public List<Cerere> getByIdCamin(int id) {
		return cereriDao.getByIdCamin(id);
	}

	@Transactional
	public void update(int id, Cerere cerere) {
		cereriDao.update(id, cerere);
		
	}

	@Transactional
	public void delete(int id) {
		cereriDao.delete(id);
	}

	public List<Cerere> getByIdStudent(int id) {
		return cereriDao.getByIdStudent(id);
	}

}
