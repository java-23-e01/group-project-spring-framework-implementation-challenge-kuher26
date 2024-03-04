package com.example.demo.service;

import com.example.demo.entities.Album;
import com.example.demo.repository.AlbumRepository;
import com.example.demo.repository.ArtistRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AlbumService {
  @Autowired private AlbumRepository albumRepository;
  public Album saveAlbum(Album album) {
    return albumRepository.save(album);
  }

  public List<Album> getAllAlbums() {
    return albumRepository.findAll();
  }

  public Album updateAlbum(Long id, Album updatedAlbum) {
    Optional<Album> optionalAlbum = albumRepository.findById(id);

    if (optionalAlbum.isPresent()) {
      Album existingAlbum = optionalAlbum.get();
      existingAlbum.setTitle(updatedAlbum.getTitle());
      existingAlbum.setArtist(updatedAlbum.getArtist());
      existingAlbum.setGenre(updatedAlbum.getGenre());
      existingAlbum.setStyle(updatedAlbum.getStyle());
      existingAlbum.setYear(updatedAlbum.getYear());
      return albumRepository.save(existingAlbum);
    }
    return null;
  }

  public Album deleteAlbum(Album album) {
    albumRepository.delete(album);
    return null;
  }
}
