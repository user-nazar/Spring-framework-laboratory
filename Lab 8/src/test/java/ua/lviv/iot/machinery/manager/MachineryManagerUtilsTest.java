package ua.lviv.iot.machinery.manager;

import java.util.LinkedList;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ua.lviv.iot.machinery.spring.manager.Machinery;
import ua.lviv.iot.machinery.spring.manager.MachineryManager;
import ua.lviv.iot.machinery.spring.manager.MachineryManagerUtils;
import ua.lviv.iot.machinery.spring.models.FuelType;
import ua.lviv.iot.machinery.spring.models.RiderTraceMakerMachine;
import ua.lviv.iot.machinery.spring.models.SkiLiftMakerMachine;
import ua.lviv.iot.machinery.spring.models.SkisTraceMakerMachine;
import ua.lviv.iot.machinery.spring.models.SortType;
import ua.lviv.iot.machinery.spring.models.WheelType;

public class MachineryManagerUtilsTest {

	private MachineryManager machineryManager;

	@BeforeEach
	public void setUp() {
		machineryManager = new MachineryManager();
		machineryManager.addMachinery(
				new SkiLiftMakerMachine(2005, 10.7, 1800, 15000, WheelType.EIGHTxEIGHT, FuelType.GAS, 100.0));
		machineryManager
				.addMachinery(new RiderTraceMakerMachine(1995, 7.5, 3600, 8000, WheelType.SIXxSIX, FuelType.DIESEL, 4));
		machineryManager.addMachinery(
				new SkisTraceMakerMachine(2001, 12.5, 2000, 12500, WheelType.FOURxFOUR, FuelType.PETROL, 3.5));
	}

	@Test
	public void testSortByLoseFuelPerOneHour() {
		List<Machinery> listOfMachinerySortedByLosingFuelPerOneHour = machineryManager.listOfMachinery;
		MachineryManagerUtils.sortByloseFuelPerOneHour(listOfMachinerySortedByLosingFuelPerOneHour, SortType.ASC);
		List<Machinery> listOfMachinery = new LinkedList<Machinery>();
		listOfMachinery.add(new RiderTraceMakerMachine(1995, 7.5, 3600, 8000, WheelType.SIXxSIX, FuelType.DIESEL, 4));
		listOfMachinery
				.add(new SkiLiftMakerMachine(2005, 10.7, 1800, 15000, WheelType.EIGHTxEIGHT, FuelType.GAS, 100.0));
		listOfMachinery
				.add(new SkisTraceMakerMachine(2001, 12.5, 2000, 12500, WheelType.FOURxFOUR, FuelType.PETROL, 3.5));
		for (int i = 0; i < listOfMachinery.size(); i++) {
			Assertions.assertTrue(
					listOfMachinery.get(i).getLoseFuelPerOneHour() == listOfMachinerySortedByLosingFuelPerOneHour.get(i)
							.getLoseFuelPerOneHour());
		}

	}

	@Test
	public void testSortByMileage() {
		List<Machinery> listOfSortedMachineryByMileage = machineryManager.listOfMachinery;
		MachineryManagerUtils.sortByMileage(listOfSortedMachineryByMileage, SortType.ASC);
		List<Machinery> listOfMachinery = new LinkedList<Machinery>();
		listOfMachinery.add(new RiderTraceMakerMachine(1995, 7.5, 3600, 8000, WheelType.SIXxSIX, FuelType.DIESEL, 8));
		listOfMachinery
				.add(new SkisTraceMakerMachine(2001, 12.5, 2000, 12500, WheelType.FOURxFOUR, FuelType.PETROL, 200.0));
		listOfMachinery.add(new SkiLiftMakerMachine(2005, 10.7, 1800, 15000, WheelType.EIGHTxEIGHT, FuelType.GAS, 4.6));
		for (int i = 0; i < listOfMachinery.size(); i++) {
			Assertions.assertTrue(listOfMachinery.get(i).getMachieneMileage() == listOfSortedMachineryByMileage.get(i)
					.getMachieneMileage());
		}
	}

	@Test
	public void testSortMachineryByMileageInKm() {
		List<Machinery> listOfSortedMachineryByKm = machineryManager.listOfMachinery;
		MachineryManagerUtils.sortMachineryByMileageInKm(listOfSortedMachineryByKm, SortType.ASC);
		List<Machinery> listOfMachinery = new LinkedList<Machinery>();
		listOfMachinery.add(new RiderTraceMakerMachine(1995, 7.5, 3600, 8000, WheelType.SIXxSIX, FuelType.DIESEL, 8));
		listOfMachinery
				.add(new SkisTraceMakerMachine(2001, 12.5, 2000, 12500, WheelType.FOURxFOUR, FuelType.PETROL, 200.0));
		listOfMachinery.add(new SkiLiftMakerMachine(2005, 10.7, 1800, 15000, WheelType.EIGHTxEIGHT, FuelType.GAS, 4.6));
		for (int i = 0; i < listOfMachinery.size(); i++) {
			Assertions.assertTrue(
					listOfMachinery.get(i).getByMileageInKm() == listOfSortedMachineryByKm.get(i).getByMileageInKm());
		}
	}
}
