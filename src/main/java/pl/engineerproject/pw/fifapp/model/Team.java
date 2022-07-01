package pl.engineerproject.pw.fifapp.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Team implements Serializable {


    private static final long serialVersionUID = 8221849130562357797L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Integer teamId;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private Integer overallRating;

    @Column
    private String logoUrl;

    @Enumerated(EnumType.STRING)
    TeamType teamType;

    public Team(String name, Integer overallRating, String logoUrl) {
        this.name = name;
        this.overallRating = overallRating;
        this.logoUrl = logoUrl;
    }

    public Team(String name, Integer overallRating, String logoUrl, TeamType teamType) {
        this.name = name;
        this.overallRating = overallRating;
        this.logoUrl = logoUrl;
        this.teamType=teamType;
    }
}
