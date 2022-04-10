package com.company;

import java.util.Random;

public class Main {

    public static void main(String[] args) {
        //Task_21();
        //Task_45();
        Task_11();
        //Task_65();
    }

    /**
     * Дано целое положительное число. Вывести символы, изображающие цифры этого числа (в порядке справа налево).
     */
    private static void Task_21() {
        Random random = new Random();
        String number = random.nextInt(100000) + 1 + "";
        System.out.println(number);
        String[] num = number.split("");
        for (int i = num.length - 1; i >= 0; i--) {
            System.out.print(num[i]);
        }
    }

    /**
     * Дана строка, состоящая из слов кириллицей, разделенных пробелами (одним или несколькими).
     * Найти длину самого короткого слова.
     */
    private static void Task_45() {
        String text = "Дана   строка    состоящая из слов    кириллицей разделенных  пробелами  слова";
        System.out.println(text);
        while (text.contains("  ")) {
            text = text.replace("  ", " ");
        }
        String[] word = text.split(" ");
        String min = word[0] + "";
        for (int i = 0; i < word.length; i++) {
            if (word[i].length() < min.length()) {
                min = word[i];
            }
        }
        System.out.println("Длина самого короткого слова=" + min.length());
    }

    /**
     * Дана непустая строка S. Вывести строку, содержащую символы строки S, между которыми вставлено по одному пробелу.
     */
    private static void Task_11() {
        String str = "ДананепустаястрокаSВывести";
        System.out.println(str);
        char[] element = str.toCharArray();
        for (int i = 0; i < str.length(); i++) {
            System.out.print(element[i] + " ");
            if (i == str.length() - 1) {
                System.out.print(element[i]);
            }
        }
    }

    private static char[] creating_alphabet() {
        final int SIZE_ALPHABET = 32;
        char[] alphabeet = new char[SIZE_ALPHABET * 4];
        int index_alphabet = 0;
        for (int m = 0; m < 4; m++) {
            if (m < 2) {
                for (char i = 'а'; i <= 'я'; i++) {
                    alphabeet[index_alphabet] = i;
                    index_alphabet++;
                }
            } else {
                for (char i = 'А'; i <= 'Я'; i++) {
                    alphabeet[index_alphabet] = i;
                    index_alphabet++;
                }
            }
        }
        return alphabeet;
    }

    private static String[] encrypted_sentence() {
        Random random = new Random();
        final int CONST = random.nextInt(9) + 1;
        String str = "Добро пожаловать!";
        char[] element_str = str.toCharArray();
        char[] alphabet = creating_alphabet();
        char[] spec_symbol = {',', '.', ' ', ';', ':', '-', '!', '?'};
        StringBuilder text = new StringBuilder();
        for (int i = 0; i < element_str.length; i++) {
            for (int k = 0, m = 0; k < alphabet.length; k++, m++) {
                if (m < spec_symbol.length) {
                    if (element_str[i] == alphabet[k]) {
                        text.append(alphabet[k + CONST]);
                        break;
                    }
                    if (element_str[i] == spec_symbol[m]) {
                        text.append(element_str[i]);
                        break;
                    }
                } else {
                    m = 0;
                    if (element_str[i] == alphabet[k]) {
                        text.append(alphabet[k + CONST]);
                        break;
                    }
                }
            }
        }
        String first_element = element_str[0] + "";
        String string = text.toString();
        String[] sentence = {string, first_element};
        return sentence;
    }

    /**
     * Дано зашифрованное предложение заданное кириллицей (способ шифрования описан в задании 63)
     * и его расшифрованный первый символ C.
     * Найти кодовое смещение K и расшифровать предложение.
     */
    private static void Task_65() {
        String[] str = encrypted_sentence();
        System.out.println("Зашифровонная строка:" + str[0]);
        System.out.println("Первый расшифрованый елемент:" + str[1]);
        char[] element_str = str[0].toCharArray();
        char first_decryption = str[1].charAt(0);
        char[] alphabet = creating_alphabet();
        final int SIZE_ALPHABET = 32;
        int index_first_element = 0;
        if (Character.isUpperCase(element_str[0])) {
            char[] BIG_alpabet = new char[SIZE_ALPHABET];
            int index_BIG_alphabet = 0;
            for (char i = 'А'; i <= 'Я'; i++) {
                BIG_alpabet[index_BIG_alphabet] = i;
                index_BIG_alphabet++;
            }
            for (int i = 0; i < BIG_alpabet.length; i++) {
                if (element_str[0] == BIG_alpabet[i]) {
                    index_first_element = i + 1;
                    break;
                }
            }
        } else {
            char[] small_alpabet = new char[SIZE_ALPHABET];
            int index_small_alphabet = 0;
            for (char i = 'а'; i <= 'я'; i++) {
                small_alpabet[index_small_alphabet] = i;
                index_small_alphabet++;
            }
            for (int i = 0; i < small_alpabet.length; i++) {
                if (element_str[0] == small_alpabet[i]) {
                    index_first_element = i + 1;
                    break;
                }
            }
        }
        int index_first_decryption = 0;
        if (Character.isUpperCase(first_decryption)) {
            char[] BIG_alpabet = new char[SIZE_ALPHABET];
            int index_BIG_alphabet = 0;
            for (char i = 'А'; i <= 'Я'; i++) {
                BIG_alpabet[index_BIG_alphabet] = i;
                index_BIG_alphabet++;
            }
            for (int i = 0; i < BIG_alpabet.length; i++) {
                if (first_decryption == BIG_alpabet[i]) {
                    index_first_decryption = i + 1;
                    break;
                }
            }
        } else {
            char[] small_alpabet = new char[SIZE_ALPHABET];
            int index_small_alphabet = 0;
            for (char i = 'а'; i <= 'я'; i++) {
                small_alpabet[index_small_alphabet] = i;
                index_small_alphabet++;
            }
            for (int i = 0; i < small_alpabet.length; i++) {
                if (first_decryption == small_alpabet[i]) {
                    index_first_decryption = i + 1;
                    break;
                }
            }
        }
        int code_shift = 0;
        if (Math.abs(index_first_element - index_first_decryption) <= 9) {
            if (index_first_element > index_first_decryption) {
                code_shift = index_first_element - index_first_decryption;
            } else {
                code_shift = (index_first_decryption + index_first_element) % 32;
            }
        } else {
            code_shift = 32 - index_first_decryption + index_first_element;
        }
        System.out.println("K=" + code_shift);
        char[] spec_symbol = {',', '.', ' ', ';', ':', '-', '!', '?'};
        for (int i = 0; i < element_str.length; i++) {
            for (int k = 0, m = 0; k < alphabet.length; k++, m++) {
                if (m < spec_symbol.length) {
                    if (element_str[i] == alphabet[k]) {
                        element_str[i] = alphabet[(k + SIZE_ALPHABET) - code_shift];
                        System.out.print(element_str[i]);
                        break;
                    }
                    if (element_str[i] == spec_symbol[m]) {
                        System.out.print(element_str[i]);
                        break;
                    }
                } else {
                    m = 0;
                    if (element_str[i] == alphabet[k]) {
                        element_str[i] = alphabet[(k + SIZE_ALPHABET) - code_shift];
                        System.out.print(element_str[i]);
                        break;
                    }
                }

            }
        }
    }
}
