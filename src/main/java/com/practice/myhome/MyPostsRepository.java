package com.practice.myhome;

import org.springframework.data.jpa.repository.JpaRepository;

public interface MyPostsRepository extends JpaRepository<MyPosts, Integer> {
}
