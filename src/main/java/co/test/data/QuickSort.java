package co.test.data;

import java.util.List;

import co.test.celebrity.Person;

public class QuickSort {
	
	private List<Person> persons;
    private int length;
 
    public void sort(List<Person> persons) {
        // If the list of people is empty
        if (persons == null || persons.isEmpty()) {
            return;
        }
        this.persons = persons;
        length = persons.size();
        quickSort(0, length - 1);
    }
 
    private void quickSort(int lowerIndex, int higherIndex) {
         
        int i = lowerIndex;
        int j = higherIndex;
        // calculate pivot number, I am taking pivot as middle index number
        Person pivot = persons.get(lowerIndex+(higherIndex-lowerIndex)/2);
        // Divide into two arrays
        while (i <= j) {
            /**
             * In each iteration, identify a number of knows people from left side which 
             * is greater then the pivot value, and also identify a number of knows people from right 
             * side which is less then the pivot value. 
             */
            while (persons.get(i).getNmbrPeopleKnows() < pivot.getNmbrPeopleKnows()) {
                i++;
            }
            while (persons.get(j).getNmbrPeopleKnows() > pivot.getNmbrPeopleKnows()) {
                j--;
            }
            if (i <= j) {
                exchangePerson(i, j);
                //move index to next position on both sides
                i++;
                j--;
            }
        }
        // call quickSort() method recursively
        if (lowerIndex < j)
            quickSort(lowerIndex, j);
        if (i < higherIndex)
            quickSort(i, higherIndex);
    }
 
    private void exchangePerson(int i, int j) {
        Person temp = persons.get(i);
        persons.set(i, persons.get(j));
        persons.set(j, temp);
    }

	public List<Person> getPersons() {
		return persons;
	}

}
