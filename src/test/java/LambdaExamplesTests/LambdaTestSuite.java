package LambdaExamplesTests;

import LambdaExamples.*;
import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.OptionalDouble;
import java.util.function.Function;
import java.util.stream.Collectors;

import static junit.framework.TestCase.fail;

//@Ignore
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class LambdaTestSuite {

    @Test
    public void test01HandlesTest() {
        System.out.println("I am the test!");
        List<Runnable> handles = new RunnableImp().handles();
        for (Runnable r : handles) {
            r.run();
        }
        Assert.assertEquals(1,1);
    }

    @Test
    public void test02ComparatorTest() {
        List<Person> personList = Person.createShortList();

        // Sort with Inner Class
        Collections.sort(personList, new Comparator<Person>(){
          public int compare(Person p1, Person p2){
            return p1.getSurName().compareTo(p2.getSurName());
          }
        });

        System.out.println("=== Sorted Asc SurName ===");
        for(Person p:personList){
          p.printName();
        }

        // Use Lambda instead

        // Print Asc
        System.out.println("=== Sorted Asc SurName ===");
        Collections.sort(personList, (Person p1, Person p2) -> p1.getSurName().compareTo(p2.getSurName()));

        for(Person p:personList){
          p.printName();
        }

        // Print Desc
        System.out.println("=== Sorted Desc SurName ===");
        Collections.sort(personList, (p1,  p2) -> p2.getSurName().compareTo(p1.getSurName()));

        for(Person p:personList){
          p.printName();
        }
        Assert.assertEquals(1,1);
    }

    // @Test
    // public void test03ListenerTest() {
    //     JButton testButton1 = new JButton("Test Button Anon");
    //     testButton1.addActionListener(new ActionListener(){
    //         @Override public void actionPerformed(ActionEvent ae){
    //             System.out.println("Click Detected by Anon Class");
    //         }
    //     });
    //
    //     JButton testButton2 = new JButton("Test Button Lambda");
    //     testButton2.addActionListener(e -> System.out.println("Click Detected by Lambda Listner"));
    //
    //     // Swing stuff
    //     JFrame frame = new JFrame("ListenerTest");
    //     frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    //     frame.add(testButton2, BorderLayout.EAST);
    //     frame.add(testButton1, BorderLayout.WEST);
    //     frame.pack();
    //     frame.setVisible(true);
    //
    //     try {Thread.sleep(6000);} catch (InterruptedException e) {}
    // }

    @Test
    public void test04RoboCallTest() {
        List<Person> pl = Person.createShortList();
        RoboContactAnon robo = new RoboContactAnon();

        System.out.println("\n==== test4RoboCallTest ====");

        System.out.println("\n=== Calling all Drivers ===");
        robo.phoneContacts(pl,
                new RoboTest<Person>(){
                    @Override
                    public boolean test(Person p){
                        return p.getAge() >=16;
                    }
                }
        );

        System.out.println("\n=== Emailing all Draftees ===");
        robo.emailContacts(pl,
                new RoboTest<Person>(){
                    @Override
                    public boolean test(Person p){
                        return p.getAge() >= 18 && p.getAge() <= 25 && p.getGender() == Gender.MALE;
                    }
                }
        );


        System.out.println("\n=== Mail all Pilots ===");
        robo.mailContacts(pl,
                new RoboTest<Person>(){
                    @Override
                    public boolean test(Person p){
                        return p.getAge() >= 23 && p.getAge() <= 65;
                    }
                }
        );
    }

    @Test
    public void test05RoboCallTest() {
        List<Person> people = Person.createShortList();
        RoboContactsLambda robo = new RoboContactsLambda();

        System.out.println("\n==== test5RoboCallTest ====");

        System.out.println("\n=== Calling all Drivers ===");
        robo.phoneContacts(people, p -> p.getAge() >=16);

        System.out.println("\n=== Emailing all Draftees ===");
        robo.emailContacts(people, p -> p.getAge() >= 18 && p.getAge() <= 25 && p.getGender() == Gender.MALE);


        System.out.println("\n=== Mail all Pilots ===");
        robo.mailContacts(people, p -> p.getAge() >= 23 && p.getAge() <= 65);
    }

    @Test
    public void test06NameTestNew() {
        System.out.println("\n==== NameTestNew ===");

        List<Person> list1 = Person.createShortList();

        // Print Custom First Name and e-mail
        System.out.println("===Custom List===");
        for (Person person:list1){
            System.out.println(
                person.printCustom(p -> "Name: " + p.getGivenName() + " EMail: " + p.getEmail())
            );
        }


        // Define Western and Eastern Lambdas

        Function<Person, String> westernStyle = p -> {
          return "\nName: " + p.getGivenName() + " " + p.getSurName() + "\n" +
                 "Age: " + p.getAge() + "  " + "Gender: " + p.getGender() + "\n" +
                 "EMail: " + p.getEmail() + "\n" +
                 "Phone: " + p.getPhone() + "\n" +
                 "Address: " + p.getAddress();
        };

        Function<Person, String> easternStyle =  p -> "\nName: " + p.getSurName() + " "
                + p.getGivenName() + "\n" + "Age: " + p.getAge() + "  " +
                "Gender: " + p.getGender() + "\n" +
                "EMail: " + p.getEmail() + "\n" +
                "Phone: " + p.getPhone() + "\n" +
                "Address: " + p.getAddress();

        // Print Western List
        System.out.println("\n===Western List===");
        for (Person person:list1){
            System.out.println(
                person.printCustom(westernStyle)
            );
        }

        // Print Eastern List
        System.out.println("\n===Eastern List===");
        for (Person person:list1){
            System.out.println(
                person.printCustom(easternStyle)
            );
        }
    }

    @Test
    public void test07ForEach() {
        List<Person> people = Person.createShortList();

        System.out.println("\n=== Western Phone List ===");
        people.forEach( p -> p.printWesternName() );

        System.out.println("\n=== Eastern Phone List ===");
        people.forEach(Person::printEasternName);

        System.out.println("\n=== Custom Phone List ===");
        people.forEach(p -> { System.out.println(p.printCustom(r -> "Name: " + r.getGivenName() + " EMail: " + r.getEmail())); });

    }

    @Test
    public void test08Filter() {
        List<Person> people = Person.createShortList();

        SearchCriteria search = SearchCriteria.getInstance();

        System.out.println("\n=== Western Pilot Phone List ===");

        people.stream().filter(search.getCriteria("allPilots"))
                .forEach(Person::printWesternName);


        System.out.println("\n=== Eastern Draftee Phone List ===");

        people.stream().filter(search.getCriteria("allDraftees"))
                .forEach(Person::printEasternName);

    }

    @Test
    public void test09ToList() {
        List<Person> people = Person.createShortList();

        SearchCriteria search = SearchCriteria.getInstance();

        // Make a new list after filtering.
        List<Person> pilotList = people
                .stream()
                .filter(search.getCriteria("allPilots"))
                .collect(Collectors.toList());

        System.out.println("\n=== Western Pilot Phone List ===");
        pilotList.forEach(Person::printWesternName);
        //fail();

    }

    @Test
    public void test10Map() {
        List<Person> people = Person.createShortList();

        SearchCriteria search = SearchCriteria.getInstance();

        // Calc average age of pilots old style
        System.out.println("== Calc Old Style ==");
        int sum = 0;
        int count = 0;

        for (Person p:people){
            if (p.getAge() >= 23 && p.getAge() <= 65 ){
                sum = sum + p.getAge();
                count++;
            }
        }

        long average = sum / count;
        System.out.println("Total Ages: " + sum);
        System.out.println("Average Age: " + average);


        // Get sum of ages
        System.out.println("\n== Calc New Style ==");
        long totalAge = people
                .stream()
                .filter(search.getCriteria("allPilots"))
                .mapToInt(p -> p.getAge())
                .sum();

        // Get average of ages
        OptionalDouble averageAge = people
                .parallelStream()
                .filter(search.getCriteria("allPilots"))
                .mapToDouble(p -> p.getAge())
                .average();

        System.out.println("Total Ages: " + totalAge);
        System.out.println("Average Age: " + averageAge.getAsDouble());

    }
}
