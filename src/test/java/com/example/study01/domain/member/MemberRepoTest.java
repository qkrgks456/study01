package com.example.study01.domain.member;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;


class MemberRepoTest {

    MemberRepo memberRepo = MemberRepo.getInstance();


    @Test
    void save() {
        // given
        Member member = new Member("hello", 13);
        // when
        Member saveMember = memberRepo.save(member);
        // then
        Member findMember = memberRepo.findById(saveMember.getId());
        assertThat(saveMember).isEqualTo(findMember);
    }

    @Test
    void findAll() {
        // given
        Member member1 = new Member("member1", 20);
        Member member2 = new Member("member2", 30);
        memberRepo.save(member1);
        memberRepo.save(member2);
        // when
        List<Member> result = memberRepo.findAll();

        // then
        assertThat(result.size()).isEqualTo(2);
        assertThat(result).contains(member1, member2);

    }
}