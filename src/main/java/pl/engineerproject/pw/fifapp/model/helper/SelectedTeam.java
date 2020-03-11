package pl.engineerproject.pw.fifapp.model.helper;

import org.hibernate.id.SelectGenerator;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name="selected_teams")
public class SelectedTeam implements Serializable {

    private static final long serialVersionUID = 7496623492525099548L;

    @Id
    @Column(name="selected_team_id")
    private Integer selectedTeamId;
    @Column(name="team_id")
    private Integer teamId;
    @Column(name="round_round_id")
    private Integer roundId;

    public SelectedTeam(Integer selectedTeamId, Integer teamId, Integer roundId) {
        this.selectedTeamId = selectedTeamId;
        this.teamId = teamId;
        this.roundId = roundId;
    }

    public SelectedTeam() {

    }

    public Integer getSelectedTeamId() {
        return selectedTeamId;
    }

    public void setSelectedTeamId(Integer selectedTeamId) {
        this.selectedTeamId = selectedTeamId;
    }

    public Integer getTeamId() {
        return teamId;
    }

    public void setTeamId(Integer teamId) {
        this.teamId = teamId;
    }

    public Integer getRoundId() {
        return roundId;
    }

    public void setRoundId(Integer roundId) {
        this.roundId = roundId;
    }
}
