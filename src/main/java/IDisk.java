import java.time.LocalDate;

public interface IDisk {

    DiskType getDiskType();

    String getName();

    LocalDate getInventoryDate();

    int getRating();
}
