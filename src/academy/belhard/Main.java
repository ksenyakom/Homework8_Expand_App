package academy.belhard;

import academy.belhard.entity.Person;
import academy.belhard.io.DataReader;
import academy.belhard.io.DataWriter;
import academy.belhard.io.IOConstants;
import academy.belhard.utils.ConsoleScan;
import academy.belhard.utils.Menu;
import academy.belhard.utils.PersonChange;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        writeObjectsToFile();

        boolean cycle = true;
        while (cycle) {
            Menu.showMenu();
            int choice = ConsoleScan.scannerInt("Your choice: ");
            switch (choice) {
                case (1): {
                    readObjectsToFile();
                    break;
                }
                case (2): {
                    changeObject();
                    break;
                }
                case (3): {
                    addObject();
                    break;
                }
                case (4): {
                    deleteObject();
                    break;
                }
                case (5): {
                    cycle = false;
                    break;
                }
                default: {
                    System.out.println("Choose option");
                }
            }
        }
    }

    public static void deleteObject() {
        DataReader dataReader = new DataReader(IOConstants.FILENAME);
        DataWriter dataWriter = new DataWriter(IOConstants.FILENAME);
        try {
            List<Person> personsFromFile = dataReader.readFromFile();
            int uc = ConsoleScan.scannerInt("Choose object number to Delete:");
            uc--;
            if (uc < personsFromFile.size()) {
                personsFromFile.remove(uc);
                dataWriter.writeToFile(personsFromFile);
                System.out.println("Object deleted from file.");
            } else System.out.println("Object number do not exist.");

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void addObject() {
        Person person = PersonChange.addPerson();
        try {
            DataReader dataReader = new DataReader(IOConstants.FILENAME);
            List<Person> persons = dataReader.readFromFile();
            persons.add(person);
            DataWriter dataWriter = new DataWriter(IOConstants.FILENAME);
            dataWriter.writeToFile(persons);
            System.out.println("New object saved to file.");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void changeObject() {
        DataReader dataReader = new DataReader(IOConstants.FILENAME);
        try {
            List<Person> personsFromFile = dataReader.readFromFile();
            int uc = ConsoleScan.scannerInt("Choose object number to change:");
            uc--;
            if (uc < personsFromFile.size()) {
                PersonChange.change(personsFromFile.get(uc));
                DataWriter dataWriter = new DataWriter(IOConstants.FILENAME);
                dataWriter.writeToFile(personsFromFile);
            } else System.out.println("Object number do not exist.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public static void writeObjectsToFile() {
        /**
         * Создание и инициализация объектов
         */
        Person person1 = new Person("Harry", "Potter", "harry.potter@mail.com", 17);
        Person person2 = new Person("Hermione", "Granger ", "hermione.granger@mail.com", 17);
        Person person3 = new Person("Ronald", "Ronald", "ronald.weasley@mail.com", 17);

        /**
         * Создаем коллекцию на основе созданных объектов
         * Внимание конструкция List.of(...) создает неизменяемую коллекцию
         * (вы не сможете добавлять и удалять объекты из коллекции)
         */
        List<Person> persons = List.of(person1, person2, person3);

        /**
         * Инициализация объекта инкапсулирующего логикузаписи в файл
         */
        DataWriter dataWriter = new DataWriter(IOConstants.FILENAME);
        try {
            /**
             * Вызов метода записывающего данные в файл
             */
            dataWriter.writeToFile(persons);
            System.out.println("Объекты записаны в файл");
        } catch (IOException e) {
            /**
             * Обработка ошибки ввода/вывода
             */
            e.printStackTrace();
        }
    }

    public static void readObjectsToFile() {
        DataReader dataReader = new DataReader(IOConstants.FILENAME);
        try {
            /**
             * Чтение (парсинг) объектов из файла
             */
            List<Person> personsFromFile = dataReader.readFromFile();

            /**
             * Вывод коллекции объектов на экран
             */
            System.out.println(personsFromFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
