package controller;
import Model.Word;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author  Tuyên
 * InputTxt đọc file text
 */
public class InputTxt {
    public static void readFileTxtAnhViet(List<Word> list) {
        FileReader fileReader;
        try {
            fileReader = new FileReader("E_V.txt");
            BufferedReader br = new BufferedReader(fileReader);
            String line, target = "";
            boolean checkW = false;
            StringBuilder explain = new StringBuilder();
//                System.out.println("====open file ok!=======");
            while ((line = br.readLine()) != null) {
                int index = line.indexOf("@");
                int indexEx = line.indexOf("/");
                if (index != -1 && checkW && indexEx != -1) {
                    list.add(new Word(target, explain.toString()));
                    target = line.substring(1, indexEx);
                    target = target.trim();
                    explain.delete(0, explain.length());
                    explain.append(line.substring(indexEx));

                } else if (index != -1 && !checkW && indexEx != -1) {

                    target = line.substring(1, indexEx);
                    target = target.trim();
                    explain.append(line.substring(index));
                    checkW = true;
                } else {
                    explain.append(System.lineSeparator()).append(line);
                }
            }
            list.add(new Word(target, explain.toString()));
        } catch (IOException e) {

            System.out.println("@@@Không tìm thấy file Tu dien" + e.getMessage());
        }
    }
}
