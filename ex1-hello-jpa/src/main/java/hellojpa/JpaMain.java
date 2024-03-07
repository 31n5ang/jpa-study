package hellojpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.List;

public class JpaMain {
    public static void main(String[] args) {
        //emf 객체는 애플리케이션 시작할 때 딱 한 번만 생성해야함
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");

        //일관된 작업할 때 마다 생성 필요
        EntityManager em = emf.createEntityManager();

        EntityTransaction tx = em.getTransaction();
        tx.begin();

        try {
            Member member = new Member();
            member.setUsername("C");

            System.out.println("========");
            em.persist(member);
            System.out.println("========");
            tx.commit();
        } catch (Exception e) {
            tx.rollback();
        } finally {
            em.close();
        }

        emf.close();
    }
}
