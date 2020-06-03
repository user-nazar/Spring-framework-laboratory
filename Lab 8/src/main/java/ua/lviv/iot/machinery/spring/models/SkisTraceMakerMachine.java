package ua.lviv.iot.machinery.spring.models;

import ua.lviv.iot.machinery.spring.manager.Machinery;
import ua.lviv.iot.machinery.spring.models.FuelType;

public class SkisTraceMakerMachine extends Machinery {

	private double hightOfMachineInMeters;

	public SkisTraceMakerMachine(int yearOfProduction, double loseFuelPerOneHour, double weightOfMachineryInKg,
			int machieneMileage, WheelType wheelType, FuelType fuelType, double hightOfMachineInMeters) {
		super(yearOfProduction, loseFuelPerOneHour, weightOfMachineryInKg, machieneMileage, wheelType, fuelType);
		this.hightOfMachineInMeters = hightOfMachineInMeters;
	}

	public double getHightOfMachineInMeters() {
		return hightOfMachineInMeters;
	}

	public void setHightOfMachineInMeters(double hightOfMachineInMeters) {
		this.hightOfMachineInMeters = hightOfMachineInMeters;
	}

	public String getHeaders() {
		return super.getHeaders() + ", hightOfMachineInMeters";
	}

	public String toCSV() {
		return super.toCSV() + ", " + hightOfMachineInMeters;
	}
}