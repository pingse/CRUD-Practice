package practice.prcatice.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import practice.prcatice.domain.Member;
import practice.prcatice.exception.ResourceNotFoundException;
import practice.prcatice.service.MemberService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@Slf4j
public class MemberController {

    private final MemberService memberService;

    @PostMapping("/test/create")
    public void create(@RequestBody Member member) {
        log.info("create");
        memberService.save(member);
    }

    @GetMapping("/test/read")
    public List<Member> readAll() {
        log.info("read all");
        List<Member> members = memberService.findMembers();

        return members;
    }

    @PutMapping("/test/{id}")
    public void update(@PathVariable Long id, String name) {
        log.info("update");
        Member member = memberService.findOne(id)
                .orElseThrow(() -> new ResourceNotFoundException("Member", "id", id));

        member.setName(name);
        memberService.save(member);
    }

    @DeleteMapping("/test/delete/{id}")
    public void delete(@PathVariable Long id) {
        log.info("delete");
        Member member = memberService.findOne(id)
                .orElseThrow(() -> new ResourceNotFoundException("Member", "id", id));

        memberService.delete(member);
    }
}
