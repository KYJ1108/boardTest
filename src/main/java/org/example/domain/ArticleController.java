package org.example.domain;

import org.example.base.CommonUtill;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Scanner;

public class ArticleController {
    CommonUtill commonUtill = new CommonUtill();
    ArticleRepository articleRepository = new ArticleRepository();
    ArticleView articleView = new ArticleView();
    Scanner scan = commonUtill.getScan();
    int WRONG_VALUE = -1;

    public void add(){
        // 등록
        System.out.print("게시물 제목을 입력해주세요 : ");
        String title = scan.nextLine();
        System.out.print("게시물 내용을 입력해주세요 : ");
        String body = scan.nextLine();
        articleRepository.addArticle(title,body);
        System.out.println("게시물이 등록되었습니다.");
    }
    public void list(){
        // 리스트
        ArrayList<Article>articleList = articleRepository.findAll();
        articleView.listArticle(articleList);
    }
    public void update(){
        //수정
        System.out.print("수정할 게시물 번호 : ");
        int inputId = getParam(scan.nextLine(),WRONG_VALUE);
        if (inputId == WRONG_VALUE){
            return;
        }
        Article article = articleRepository.idArticle(inputId);
        if (article == null){
            System.out.println("없는 게시물입니다.");
            return;
        }
        System.out.print("새 제목 : ");
        String newTitle = scan.nextLine();
        System.out.print("새 내용 : ");
        String newBody = scan.nextLine();
        articleRepository.updateArticle(article, newTitle, newBody);
        System.out.printf("%d번 게시물이 수정되었습니다.\n", inputId);
    }
    public void detail(){
        // 상세보기
        System.out.print("상세보기 할 게시물 번호를 입력해주세요 : ");
        int inputId = getParam(scan.nextLine(),WRONG_VALUE);
        if (inputId == WRONG_VALUE){
            return;
        }
        Article article = articleRepository.idArticle(inputId);
        if (article == null){
            System.out.println("없는 게시물입니다.");
            return;
        }
        article.inHit();
        articleView.detailArticle(article);
    }
    public void delete(){
        //삭제
        System.out.print("삭제할 게시물 번호 : ");
        int inputId = getParam(scan.nextLine(),WRONG_VALUE);
        if (inputId == WRONG_VALUE){
            return;
        }
        Article article = articleRepository.idArticle(inputId);
        if (article == null){
            System.out.println("없는 게시물입니다.");
            return;
        }
        articleRepository.deleteArticle();
        System.out.printf("%d번 게시물이 삭제되었습니다.",inputId);
    }
    public void search(){
        // 키워드 찾기
        System.out.print("검색 키워드를 입력해주세요 : ");
        String keyword = scan.nextLine();
        ArrayList<Article> searchedList = articleRepository.keywordArticle(keyword);

        articleView.listArticle(searchedList);
    }
    public int getParam(String param, int dValue){
        try {
            return Integer.parseInt(param);
        } catch (NumberFormatException e){
            System.out.println("숫자로 적어주세요 : ");
            return dValue;
        }
    }
}
