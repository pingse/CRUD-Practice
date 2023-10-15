package practice.prcatice;

import jakarta.persistence.Id;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;
import practice.prcatice.domain.Member;
import practice.prcatice.exception.ResourceNotFoundException;
import practice.prcatice.repository.MemberRepository;

import java.util.Optional;

@SpringBootTest
@Transactional
@Rollback(value = false)
public class CrudTest {

    @Autowired
    MemberRepository memberRepository;

    @Test
    public void create() throws Exception {
        //given
        Member member = new Member();
        member.setName("HI");
        //when
        memberRepository.save(member);
        //then
    }

    @Test
    public void read() throws Exception {
        //given
        Member member = new Member();
        member.setName("HI");
        //when
        memberRepository.save(member);
        Optional<Member> savedId = memberRepository.findById(1L);
        //then
        System.out.println("MemberId = " + savedId.get().getId());
        System.out.println("Name = " + savedId.get().getName());
    }

    @Test
    public void update() throws Exception {
        //given
        Member member = new Member();
        member.setName("HI");

        Member member2 = new Member();
        member2.setName("HI");
        //when
        memberRepository.save(member);
        memberRepository.save(member2);

        Optional<Member> member1 = memberRepository.findById(1L);
        member1.get().setName("Hello");
        //then
    }

    @Test
    public void delete() throws Exception {
        //given
        Member member = new Member();
        member.setName("HI");

        Member member2 = new Member();
        member2.setName("HI");
        //when
        memberRepository.save(member);
        memberRepository.save(member2);

        Member member3 = memberRepository.findById(2L)
                .orElseThrow(() -> new ResourceNotFoundException("Member", "id", 2L));

        //then
        memberRepository.delete(member3);
    }
}
