package com.example.music_test.config;

import java.time.LocalDate;
import java.time.LocalDateTime;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.example.music_test.entity.Album;
import com.example.music_test.entity.Music;
import com.example.music_test.entity.User;
import com.example.music_test.repository.AlbumRepository;
import com.example.music_test.repository.MusicRepository;
import com.example.music_test.repository.UserRepository;

@Configuration
public class DataInitializer {

    @Bean
    CommandLineRunner initData(UserRepository userRepository, AlbumRepository albumRepository, MusicRepository musicRepository, PasswordEncoder passwordEncoder) {
        return args -> {
            if (userRepository.count() == 0) {
                User u = new User();
                u.setUsername("user");
                u.setPassword(passwordEncoder.encode("password"));
                u.setCreatedAt(LocalDateTime.now());
                userRepository.save(u);
            }

            if (albumRepository.count() == 0) {
                Album a1 = new Album();
                a1.setTitle("Greatest Hits");
                a1.setArtist("Sample Artist");
                a1.setReleaseDate(LocalDate.of(2020, 1, 1));
                a1.setCreatedAt(LocalDateTime.now());
                albumRepository.save(a1);

                Music m1 = new Music();
                m1.setAlbum(a1);
                m1.setTitle("First Track");
                m1.setDurationSeconds(210);
                m1.setCreatedAt(LocalDateTime.now());
                musicRepository.save(m1);

                Music m2 = new Music();
                m2.setAlbum(a1);
                m2.setTitle("Second Track");
                m2.setDurationSeconds(185);
                m2.setCreatedAt(LocalDateTime.now());
                musicRepository.save(m2);
            }
        };
    }
}
