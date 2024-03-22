package org.example.base;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class CommonUtill {
    private Scanner scan = new Scanner(System.in);

    public Scanner getScan() {
        return scan;
    }

    public String getDateTime(){
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy.MM.dd HH:mm:ss");
        String fomattedDtae = now.format(formatter);
        return fomattedDtae;
    }
}
