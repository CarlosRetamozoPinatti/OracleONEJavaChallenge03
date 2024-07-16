package com.forohub.ForoHub.domain.answer;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AnswerRepository extends JpaRepository<Answer, Long> {
    Page<Answer> findByIsDeletedFalse(Pageable pageable);
}
