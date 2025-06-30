package com.viscontti.challenge002.repository;

import com.viscontti.challenge002.model.Language;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface LanguageRepository extends JpaRepository<Language, Long> {

    Optional<Language> findByLanguageCode(String languageCode);
}
