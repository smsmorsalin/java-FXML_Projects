package com.example.devlop_research_article;

import java.time.LocalDate;

public class Article {
    private String Title;
    private String Author;
    private String Article_Type;
    private LocalDate Publication_date;
    private boolean Citation_status;
    private int No_of_Authors;

    public Article(String title, String author, String article_Type, LocalDate publication_date, boolean citation_status, int no_of_Authors) {
        Title = title;
        Author = author;
        Article_Type = article_Type;
        Publication_date = publication_date;
        Citation_status = citation_status;
        No_of_Authors = no_of_Authors;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public String getAuthor() {
        return Author;
    }

    public void setAuthor(String author) {
        Author = author;
    }

    public String getArticle_Type() {
        return Article_Type;
    }

    public void setArticle_Type(String article_Type) {
        Article_Type = article_Type;
    }

    public LocalDate getPublication_date() {
        return Publication_date;
    }

    public void setPublication_date(LocalDate publication_date) {
        Publication_date = publication_date;
    }

    public boolean isCitation_status() {
        return Citation_status;
    }

    public void setCitation_status(boolean citation_status) {
        Citation_status = citation_status;
    }

    public int getNo_of_Authors() {
        return No_of_Authors;
    }

    public void setNo_of_Authors(int no_of_Authors) {
        No_of_Authors = no_of_Authors;
    }

    @Override
    public String toString() {
        return "Article{" +
                "Title='" + Title + '\'' +
                ", Author='" + Author + '\'' +
                ", Article_Type='" + Article_Type + '\'' +
                ", Publication_date=" + Publication_date +
                ", Citation_status=" + Citation_status +
                ", No_of_Authors=" + No_of_Authors +
                '}';
    }
}
