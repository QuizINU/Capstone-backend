package com.example.capstone_backend.controller;

import com.example.capstone_backend.domain.Memo;
import com.example.capstone_backend.dto.MemoRequest;
import com.example.capstone_backend.service.MemoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/notes")
@RequiredArgsConstructor
public class MemoController {

    private final MemoService memoService;

    @GetMapping("/{noteId}/memos")
    public ResponseEntity<List<Memo>> getMemos(@PathVariable int noteId) {
        return ResponseEntity.ok(memoService.getMemosByNoteId(noteId));
    }

    @PostMapping("/{noteId}/memos")
    public ResponseEntity<Memo> createMemo(
            @PathVariable int noteId,
            @RequestBody MemoRequest request) {

        Memo created = memoService.addMemo(noteId, request);
        return ResponseEntity.ok(created);
    }

    @DeleteMapping("/memos/{memoId}")
    public ResponseEntity<Void> deleteMemo(@PathVariable Long memoId) {
        memoService.deleteMemo(memoId);
        return ResponseEntity.noContent().build();
    }
}
