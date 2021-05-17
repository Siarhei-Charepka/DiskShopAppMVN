import java.time.LocalDate;

public class Music extends Disk {

    public Music(DiskType diskType, String name, LocalDate inventoryDate, int rating) {
        super(diskType, name, inventoryDate, rating);
    }
}
