package com.example.capstone_backend.controller;

import com.example.capstone_backend.domain.Note;
import com.example.capstone_backend.service.NoteService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/notes")
@RequiredArgsConstructor
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

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteNote(@PathVariable int id) {
        noteService.deleteNoteById(id);
        return ResponseEntity.noContent().build();
    }
}
