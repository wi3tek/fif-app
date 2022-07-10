package pl.engineerproject.pw.fifapp.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
//@SequenceGenerator(name="player_seq",initialValue = 30, allocationSize=1000)
public class Player implements Serializable {

    private static final long serialVersionUID = 8066347468898311564L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY )
    @Column
    private Integer playerId;

    @Column
    private String name;

    @Column(unique = true)
    private String alias;

    @Column
    private Date dateOfBirth;

    @Column
    private Date joinDate;

    @Column
    private Date lastModificationDate;

    @OneToOne
    private User owner;


    public Player(String name, String alias, Date dateOfBirth, Date joinDate, Date lastModificationDate) {
        this.name=name;
        this.alias=alias;
        this.dateOfBirth=dateOfBirth;
        this.joinDate=joinDate;
        this.lastModificationDate=lastModificationDate;

    }
}

