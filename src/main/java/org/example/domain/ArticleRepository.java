package org.example.domain;

import org.example.base.CommonUtill;

import java.util.ArrayList;

public class ArticleRepository {
    CommonUtill commonUtill = new CommonUtill();
    ArrayList<Article> articleList = new ArrayList<>();
    int startId = 1;

    // 재시험^^
    public ArrayList<Article> keywordArticle(String keyword){
        ArrayList<Article>searchedList = new ArrayList<>();
        Article article = new Article();
        if (article.getTitle().contains(keyword)){
            return searchedList;
        }
        return searchedList;
    }

    public Article idArticle(int id){
        Article article = new Article();
        if(article.getId() == id){
            return article;
        }
        return null;
    }
    public void deleteArticle(){
        Article article = new Article();
        articleList.remove(article);
    }

    public void updateArticle(Article article, String newTitle, String newBody){
        article.setTitle(newTitle);
        article.setBody(newBody);
    }
    public ArrayList<Article>findAll(){
        return articleList;
    }
    public Article addArticle(String title, String body){
        Article article = new Article(startId, title, body, 0, commonUtill.getDateTime());
        articleList.add(article);
        startId++;
        return article;
    }
}
