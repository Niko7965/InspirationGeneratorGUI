package sample;


import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class TextGen {

    public TextGen() {
    }

    public String thecharacter(int n) {
        ArrayList<String> characterlist = new ArrayList<String>();
        Scanner scan = null;
        try {
            scan = new Scanner(new File("files/TheCharacter.txt"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        while (scan.hasNextLine()) {
            characterlist.add(scan.nextLine());
        }
        scan.close();

        System.out.println(characterlist.get(5));
        return characterlist.get(n);
    }
    public String thescene(int n) {
        ArrayList<String> scenelist = new ArrayList<String>();
        Scanner scan = null;
        try {
            scan = new Scanner(new File("files/TheScene.txt"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        while (scan.hasNextLine()) {
            scenelist.add(scan.nextLine());
        }
        scan.close();

        System.out.println(scenelist.get(5));
        return scenelist.get(n);
    }
    public String thetwist(int n) {
        ArrayList<String> twistlist = new ArrayList<String>();
        Scanner scan = null;
        try {
            scan = new Scanner(new File("files/TheTwist.txt"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        while (scan.hasNextLine()) {
            twistlist.add(scan.nextLine());
        }
        scan.close();

        System.out.println(twistlist.size());
        return twistlist.get(n);
    }

    public int length(String n) {
        ArrayList<String> listlist = new ArrayList<String>();
        Scanner scan = null;
        try {
            scan = new Scanner(new File("files/The"+n+".txt"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        while (scan.hasNextLine()) {
            listlist.add(scan.nextLine());
        }
        scan.close();
        return (listlist.size()-1);
    }
        //* ! $

    String input1 = thecharacter(ThreadLocalRandom.current().nextInt(0,34));
    String input2 = "goes to church ";
    String input3 = "and meets ¤ mother";



   public String getInspiration(){
       input1 = thecharacter(ThreadLocalRandom.current().nextInt(0, length("Character")));
       input2 = thescene(ThreadLocalRandom.current().nextInt(0,length("Scene")));
       input3 = thetwist(ThreadLocalRandom.current().nextInt(0,length("Twist")));
        return (removePID(input1)) + input2 + insertPronoun(input3,getPronoun(input1));

    }

    String insertPronoun (String sentence, int pronounInt){
       String pronoun = "";
        StringBuilder newSentence = new StringBuilder();
        for(int i = 0, n = sentence.length(); i<n; i++){
            if(sentence.charAt(i) == '%'){
                switch (pronounInt){
                    case 0:
                        pronoun = "he";
                        break;
                    case 1:
                        pronoun = "she";
                        break;
                    case 2:
                        pronoun = "they";
                        break;
                }
                    newSentence.append(pronoun);
            }

            if(sentence.charAt(i) == '%'){
                switch (pronounInt){
                    case 0:
                        pronoun = "him";
                        break;
                    case 1:
                        pronoun = "her";
                        break;
                    case 2:
                        pronoun = "them";
                        break;
                }
                newSentence.append(pronoun);
            }

            if(sentence.charAt(i) == '^'){
                switch (pronounInt){
                    case 0:
                        pronoun = "his";
                        break;
                    case 1:
                        pronoun = "her";
                        break;
                    case 2:
                        pronoun = "their";
                        break;
                }
                newSentence.append(pronoun);
            }
            if(sentence.charAt(i) == '¤'){
                switch (pronounInt){
                    case 0:
                        pronoun = "himself";
                        break;
                    case 1:
                        pronoun = "herself";
                        break;
                    case 2:
                        pronoun = "themselves";
                        break;
                }
                newSentence.append(pronoun);
            }

            if(sentence.charAt(i) != '%' && sentence.charAt(i) != '&' && sentence.charAt(i) != '^' && sentence.charAt(i) != '¤'){
                newSentence.append(sentence.charAt(i));
            }
        }
        return newSentence.toString();


    }

    String removePID(String input){
        String newinput = "";
        for(int i = 0, n = input.length(); i<n; i++){
            if(input.charAt(i) != '*' && input.charAt(i) != '!' ){
                newinput = newinput+input.charAt(i);
            }
        }
        return newinput;
    }

    int getPronoun (String person){
        if(person.charAt(0) == '*' ){
            return 0;
        }
        if(person.charAt(0) == '!' ){
            return 1;
        }
        if(person.charAt(0) == '$'){
            return 2;
        }
        else{
            return ThreadLocalRandom.current().nextInt(0,3);
        }
    }
}


