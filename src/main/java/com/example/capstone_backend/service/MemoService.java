package com.example.capstone_backend.service;

import com.example.capstone_backend.domain.Memo;
import com.example.capstone_backend.domain.Note;
import com.example.capstone_backend.dto.MemoRequest;
import com.example.capstone_backend.repository.MemoRepository;
import com.example.capstone_backend.repository.NoteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MemoService {

    private final MemoRepository memoRepository;
    private final NoteRepository noteRepository;

    public Memo addMemo(int noteId, MemoRequest request) {
        try {
            Note note = noteRepository.findById(noteId)
                    .orElseThrow(() -> new IllegalArgumentException("Note not found"));

            Memo memo = Memo.builder()
                    .content(request.getContent())
                    .note(note)
                    .build();

            return memoRepository.save(memo);
        } catch (Exception e) {
            // 예외 발생 시 로깅
            System.err.println("Error in adding memo: " + e.getMessage());
            throw new RuntimeException("Failed to add memo", e);
        }
    }

    public List<Memo> getMemosByNoteId(int noteId) {
        return memoRepository.findByNoteId(noteId);
    }

    public void deleteMemo(Long memoId) {
        memoRepository.deleteById(memoId);
    }
}

