import java.time.LocalDate;

public class Movie extends Disk {

    public Movie(DiskType diskType, String name, LocalDate inventoryDate, int rating) {
        super(diskType, name, inventoryDate, rating);
    }
}
