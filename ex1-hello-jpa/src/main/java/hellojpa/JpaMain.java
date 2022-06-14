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
        // Transacrion 시작
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
            /*List<Member> result = em.createQuery("select m from Member as m", Member.class)

                    // 페이징 쿼리
                    // ()부터
                    .setFirstResult(0)
                    // ()개 조회
                    .setMaxResults(1)

                    .getResultList();

            for (Member member : result) {
                System.out.println("member.name = " + member.getName());
            }*/

            // 영속성 컨텍스트
            /*//객체를 생성한 상태(비영속)
            Member member = new Member();
            member.setId(101L);
            member.setName("HelloJPA");

            //객체를 저장한 상태(영속)
            System.out.println("=== Before ===");
            em.persist(member);
            System.out.println("=== After ===");

            //1차 캐시에서 조회
            Member findMember1 = em.find(Member.class, 101L);
//            System.out.println("findMember.id = " + findMember.getId());
//            System.out.println("findMember.name = " + findMember.getName());
            Member findMember2 = em.find(Member.class, 101L);

            System.out.println("result = " + (findMember1 == findMember2));

            //쓰기 지연 엔티티 등록
            Member member1 = new Member(150L, "A");
            Member member2 = new Member(160L, "B");

            em.persist(member1);
            em.persist(member2);
            System.out.println("======================");*/

            // 엔티티 수정(변경 감지)
            /*//엔티티 조회
            Member member = em.find(Member.class, 150L);
            //엔티티 데이터 수정
            member.setName("ZZZZZ");

            System.out.println("===============");*/

            // 엔티티 삭제
            /*//삭제 대상 엔티티 조회
            Member member = em.find(Member.class, 150L);

            em.remove(member);*/

            // 커밋(커밋하는 순간 insert sql을 DB에 전달)
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
