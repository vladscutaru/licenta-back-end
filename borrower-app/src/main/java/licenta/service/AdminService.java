package licenta.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import licenta.dao.AdminDao;
import licenta.model.Admin;

@Service
@Transactional(readOnly = true)
public class AdminService {

	@Autowired
	private AdminDao adminDao;

	@Transactional
	public Admin save(Admin admin) {
		return adminDao.save(admin);
	}

	public Admin get(int id) {
		return adminDao.get(id);
	}
	
	public List<Admin> list() {
		return adminDao.list();
	}

	@Transactional
	public void update(int id, Admin admin) {
		adminDao.update(id, admin);
		
	}

	@Transactional
	public void delete(int id) {
		adminDao.delete(id);
		
	}
	

}
