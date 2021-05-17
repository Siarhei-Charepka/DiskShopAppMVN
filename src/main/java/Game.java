import java.time.LocalDate;

public class Game extends Disk {

    public Game(DiskType diskType, String name, LocalDate inventoryDate, int rating) {
        super(diskType, name, inventoryDate, rating);
    }
}
