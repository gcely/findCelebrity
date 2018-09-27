package co.test.data;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

import co.test.celebrity.Person;

public class CsvReaderFile {
	
	private String inputFilePath;
	
	public CsvReaderFile () {
		ClassLoader classLoader = getClass().getClassLoader();
		this.inputFilePath = classLoader.getResource("MOCK_DATA.csv").getFile();
	}
	
	public List<Person> getMeetPeopleList() {
	    List<Person> inputList = new ArrayList<Person>();
	    try{
	      File inputF = new File(inputFilePath);
	      InputStream inputFS = new FileInputStream(inputF);
	      BufferedReader br = new BufferedReader(new InputStreamReader(inputFS));
	      // skip the header of the csv
	      inputList = br.lines().skip(1).map(mapToItem).collect(Collectors.toList());
	      br.close();
	    } catch (IOException e) {
	      System.out.println(e.getMessage());
	    }
	    return inputList ;
	}
	
	private Function<String, Person> mapToItem = (line) -> {
		String[] p = line.split(",");// a CSV has comma separated lines
		Person person = new Person(new Integer(p[0]), p[1], p[2], p[3], p[4], new Integer(p[5]));
		return person;
	};

}
