package ua.lviv.iot.machinery.spring.models;

import ua.lviv.iot.machinery.spring.manager.Machinery;
import ua.lviv.iot.machinery.spring.models.FuelType;

public class SkiLiftMakerMachine extends Machinery {

	private double sizeOfMachine;

	public SkiLiftMakerMachine(int yearOfProduction, double loseFuelPerOneHour, double weightOfMachineryInKg,
			int machieneMileage, WheelType wheelType, FuelType fuelType, double sizeOfMachine) {
		super(yearOfProduction, loseFuelPerOneHour, weightOfMachineryInKg, machieneMileage, wheelType, fuelType);
		this.sizeOfMachine = sizeOfMachine;
	}

	public SkiLiftMakerMachine() {
		
	}

	public double getSizeOfMachine() {
		return sizeOfMachine;
	}

	public void setSizeOfMachine(double sizeOfMachine) {
		this.sizeOfMachine = sizeOfMachine;
	}

	public String getHeaders() {
		return super.getHeaders() + ", sizeOfMachine";
	}

	public String toCSV() {
		return super.toCSV() + ", " + sizeOfMachine;
	}
}

