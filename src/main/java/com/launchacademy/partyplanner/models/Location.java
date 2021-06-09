package com.launchacademy.partyplanner.models;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "locations")
public class Location {
  @Id
  @SequenceGenerator(name = "location_generator", sequenceName = "locations_id_seq", allocationSize = 1)
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "location_generator")
  @Column(name = "id")
  private Integer id;

  @Column(name = "name")
  private String name;

  @Column(name = "city")
  private String city;

  @Column(name = "state")
  private String state;

  @Column(name = "rental_price",columnDefinition = "NUMERIC")
  private Double rentalPrice;

  @OneToMany(mappedBy = "location")
  private List<Party> parties = new ArrayList<>();
}