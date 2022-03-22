package com.wflix.model.service;

import com.wflix.dto.locator.LocatorDTO;
import com.wflix.model.entities.Locator;
import com.wflix.repository.LocatorRepository;
import com.wflix.repository.MovieRepository;
import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class LocatorServiceTest {

 @InjectMocks
 private LocatorService locatorService;

 @Mock
 private LocatorRepository locatorRepository;

 @Mock
 private MovieRepository movieRepository;


    @Test
    void signIn() {

        String cpf = "12345678911";

        String expectMsg = "this CPF already exists";

        Locator locator = Locator.builder()
                .id("15632")
                .name("Willian")
                .cpf("12345678911")
                .movieList(null)
                .build();
        Mockito.doReturn(locator).when(this.locatorRepository).getByCpf(cpf);
        String expect = this.locatorService.signIn(locator);
        Assertions.assertSame(expectMsg, expect);
        Mockito.verify(this.locatorRepository, Mockito.atLeastOnce()).getByCpf(cpf);


    }

    @Test
    void listClient() {


        List<LocatorDTO> listLocators = new ArrayList<>();

        Mockito.doReturn(listLocators).when(this.locatorRepository).findAll();
        List<LocatorDTO> expect = this.locatorService.listClient();
        Mockito.verify(this.locatorRepository, Mockito.atLeastOnce()).findAll();
    }

    @Test
    void getByName() {
    }

    @Test
    void rentMovies() {
    }

    @Test
    void giveBack() {
    }

    @Test
    void signOut() {
    }
}