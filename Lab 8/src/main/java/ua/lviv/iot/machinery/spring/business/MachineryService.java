package ua.lviv.iot.machinery.spring.business;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ua.lviv.iot.machinery.spring.dataaccess.MachineryRepository;
import ua.lviv.iot.machinery.spring.manager.Machinery;

@Service
public class MachineryService {
	@Autowired
	private MachineryRepository machineryRepository;

	public Machinery createMachinery(Machinery machinery) {
		return machineryRepository.save(machinery);
	}

	public void deleteMachinery(Integer id) {
		machineryRepository.deleteById(id);
	}

	public Machinery updateMachinery(Integer id, Machinery newMachinery) {
		Machinery machinery = machineryRepository.getOne(id);
		machinery = newMachinery;
		return machineryRepository.save(machinery);
	}
}