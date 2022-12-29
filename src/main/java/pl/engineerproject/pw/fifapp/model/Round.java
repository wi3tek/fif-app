package pl.engineerproject.pw.fifapp.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serial;
import java.io.Serializable;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Round implements Serializable {
    @Serial
    private static final long serialVersionUID = 6834844252091608740L;
    @Column
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer roundId;

    @Column
    private Date roundDate;

    @Column
    private Integer whichLeagueRound;

    @Column
    private String description;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<MatchData> matches = new LinkedList<>();

    @ManyToOne
    private League league;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Team> teams = new LinkedList<>();

    public Round(Date roundDate, Integer whichLeagueRound, String description, League league, List<MatchData> matches, List<Team> teams) {
        this.roundDate=roundDate;
        this.whichLeagueRound=whichLeagueRound;
        this.description=description;
        this.league=league;
        this.matches = matches;
        this.teams=teams;
    }
}

