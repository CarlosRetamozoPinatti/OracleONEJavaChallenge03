package com.forohub.ForoHub.domain.courses;

public record DataListCourse(
        Long id,
        String name,
        Category category
) {
    public DataListCourse(Course course) {
        this(
                course.getId(),
                course.getName(),
                course.getCategory()
        );
    }
}
