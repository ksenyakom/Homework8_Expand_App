package academy.belhard.io;

import academy.belhard.entity.Person;
import academy.belhard.utils.PersonCsvUtil;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class DataWriter {
    private String fileName;

    public DataWriter(String fileName) {
        this.fileName = fileName;
    }

    public String getFileName() {
        return fileName;
    }

    public void writeToFile(List<Person> persons) throws IOException {
        try (FileWriter writer = new FileWriter(fileName)) {
            writer.write(PersonCsvUtil.headers());

            for (Person person : persons) {
                writer.write(PersonCsvUtil.toCsvString(person));
            }
        }
    }
}
