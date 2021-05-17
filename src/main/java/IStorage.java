import java.util.List;

public interface IStorage {

    void addToStorage(IDisk disk);

    List<IDisk> getAll();

    IDisk getByName(String name);

    List<IDisk> getByType(DiskType type);

    List<IDisk> getAllByRating(int rating);

    boolean isExistByDiskType(DiskType type);

    boolean isExistByName(String name);

    List<IDisk> getAllByYear(String year) throws EmptyDiskListException;

}
