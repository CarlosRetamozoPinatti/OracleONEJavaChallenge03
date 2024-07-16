package com.forohub.ForoHub.domain.topics;

import java.time.LocalDateTime;

public record TopicSearchRequest(
        String courseName,
        String dateCreation
) {
}
