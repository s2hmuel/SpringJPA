package com.ll.springjpa.member.service;

import com.ll.springjpa.global.rsData.RsData.RsData;
import com.ll.springjpa.member.entity.Member;
import com.ll.springjpa.member.repository.MemberRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class MemberService {
    private final MemberRepository memberRepository;

    @Transactional
    public RsData<Member> join(String username, String password) {
        Member member = Member.builder()
                .username(username)
                .password(password)
                .build();

        memberRepository.save(member);

        return RsData.of("200", "%s님 가입을 환영합니다.".formatted(username), member);
    }

    public Optional<Member> findById(long id) {
        return memberRepository.findById(id);
    }
}