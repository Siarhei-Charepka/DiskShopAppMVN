import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


public class Main {
    public static void main(String[] args) throws IOException, ParseException, EmptyDiskListException {

        Storage storage = new Storage(getDisksCollection());

        List<IDisk> byYear = storage.getAllByYear("2015");
        for (IDisk disk : byYear) {
            System.out.println(disk);
        }

        System.out.println(Configurations.getProperty("host"));


        JSONObject object = null;
        try {
            FileReader reader = new FileReader("src/main/resources/app.json");
            JSONParser jsonParser = new JSONParser();
            object = (JSONObject) jsonParser.parse(reader);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        System.out.println(object.get("type"));

        List<IDisk> disks = storage.getByType(DiskType.MOVIE);
        for (IDisk disk : disks) {
            System.out.println(disk.toString());
        }
    }

    public static List<IDisk> getDisksCollection() {
        List<IDisk> disks = new ArrayList<>();
        disks.add(new Soft(DiskType.SOFT, "ip-cam", LocalDate.of(2016, 6, 1), 6));
        disks.add(new Music(DiskType.MUSIC, "Децл", LocalDate.of(2010, 12, 1), 6));
        disks.add(new Movie(DiskType.MOVIE, "Хоббит", LocalDate.of(2015, 12, 1), 10));
        disks.add(new Soft(DiskType.SOFT, "Windows 10", LocalDate.of(2019, 10, 15), 8));
        disks.add(new Game(DiskType.GAME, "Need for speed", LocalDate.of(2012, 4, 15), 9));
        disks.add(new Movie(DiskType.MOVIE, "Good morning", LocalDate.of(2019, 10, 15), 3));
        disks.add(new Music(DiskType.MUSIC, "Цой", LocalDate.of(2010, 12, 1), 8));
        disks.add(new Movie(DiskType.MOVIE, "Пила 5", LocalDate.of(2020, 3, 1), 8));
        disks.add(new Movie(DiskType.MOVIE, "Маугли 3019", LocalDate.of(2019, 3, 1), 8));
        disks.add(new Music(DiskType.MUSIC, "Сектор газа", LocalDate.of(2005, 6, 1), 8));
        disks.add(new Music(DiskType.MUSIC, "Сливки", LocalDate.of(2016, 6, 1), 8));
        disks.add(new Movie(DiskType.MUSIC, "Scorpions", LocalDate.of(2012, 10, 15), 3));
        disks.add(new Soft(DiskType.SOFT, "Windows 10", LocalDate.of(2019, 10, 15), 8));
        disks.add(new Soft(DiskType.SOFT, "Windows 7", LocalDate.of(2015, 10, 15), 8));
        disks.add(new Music(DiskType.MUSIC, "Bon Jovi", LocalDate.of(2008, 12, 1), 8));
        disks.add(new Music(DiskType.MUSIC, "София Ротару", LocalDate.of(2015, 12, 3), 3));
        disks.add(new Movie(DiskType.MOVIE, "Пила 4", LocalDate.of(2020, 3, 1), 8));
        disks.add(new Movie(DiskType.MOVIE, "Грибы", LocalDate.of(2020, 3, 1), 8));
        disks.add(new Movie(DiskType.GAME, "Фиксики", LocalDate.of(2020, 3, 1), 8));
        disks.add(new Movie(DiskType.MOVIE, "Пила 2", LocalDate.of(2018, 3, 1), 8));
        disks.add(new Movie(DiskType.MOVIE, "Пила 1", LocalDate.of(2018, 3, 1), 8));
        return disks;
    }
}




