package com.example.music_test.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.music_test.entity.Music;

public interface MusicRepository extends JpaRepository<Music, Long> {
    List<Music> findByAlbumId(Long albumId);
}
