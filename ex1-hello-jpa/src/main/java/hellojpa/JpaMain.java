package hellojpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.List;

public class JpaMain {
    public static void main(String[] args) {
        // 변수를 받으면 emf 반환
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");

        // EntityManager 생성
        EntityManager em = emf.createEntityManager();

        // Transacrion 생성
        EntityTransaction tx = em.getTransaction();
        tx.begin();

        try {
            // 객체 저장 로직
            /*Member member = new Member();

            member.setId(2L);
            member.setName("HelloB");

            em.persist(member);*/


            // 객체 조회 로직
            /*Member findMember = em.find(Member.class, 1L);

            System.out.println("findMember.id = " + findMember.getId());
            System.out.println("findMember.name = " + findMember.getName());*/


            // 객체 삭제 로직
            /*Member finMember = em.find(Member.class, 1L);

            em.remove(finMember);*/


            // 객체 수정 로직
            /*Member findMember = em.find(Member.class, 1L);
            // JPA가 변경 사항 확인 후 update
            findMember.setName("HelloJPA");*/


            // JPQL(객체지향 쿼리)
            List<Member> result = em.createQuery("select m from Member as m", Member.class)

                    // 페이징 쿼리
                    /*// ()부터
                    .setFirstResult(0)
                    // ()개 조회
                    .setMaxResults(1)*/

                    .getResultList();

            for (Member member : result) {
                System.out.println("member.name = " + member.getName());
            }


            // 커밋
            tx.commit();
        } catch (Exception e) {
            // 롤백
            tx.rollback();

        } finally {
            // EntityManager 종료
            em.close();
        }

        // EntityManagerFactory 종료
        emf.close();
    }
}
