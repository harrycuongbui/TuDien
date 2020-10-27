package controller;

import Model.Word;

import java.util.*;

public class MyTimerTask extends TimerTask {

    @Override
    public void run() {
        completeTask();
    }

    private void completeTask() {
        try {

            Thread.sleep(4);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    public static void main(String args[]) throws  Exception{
        DictionaryManagementData dicM = new DictionaryManagementData();
        List<Word> list = new ArrayList<>();
        InputTxt.readFileTxtAnhViet(list);
        list.get(0).setWordTarget("a");
        System.out.println("Size = " + list.size());
        TimerTask timerTask = new MyTimerTask();
        //running timer task as daemon thread
        Timer timer = new Timer(true);
        timer.scheduleAtFixedRate(timerTask, 0, 10*1000);
        System.out.println("Main bat dau 0: "+ new Date());
        for(int i = 0; i < list.size(); i++){
            try {
                dicM.dictionaryInsert(list.get(i), "k");
                System.out.println(i);
                Thread.sleep(4);

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("sau For");
        timer.cancel();
        System.out.println("TimerTask cancelled" + new Date());
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("end " + new Date());
    }

}