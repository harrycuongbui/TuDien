package Model;

import controller.Translator;

public class Tesst {
    public static void  main (String [] okok){
        String toLangTxt = Translator.translateText( "en", "vi","Hello");
        System.out.println(toLangTxt);
    }
}
