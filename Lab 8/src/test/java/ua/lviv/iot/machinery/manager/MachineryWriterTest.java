package ua.lviv.iot.machinery.manager;

import java.util.LinkedList;

import org.junit.jupiter.api.Test;

import ua.lviv.iot.machinery.spring.manager.Machinery;
import ua.lviv.iot.machinery.spring.manager.MachineryWriter;
import ua.lviv.iot.machinery.spring.models.FuelType;
import ua.lviv.iot.machinery.spring.models.RiderTraceMakerMachine;
import ua.lviv.iot.machinery.spring.models.SkiLiftMakerMachine;
import ua.lviv.iot.machinery.spring.models.SkisTraceMakerMachine;
import ua.lviv.iot.machinery.spring.models.WheelType;

class MachineryWriterTest {

	@Test
	void writeToCSV() {

		MachineryWriter writer = new MachineryWriter();

		LinkedList<Machinery> machinery = new LinkedList<Machinery>();
		machinery.add(new SkisTraceMakerMachine(2002, 12.3, 3000, 8000, WheelType.SIXxSIX, FuelType.DIESEL, 2.5));
		machinery.add(new SkiLiftMakerMachine(2000, 9.2, 2000, 7800, WheelType.EIGHTxEIGHT, FuelType.ELECTRO_ENGINE, 1.7));
		machinery.add(new RiderTraceMakerMachine(2005, 11.4, 3500, 9900, WheelType.FOURxFOUR, FuelType.PETROL, 8));

		writer.writeToFile(machinery);
	}
}

