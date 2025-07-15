package net.dsa.web5.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import net.dsa.web5.dto.MemberDTO;
import net.dsa.web5.entity.MemberEntity;
import net.dsa.web5.repository.MemberRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Slf4j
@Transactional
@RequiredArgsConstructor
public class MemberService {

    // 회원정보 DB
    private final MemberRepository mr;

    // 암호화 ,단순 복호화 어려움, 일치여부만 확인
    private final BCryptPasswordEncoder passwordEncoder;


    public boolean idCheck(String searchId) {

        return !mr.existsById(searchId);
    }

    public void join(MemberDTO member) {

        MemberEntity memberEntity = MemberEntity.builder()
                .memberId(member.getMemberId())
                .memberPassword(passwordEncoder.encode(member.getMemberPassword()))
                .memberName(member.getMemberName())
                .email(member.getEmail())
                .phone(member.getPhone())
                .address(member.getAddress())
                .enabled(true)
                .rolename("ROLE_USER")
                .build();

        mr.save(memberEntity);
    }
}
