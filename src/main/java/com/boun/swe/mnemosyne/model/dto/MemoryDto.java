package com.boun.swe.mnemosyne.model.dto;

import com.boun.swe.mnemosyne.model.Location;
import com.boun.swe.mnemosyne.model.Media;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class MemoryDto {
    private String title;
    private String text;
    private Date dateFrom;
    private Date dateTo;
    private boolean isPublished;
    private boolean isPublic;
    private Set<Location> locations;
    private Set<Media> mediaSet;
}
