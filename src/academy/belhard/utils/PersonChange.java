package academy.belhard.utils;

import academy.belhard.Main;
import academy.belhard.entity.Person;

public class PersonChange {
    public static void change(Person person){
        System.out.println(person);

        boolean cycle = true;
        while (cycle) {
            showMenuChangeObject();
            int uc = ConsoleScan.scannerInt("Your choice: ");
            String s;
            switch (uc) {
                case (1): {
                    s = ConsoleScan.scannerString("Enter firstName: ");
                    if (s != null) person.setFirstName(s);
                    break;
                }
                case (2): {
                    s = ConsoleScan.scannerString("Enter lastName: ");
                    if (s != null) person.setLastName(s);
                    break;
                }
                case (3): {
                    s = ConsoleScan.scannerString("Enter email: ");
                    if (s != null) person.setEmail(s);
                    break;
                }
                case (4): {
                    int a = ConsoleScan.scannerInt("Enter age: ");
                    if (a != 0) person.setAge(a);
                    break;
                }
                case (5): { cycle = false;
                    System.out.print("New data saved: ");
                    System.out.println(person);
                    break;
                }
                default: {
                }
            }
        }
    }
    public static void showMenuChangeObject(){
        System.out.print("Choose field: ");
        System.out.print(" 1.Firstname.");
        System.out.print(" 2.Lastname.");
        System.out.print(" 3.Email.");
        System.out.print(" 4.Age.");
        System.out.println(" 5.Save and Exit.");
    }

    public static Person addPerson(){
        String firstName = ConsoleScan.scannerString("Enter firstname: ");
        if (firstName.equals("")) firstName = "noname";
        String lastName = ConsoleScan.scannerString("Enter lastname: ");
        if (lastName.equals("")) lastName =  "noname";
        int age = ConsoleScan.scannerInt("Enter age: ");

        String email = ConsoleScan.scannerString("Enter email: ");
        if (email.equals("")) email = "no email";

        Person person = new Person(firstName,lastName,email,age);
        System.out.println(person.toString());
        return person;
    }
}
