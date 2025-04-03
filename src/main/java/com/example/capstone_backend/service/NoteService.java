package com.example.capstone_backend.service;

import com.example.capstone_backend.domain.Note;
import com.example.capstone_backend.repository.NoteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class NoteService {

    private final NoteRepository noteRepository;

    public Note saveNote(Note note) {
        return noteRepository.save(note);
    }

    public List<Note> getAllNotes() {
        return noteRepository.findAll();
    }

    public void deleteNoteById(int id) {
        noteRepository.deleteById(id);
    }

}
