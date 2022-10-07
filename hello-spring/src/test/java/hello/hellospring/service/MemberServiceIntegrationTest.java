package hello.hellospring.service;

import hello.hellospring.domain.Member;
import hello.hellospring.repository.MemberRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
@Transactional // test를 시작할때 트랜잭션을 먼저 실행을하고 DB에 데이터를 인서트 쿼리로 다 넣고 테스트가 끝나면 rollback을 해줌
class MemberServiceIntegrationTest {

    @Autowired
    MemberService memberService; // TestCase는 필드기반으로 Autowired 받아도 무방
    @Autowired
    MemberRepository memberRepository;

    @Test
    void join() {
        // given
        Member member = new Member();
        member.setName("spring");
        // when

        Long saveId = memberService.join(member);

        // then
        Member findMember = memberService.findOne(saveId).get();
        assertThat(member.getName()).isEqualTo(findMember.getName());
    }

    @Test
    public void duplicateMemberTest() {
        // given
        Member member1 = new Member();
        member1.setName("spring");

        Member member2 = new Member();
        member2.setName("spring");
        // when
        memberService.join(member1);
        IllegalStateException e = assertThrows(IllegalStateException.class, () -> memberService.join(member2));// nullpointerException이 들어가게된다면?? -> test실패

        assertThat(e.getMessage()).isEqualTo("이미 존재하는 회원입니다.");


        /*try {
            memberService.join(member2);
           fail();
        } catch (IllegalStateException e) {
            assertThat(e.getMessage()).isEqualTo("이미 존재하는 회원입니다.");
        }*/


        // then
    }
}