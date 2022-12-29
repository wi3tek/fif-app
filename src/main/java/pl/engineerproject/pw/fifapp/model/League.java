package pl.engineerproject.pw.fifapp.model;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@ToString
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class League implements Serializable {

    private static final long serialVersionUID = 8871472796696693981L;

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer leagueId;
    @Column(unique = true)
    private String name;
    private String description;
    private String startDate;
    private String endDate;
    private String location;
    @ManyToOne
    private User owner;
    public League(String name, String description, String startDate, String endDate, String location, User owner) {
        this.name=name;
        this.description=description;
        this.startDate=startDate;
        this.endDate=endDate;
        this.location=location;
        this.owner = owner;
    }
}
