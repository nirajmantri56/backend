package com.project.backend.Entity;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "projects")
public class Project {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "project_id")
    private int projectId;

    private String project_type;

    private String department;

    private String category;

    @Column(name = "project_title")
    private String projectTitle;

    @Column(name = "project_statement")
    private String projectStatement;

    @Column(name = "teck_stack")
    private String techStack;

    private String group_members;

    private String faculty_name;

    private String faculty_email;

    private String domain;
    
    @Column(name = "project_githubLink")
    private String githubLink;

    @Column(name = "project_srsUploadedLink")
    private String srsUploadedLink;

    @Column(name = "project_videoUploadedLink")
    private String videoUploadedLink;

    @Column(name = "project_tags")
    private String stringTag;

    public String getStringTag() {
        return stringTag;
    }

    public void setStringTag(String stringTag) {
        this.stringTag = stringTag;
    }

    private String paperlink;
    
    
    @ManyToOne
    @JoinColumn(name = "user_id")
    @JsonIgnore
    private User user;

    public int getProjectId() {
        return projectId;
    }

    public void setProjectId(int projectId) {
        this.projectId = projectId;
    }

    public String getProjectTitle() {
        return projectTitle;
    }

    public void setProjectTitle(String projectTitle) {
        this.projectTitle = projectTitle;
    }

    public String getProjectStatement() {
        return projectStatement;
    }

    public void setProjectStatement(String projectStatement) {
        this.projectStatement = projectStatement;
    }

    public String getTechStack() {
        return techStack;
    }

    public void setTechStack(String techStack) {
        this.techStack = techStack;
    }

    public String getGroup_members() {
        return group_members;
    }

    public void setGroup_members(String group_members) {
        this.group_members = group_members;
    }

    public String getGithubLink() {
        return githubLink;
    }

    public void setGithubLink(String githubLink) {
        this.githubLink = githubLink;
    }

    public String getSrsUploadedLink() {
        return srsUploadedLink;
    }

    public void setSrsUploadedLink(String srsUploadedLink) {
        this.srsUploadedLink = srsUploadedLink;
    }

    public String getVideoUploadedLink() {
        return videoUploadedLink;
    }

    public void setVideoUploadedLink(String videoUploadedLink) {
        this.videoUploadedLink = videoUploadedLink;
    }

    public User getUser() {
        return user;
    }

    public String getFaculty_name() {
        return faculty_name;
    }

    public void setFaculty_name(String faculty_name) {
        this.faculty_name = faculty_name;
    }

    public String getFaculty_email() {
        return faculty_email;
    }

    public void setFaculty_email(String faculty_email) {
        this.faculty_email = faculty_email;
    }

    public void setUser(User user) {
        this.user = user;
    }
    
    public String getProject_type() {
        return project_type;
    }

    public void setProject_type(String project_type) {
        this.project_type = project_type;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getDomain() {
        return domain;
    }

    public void setDomain(String domain) {
        this.domain = domain;
    }

    public String getPaperlink() {
        return paperlink;
    }

    public void setPaperlink(String paperlink) {
        this.paperlink = paperlink;
    }

    public Project(int projectId, String project_type, String department, String category, String projectTitle,
            String projectStatement, String techStack, String group_members, String faculty_name,
            String faculty_email, String domain, String githubLink, String srsUploadedLink, String videoUploadedLink,
            String stringTag, String paperlink, User user) {
        this.projectId = projectId;
        this.project_type = project_type;
        this.department = department;
        this.category = category;
        this.projectTitle = projectTitle;
        this.projectStatement = projectStatement;
        this.techStack = techStack;
        this.group_members = group_members;
        this.faculty_name = faculty_name;
        this.faculty_email = faculty_email;
        this.domain = domain;
        this.githubLink = githubLink;
        this.srsUploadedLink = srsUploadedLink;
        this.videoUploadedLink = videoUploadedLink;
        this.stringTag = stringTag;
        this.paperlink = paperlink;
        this.user = user;
    }

    @Override
    public String toString() {
        return "Project [projectId=" + projectId + ", project_type=" + project_type + ", department=" + department
                + ", category=" + category + ", projectTitle=" + projectTitle + ", projectStatement=" + projectStatement
                + ", techStack=" + techStack + ", group_members=" + group_members + ", faculty_name=" + faculty_name
                + ", faculty_email=" + faculty_email + ", domain=" + domain + ", githubLink=" + githubLink
                + ", srsUploadedLink=" + srsUploadedLink + ", videoUploadedLink=" + videoUploadedLink + ", tags=" + stringTag
                + ", paperlink=" + paperlink + ", user=" + user + "]";
    }

    public Project() {
    }

}
