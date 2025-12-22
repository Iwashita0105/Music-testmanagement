package com.example.music_test.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.music_test.entity.Album;

public interface AlbumRepository extends JpaRepository<Album, Long> {

}
