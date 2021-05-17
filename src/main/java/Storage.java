import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Storage implements IStorage {

    private List<IDisk> diskStorage;

    public Storage() {
        this.diskStorage = new ArrayList<>();
    }

    public Storage(List<IDisk> disks) {
        this.diskStorage = disks;
    }

    @Override
    public void addToStorage(IDisk disk) {
        diskStorage.add(disk);
    }

    @Override
    public List<IDisk> getAll() {
        return diskStorage;
    }

    @Override
    public IDisk getByName(String name) {
        return diskStorage.stream().filter(disk -> disk.getName().equals(name)).findFirst().get();
    }

    @Override
    public List<IDisk> getByType(DiskType type) {
        return diskStorage.stream().filter(disk -> disk.getDiskType().equals(type)).collect(Collectors.toList());
    }

    @Override
    public List<IDisk> getAllByRating(int rating) {
        return diskStorage.stream().filter(disk -> disk.getRating() == rating).collect(Collectors.toList());
    }

    @Override
    public boolean isExistByDiskType(DiskType type) {
        return diskStorage.stream().anyMatch(disk -> disk.getDiskType().equals(type));
    }

    @Override
    public boolean isExistByName(String name) {
        return diskStorage.stream().anyMatch(disk -> disk.getName().equals(name));
    }

    @Override
    public List<IDisk> getAllByYear(String year) throws EmptyDiskListException {
        List<IDisk> diskByYear = diskStorage.stream().filter(disk -> String.valueOf(disk.getInventoryDate().getYear()).equals(year))
                .collect(Collectors.toList());
        if (diskByYear.isEmpty()) {
            throw new EmptyDiskListException();
        }
        return diskByYear;
    }
}