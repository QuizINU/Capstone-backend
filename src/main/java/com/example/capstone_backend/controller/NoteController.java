package com.example.capstone_backend.controller;

import com.example.capstone_backend.domain.Note;
import com.example.capstone_backend.service.NoteService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/notes")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class NoteController {

    private final NoteService noteService;

    @PostMapping
    public Note saveNote(@RequestBody Note note) {
        return noteService.saveNote(note);
    }

    @GetMapping
    public List<Note> getAllNotes() {
        return noteService.getAllNotes();
    }
}
