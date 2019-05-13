package licenta.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import licenta.dao.UtilizatorDao;
import licenta.model.Utilizator;

@Service
@Transactional(readOnly = true)
public class UtilizatorService {

	@Autowired
	private UtilizatorDao utilizatorDao;

	@Transactional
	public Utilizator save(Utilizator utilizator) {
		return utilizatorDao.save(utilizator);
	}

	public Utilizator get(int id) {
		return utilizatorDao.get(id);
	}

	public List<Utilizator> list() {
		return utilizatorDao.list();
	}

	@Transactional
	public void update(int id, Utilizator utilizator) {
		utilizatorDao.update(id, utilizator);
		
	}

	@Transactional
	public void delete(int id) {
		utilizatorDao.delete(id);
		
	}
}
