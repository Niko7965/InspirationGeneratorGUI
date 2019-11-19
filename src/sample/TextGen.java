package sample;


import java.util.concurrent.ThreadLocalRandom;

public class TextGen {

    //* ! $ ?

    String input1 = "!A girl ";
    String input2 = "goes to church ";
    String input3 = "and meets ¤ mother";


   public String getInspiration(){
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


