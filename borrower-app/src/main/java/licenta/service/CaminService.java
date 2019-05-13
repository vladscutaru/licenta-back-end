package licenta.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import licenta.dao.CaminDao;
import licenta.model.Camin;

@Service
@Transactional(readOnly = true)
public class CaminService {

	@Autowired
	private CaminDao caminDao;

	@Transactional
	public Camin save(Camin camin) {
		return caminDao.save(camin);
	}

	public Camin get(int id) {
		return caminDao.get(id);
	}

	public List<Camin> list() {
		return caminDao.list();
	}

	@Transactional
	public void update(int id, Camin camin) {
		caminDao.update(id, camin);
		
	}

	@Transactional
	public void delete(int id) {
		caminDao.delete(id);
		
	}

}
