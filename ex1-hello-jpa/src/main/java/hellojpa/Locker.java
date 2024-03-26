package hellojpa;

import javax.persistence.*;

@Entity
public class Locker {
    @Id @GeneratedValue
    @Column(name = "LOCKER_ID")
    private Long id;

    private String name;

    //주인이 아니므로 mappedBy 적용
    @OneToOne(mappedBy = "locker")
    private Member member;
}
