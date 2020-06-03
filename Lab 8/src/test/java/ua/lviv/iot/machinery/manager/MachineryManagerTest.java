package ua.lviv.iot.machinery.manager;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.LinkedList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ua.lviv.iot.machinery.spring.manager.Machinery;
import ua.lviv.iot.machinery.spring.manager.MachineryManager;
import ua.lviv.iot.machinery.spring.models.FuelType;
import ua.lviv.iot.machinery.spring.models.RiderTraceMakerMachine;
import ua.lviv.iot.machinery.spring.models.SkiLiftMakerMachine;
import ua.lviv.iot.machinery.spring.models.SkisTraceMakerMachine;
import ua.lviv.iot.machinery.spring.models.WheelType;


class MachineryManagerTest extends BaseMachineryManagerTest {

	private MachineryManager machineryManager;
	
	@BeforeEach
	public void setUp() {	
		machineryManager = new MachineryManager();
		machineryManager.addMachinery(new SkiLiftMakerMachine(2005, 10.7, 1800, 15000, WheelType.EIGHTxEIGHT, FuelType.GAS, 100.0));
		machineryManager.addMachinery(new RiderTraceMakerMachine(1995, 7.5, 3600, 8000, WheelType.SIXxSIX, FuelType.DIESEL, 4));
		machineryManager.addMachinery(new SkisTraceMakerMachine(2001, 12.5, 2000, 12500, WheelType.FOURxFOUR, FuelType.PETROL, 3.5));
	}
	
	@Test
	public void testSearchByFuelType() {
		List<Machinery> listOfSortedMachinery = machineryManager.listOfMachinery;
		List<Machinery> expectedList = new LinkedList<Machinery>();
		MachineryManager manager = new MachineryManager ();
		listOfSortedMachinery = manager.searchByFuelType(listOfSortedMachinery, FuelType.GAS);
		Machinery something = new Machinery(2005, 10.7, 1800, 15000, WheelType.EIGHTxEIGHT, FuelType.GAS);
		expectedList.add(something);
		assertEquals(expectedList.get(0).getFuelType(), listOfSortedMachinery.get(0).getFuelType());
	};
	
	@Test
	public void testSearchByWheelType() {
		List<Machinery> listOfSortedMachinery = machineryManager.listOfMachinery;
		List<Machinery> expectedList = new LinkedList<Machinery>();
		MachineryManager manager = new MachineryManager ();
		listOfSortedMachinery = manager.searchByWheelType(listOfSortedMachinery, WheelType.EIGHTxEIGHT);
		Machinery something = new Machinery(2005, 10.7, 1800, 15000, WheelType.EIGHTxEIGHT, FuelType.GAS);
		expectedList.add(something);
		assertEquals(expectedList.get(0).getWheelType(), listOfSortedMachinery.get(0).getWheelType());
	};
}
