package practice.prcatice.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import practice.prcatice.domain.Member;
import practice.prcatice.repository.MemberRepository;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;

    public List<Member> findMembers() {
        return memberRepository.findAll();
    }

    public Optional<Member> findOne(Long memberId) {
        return memberRepository.findById(memberId);
    }

    public void save(Member member) {
        memberRepository.save(member);
    }

    public void delete(Member member) {
        memberRepository.delete(member);
    }
}
