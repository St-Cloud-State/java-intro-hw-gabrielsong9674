import java.io.PrintWriter;
import java.util.*;
import java.awt.*;
import java.io.*;
import java.io.FileNotFoundException;



public class MyMain{

    static void store(File inputFile, LinkedList<Person> l1)throws FileNotFoundException {
        Scanner fileScanner = new Scanner(inputFile).useDelimiter("\n");
        Person personToAdd;
        while(fileScanner.hasNext()){
            String temp[] = fileScanner.nextLine().split(" ");
            personToAdd = new Person(temp[0], temp[1], temp[2]);
            l1.add(personToAdd);
        }
        fileScanner.close();
    }

    static void display(File outputFile, LinkedList<Person> l1) throws FileNotFoundException{
        PrintWriter output = new PrintWriter(outputFile);
        for(Person p: l1){
            output.print("First Name: " + p.getFirstName() + ", Last Name: " + p.getLastName() + ", Student Id: " + p.getId() + "\n");
        }
        output.close();
    }

    static int find(String sid, LinkedList<Person> l1){
        for(int i = 0; i < l1.size(); i ++){
            Person temp = l1.get(i);
            if(temp.getId().equals(sid)){
                return i;
            }
        }
        return -1;
    }


    public static void main(String[] args) throws FileNotFoundException{
    
       LinkedList<Person> list = new LinkedList<Person>();
       File personFile = new File("person.txt");
       File outputFile = new File("output.txt");
       store(personFile, list);
       display(outputFile, list);
       System.out.println(find("3", list));
    }
}

class Person {

    private String firstName;
    private String lastName;
    private String id;
    public Person(String firstName, String lastName, String id){
        this.firstName = firstName;
        this.lastName = lastName;
        this.id = id;
    }

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

