package com.launchacademy.partyplanner.controllers;

import com.launchacademy.partyplanner.models.Location;
import com.launchacademy.partyplanner.services.LocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping
public class LocationController {
  private LocationService locationService;

  @Autowired
  public LocationController(LocationService locationService){
    this.locationService = locationService;
  }

  @GetMapping
  public String getLocationsRedirect(){
    return "redirect:/locations";
  }

  @GetMapping("/locations")
  public String getLocations(Model model){
    model.addAttribute("locations", locationService.findAllLocations());
    return "locations/index";
  }

  @GetMapping("/locations/{id}")
  public String getLocationById(@PathVariable Integer id, Model model){
    model.addAttribute("location", locationService.findLocationById(id).get());
    return "locations/show";
  }

  @GetMapping("/locations/new")
  public String getLocationForm(@ModelAttribute Location location) {
    return "locations/new";
  }

  @PostMapping("/locations")
  public String addLocation(@ModelAttribute Location location) {
    locationService.save(location);
    return "redirect:/locations";
  }
}