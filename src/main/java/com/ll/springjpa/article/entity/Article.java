package com.ll.springjpa.article.entity;

import com.ll.springjpa.member.entity.Member;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.*;

import static jakarta.persistence.GenerationType.IDENTITY;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
// 생성자의 접근 수준을 protect로 설정. 같은 패키지 내의 클래스나 상속받는 클래스에서만 이 생성자 사용 가능 의미
@AllArgsConstructor(access = AccessLevel.PROTECTED)
@Builder
@Getter
@Setter
@EqualsAndHashCode
public class Article {

    @GeneratedValue(strategy = IDENTITY)
    @EqualsAndHashCode.Include
    @Id
    private Long id;
    private String title;
    private String body;
    @ManyToOne
    private Member author;
}