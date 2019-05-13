package licenta.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import licenta.dao.CameraDao;
import licenta.model.Camera;

@Service
@Transactional(readOnly = true)
public class CameraService {

	@Autowired
	private CameraDao cameraDao;

	@Transactional
	public Camera save(Camera camera) {
		return cameraDao.save(camera);
	}

	public Camera get(int id) {
		return cameraDao.get(id);
	}
	
	public List<Camera> getByCamin(int id) {
		return cameraDao.getByCamin(id);
	}

	public List<Camera> list() {
		return cameraDao.list();
	}

	@Transactional
	public void update(int id, Camera camera) {
		cameraDao.update(id, camera);
		
	}

	@Transactional
	public void delete(int id) {
		cameraDao.delete(id);
		
	}

	

}
