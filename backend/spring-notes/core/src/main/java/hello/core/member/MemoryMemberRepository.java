package hello.core.member;

import java.util.HashMap;
import java.util.Map;

public class MemoryMemberRepository implements  MemberRepository{

    // 실무에서는 ConcurrentHashMap 사용. (동시성 문제 해결)
    private static Map<Long, Member> stroe = new HashMap<>();

    @Override
    public void save(Member member) {
stroe.put(member.getId(), member);
    }

    @Override
    public Member findById(Long memberId) {
        return stroe.get(memberId);
    }
}
