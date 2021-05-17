import java.time.LocalDate;
import java.util.Objects;

public abstract class Disk implements IDisk {

    private DiskType diskType;
    private String name;
    private LocalDate inventoryDate;
    private int rating;

    public Disk(DiskType diskType, String name, LocalDate inventoryDate, int rating) {
        this.diskType = diskType;
        this.name = name;
        this.inventoryDate = inventoryDate;
        this.rating = rating;
    }

    public DiskType getDiskType() {
        return diskType;
    }

    public String getName() {
        return name;
    }

    public LocalDate getInventoryDate() {
        return inventoryDate;
    }

    public int getRating() {
        return rating;
    }

    @Override
    public String toString() {
        return "Disk{" +
                "diskType=" + diskType +
                ", name='" + name + '\'' +
                ", inventoryDate=" + inventoryDate +
                ", rating=" + rating +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Disk disk = (Disk) o;
        return rating == disk.rating &&
                diskType == disk.diskType &&
                Objects.equals(name, disk.name) &&
                Objects.equals(inventoryDate, disk.inventoryDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(diskType, name, inventoryDate, rating);
    }
}

