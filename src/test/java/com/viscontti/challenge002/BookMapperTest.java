package com.viscontti.challenge002;

import com.viscontti.challenge002.dto.AuthorDTO;
import com.viscontti.challenge002.dto.BookDTO;
import com.viscontti.challenge002.model.Author;
import com.viscontti.challenge002.model.Book;
import com.viscontti.challenge002.service.LanguageService;
import com.viscontti.challenge002.util.BookMapper;
import com.viscontti.challenge002.util.TestLogger;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;
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
    void logTestInfo(TestInfo testInfo){
        System.out.printf("### Running test:\t%s%n",
                          testInfo.getDisplayName());
    }

    @BeforeEach
    void setup(){
        bookMapper = new BookMapper(languageService);
    }





    @DisplayName("Should correctly map BookDTO to Book")
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

        TestLogger.assertWithLog("Book Title",
                                 "L'Étranger", testBook.getName());
        TestLogger.assertWithLog("Book Author",
                                 "Albert Camus",
                                 testBook.getAuthors().getFirst().getName());

    }

}
