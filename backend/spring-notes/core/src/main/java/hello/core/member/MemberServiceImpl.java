package hello.core.member;

public class MemberServiceImpl implements MemberService {

    // 추상화와 구상화 모두에 의존 (DIP 위반)
    // -> 나중에 저장소를 DB 기반으로 바꾸고 싶다면
    // MemoryMemberRepository를 다른 구현체로 변경해야함
    // (OCP 위반: 확장에는 열려있고 변경에는 닫혀있어야 한다)
    private final MemberRepository memberRepository = new MemoryMemberRepository();

    @Override
    public void join(Member member) {
        memberRepository.save(member);
    }

    @Override
    public Member findMember(Long memberId) {
        return memberRepository.findById(memberId);
    }
}
