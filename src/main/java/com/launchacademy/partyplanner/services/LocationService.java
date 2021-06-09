package com.launchacademy.partyplanner.services;

import com.launchacademy.partyplanner.models.Location;
import com.launchacademy.partyplanner.repositories.LocationRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LocationService {
  private LocationRepository locationRepository;

  @Autowired
  public LocationService(LocationRepository locationRepository) {
    this.locationRepository = locationRepository;
  }

  public List<Location> findAllLocations(){
    return (List<Location>) locationRepository.findAll();
  }

  public Optional<Location> findLocationById(Integer id){
    return locationRepository.findById(id);
  }

  public Location save(Location location) {
    return locationRepository.save(location);
  }
}