package com.launchacademy.partyplanner.controllers;

import com.launchacademy.partyplanner.models.Party;
import com.launchacademy.partyplanner.services.LocationService;
import com.launchacademy.partyplanner.services.PartyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/parties")
public class PartyController {
  private LocationService locationService;
  private PartyService partyService;

  @Autowired
  public PartyController(LocationService locationService,
      PartyService partyService) {
    this.locationService = locationService;
    this.partyService = partyService;
  }

  @GetMapping("/new")
  public String getNewPartyForm(@ModelAttribute Party party, Model model) {
    model.addAttribute("locations", locationService.findAllLocations());
    return "parties/new";
  }

  @GetMapping("/{id}")
  public String showParty(@PathVariable Integer id, Model model) {
    model.addAttribute("party", partyService.findById(id).get());
    return "parties/show";
  }

  @PostMapping
  public String addParty(@ModelAttribute Party party) {
    partyService.save(party);
    return ("redirect:/parties/" + party.getId());
  }
}