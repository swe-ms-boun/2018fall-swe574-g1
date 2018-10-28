package com.boun.swe.mnemosyne.model;


import lombok.Getter;
import lombok.Setter;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "memory")
public class Memory {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "user_id", nullable = false)
    @NotNull
    private User user;

    @Size(max = 300)
    @NotNull
    private String title;

    @Size(max = 12000)
    @NotNull
    private String text;

    @Temporal(TemporalType.DATE)
    @Column(name = "date_from")
    private Date dateFrom;

    @Temporal(TemporalType.DATE)
    @Column(name = "date_to")
    private Date dateTo;

    @NotNull
    @Column(name = "is_published")
    private boolean isPublished;

    @NotNull
    @Column(name = "is_public")
    private boolean isPublic;

    @OneToMany
    @Column(name = "locations")
    private List<Location> locations;

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Memory{\n");
        sb.append("memory title='").append(title).append('\n');
        sb.append(", user name='").append(title).append('\n');
        sb.append(", memory text='").append(text).append('\n');
        sb.append("}\n");
        return sb.toString();
    }
}
