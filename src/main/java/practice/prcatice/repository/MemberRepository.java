package practice.prcatice.repository;

import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import practice.prcatice.domain.Member;

@Repository
public interface MemberRepository extends JpaRepository<Member, Long> {
}
