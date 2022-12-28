package com.practice.myhome;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
public class MyPosts {
    @Id
    @Column(nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer postId;
    @Column(nullable = false)
    private String userName;
    @Column(length = 200)
    private String subject;
    private String content;
    private LocalDateTime postedDate;

    @Builder
    public MyPosts(String userName, String subject, String content, LocalDateTime localDateTime) {
        this.userName = userName;
        this.subject = subject;
        this.content = content;
        this.postedDate = localDateTime;
    }

    public void update(String subject, String content) {
        this.subject = subject;
        this.content = content;
    }
}
