import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static junit.framework.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class StorageTest {

    private Storage storage;
    private List<IDisk> testDisks;
    private IDisk testDisk;
    private List<IDisk> musicDisks;
    private List<IDisk> disksByRating;

    @Before
    public void init() {
        testDisk = new Music(DiskType.MUSIC, "Eminem",
                LocalDate.of(2021, 5, 15), 7);
        musicDisks = getMusicDisks();
        disksByRating = getDisksByRating();
        testDisks = Main.getDisksCollection();
        storage = new Storage(testDisks);
    }

    @Test
    public void testAddToStorage() {
        storage.addToStorage(testDisk);
        assertTrue(storage.getAll().contains(testDisk));
    }

    @Test
    public void testGetAll() {
        List<IDisk> disk = storage.getAll();
        assertEquals(testDisks, disk);
    }

    @Test
    public void testGetByName() {
        storage.addToStorage(testDisk);
        IDisk actualDisk = storage.getByName("Eminem");
        assertEquals(testDisk, actualDisk);
    }

    @Test
    public void testGetByType() {
        List<IDisk> actualDisks = storage.getByType(DiskType.MUSIC);
        assertEquals(musicDisks, actualDisks);
    }

    @Test
    public void testGetAllByRating() {
        List<IDisk> actualDisks = storage.getAllByRating(6);
        assertEquals(disksByRating, actualDisks);
    }

    @Test
    public void testIsExistByDiskType() {
        boolean actualDisk = storage.isExistByDiskType(DiskType.MUSIC);
        assertTrue(actualDisk);
    }

    @Test
    public void testIsExistByName() {
        storage.addToStorage(testDisk);
        boolean actualDisk = storage.isExistByName("Eminem");
        assertTrue(actualDisk);
    }

    @Test(expected = EmptyDiskListException.class)
    public void testEmptyDiskListExceptionGetAllByYear() throws EmptyDiskListException {
        storage.getAllByYear("2030");
    }

    @Test
    public void testGetAllByYear() throws EmptyDiskListException {
        storage.addToStorage(testDisk);
        List<IDisk> actualDisks = storage.getAllByYear("2021");
        assertTrue(actualDisks.contains(testDisk));
        assertEquals(1, actualDisks.size());
    }

    private List<IDisk> getMusicDisks() {
        return Stream.of(
                new Music(DiskType.MUSIC, "Децл", LocalDate.of(2010, 12, 1), 6),
                new Music(DiskType.MUSIC, "Цой", LocalDate.of(2010, 12, 1), 8),
                new Music(DiskType.MUSIC, "Сектор газа", LocalDate.of(2005, 6, 1), 8),
                new Music(DiskType.MUSIC, "Сливки", LocalDate.of(2016, 6, 1), 8),
                new Movie(DiskType.MUSIC, "Scorpions", LocalDate.of(2012, 10, 15), 3),
                new Music(DiskType.MUSIC, "Bon Jovi", LocalDate.of(2008, 12, 1), 8),
                new Music(DiskType.MUSIC, "София Ротару", LocalDate.of(2015, 12, 3), 3)
        ).collect(Collectors.toList());
    }

    private List<IDisk> getDisksByRating() {
        return Stream.of(
                new Soft(DiskType.SOFT, "ip-cam", LocalDate.of(2016, 6, 1), 6),
                new Music(DiskType.MUSIC, "Децл", LocalDate.of(2010, 12, 1), 6)
        ).collect(Collectors.toList());
    }
}
