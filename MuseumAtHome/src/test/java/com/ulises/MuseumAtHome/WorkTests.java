package com.ulises.MuseumAtHome;

import com.ulises.MuseumAtHome.Exceptions.InsufficientStock;
import com.ulises.MuseumAtHome.entity.Work;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpServerErrorException;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class WorkTests {

    @Autowired
    private TestRestTemplate testRestTemplate;

    private Work testwork = new Work(1L, "nombre", "descripcion", 20, 20, 15.00, 10, "/valido.jpg");

    @Test
    @DirtiesContext
    public void reduceStockOverZero(){
        try {
            testwork.reduceStock(200);
            Assertions.fail();
        } catch (InsufficientStock _) {
        }
    }

    @Test
    @DirtiesContext
    public void reduceStock() throws InsufficientStock {
        assertEquals(10, testwork.getStock());
        testwork.reduceStock(4);
        assertEquals(6, testwork.getStock());
    }

    @Test
    @DirtiesContext
    public void listAccounts() {
       String url = "/works";
       Work[] works = testRestTemplate.getForObject(url, Work[].class);
        assertEquals("Guernica",works[0].getName());
    }

    @Test
    @DirtiesContext
    public void listOneAccount(){
        String url = "/works/1";
        Work work = testRestTemplate.getForObject(url, Work.class);
        assertEquals("Guernica", work.getName());
    }

    @Test
    @DirtiesContext
    public void deleteFirstAccount(){
        String url = "/works/1";
        Work work = testRestTemplate.getForObject(url, Work.class);
        assertEquals("Guernica", work.getName());
        testRestTemplate.delete("/works/1");
        url = "/works";
        Work[] works = testRestTemplate.getForObject(url, Work[].class);
        assertNotEquals("Guernica", works[0].getName());
    }

}
