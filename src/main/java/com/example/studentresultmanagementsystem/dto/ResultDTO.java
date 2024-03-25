package com.example.studentresultmanagementsystem.dto;

public class ResultDTO {
    private Long id;
    private String courseName;
    private String studentName;
    private String score;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score;
    }

    @Override
    public String toString() {
        return "ResultDTO{" +
                "id=" + id +
                ", courseName='" + courseName + '\'' +
                ", studentName='" + studentName + '\'' +
                ", score='" + score + '\'' +
                '}';
    }
}
