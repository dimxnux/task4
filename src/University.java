import java.util.Objects;
import java.util.concurrent.atomic.AtomicLong;

public class University {

    private static AtomicLong idGenerator = new AtomicLong(0);

    private long id;
    private String name;

    public University(String name) {
        id = idGenerator.incrementAndGet();
        this.name = name;
    }

    public String getName() {
        return name;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        University that = (University) o;

        return id == that.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}
