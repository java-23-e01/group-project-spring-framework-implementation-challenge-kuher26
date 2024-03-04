package com.example.demo.service;

import com.example.demo.entities.Artist;
import com.example.demo.repository.ArtistRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ArtistService {
    @Autowired private ArtistRepository ArtistRepository;
    public Artist saveArtist(Artist Artist) {
        return ArtistRepository.save(Artist);
    }

    public List<Artist> getAllArtists() {
        return ArtistRepository.findAll();
    }

    public Artist updateArtist(Long id, Artist updatedArtist) {
        Optional<Artist> optionalArtist = ArtistRepository.findById(id);

        if (optionalArtist.isPresent()) {
            Artist existingArtist = optionalArtist.get();
            existingArtist.setName(updatedArtist.getName());
            return ArtistRepository.save(existingArtist);
        }
        return null;
    }

    public Artist deleteArtist(Artist Artist) {
        ArtistRepository.delete(Artist);
        return null;
    }
}
