package com.vc.tnote.controller;

import com.vc.tnote.model.Note;
import com.vc.tnote.service.NoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/note")
public class NoteController {

    @Autowired
    NoteService noteService;

    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    List<Note> getAllNotes() {
        return noteService.getAllNotes();
    }

    @RequestMapping(method = RequestMethod.POST)
    @ResponseBody
    ResponseEntity<Note> addNote(@RequestBody Note note) {
        noteService.addNote(note);
        return ResponseEntity.ok().build();
    }

}
