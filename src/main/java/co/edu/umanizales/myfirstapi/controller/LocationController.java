package co.edu.umanizales.myfirstapi.controller;

import co.edu.umanizales.myfirstapi.service.LocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.edu.umanizales.myfirstapi.model.Location;
import co.edu.umanizales.myfirstapi.model.State;
import java.util.List;


@RestController
@RequestMapping("/location")
public class LocationController {

    @Autowired
    private LocationService locationService;

    @GetMapping
    public List<Location> getLocations() {
        return locationService.getLocations();
    }

    @GetMapping(path = "/by_code/{code}")
    public Location getLocationByCode(@PathVariable String code) {
        return locationService.getLocationByCode(code);

    }

    @GetMapping(path = "/by_name/{name}")
    public Location getLocationByName(@PathVariable String name) {
        return locationService.getLocationByName(name);
    }

    @GetMapping(path = "/by_initial_letter/{letter}")
    public List<Location> getLocationByInitialLetter(@PathVariable Character letter) {
        return locationService.getLocationByInitialLetter(letter);

    }

    @GetMapping(path = "/by_state_code/{code}")
    public List<Location> getLocationByStateCode(@PathVariable String code) {
        return locationService.getLocationByStateCode(code);

    }

    @GetMapping(path = "/by_states/{states}")
    public List<State> getStateByStates(@PathVariable String states) {
        return locationService.getByStates();

    }

    @GetMapping(path = "/by_states_code/{code}")
    public State getStateByCode(@PathVariable String code) {
        return locationService.getStateByCode(code);

    }

    @GetMapping(path = "/departments_with_capitals")
    public List<String> getDepartmentsWithCapitals() {
        return locationService.getDepartmentsWithCapitals();
    }

    }







