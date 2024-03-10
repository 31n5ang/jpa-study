package hellojpa;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Team {
    @Id @GeneratedValue
    @Column(name = "TEAM_ID")
    private Long id;
    private String name;

    //1대N 연관관계 Team(1) : Member(N), 주인은 대부분 N 쪽(외래키가 존재하는 쪽)
    @OneToMany(mappedBy = "team")
    private List<Member> members = new ArrayList<>();

    //연관관계 편의 메소드 (순수 객체 상태에서 값을 사용하기 위함)
    public void addMember(Member member) {
        member.setTeam(this);
        members.add(member);
    }

    public Team() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Member> getMembers() {
        return members;
    }

    public void setMembers(List<Member> members) {
        this.members = members;
    }
}
