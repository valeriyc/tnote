package com.vc.tnote.integration;

import com.vc.tnote.model.Note;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment= SpringBootTest.WebEnvironment.RANDOM_PORT)
public class NoteControllerTest {

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void createAndGetNotes() {
        Note note = new Note();

        note.setContent("note 1 content");
        restTemplate.postForEntity("/note", note, String.class);

        note.setContent("note 2 content");
        restTemplate.postForEntity("/note", note, String.class);

        ResponseEntity<Note[]> result = restTemplate.getForEntity( "/note", Note[].class);

        assertEquals(result.getStatusCode().value(), 200);

        assertEquals(result.getBody()[0].getContent(), "note 1 content");
        assertEquals(result.getBody()[1].getContent(), "note 2 content");
    }

}



