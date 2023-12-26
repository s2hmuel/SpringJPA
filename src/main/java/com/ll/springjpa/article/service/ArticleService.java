package com.ll.springjpa.article.service;

import com.ll.springjpa.article.entity.Article;
import com.ll.springjpa.article.repository.ArticleRepository;
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
public class ArticleService {
    private final ArticleRepository articleRepository;

    @Transactional
    public RsData<Article> write(long authorId, String title, String body) {
        Article article = Article.builder()
                .author(Member.builder().id(authorId).build())
                .title(title)
                .body(body)
                .build();

        articleRepository.save(article);

        return RsData.of("200", "%d번 게시물이 작성되었습니다.".formatted(article.getId()), article);
    }

    public Optional<Article> findById(long id) {
        return articleRepository.findById(id);
    }
}