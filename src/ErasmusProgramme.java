import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.stream.Collectors;

/**
 * The student registers for the Erasmus Programme on a date that he likes.
 * On the Erasmus Programme, the student has a large selection of universities to choose from.
 * If the date comes and is between the passed range as arguments, the student is readyForErasmus(), thus he
 * can go to a university he chooses.
 */
public class ErasmusProgramme {

    private static final StudentsRegistrationHistory registrationHistory = new StudentsRegistrationHistory();

    // avoid the duplication of the same student
    private static final Set<Student> registeredStudents = new HashSet<>();
    private static final Set<University> universities = new HashSet<>();

    public static void registerStudent(Student student, LocalDateTime registrationDateTime) {
        registrationHistory.addRecord(student, registrationDateTime);
        registeredStudents.add(student);
    }

    public static void addUniversities(University... universities) {
        Collections.addAll(ErasmusProgramme.universities, universities);
    }

    /**
     * Returns a list of registered students which registration date to Erasmus Programme
     * is between {@code startDate} inclusive and {@code endDate} inclusive.
     * */
    public static List<Student> readyForErasmus(LocalDateTime start, LocalDateTime end) {
        return registeredStudents.stream().filter(student -> {
            LocalDateTime registration =
                    registrationHistory.getRegistrationDateTimeByStudentId(student.getId());

            return !(registration.isBefore(start) || registration.isAfter(end));
        }).collect(Collectors.toList());
    }

    /**
     * Returns a list of all students that want to visit the specified university.
     * */
    public static List<Student> allWhoCanVisit(University university) {
        return registeredStudents.stream()
                .filter(student -> student.getUniversitiesForApplication().contains(university))
                .collect(Collectors.toList());
    }

    /**
     * For each university maps a list of students that want to visit it.
     * */
    public static Collection<Map.Entry<University, List<Student>>> allWhoMightStudyHere() {
        Map<University, List<Student>> studentsByUniversity = new HashMap<>();

        universities.forEach(university -> {
            List<Student> studentsThatWantToApply = registeredStudents.stream()
                    .filter(student -> student.wantsToApplyFor(university))
                    .collect(Collectors.toList());
            studentsByUniversity.put(university, studentsThatWantToApply);
        });

        return Collections.unmodifiableCollection(studentsByUniversity.entrySet());
    }


    // Initialization of the students registration history
    static {
        final DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd-MMM-uuuu");
        Student student;
        LocalDate registrationDate;
        University cambridge = new University("Cambridge");
        University oxford = new University("Oxford");
        University sorbonne = new University("Sorbonne");
        University copenhagen = new University("Copenhagen");
        University amsterdam = new University("Amsterdam");
        University geneva = new University("Geneva");
        University oslo = new University("Oslo");
        addUniversities(cambridge, oxford, sorbonne, copenhagen, amsterdam, geneva, oslo);


        student = new Student("John", "Brown", 25);
        student.addUniversityForApplication(cambridge);
        student.addUniversityForApplication(oxford);
        student.addUniversityForApplication(copenhagen);
        registrationDate = LocalDate.parse("12-Aug-2005", dateFormatter);
        registerStudent(student, registrationDate.atStartOfDay());

        student = new Student("Jack", "Smith", 18);
        student.addUniversityForApplication(oxford);
        registrationDate = LocalDate.parse("25-Jan-2018", dateFormatter);
        registerStudent(student, registrationDate.atStartOfDay());

        student = new Student("Connor", "Jones", 22);
        student.addUniversityForApplication(cambridge);
        student.addUniversityForApplication(oxford);
        student.addUniversityForApplication(copenhagen);
        student.addUniversityForApplication(amsterdam);
        student.addUniversityForApplication(geneva);
        registrationDate = LocalDate.parse("02-Feb-2020", dateFormatter);
        registerStudent(student, registrationDate.atStartOfDay());

        student = new Student("Jessica", "Williams", 19);
        student.addUniversityForApplication(oxford);
        student.addUniversityForApplication(copenhagen);
        registrationDate = LocalDate.parse("19-Jun-2022", dateFormatter);
        registerStudent(student, registrationDate.atStartOfDay());

        student = new Student("Ava", "Taylor", 20);
        student.addUniversityForApplication(amsterdam);
        student.addUniversityForApplication(geneva);
        student.addUniversityForApplication(oslo);
        registrationDate = LocalDate.parse("30-Sep-2017", dateFormatter);
        registerStudent(student, registrationDate.atStartOfDay());

        student = new Student("Oscar", "Garcia", 24);
        student.addUniversityForApplication(amsterdam);
        student.addUniversityForApplication(geneva);
        student.addUniversityForApplication(oslo);
        registrationDate = LocalDate.parse("09-Oct-2010", dateFormatter);
        registerStudent(student, registrationDate.atStartOfDay());

        student = new Student("Jacob", "Lam", 22);
        student.addUniversityForApplication(amsterdam);
        student.addUniversityForApplication(geneva);
        student.addUniversityForApplication(oslo);
        registrationDate = LocalDate.parse("15-Dec-2014", dateFormatter);
        registerStudent(student, registrationDate.atStartOfDay());

        student = new Student("Poppy", "White", 20);
        student.addUniversityForApplication(cambridge);
        student.addUniversityForApplication(copenhagen);
        student.addUniversityForApplication(geneva);
        registrationDate = LocalDate.parse("09-Apr-2018", dateFormatter);
        registerStudent(student, registrationDate.atStartOfDay());

        student = new Student("James", "Smith", 27);
        student.addUniversityForApplication(cambridge);
        student.addUniversityForApplication(copenhagen);
        student.addUniversityForApplication(geneva);
        registrationDate = LocalDate.parse("25-Nov-2021", dateFormatter);
        registerStudent(student, registrationDate.atStartOfDay());

        student = new Student("Tom", "Thomas", 21);
        student.addUniversityForApplication(cambridge);
        student.addUniversityForApplication(copenhagen);
        student.addUniversityForApplication(geneva);
        registrationDate = LocalDate.parse("08-Jul-2022", dateFormatter);
        registerStudent(student, registrationDate.atStartOfDay());

        // #10

        student = new Student("George", "Roberts", 22);
        student.addUniversityForApplication(oxford);
        student.addUniversityForApplication(sorbonne);
        registrationDate = LocalDate.parse("21-May-2007", dateFormatter);
        registerStudent(student, registrationDate.atStartOfDay());

        student = new Student("Elizabeth", "Davis", 20);
        student.addUniversityForApplication(cambridge);
        student.addUniversityForApplication(sorbonne);
        registrationDate = LocalDate.parse("14-Jan-2017", dateFormatter);
        registerStudent(student, registrationDate.atStartOfDay());

        student = new Student("Harry", "Johnson", 21);
        student.addUniversityForApplication(oslo);
        student.addUniversityForApplication(geneva);
        registrationDate = LocalDate.parse("09-Feb-2020", dateFormatter);
        registerStudent(student, registrationDate.atStartOfDay());

        student = new Student("Isabella", "Davis", 23);
        student.addUniversityForApplication(sorbonne);
        student.addUniversityForApplication(copenhagen);
        student.addUniversityForApplication(cambridge);
        registrationDate = LocalDate.parse("18-Feb-2020", dateFormatter);
        registerStudent(student, registrationDate.atStartOfDay());

        student = new Student("Lily", "Evans", 23);
        student.addUniversityForApplication(sorbonne);
        student.addUniversityForApplication(copenhagen);
        student.addUniversityForApplication(cambridge);
        registrationDate = LocalDate.parse("05-Aug-2021", dateFormatter);
        registerStudent(student, registrationDate.atStartOfDay());

        // #15

        // Method testing

        // Sub-task 3
        LocalDateTime erasmusStart = LocalDate.parse("2017-05-05").atTime(15, 30);
        LocalDateTime erasmusEnd = LocalDate.parse("2020-12-15").atTime(10, 44);
        System.out.printf("Students that are ready for Erasmus between: [%s, %s]\n", erasmusStart, erasmusEnd);

        readyForErasmus(erasmusStart, erasmusEnd).forEach(stud ->
                System.out.println(stud.getFirstName() + " " + stud.getLastName()));

        System.out.println();

        // Sub-task 4
        System.out.println("All students who can visit oxford:");
        List<Student> oxfordStudents = allWhoCanVisit(oxford);
        oxfordStudents.forEach(stud -> System.out.println(stud.getFirstName() + " " + stud.getLastName()));
        System.out.println();


        // Sub-task 5
        System.out.println("All students who might study here:");
        Collection<Map.Entry<University, List<Student>>> entries = allWhoMightStudyHere();
        for (Map.Entry<University, List<Student>> entry : entries) {
            String university = entry.getKey().getName();
            String students = entry.getValue().stream().map(stud -> {
                return "\t" + stud.getFirstName() +
                        " " +
                        stud.getLastName() +
                        "\n";
            }).reduce("", String::concat);

            System.out.println(university);
            System.out.println(students);
        }
    }
    
}
