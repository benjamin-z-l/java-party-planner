package com.launchacademy.partyplanner.seeders;

import com.launchacademy.partyplanner.models.Location;
import com.launchacademy.partyplanner.services.LocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class LocationSeeder implements CommandLineRunner {
  private LocationService locationService;

  @Autowired
  public LocationSeeder(LocationService locationService) {
    this.locationService = locationService;
  }

  @Override
  public void run(String... args) throws Exception {
    if (locationService.findAllLocations().size() == 0) {
      Location l1 = new Location();
      l1.setName("Bowling Alley");
      l1.setCity("Boston");
      l1.setState("England");
      l1.setRentalPrice(120.50);
      locationService.save(l1);
      Location l2 = new Location();
      l2.setName("Kirkland Marina");
      l2.setCity("Kirkland");
      l2.setState("Washington");
      locationService.save(l2);
    }
  }
}