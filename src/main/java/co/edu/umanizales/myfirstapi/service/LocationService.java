package co.edu.umanizales.myfirstapi.service;

import co.edu.umanizales.myfirstapi.model.Location;
import co.edu.umanizales.myfirstapi.model.State;
import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Value;
import jakarta.annotation.PostConstruct;

import lombok.Getter;

import java.io.FileReader;
import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;


@Service
@Getter

public class LocationService {


    private List<Location> locations;
    private List<State> states;

    @Value ("${locations_filename}")
    private String locationsFilename;

    @PostConstruct
    public void readLocationsFromCSV() throws IOException, URISyntaxException {
        locations = new ArrayList<>();
        states = new ArrayList<>();

        Path pathFile = Paths.get(ClassLoader.getSystemResource(locationsFilename).toURI());

        try (CSVReader csvReader = new CSVReader(new FileReader(pathFile.toString()))) {
            String[] line;
            csvReader.skip(1);
            // Leer todas las filas del CSV
            while ((line = csvReader.readNext()) != null) {
                // Crear un nuevo objeto Location y agregarlo a la lista
                locations.add(new Location(line[2],line[3],line[0],line[1]));
                boolean exists = false;
                for (State state : states) {
                    if (state.getCode().equals(line[0])) {
                        exists = true;
                        break;
                    }
                }
                if(exists == false){
                    states.add(new State(line[0],line[1]));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
            throw e;
        } catch (CsvValidationException e) {
            throw new RuntimeException(e);
        }
    }

    public Location getLocationByCode(String code) {
        for (Location location : locations) {
            if (location.getCode().equals(code)) {
                return location;
            }
        }
        return null;
    }

    public List<Location> getLocations() {
        return locations;
    }

    public Location getLocationByName(String name) {
        for (Location location : locations) {
            if((location.getDescription().toLowerCase()).equals(name.toLowerCase())){
                return location;
            }
        }
        return null;
    }

    public List<Location> getLocationByInitialLetter(Character letter) {
        List<Location> initialLetters = new ArrayList<>();
        for (Location location : locations) {
            if(location.getDescription().charAt(0) == letter){
                initialLetters.add(location);
            }
        }
        return initialLetters;
    }

    public List<Location> getLocationByStateCode(String stateCode) {
        List<Location> states = new ArrayList<>();
        for (Location location : locations) {
            if(location.getCode_state().equals(stateCode)){
                states.add(location);
            }
        }
        return states;
    }

    public List<State> getByStates() {

        return states;
    }

    public State getStateByCode(String code) {
        for (State state : states) {
            if (state.getCode().equals(code)) {
                return state;
            }
        }
        return null;
    }

    public List<String> getDepartmentsWithCapitals() {
        Map<String, String> departments = new HashMap<>();
        Map<String, String> capitals = new HashMap<>();

        for (Location location : locations) {

            departments.put(location.getCode_state(), location.getState_name());


            if (location.getCode().endsWith("001")) {
                capitals.put(location.getCode_state(), location.getCode() + " " + location.getDescription());
            }
        }

        List<String> result = new ArrayList<>();
        for (String code : departments.keySet()) {
            result.add(code + " " + departments.get(code));
            if (capitals.containsKey(code)) {
                result.add(capitals.get(code));
            }
        }

        return result;
    }

}
