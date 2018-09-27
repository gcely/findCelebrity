package co.test.run;

import java.util.List;

import co.test.celebrity.Person;
import co.test.data.CsvReaderFile;
import co.test.data.QuickSort;

public class Seeker {

	public static void main(String[] args) {
		// read the file with all people
		CsvReaderFile reader = new CsvReaderFile();
		List<Person> persons = reader.getMeetPeopleList();
		// order the list using quick sort algorithm by amount of people knows by the person
		// the person with less people knows will be consider as celebrity
		// maybe he knows 0 or meybe he knows anyone
		QuickSort qs = new QuickSort();
		qs.sort(persons);
		List<Person> orderPersons = qs.getPersons();
		Person celebrity = orderPersons.get(0);
		System.out.println("The celebrity is " + celebrity.getId()+ " - " + celebrity.getFirstName() + " " + celebrity.getLastName() + " who knows " + celebrity.getNmbrPeopleKnows() + " persons");
	}

}
