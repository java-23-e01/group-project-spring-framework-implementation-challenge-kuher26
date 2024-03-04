package com.example.demo.controller;

import com.example.demo.entities.Album;
import com.example.demo.service.AlbumService;
import com.example.demo.service.ArtistService;
import org.slf4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AlbumController {
    private final AlbumService albumService;
    private final ArtistService artistService;
    private final Logger logger;

    // Constructor injection for services and logger
    public AlbumController(AlbumService albumService, ArtistService artistService, Logger logger) {
        this.albumService = albumService;
        this.artistService = artistService;
        this.logger = logger;
    }

    @GetMapping("/enter-album")
    public String showAlbumForm(Model model) {
        model.addAttribute("album", new Album());
        model.addAttribute("artists", artistService.getAllArtists());
        return "album";
    }

    @PostMapping("/save-album")
    public String saveAlbum(@ModelAttribute Album album) {
        albumService.saveAlbum(album);

        // Log existing artists before redirecting
        logger.debug("Existing Artists: {}", artistService.getAllArtists());

        return "redirect:/enter-album";
    }
}
