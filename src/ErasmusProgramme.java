import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.stream.Collectors;

public class ErasmusProgramme {

    // about
    /*
     * The student registers for the Erasmus Programme on a date that he likes.
     * On the Erasmus Programme, the student has a large selection of universities to choose from.
     * If the date comes and is between the passed range as arguments, the student is readyForErasmus(), thus he
     * can go to a university he chooses.
     *
     * */

    // Task 5
    // universities

    private static final StudentsRegistrationHistory registrationHistory = new StudentsRegistrationHistory();

    // avoid the duplication of the same student
    private static final Set<Student> registeredStudents = new HashSet<>();
    private static final List<University> universities = new ArrayList<>();

    public static void registerStudent(Student student, LocalDateTime registrationDateTime) {
        registrationHistory.addRecord(student, registrationDateTime);
        registeredStudents.add(student);
    }

    public static List<Student> readyForErasmus(LocalDateTime start, LocalDateTime end) {
        return registeredStudents.stream().filter(student -> {
            // todo: should I use DateTime in variable names?
            LocalDateTime registration =
                    registrationHistory.getRegistrationDateTimeByStudentId(student.getId());

            return !(registration.isBefore(start) && registration.isAfter(end));
        }).collect(Collectors.toList());
    }

    /**
     * For each university maps a list of students that want to visit it,
     * even though the registration date hasn't arrived yet, i.e. aren't mandatory Erasmus ready.
     * */
    public static Map<University, List<Student>> allWhoCanVisitSpecificUniversity() {
        Map<University, List<Student>> studentsByUniversity = new HashMap<>();

        universities.forEach(university -> {
            List<Student> studentsThatWantToApply = registeredStudents.stream()
                    .filter(student -> student.wantsToApplyFor(university))
                    .collect(Collectors.toList());
            studentsByUniversity.put(university, studentsThatWantToApply);
        });

        return studentsByUniversity;
    }

    /**
     * For each university maps a list of students that want to visit it and are Erasmus ready,
     * i.e. the registration date hasn't arrived yet or expired.
     * */
    public static Collection<Map.Entry<University, List<Student>>> allWhoMightStudyThere(
            LocalDateTime startDate, LocalDateTime endDate) {

        Map<University, List<Student>> studentsByUniversity = new HashMap<>();

        universities.forEach(university -> {
// fixme: either create method isReadyForErasmus(Student) and finish the current version or implement the next version
            List<Student> studentsThatWantToApply = registeredStudents.stream()
                    .filter(student -> student.wantsToApplyFor(university) && readyForErasmus(startDate, endDate))
                    .collect(Collectors.toList());
            studentsByUniversity.put(university, studentsThatWantToApply);
        });

        return Collections.unmodifiableCollection(studentsByUniversity.entrySet());
    }

    // todo: a new version tag:
    // todo: make ex4 to return the list of students for an argument university
    // todo: make ex5 to return what ex4 returns now
    // todo: note: don't use erasmusReady in ex4 and ex5

    // todo: populate the universities for each student
    // initialize students registration history
    static {
        Student student;
        LocalDate registrationDate;
        final DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd-MMM-uuuu");

        student = new Student("John", "Brown", 25);
        registrationDate = LocalDate.parse("12-Aug-2005", dateFormatter);
        registrationHistory.addRecord(student, registrationDate.atStartOfDay());

        student = new Student("Jack", "Smith", 18);
        registrationDate = LocalDate.parse("25-Jan-2018", dateFormatter);
        registrationHistory.addRecord(student, registrationDate.atStartOfDay());

        student = new Student("Connor", "Jones", 22);
        registrationDate = LocalDate.parse("02-Feb-2020", dateFormatter);
        registrationHistory.addRecord(student, registrationDate.atStartOfDay());

        student = new Student("Jessica", "Williams", 19);
        registrationDate = LocalDate.parse("19-Jun-2022", dateFormatter);
        registrationHistory.addRecord(student, registrationDate.atStartOfDay());

        student = new Student("Ava", "Taylor", 20);
        registrationDate = LocalDate.parse("30-Sep-2017", dateFormatter);
        registrationHistory.addRecord(student, registrationDate.atStartOfDay());

        student = new Student("Oscar", "Garcia", 24);
        registrationDate = LocalDate.parse("09-Oct-2010", dateFormatter);
        registrationHistory.addRecord(student, registrationDate.atStartOfDay());

        student = new Student("Jacob", "Lam", 22);
        registrationDate = LocalDate.parse("15-Dec-2014", dateFormatter);
        registrationHistory.addRecord(student, registrationDate.atStartOfDay());

        student = new Student("Poppy", "White", 20);
        registrationDate = LocalDate.parse("09-Apr-2018", dateFormatter);
        registrationHistory.addRecord(student, registrationDate.atStartOfDay());

        student = new Student("James", "Smith", 27);
        registrationDate = LocalDate.parse("25-Nov-2021", dateFormatter);
        registrationHistory.addRecord(student, registrationDate.atStartOfDay());

        student = new Student("Tom", "Thomas", 21);
        registrationDate = LocalDate.parse("08-Jul-2022", dateFormatter);
        registrationHistory.addRecord(student, registrationDate.atStartOfDay());

        // #10

        student = new Student("George", "Roberts", 22);
        registrationDate = LocalDate.parse("21-May-2007", dateFormatter);
        registrationHistory.addRecord(student, registrationDate.atStartOfDay());

        student = new Student("Elizabeth", "Davis", 20);
        registrationDate = LocalDate.parse("14-Jan-2017", dateFormatter);
        registrationHistory.addRecord(student, registrationDate.atStartOfDay());

        student = new Student("Harry", "Johnson", 21);
        registrationDate = LocalDate.parse("09-Feb-2020", dateFormatter);
        registrationHistory.addRecord(student, registrationDate.atStartOfDay());

        student = new Student("Isabella", "Davis", 23);
        registrationDate = LocalDate.parse("18-Feb-2020", dateFormatter);
        registrationHistory.addRecord(student, registrationDate.atStartOfDay());

        student = new Student("Lily", "Evans", 23);
        registrationDate = LocalDate.parse("05-Aug-2021", dateFormatter);
        registrationHistory.addRecord(student, registrationDate.atStartOfDay());

        // #15
    }
    
}
