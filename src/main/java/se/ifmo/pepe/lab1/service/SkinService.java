package se.ifmo.pepe.lab1.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import se.ifmo.pepe.lab1.model.Skin;
import se.ifmo.pepe.lab1.repository.SkinRepository;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Random;

@Service
public class SkinService {
    private final SkinRepository skinRepository;

    @Autowired
    public SkinService(SkinRepository skinRepository) {
        this.skinRepository = skinRepository;
    }

    public ArrayList<Skin> fetchAllSkins() {
        return new ArrayList<>(skinRepository.findAll());
    }


    public ArrayList<Skin> fetchAllApprovedSkins(Boolean approved) {
        return new ArrayList<>(skinRepository.findAllByApproved(approved));
    }


    public Skin saveSkin(Skin skin) {
        skin.setApproved(false)
                .setDlUrl(generateDownloadLink(skin.getTitle()));
        skinRepository.save(skin);
        return skin;
    }

    private String generateDownloadLink(String skinTitle) {
        /*
         * !PLACEHOLDER!
         * STRING GENERATOR WITH LENGTH BASED ON SKIN'S TITLE LENGTH
         * */
        byte[] array = new byte[skinTitle.length()];
        new Random().nextBytes(array);
        return new String(array, Charset.forName("Windows-1251"));
    }
}