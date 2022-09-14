import java.util.ArrayList;
import java.util.Collections;
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

    // Universities the student would like to visit
    private final List<University> universitiesForApplication = new ArrayList<>();

    public Student(String firstName, String lastName, int age) {
        this.id = idGenerator.incrementAndGet();
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

    public List<University> getUniversitiesForApplication() {
        return Collections.unmodifiableList(universitiesForApplication);
    }

    public void addUniversityForApplication(University university) {
        universitiesForApplication.add(university);
    }

    public boolean wantsToApplyFor(University university) {
        for (University u : universitiesForApplication) {
            if (u.equals(university)) {
                return true;
            }
        }

        return false;
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
