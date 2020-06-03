package ua.lviv.iot.machinery.spring.manager;

import java.util.Comparator;
import java.util.List;

import ua.lviv.iot.machinery.spring.models.SortType;

public class MachineryManagerUtils {
	private static final SortByLoseFuelPerOneHour FUEL_PER_HOUR_SORTER = new SortByLoseFuelPerOneHour();

	class SortByMileage implements Comparator<Machinery> {
		@Override
		public int compare(Machinery m1, Machinery m2) {
			return new Integer(m1.getMachieneMileage()).compareTo(new Integer(m2.getMachieneMileage()));
		}
	}

	static class SortByLoseFuelPerOneHour implements Comparator<Machinery> {
		/* Static Inner Class */
		@Override
		public int compare(Machinery m1, Machinery m2) {
			return (int) (m1.getLoseFuelPerOneHour() - m2.getLoseFuelPerOneHour());
		}
	}

	public static void sortByMileage(List<Machinery> listOfSortedMachineryByMileage, SortType ASC) {
		MachineryManagerUtils utils = new MachineryManagerUtils();
		listOfSortedMachineryByMileage.sort(utils.new SortByMileage());
	}

	public static void sortByloseFuelPerOneHour(List<Machinery> listOfMachinerySortedByLosingFuelPerOneHour,
			SortType sortType) {
		listOfMachinerySortedByLosingFuelPerOneHour
				.sort(sortType == SortType.ASC ? FUEL_PER_HOUR_SORTER : FUEL_PER_HOUR_SORTER.reversed());

	}

	public static void sortByMileageAndLoseFuel(List<Machinery> listOfSortedMachineryByMileageAndLoseFuel,
			SortType sortType) {
		/* Anonymous Inner Class */

		Comparator<Machinery> comparator = new Comparator<Machinery>() {
			@Override
			public int compare(Machinery m1, Machinery m2) {
				int mileageAndLoseFuelComparisonResult = m1.getMachieneMileage() - m2.getMachieneMileage();
				if (mileageAndLoseFuelComparisonResult != 0) {
					return mileageAndLoseFuelComparisonResult;
				}

				return new Integer(m1.getMachieneMileage()).compareTo(new Integer(m2.getMachieneMileage()));

			}
		};

		listOfSortedMachineryByMileageAndLoseFuel.sort(sortType == SortType.ASC ? comparator : comparator.reversed());
	}

	public static void sortByFuelAndMileage(List<Machinery> listOfSortedMachineryByLoseFuelAndMileage,
			SortType sortType) {
		/* Inner class */
		class LoseFuelAndMileageComparator implements Comparator<Machinery> {

			@Override
			public int compare(Machinery m1, Machinery m2) {
				double LoseFuelAndMileageComparisonResult = m1.getLoseFuelPerOneHour() - m2.getLoseFuelPerOneHour();
				if (LoseFuelAndMileageComparisonResult != 0) {
					return (int) LoseFuelAndMileageComparisonResult;
				}
				return Double.compare(m1.getLoseFuelPerOneHour(), m2.getLoseFuelPerOneHour());

			}

		};

		Comparator<Machinery> comparator = new LoseFuelAndMileageComparator();
		listOfSortedMachineryByLoseFuelAndMileage.sort(sortType == SortType.ASC ? comparator : comparator.reversed());

	}

	public static void sortMachineryByMileageInKm(List<Machinery> machineryByMileageInKmList, SortType sortType) {
		machineryByMileageInKmList
				.sort(sortType == SortType.ASC ? (o1, o2) -> (int) (o1.getByMileageInKm() - o2.getByMileageInKm())
						: (o1, o2) -> (int) (o2.getByMileageInKm() - o1.getByMileageInKm()));
	}
}
