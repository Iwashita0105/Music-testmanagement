package com.example.music_test.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.music_test.entity.Favorite;

public interface FavoriteRepository extends JpaRepository<Favorite, Long> {

}
