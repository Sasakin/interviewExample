package org.example.task1;

public class Task1 {

    public static final String TEXT = "I am Java Developer";

    //private static final String FOOTER_AND_HEADER = "*************";

    /*
     *   *************
     *   * I         *
     *   * am        *
     *   * Java      *
     *   * Developer *
     *   *************
     */

    /*
     *************
     * I          *
     * I          ** am         *
     * I          ** am         ** Java       *
     * I          ** am         ** Java       ** Developer  *
     *************
     */

    /**
     * Реализовать функцию вывода на консоль текста в параметре TEXT в формате указанном выше
     */
    public void printFormattedText(String text) {
        // 1. Найти максимально длинное слово.
        // 2. Найти колличество звездочек , через максимально длинное слово.
        String[] words = text.split(" ");
        int footerHeaderLength = calcCountStars(words);
        String footerAndHeader = "*".repeat(footerHeaderLength);
        System.out.println(footerAndHeader);
        StringBuilder row = new StringBuilder();
        String startRow = "* ";
        String endRow = " *";
        for(String word : words) {
            row.append(startRow);
            row.append(word);
            row.append(" ".repeat(calcEmptySpaceCount(word, footerHeaderLength)));
            row.append(endRow);
            System.out.println(row);
            row = new StringBuilder();
        }
        System.out.println(footerAndHeader);
    }

    private int calcEmptySpaceCount(String word, int countStars) {
        return countStars - (word.length() + 2) - 2;
    }


    private int calcCountStars(String[] words) {
        return getMaxWordLength(words) + 4;
    }


    private int getMaxWordLength(String[] words) {
        int length = 0;

        for(String word : words) {
            length = word.length() > length ? word.length() : length;
        }

        return length;

    }
}
