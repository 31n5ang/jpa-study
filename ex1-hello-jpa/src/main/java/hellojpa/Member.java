package hellojpa;

import javax.persistence.*;

@Entity
public abstract class Member extends BaseEntity{
    @Id
    @GeneratedValue
    @Column(name = "MEMBER_ID")
    private Long id;

    @Column(name = "USERNAME")
    private String username;

    //연관관계 주인(Owner). 값 상태 변경은 "주인" 객체로부터 이루어져야함
    @ManyToOne
    @JoinColumn(name = "TEAM_ID")
    private Team team;

    //연관관계의 주인이므로 조인 칼럼
    @OneToOne
    @JoinColumn(name = "LOCKER_ID")
    private Locker locker;
    public Member() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }
}
