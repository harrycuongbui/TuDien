package controller;
import Model.Word;

import java.sql.SQLException;
import  java.util.List;
import java.util.Collections;
import java.util.Comparator;

/**
 * @author qCuong
 * DictionaryManagement show, insert, delete, update trong list
 *gọi tới các hàm trong DictionaryManagementData insert, delete, update Mysql
 */
public class DictionaryManagement  {
    DictionaryManagementData dicMD ;
    public DictionaryManagement() {
        dicMD = new DictionaryManagementData();
    }

    public void showAllWords(List<Word> list) {

    }
    private  int dictionarySearcherWordIndex(Word searchW, List<Word> list){
        return 0;
    }
    public String dictionarySearcher(Word searchW, List<Word> list) {
        int i = this.dictionarySearcherWordIndex( searchW, list);
        if( i>= 0){return list.get(i).getWordExplain();}
        else {
            System.out.println("Word không tồn tại!");
            return "";
        }
    }
    public void dictionaryInsert(Word word, List<Word> list)  {

    }
    public  void dictionaryUpdate(Word wordUpdate, List<Word> list) {

    }
    public void dictionaryDelete(Word wordDelete, List<Word> list) {

    }

}
