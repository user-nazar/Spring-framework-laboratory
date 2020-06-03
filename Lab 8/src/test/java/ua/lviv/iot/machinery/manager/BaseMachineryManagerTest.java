package ua.lviv.iot.machinery.manager;

import java.util.LinkedList;
import java.util.List;

import ua.lviv.iot.machinery.spring.models.SkiLiftMakerMachine;

public abstract class BaseMachineryManagerTest {

	protected List<SkiLiftMakerMachine> skiLiftMakerMachine;
	
	public void createSkiLiftMakerMachine() {
		skiLiftMakerMachine = new LinkedList<SkiLiftMakerMachine>();
		skiLiftMakerMachine.add(new SkiLiftMakerMachine());
	}
}
    

