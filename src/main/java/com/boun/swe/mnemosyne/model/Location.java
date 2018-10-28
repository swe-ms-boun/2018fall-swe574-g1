package com.boun.swe.mnemosyne.model;

import lombok.Getter;
import lombok.Setter;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
@Setter
@Entity
@Table(name = "location")
public class Location {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @NotNull
    @Size(max = 150)
    private String locationName;

    private double latitude;

    private double longitude;

    //private Area area;

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Location{");
        return sb.toString();
    }
}