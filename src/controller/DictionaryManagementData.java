package controller;

import Model.Word;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
/**
 * @author qCuong
 * DictionaryManagementData insert, update, find, delete Word
 */
public class DictionaryManagementData  {
    public void dictionaryDelete(Word wordDelete, String name)  {
        Connection con = null;
        String namePath = "";
        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/TuDien", "root", "");
            String sql = "delete from tblWord where wordTarget=?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, wordDelete.getWordTarget());
            ps.executeUpdate();
            ps.close();
        } catch (Exception e){
            System.out.println(e.getMessage());
        } finally {
            try {
                con.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }
    public void dictionaryInsert(Word word, String name) {
        Connection con = null;
        String namePath = "";
        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/TuDien", "root", "");
            String sql = "insert into tblWord(wordTarget,wordExplain) values(?,?)";

            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, word.getWordTarget());
            ps.setString(2, word.getWordExplain());
            ps.executeUpdate();
            ps.close();
        } catch (Exception e){
            System.out.println("Ngoai le: " + e.getMessage());
        } finally {
            if (con != null){
                try {
                    con.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
        }
    }
    public void dictionaryUpdate(Word wordUpdate, String name)  {
        this.dictionaryDelete(wordUpdate,name);
        this.dictionaryInsert(wordUpdate, name);
//        Connection con = null;
//        String namePath = "";
//        try {
//            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/TuDien", "root", "");
//            String sql = "update tblWord set wordExplain = ? where WordTarget = ? ";
//            PreparedStatement ps = con.prepareStatement(sql);
//            ps.setString(1, wordUpdate.getWordTarget());
//            ps.setString(2, wordUpdate.getWordExplain());
//            ps.executeUpdate();
//            ps.close();
//        } catch (Exception e){
//            System.out.println("Ngoai le: " + e.getMessage());
//        } finally {
//            if (con != null){
//                con.close();
//            }
//        }
    }

    public void showAllWords(String name, List<Word> list) {
        Connection con = null;
        String namePath = "";
        int i = 0;
        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/TuDien", "root", "");
            String sql = "select *from tblWord";
            Statement statement = con.createStatement();
            ResultSet re = statement.executeQuery(sql);
            while (re.next()) {
                Word w = new Word(re.getString(1), re.getString(2));
                list.add(w);
        }
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}
