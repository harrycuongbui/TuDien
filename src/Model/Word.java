package Model;

/**
 * @author vCuong
 * Word
 */
public class Word implements Comparable<Word>{
    private String wordTarget; // từ
    private String wordExplain; // ý nghĩa
    public Word() {
    }
    public Word(String wordTarget, String wordExplain) {
        this.wordTarget = wordTarget;
        this.wordExplain = wordExplain;
    }


    public String getWordTarget() {
        return wordTarget;
    }

    public String getWordExplain() {
        return wordExplain;
    }

    public void setWordTarget(String wordTarget) {
        this.wordTarget = wordTarget;
    }

    public void setWordExplain(String wordExplain) {
        this.wordExplain = wordExplain;
    }

    @Override
    public String toString() {
        return "Word{" + "wordTarget=" + wordTarget + ", wordExplain=" + wordExplain + '}';
    }

    @Override
    public int compareTo(Word o) {
        return wordTarget.compareTo(o.getWordTarget());
    }

}
