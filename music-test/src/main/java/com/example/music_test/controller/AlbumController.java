package com.example.music_test.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.music_test.service.AlbumService;

@Controller
public class AlbumController {

    private final AlbumService albumService;

    public AlbumController(AlbumService albumService) {
        this.albumService = albumService;
    }

    @GetMapping("/albums")
    public String list(Model model) {
        model.addAttribute("albums", albumService.findAll());
        return "albums";
    }

    @GetMapping("/albums/{id}")
    public String detail(@PathVariable Long id, Model model) {
        model.addAttribute("album", albumService.findById(id));
        return "album_detail";
    }
}
