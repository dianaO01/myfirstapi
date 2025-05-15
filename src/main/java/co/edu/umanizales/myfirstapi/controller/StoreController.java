package co.edu.umanizales.myfirstapi.controller;

import co.edu.umanizales.myfirstapi.model.Store;
import co.edu.umanizales.myfirstapi.service.StoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path =  "/store")
public class StoreController {

    @Autowired
      private StoreService storeService;

    @GetMapping
      public List<Store> getAllStores() {
          return storeService.getStores();
    }
}
