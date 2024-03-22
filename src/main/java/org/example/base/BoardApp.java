package org.example.base;

import org.example.domain.ArticleController;

import java.util.Scanner;

public class BoardApp {
    Scanner scan = new Scanner(System.in);
    ArticleController articleController = new ArticleController();

    public void run(){
        while (true){
            System.out.print("명령어 : ");
            String cmd =scan.nextLine();

            if (cmd.equals("exit")){
                System.out.println("프로그램을 종료합니다.");
                break;
            }
            switch (cmd){
                case "add" ->articleController.add();
                case "list" ->articleController.list();
                case "update"-> articleController.update();
                case "detail" -> articleController.detail();
                case "delete" -> articleController.delete();
                case "search"->articleController.search();
                default -> System.out.println("올바른 명령어가 아닙니다.");
            }
        }
    }
}
