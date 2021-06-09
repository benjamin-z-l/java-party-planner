package com.launchacademy.partyplanner.services;

import com.launchacademy.partyplanner.models.Party;
import com.launchacademy.partyplanner.repositories.PartyRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PartyService {
  private PartyRepository repository;

  @Autowired
  public PartyService(PartyRepository repository) {
    this.repository = repository;
  }

  public List<Party> findAllParties(){
    return (List<Party>) repository.findAll();
  }

  public Optional<Party> findById(Integer id){
    return repository.findById(id);
  }

  public Party save(Party party) {
    return repository.save(party);
  }
}
