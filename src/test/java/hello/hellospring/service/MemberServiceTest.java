package hello.hellospring.service;

import hello.hellospring.domain.Member;
import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import hello.hellospring.repository.MemoryMemberRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


class MemberServiceTest {
    MemberService memberService;
    MemoryMemberRepository memoryMemberRepository;
    @BeforeEach
    void beforeEach(){
        memoryMemberRepository = new MemoryMemberRepository();
        memberService = new MemberService(memoryMemberRepository);
    }
    @AfterEach
    void afterEach(){
        memoryMemberRepository.clearStore();
    }

    @Test
    void join() {
        // given
        Member member = new Member();
        member.setName("member");
        // when
        Long memberId = memberService.join(member);
        // then
        Member foundMember = memberService.findOne(memberId).get();
        assertThat(memberId).isEqualTo(foundMember.getId());
    }

    @Test
    void duplicateJoin() {
        // given
        Member member1 = new Member();
        member1.setName("member");
        Member member2 = new Member();
        member2.setName("member");

        // when
        memberService.join(member1);
        IllegalStateException e = assertThrows(IllegalStateException.class, ()->{
            memberService.join(member2);
        });

        // then
        assertThat(e.getMessage()).isEqualTo("member already exists");

    }
    @Test
    void findMembers() {
    }

    @Test
    void findOne() {
    }
}