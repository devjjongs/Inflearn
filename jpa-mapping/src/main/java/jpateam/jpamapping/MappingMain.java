package jpateam.jpamapping;

import jpateam.jpamapping.domain.Member;
import jpateam.jpamapping.domain.Team;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class MappingMain {
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

            // 팀 저장
            Team team = new Team();
            team.setName("TeamA");
            em.persist(team);

            // 회원 저장
            Member member = new Member();
            member.setUsername("member1");
            member.setTeam(team);
            em.persist(member);

            // Query
            em.flush();
            em.clear();

            // 조회
            Member findMember = em.find(Member.class, member.getId());
            Team findTeam = findMember.getTeam();
            System.out.println("findTeam : " + findTeam.getName());

            // 수정
            Team newTeam = em.find(Team.class, 100L);
            findMember.setTeam(newTeam);
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
