package com.example.capstone_backend.repository;

import com.example.capstone_backend.domain.Memo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MemoRepository extends JpaRepository<Memo, Long> {
    List<Memo> findByNoteId(int noteId);
}