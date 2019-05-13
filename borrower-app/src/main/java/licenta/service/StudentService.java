package licenta.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import licenta.dao.StudentDao;
import licenta.model.Student;

@Service
@Transactional(readOnly = true)
public class StudentService {
	
	@Autowired
	private StudentDao studentDao;

	@Transactional
	public Student save(Student student) {
		return studentDao.save(student);
	}

	public Student get(int id) {
		return studentDao.get(id);
	}
	
	public List<Student> getByCamin(int id) {
		return studentDao.getByCamin(id);
	}

	public List<Student> list() {
		return studentDao.list();
	}

	@Transactional
	public void update(int id, Student student) {
		studentDao.update(id, student);
		
	}

	@Transactional
	public void delete(int id) {
		studentDao.delete(id);
		
	}
	
	
}
