package com.viscontti.challenge002;

import com.viscontti.challenge002.dto.AuthorDTO;
import com.viscontti.challenge002.dto.BookDTO;
import com.viscontti.challenge002.model.Book;
import com.viscontti.challenge002.service.LanguageService;
import com.viscontti.challenge002.util.BookMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
public class BookMapperTest {
    @Mock
    private LanguageService languageService;
    BookMapper bookMapper;

    @BeforeEach
    void setup(){
        bookMapper = new BookMapper(languageService);
    }





    @Test
    void testMapToEntity_ShouldMapAllFieldsCorrectly(){
        AuthorDTO author1 = new AuthorDTO("Albert Camus",
                                          1679,
                                          1754);
        List<AuthorDTO> authors = new ArrayList<>();
        authors.add(author1);
        List<String> languages = new ArrayList<>();
        languages.add("fr");
        BookDTO bookDTO = new BookDTO("L'Étranger",
                                      authors,
                                      languages,
                                      5275924);
        Book testBook = bookMapper.toEntity(bookDTO);

        assertEquals("L'Étranger", testBook.getName());

    }

}
