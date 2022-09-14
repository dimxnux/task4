import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.*;

public class StudentsRegistrationHistory {

    public static Map<Long, LocalDateTime> registrationHistory = new HashMap<>();

    public void addRecord(Student student, LocalDateTime registrationDate) {
        // avoid potential overwrite of the registration date
        registrationHistory.putIfAbsent(student.getId(), registrationDate);
    }

    public Set<Map.Entry<Long, LocalDateTime>> getAllRecords() {
        return registrationHistory.entrySet();
    }

    public LocalDateTime getRegistrationDateTimeByStudentId(long studentId) {
        return registrationHistory.get(studentId);
    }

}
