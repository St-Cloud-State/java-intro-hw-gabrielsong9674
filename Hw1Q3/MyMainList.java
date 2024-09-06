import java.io.PrintWriter;
import java.util.*;
import java.awt.*;
import java.io.*;
import java.io.FileNotFoundException;


public class MyMain{

    //read in from a txt file and store to the PersonList object
    static void store(File inputFile, PersonList pList)throws FileNotFoundException {
        Scanner fileScanner = new Scanner(inputFile).useDelimiter("\n");
        while(fileScanner.hasNext()){
            String temp[] = fileScanner.nextLine().split(" ");
            pList.addPerson(temp[0], temp[1], temp[2]);
       }
       fileScanner.close();
    }

    //print the contents of the LinkedList to an output file
    static void display(File outputFile, PersonList pList) throws FileNotFoundException{
        PrintWriter output = new PrintWriter(outputFile);
        for(Person p: pList.getPersonList()){
            output.print("First Name: " + p.getFirstName() + ", Last Name: " + p.getLastName() + ", Student Id: " + p.getId() + "\n");

        }
        output.close();
    }

    //return the index with the matching id, else return -1
    static int find(String sid, PersonList pList){
        LinkedList<Person> list = pList.getPersonList();
        for(int i = 0; i < list.size(); i ++){
            Person temp = list.get(i);
            if(temp.getId().equals(sid)){
                return i;
            }
        }
        return -1;
    }


    public static void main(String[] args) throws FileNotFoundException{
       PersonList pList = new PersonList();
       File personFile = new File("person.txt");
       File outputFile = new File("output.txt");
       store(personFile, pList);
       display(outputFile, pList);
       System.out.println(find("7", pList));
    }
}

class Person {
    //private member variables
    private String firstName;
    private String lastName;
    private String id;
    //constructor
    public Person(String firstName, String lastName, String id){
        this.firstName = firstName;
        this.lastName = lastName;
        this.id = id;
    }

    //getters for the Person class
    String getFirstName(){
        return firstName;
    }
    String getLastName(){
        return lastName;
    }
    String getId(){
        return id;
    }

}


class PersonList{
    private LinkedList<Person> personList;
    //constructor to initialize linked list of Person objects
    public PersonList(){
        personList = new LinkedList<Person>();
    }

    void addPerson(String firstName, String lastName, String id){
        personList.add(new Person(firstName, lastName, id));
    }

    LinkedList<Person> getPersonList(){
        return personList;
    }


}