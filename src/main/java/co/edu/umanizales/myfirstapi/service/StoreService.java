package co.edu.umanizales.myfirstapi.service;

import co.edu.umanizales.myfirstapi.model.Store;
import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Value;
import jakarta.annotation.PostConstruct;

import java.io.FileReader;
import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

@Service
public class StoreService {
public List<Store> getStore(){
    return storeList;
}
    private List<Store> storeList;

    @Value("${locations_filename}")
    private String storeFilename;

    @PostConstruct
    public void readStoreFromCSV() throws IOException, URISyntaxException {
        storeList = new ArrayList<>();

        Path pathFile = Paths.get(ClassLoader.getSystemResource(storeFilename).toURI());

        try (CSVReader csvReader = new CSVReader(new FileReader(pathFile.toString()))) {
            String[] line;
            csvReader.skip(1);
            while ((line = csvReader.readNext()) != null) {
                Store store = new Store(line[0], line[1], line[2], line[3], line[4]);

            }
        } catch (IOException e) {
            e.printStackTrace();
            throw e;
        } catch (CsvValidationException e) {
            throw new IOException(e.getMessage());

            }
        }
    }

