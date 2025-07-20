package com.dbwls.mapping.section01.entity;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import jakarta.transaction.Transactional;

@Service
public class MemberRegistService {
    private static final Logger log = LoggerFactory.getLogger(MemberRegistService.class);

    private MemberRepository memberRepository;


    public MemberRegistService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Transactional // 메소드 수행이 잘 완료 되면 commit, 안되면 rollback
    // 데이터를 날라서 entity라는 형태로 가공해서 저장!
    public void registMember(MemberRegistDTO newMember) {
        // dto -> entity
        Member member = new Member(
                newMember.getMemberId(),
                newMember.getMemberPwd(),
                newMember.getMemberName(),
                newMember.getPhone(),
                newMember.getAddress(),
                newMember.getEnrollDate(),
                newMember.getMemberRole(),
                newMember.getStatus()
        );

        memberRepository.save(member);
    }

    /* Spring의 트랜잭션 전파 방식 : default PROPAGATION_REQUIRED
    * @Transactional이 붙은 메소드 내부에서 다시 @Transactional이 붙은 메소드를 호출하면
    * 호출 된 메소드는 호출 한 메소드와 동일한 트랜잭션 컨텍스트를 사용하게 된다. */
    @Transactional
    public String registMemberAndFindName(MemberRegistDTO newMember){
        registMember(newMember);
        return memberRepository.finNameById(newMember.getMemberId());
    }
}
