package com.viscontti.challenge002.service;

import com.viscontti.challenge002.model.Language;
import com.viscontti.challenge002.repository.LanguageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class LanguageService {
    private final LanguageRepository languageRepository;

    @Autowired
    public LanguageService(LanguageRepository languageRepository){
        this.languageRepository = languageRepository;
    }

    public Optional<Language> findByLanguageCode(String languageCode){
        return languageRepository.findByLanguageCode(languageCode);
    }

    public Language findOrCreateLanguage(String languageCode){
        return languageRepository.findByLanguageCode(languageCode)
                .orElseGet(() -> languageRepository.save(new Language(languageCode)));
    }
}
