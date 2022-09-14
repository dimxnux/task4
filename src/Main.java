import javax.swing.text.DateFormatter;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;

public class Main {

    public static void main(String[] args) {
        initializeStudentsRegistrationHistory();
    }

    public static void initializeStudentsRegistrationHistory() {
        StudentsRegistrationHistory registrationHistory = new StudentsRegistrationHistory();
        Student student;
        LocalDate registrationDate;
        final DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd-MMM-uuuu");

        student = new Student("John", "Brown", 25);
        registrationDate = LocalDate.parse("12-Aug-2005", dateFormatter);
        StudentsRegistrationHistory.addRecord(student, registrationDate.atStartOfDay());

        student = new Student("Jack", "Smith", 18);
        registrationDate = LocalDate.parse("25-Jan-2018", dateFormatter);
        StudentsRegistrationHistory.addRecord(student, registrationDate.atStartOfDay());

        student = new Student("Connor", "Jones", 22);
        registrationDate = LocalDate.parse("02-Feb-2020", dateFormatter);
        StudentsRegistrationHistory.addRecord(student, registrationDate.atStartOfDay());

        student = new Student("Jessica", "Williams", 19);
        registrationDate = LocalDate.parse("19-Jun-2022", dateFormatter);
        StudentsRegistrationHistory.addRecord(student, registrationDate.atStartOfDay());

        student = new Student("Ava", "Taylor", 20);
        registrationDate = LocalDate.parse("30-Sep-2017", dateFormatter);
        StudentsRegistrationHistory.addRecord(student, registrationDate.atStartOfDay());

        student = new Student("Oscar", "Garcia", 24);
        registrationDate = LocalDate.parse("09-Oct-2010", dateFormatter);
        StudentsRegistrationHistory.addRecord(student, registrationDate.atStartOfDay());

        student = new Student("Jacob", "Lam", 22);
        registrationDate = LocalDate.parse("15-Dec-2014", dateFormatter);
        StudentsRegistrationHistory.addRecord(student, registrationDate.atStartOfDay());

        student = new Student("Poppy", "White", 20);
        registrationDate = LocalDate.parse("09-Apr-2018", dateFormatter);
        StudentsRegistrationHistory.addRecord(student, registrationDate.atStartOfDay());

        student = new Student("James", "Smith", 27);
        registrationDate = LocalDate.parse("25-Nov-2021", dateFormatter);
        StudentsRegistrationHistory.addRecord(student, registrationDate.atStartOfDay());

        student = new Student("Tom", "Thomas", 21);
        registrationDate = LocalDate.parse("08-Jul-2022", dateFormatter);
        StudentsRegistrationHistory.addRecord(student, registrationDate.atStartOfDay());

        // #10

        student = new Student("George", "Roberts", 22);
        registrationDate = LocalDate.parse("21-May-2007", dateFormatter);
        StudentsRegistrationHistory.addRecord(student, registrationDate.atStartOfDay());

        student = new Student("Elizabeth", "Davis", 20);
        registrationDate = LocalDate.parse("14-Jan-2017", dateFormatter);
        StudentsRegistrationHistory.addRecord(student, registrationDate.atStartOfDay());

        student = new Student("Harry", "Johnson", 21);
        registrationDate = LocalDate.parse("09-Feb-2020", dateFormatter);
        StudentsRegistrationHistory.addRecord(student, registrationDate.atStartOfDay());

        student = new Student("Isabella", "Davis", 23);
        registrationDate = LocalDate.parse("18-Feb-2020", dateFormatter);
        StudentsRegistrationHistory.addRecord(student, registrationDate.atStartOfDay());

        student = new Student("Lily", "Evans", 23);
        registrationDate = LocalDate.parse("05-Aug-2021", dateFormatter);
        StudentsRegistrationHistory.addRecord(student, registrationDate.atStartOfDay());

        // #15
    }

}
