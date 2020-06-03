package ua.lviv.iot.machinery.spring.manager;

import ua.lviv.iot.machinery.spring.models.FuelType;
import ua.lviv.iot.machinery.spring.models.WheelType;

public class Machinery {

	private int yearOfProduction;
	private double loseFuelPerOneHour;
	private double weightOfMachineryInKg;
	private int machieneMileage;
	private WheelType wheelType;
	private FuelType fuelType;
	private Integer id;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Machinery() {
	}

	public Machinery(int yearOfProduction, double loseFuelPerOneHour, double weightOfMachineryInKg, int machieneMileage,
			WheelType wheelType, FuelType fuelType) {
		this.yearOfProduction = yearOfProduction;
		this.loseFuelPerOneHour = loseFuelPerOneHour;
		this.weightOfMachineryInKg = weightOfMachineryInKg;
		this.machieneMileage = machieneMileage;
		this.wheelType = wheelType;
		this.fuelType = fuelType;

	}

	public String getHeaders() {
		return "yearOfProduction,loseFuelPerOneHour,weightOfMachineryInKg,machieneMileage,wheelType,fuelType";

	}

	public String toCSV() {
		return yearOfProduction + "," + loseFuelPerOneHour + "," + weightOfMachineryInKg + "," + machieneMileage + ","
				+ wheelType + "," + fuelType;
	}

	public int getYearOfProduction() {
		return yearOfProduction;
	}

	public void setYearOfProduction(int yearOfProduction) {
		this.yearOfProduction = yearOfProduction;
	}

	public double getLoseFuelPerOneHour() {
		return loseFuelPerOneHour;
	}

	public void setLoseFuelPerOneHour(double loseFuelPerOneHour) {
		this.loseFuelPerOneHour = loseFuelPerOneHour;
	}

	public double getWeightOfMachineryInKg() {
		return weightOfMachineryInKg;
	}

	public void setWeightOfMachineryInKg(double weightOfMachineryInKg) {
		this.weightOfMachineryInKg = weightOfMachineryInKg;
	}

	public int getMachieneMileage() {
		return machieneMileage;
	}

	public void setMachieneMileage(int machieneMileage) {
		this.machieneMileage = machieneMileage;
	}

	public WheelType getWheelType() {
		return wheelType;
	}

	public void setWheelType(WheelType wheelType) {
		this.wheelType = wheelType;
	}

	public FuelType getFuelType() {
		return fuelType;
	}

	public void setFuelType(FuelType fuelType) {
		this.fuelType = fuelType;
	}

	public double getByMileageInKm() {
		return this.machieneMileage * 1.60934;
	}
}
