package ua.lviv.iot.machinery.spring.models;

import ua.lviv.iot.machinery.spring.manager.Machinery;
import ua.lviv.iot.machinery.spring.models.FuelType;

public class RiderTraceMakerMachine extends Machinery {

	private int countOfWheels;

	public RiderTraceMakerMachine(int yearOfProduction, double loseFuelPerOneHour, double weightOfMachineryInKg,
			int machieneMileage, WheelType wheelType, FuelType fuelType, int countOfWheels) {
		super(yearOfProduction, loseFuelPerOneHour, weightOfMachineryInKg, machieneMileage, wheelType, fuelType);
		this.countOfWheels = countOfWheels;
	}

	public int getCountOfWheels() {
		return countOfWheels;
	}

	public void setCountOfWheels(int countOfWheels) {
		this.countOfWheels = countOfWheels;
	}

	public String getHeaders() {
		return super.getHeaders() + ", countOfWheels";
	}

	public String toCSV() {
		return super.toCSV() + ", " + countOfWheels;
	}
}
