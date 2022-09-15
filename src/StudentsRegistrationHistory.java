import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class StudentsRegistrationHistory {

    private final Map<Long, LocalDateTime> registrationHistory = new HashMap<>();

    public void addRecord(Student student, LocalDateTime registration) {
        // avoid potential overwrite of the registration date
        registrationHistory.putIfAbsent(student.getId(), registration);
    }

    public Set<Map.Entry<Long, LocalDateTime>> getAllRecords() {
        return registrationHistory.entrySet();
    }

    public LocalDateTime getRegistrationDateTimeByStudentId(long studentId) {
        return registrationHistory.get(studentId);
    }

}
