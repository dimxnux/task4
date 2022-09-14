import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicLong;

public class Student {

    private static AtomicLong idGenerator = new AtomicLong(0);

    private long id;
    private String firstName;
    private String lastName;
    private int age;
    private boolean eligibleForErasmusScholarship;
    private List<University> universitiesForApplication = new ArrayList<>();

    public Student(String firstName, String lastName, int age) {
        this.id = idGenerator.get();
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
    }

    public long getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getAge() {
        return age;
    }

    public boolean readyForErasmus(LocalDateTime start, LocalDateTime end) {
        LocalDateTime d = LocalDate.parse("2007-12-03").atStartOfDay();

        return !(d.isBefore(start) && d.isAfter(end));
    }

    public void addUniversityForApplication() {

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Student student = (Student) o;

        return id == student.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}
