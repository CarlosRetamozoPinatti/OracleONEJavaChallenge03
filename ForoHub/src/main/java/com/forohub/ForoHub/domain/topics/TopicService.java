package com.forohub.ForoHub.domain.topics;

import com.forohub.ForoHub.domain.courses.CourseRepository;
import com.forohub.ForoHub.domain.users.UserRepository;
import com.forohub.ForoHub.infra.errors.IntegrityValidation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.time.LocalDateTime;
import java.util.stream.Collectors;

@Service
public class TopicService {
    @Autowired
    private TopicRepository topicRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private CourseRepository courseRepository;

    public DataAnswerTopic createTopic(DataCreateTopic dataCreateTopic) {

        if (!userRepository.findById(dataCreateTopic.idUser()).isPresent()) {
            throw new IntegrityValidation("id user not found");
        }

        if (!courseRepository.findById(dataCreateTopic.idCourse()).isPresent()) {
            throw new IntegrityValidation("id course not found");
        }

        if (topicRepository.findByTitle(dataCreateTopic.title()).isPresent()) {
            throw new IntegrityValidation("There already exists a topic with the same title");
        }

        if (topicRepository.findByMessage(dataCreateTopic.message()).isPresent()) {
            throw new IntegrityValidation("There already exists a topic with the same message");
        }

        var user = userRepository.findById(dataCreateTopic.idUser()).get();
        var course = courseRepository.findById(dataCreateTopic.idCourse()).get();

        var topic = new Topic(
                dataCreateTopic.title(),
                dataCreateTopic.message(),
                user,
                course
        );

        topicRepository.save(topic);
        return new DataAnswerTopic(topic);
    }

    public Page<DataListTopic> getTopics(Pageable pageable) {
        Page<Topic> topicPage = topicRepository.findByIsDeletedFalse(pageable);
        return topicPage.map(DataListTopic::new);
    }

    public Page<DataListTopic> getTopicsByCourseNameAndDateCreation(String courseName, String year, Pageable pageable) {
        var course = courseRepository.findByName(courseName);
        if (course == null) {
            throw new IntegrityValidation("Course does not exist");
        }

        LocalDateTime startDate;
        try {
            int yearNumber = Integer.parseInt(year);
            startDate = LocalDateTime.of(yearNumber, 1, 1, 0, 0);
        } catch (NumberFormatException e) {
            throw new IntegrityValidation("Invalid year format");
        }

        var topics = topicRepository.findByCourseAndDateCreationAfter(course, startDate, pageable);

        var dataListTopics = topics.getContent().stream()
                .map(DataListTopic::new)
                .collect(Collectors.toList());

        return new PageImpl<>(dataListTopics, pageable, topics.getTotalElements());
    }

    public DataAnswerTopic detailsTopic(@PathVariable Long id) {
        Topic topic = topicRepository.getReferenceById(id);
        return new DataAnswerTopic(topic);
    }

    public DataAnswerTopic updateTopic(DataUpdateTopic dataUpdateTopic) {
        if (!topicRepository.findById(dataUpdateTopic.id()).isPresent()) {
            throw new IntegrityValidation("id topic not found");
        }

        Topic topic = topicRepository.getReferenceById(dataUpdateTopic.id());
        topic.putData(dataUpdateTopic);

        return new DataAnswerTopic(topic);
    }

    public void deletedTopic(Long id) {
        Topic topic = topicRepository.findById(id)
                .orElseThrow(() -> new IntegrityValidation("Topic not found with id"));

        topic.deletedTopic();
        topicRepository.save(topic);
    }
}
