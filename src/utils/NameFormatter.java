package utils;

public class NameFormatter {

    public String nameFormatter(String name) {
        String[] words = name.split(" ");
        StringBuilder sb = new StringBuilder();

        for (String word : words) {
            if (word.length() > 2) {
                sb.append(word.substring(0, 1).toUpperCase() + word.substring(1).toLowerCase());
            }else {
                sb.append(word.substring(0).toLowerCase());
            }
            sb.append(" ");
        }
        return sb.toString().trim();
    }

}
