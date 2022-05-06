package com.example.study01.domain.member;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MemberRepo {
    private static Map<Long, Member> store = new HashMap<>();
    private static long seq = 0L;

    private static final MemberRepo instance = new MemberRepo();

    public static MemberRepo getInstance() {
        return instance;
    }

    private MemberRepo() {

    }

    public Member save(Member member) {
        member.setId(++seq);
        store.put(member.getId(), member);
        return member;
    }

    public Member findById(Long id) {
        return store.get(id);
    }

    public List<Member> findAll() {
        return new ArrayList<>(store.values());
    }

    public void clearStore() {
        store.clear();
    }
}
