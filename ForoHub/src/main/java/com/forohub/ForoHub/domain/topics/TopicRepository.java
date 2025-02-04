package com.forohub.ForoHub.domain.topics;

import com.forohub.ForoHub.domain.courses.Course;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.Optional;

public interface TopicRepository extends JpaRepository<Topic, Long> {
    Optional<Topic> findByTitle(String title);
    Optional<Topic> findByMessage(String message);
    Page<Topic> findByIsDeletedFalse(Pageable pageable);
    Page<Topic> findByCourseAndDateCreationAfter(Course course, LocalDateTime dateCreation, Pageable pageable);
}
