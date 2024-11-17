import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
public class TopWords {
    public static void main(String[] args) {
        Map<String, Integer> words = new HashMap<String, Integer>();
        String filePath = "src/sample3.txt";
        File file = new File(filePath);
        Scanner scanner = null;
        try {
            scanner = new Scanner(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        scanner.useDelimiter("\\s");
        while (scanner.hasNext()){
            String word = processedWord(scanner.next());
            if (word.isBlank()) continue;
            words.putIfAbsent(word,0);
            words.put(word,words.get(word)+1);
        }
        scanner.close();

        List<Map.Entry<String, Integer>> wordsList = new ArrayList<>(words.entrySet());
        Collections.sort(wordsList, new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                return o2.getValue() - o1.getValue();
            }
        });

        for (int i = 0; i < 10; i++) {
            System.out.println(String.valueOf(i + 1) + ": " + wordsList.get(i).getKey() + " " + wordsList.get(i).getValue());
        }
    }
    public static String processedWord(String word){
        return word.toLowerCase().replaceAll("\\W","");
    }

}