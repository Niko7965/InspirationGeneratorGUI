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

        //System.out.println(characterlist.get(5));
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

        //System.out.println(scenelist.get(5));
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

        //System.out.println(twistlist.size());
        return twistlist.get(n);
    }
    public int length(String n) {
        ArrayList<String> listlist = new ArrayList<String>();
        Scanner scan = null;
        try {
            scan = new Scanner(new File("files/"+n+".txt"));
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

    //move me
    public String verb(int n){
        ArrayList<String> verblist = new ArrayList<String>();
        Scanner scan = null;
        try {
            scan = new Scanner(new File("files/Verbs.txt"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        while (scan.hasNext()) {
            verblist.add(scan.next());
        }
        scan.close();
        return verblist.get(n);
    }
    //move me

    String input1 = "";
    String input2 = "";
    String input3 = "";

    String verbinput2 = "";
    String verbinput3 = "";
    String pronouninput2 = "";
    String pronouninput3 = "";
    int pronounInt;

   public String getInspiration(){
       input1 = thecharacter(ThreadLocalRandom.current().nextInt(0,length("TheCharacter")));
       input2 = " " + thescene(ThreadLocalRandom.current().nextInt(0,length("TheScene")));
       input3 = commaSpace(thetwist(ThreadLocalRandom.current().nextInt(0,length("TheTwist"))));

       pronounInt = getPronoun(input1);

       verbinput2 = insertVerb(input2, pronounInt);
       verbinput3 = insertVerb(input3, pronounInt);
       verbinput3 = insertVerb(verbinput3, pronounInt);
       pronouninput2 = insertPronoun(verbinput2, pronounInt);
       pronouninput3 = insertPronoun(verbinput3, pronounInt);

        return (removePID(input1)) + removePID(pronouninput2) + removePID( pronouninput3);
       //return (removePID(input1)) + insertPronoun(input2,getPronoun(input1)) + insertPronoun(input3,getPronoun(input1));
//insertverb virker ikke optimalt
    }

    String commaSpace (String sentence){
        if (sentence.charAt(0) == ',') {
            return sentence;
        }
        else{
            return " " + sentence;
        }

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

            if(sentence.charAt(i) == '&'){
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

            /*if(sentence.contains(verb(i)) == true){
                switch (pronounInt){
                    case 0:
                    case 1:
                        if(i%2!=0) {
                            pronoun = verb(i-1); //technically wrong to use pronoun but whatever
                        }
                        break;
                    case 2:
                        if(i%2==0) {
                            pronoun = verb(i+1); //technically wrong to use pronoun but whatever
                        }
                        break;
                }
                newSentence.append(pronoun);
            }*/
        }
        return newSentence.toString();
    }

    // her

    String insertVerb (String sentence, int verbInt){
        String verbword = "";
        String newsentence = sentence;
        for(int i = 0, n = length("Verbs")*2; i<n; i++){
            if(sentence.contains("¨" + verb(i) + " ")){
                System.out.print("CONTAINS ");
                switch (verbInt){
                    case 0:
                        System.out.print("case 0:");
                        if (i%2!=0){
                            verbword = verb(i-1);
                            newsentence = sentence.replaceAll(verb(i),verbword);
                        }
                        break;
                    case 1:
                        System.out.print("case 1:");
                        if (i%2!=0){
                            verbword = verb(i-1);
                            newsentence = sentence.replaceAll(verb(i),verbword);
                        }
                        break;
                    case 2:
                        System.out.print("case 2:");
                        if (i%2==0){
                            verbword = verb(i+1);
                            newsentence = sentence.replaceAll(verb(i),verbword);
                        }
                        break;
                }
                System.out.println(" "+ verb(i));
            }
        }

        return newsentence;
   }
    // over

    String removePID(String input){
        String newinput = "";
        for(int i = 0, n = input.length(); i<n; i++){
            if(input.charAt(i) != '*' && input.charAt(i) != '!'&& input.charAt(i) != '$' && input.charAt(i) != '¨'){
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
