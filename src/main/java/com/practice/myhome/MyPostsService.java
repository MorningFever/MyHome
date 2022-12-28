package com.practice.myhome;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

import java.util.List;

@RequiredArgsConstructor
@Service
public class MyPostsService {
    private final MyPostsRepository myPostsRepository;

    public List<MyPosts> getBbsList() {
        return this.myPostsRepository.findAll();
    }

    public MyPosts getMyPosts(Integer id) {
        Optional<MyPosts> myPostsOptional = this.myPostsRepository.findById(id);
        if (myPostsOptional.isPresent()) {
            return myPostsOptional.get();
        } else {
            throw new RuntimeException();
        }
    }


    public void create(String userName, String subject, String content) {
        MyPosts p = new MyPosts.MyPostsBuilder()
                .userName(userName)
                .subject(subject)
                .content(content)
                .localDateTime(LocalDateTime.now())
                .build();
        this.myPostsRepository.save(p);
    }

    public void updateById(Integer id, String subject, String content) {
        Optional<MyPosts> p = this.myPostsRepository.findById(id);
        if (p.isPresent()) {
            p.get().update(subject, content);
            this.myPostsRepository.save(p.get());
        } else {
            throw new RuntimeException();
        }
    }

    public void delete(Integer id) {
        Optional<MyPosts> p = this.myPostsRepository.findById(id);
        if (p.isPresent()) {
            this.myPostsRepository.delete(p.get());
        }
    }

}
