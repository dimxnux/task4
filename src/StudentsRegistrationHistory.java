import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.*;

public class StudentsRegistrationHistory {

    public static Map<Student, LocalDateTime> registrationHistory = new HashMap<>();

    public static void addRecord(Student student, LocalDateTime registrationDate) {
        // avoid potential registration date overwrite
        registrationHistory.putIfAbsent(student, registrationDate);
    }

    public static Set<Map.Entry<Student, LocalDateTime>> getAllRecords() {
        return registrationHistory.entrySet();
    }

    public static Student getStudentById(long studentId) {

    }

}
