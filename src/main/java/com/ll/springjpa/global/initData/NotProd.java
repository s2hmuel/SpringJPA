package com.ll.springjpa.global.initData;


import com.ll.springjpa.article.service.ArticleService;
import com.ll.springjpa.global.rsData.RsData.RsData;
import com.ll.springjpa.member.entity.Member;
import com.ll.springjpa.member.service.MemberService;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;


@Profile("!prod")
@Configuration
public class NotProd {
    @Bean
    public ApplicationRunner initNotProdData(
            MemberService memberService,
            ArticleService articleService
    ) {
        return args -> {
            RsData<Member> joinRs = memberService.join("user1", "1234");
            Member member1 = memberService.join("user1", "1234").getData();
            Member member2 = memberService.join("user2", "1234").getData();

            System.out.println(joinRs.getMsg());
            articleService.write(member1.getId(), "제목1", "내용1");
            articleService.write(member1.getId(), "제목2", "내용2");

            articleService.write(member2.getId(), "제목3", "내용3");
            articleService.write(member2.getId(), "제목4", "내용4");
        };
    }
}