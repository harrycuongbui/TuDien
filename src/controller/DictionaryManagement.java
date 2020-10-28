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
        int size = list.size();
        for (Word word : list) {
            System.out.println("i :" + word.toString());
        }
    }
    private  int dictionarySearcherWordIndex(Word searchW, List<Word> list){
        list.sort(new Comparator<Word>() {
            @Override
            public int compare(Word o1, Word o2) {
                return o1.getWordTarget().compareTo(o2.getWordTarget());
            }
        });
        int i = Collections.binarySearch(list, searchW);
        if( i >= 0) {
//            System.out.println("Vi tri thu " + i);
            return i;
        } else{
            System.out.println("Khong tim thay tu trong file");
            return -1;
        }
    }
    public String dictionarySearcher(Word searchW, List<Word> list) {
        int i = this.dictionarySearcherWordIndex( searchW, list);
        if( i>= 0){return list.get(i).getWordExplain();}
        else {
            System.out.println("Word không tồn tại!");
            return "";
        }
    }
    public boolean dictionaryInsert(Word word, List<Word> list)  {
        int i = this.dictionarySearcherWordIndex(word, list);
        if(i >= 0){
            System.out.println("Đã tồn tại! Insert lỗi!");
            return false;
        } else{
            list.add(word);
            dicMD.dictionaryInsert(word, "ok");
            System.out.println("Insert Word ok!");
            return true;
        }
    }
    public  void dictionaryUpdate(Word wordUpdate, List<Word> list) {
        int i = this.dictionarySearcherWordIndex( wordUpdate, list);
        if( i>= 0) {
            list.get(i).setWordExplain(wordUpdate.getWordExplain());
            dicMD.dictionaryUpdate(wordUpdate, "ok");
        } else{
            System.out.println("Từ vựng không tồn tại, Update lỗi!");
        }
    }
    public void dictionaryDelete(Word wordDelete, List<Word> list) {
        int i = this.dictionarySearcherWordIndex( wordDelete, list);
        if(i >= 0) {
            list.remove(i);
            dicMD.dictionaryDelete(wordDelete, "ok");
        } else{
            System.out.println("Từ vựng không tồn tại, Delete lỗi!");
        }
    }

}
