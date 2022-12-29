package pl.engineerproject.pw.fifapp.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
//@SequenceGenerator(name="match_seq", allocationSize=10000)
public class MatchData implements Serializable {
    private static final long serialVersionUID = 6477919665194573452L;

    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Integer matchId;

    @Column
    private LocalDateTime matchDate;

    @OneToOne
    @JoinColumn(nullable = false)
    private Player homeFirstPlayer;

    @OneToOne
    @JoinColumn(nullable = false)
    private Player homeSecondPlayer;

    @OneToOne
    @JoinColumn(nullable = false)
    private Player awayFirstPlayer;

    @OneToOne
    @JoinColumn(nullable = false)
    private Player awaySecondPlayer;

    @Column
    private Integer homeGoals;

    @Column
    private Integer awayGoals;

    @OneToOne
    @JoinColumn(nullable = false)
    private Team homeTeam;

    @OneToOne
    @JoinColumn(nullable = false)
    private Team awayTeam;

    @Column
    private String comment;

    @Column
    private LocalDateTime updateDate;

    @Column
    private Character matchType;

    @ManyToOne
    private Round round; //eventually one element List

    @ManyToOne
    private League league;


    public MatchData(LocalDateTime matchDate, Player homeFirstPlayer, Player homeSecondPlayer, Player awayFirstPlayer, Player awaySecondPlayer, Integer homeGoals, Integer awayGoals, Team homeTeam, Team awayTeam, String comment, LocalDateTime updateDate, Character matchType) {
        this.matchDate = matchDate;
        this.homeFirstPlayer = homeFirstPlayer;
        this.homeSecondPlayer = homeSecondPlayer;
        this.awayFirstPlayer = awayFirstPlayer;
        this.awaySecondPlayer = awaySecondPlayer;
        this.homeGoals = homeGoals;
        this.awayGoals = awayGoals;
        this.homeTeam = homeTeam;
        this.awayTeam = awayTeam;
        this.comment = comment;
        this.updateDate = updateDate;
        this.matchType = matchType;
    }
}
