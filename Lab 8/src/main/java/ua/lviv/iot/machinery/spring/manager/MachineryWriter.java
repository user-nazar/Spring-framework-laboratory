package ua.lviv.iot.machinery.spring.manager;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedList;

public class MachineryWriter {
	public void writeToFile(LinkedList<Machinery> machinery) {
		File file;
		FileWriter fileWriter = null;
		try {

			file = new File(("C:\\Users\\nazarcomp\\projects"), "5lab.csv");

			file.setWritable(true);
			if (!file.exists()) {

				file.createNewFile();

			}

			fileWriter = new FileWriter(file);

			fileWriter.write(machinery.get(0).getHeaders() + "\n");
			for (Machinery mach : machinery) {
				fileWriter.write(mach.toCSV() + "\n");
			}

		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				fileWriter.flush();
				fileWriter.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}
}
