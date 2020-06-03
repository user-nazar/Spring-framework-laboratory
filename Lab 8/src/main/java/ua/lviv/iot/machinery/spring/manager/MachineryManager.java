package ua.lviv.iot.machinery.spring.manager;

import java.util.LinkedList;
import java.util.List;

import ua.lviv.iot.machinery.spring.models.FuelType;
import ua.lviv.iot.machinery.spring.models.WheelType;

public class MachineryManager {
	List<Machinery> listOfMachinery = new LinkedList<Machinery>();

	public void addMachinery(Machinery machine) {
		listOfMachinery.add(machine);
	}

	public List<Machinery> searchByFuelType(List<Machinery> listOfSortedMachinery, FuelType fuelType) {
		List<Machinery> listOfMachineryWithFuelType = new LinkedList<Machinery>();
		for (Machinery list : listOfSortedMachinery) {
			if (fuelType == list.getFuelType()) {
				listOfMachineryWithFuelType.add(list);
			}
		}
		return listOfMachineryWithFuelType;
	}

	public List<Machinery> searchByWheelType(List<Machinery> listOfSortedMachinery, WheelType wheelType) {
		List<Machinery> listOfMachineryWithWheelType = new LinkedList<Machinery>();
		for (Machinery list : listOfSortedMachinery) {
			if (wheelType == list.getWheelType()) {
				listOfMachineryWithWheelType.add(list);
			}
		}
		return listOfMachineryWithWheelType;
	}

}
