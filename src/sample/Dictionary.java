package sample;

import java.util.ArrayList;
import java.util.TreeMap;

public class Dictionary {
    private final TreeMap<String, String> datamap;
    private ArrayList<String> key;

    public Dictionary(TreeMap<String, String> datamap, ArrayList<String> key) {
        this.datamap = datamap;
        this.key = key;
    }

    public TreeMap<String, String> getMap() {
        return datamap;
    }

    /**
     * @return
     */
    public ArrayList<String> getKey() {
        return key;
    }

    public void setKey(ArrayList<String> key) {
        this.key = key;
    }
    int BinarySearch(String word, int left, int right) { //tìm kiếm nhị phân trong các hàm tìm kiến keyword, nếu từ đó ko có thì return -1
        if (key.get(left).compareTo(key.get(right)) > 0) {
            return -1;
        } else {
            int mid = (left + right) / 2;
            if (key.get(mid).compareTo(word) > 0) {
                return BinarySearch(word, left, mid - 1);
            } else if (key.get(mid).compareTo(word) < 0) {
                return BinarySearch(word, mid + 1, right);
            } else {
                return mid;
            }
        }
    }

    /**
     * @param word cần tim nếu có không thì null
     * @return
     */
    public String Search(String word) {
        int high = key.size() - 1;
        int low = 0;
        int index = BinarySearch(word, low, high);
        if (index < 0) {
            return "";
        } else {
            return key.get(index);
        }
    }
    public boolean removeWord(String word) {
        if (Search(word).equals("")) {
            return false;
        } else {
            key.remove(word);
            datamap.remove(word);
            return true;
        }
    }
}