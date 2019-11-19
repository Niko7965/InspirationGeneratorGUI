package sample;




public class TextGen {

    //* ! $ ?

    String input1 = "*A girl ";
    String input2 = "goes to church ";
    String input3 = "and meets ^ mother";


   public String getInspiration(){
        return (removePID(input1)) + input2 + insertPronoun(input3,getPronoun(input1));

    }

    String insertPronoun (String sentence, String pronoun){
        String newSentence = "";
        for(int i = 0, n = sentence.length(); i<n; i++){
            if(sentence.charAt(i) == '^'){
                for(int j = 0, m =pronoun.length(); i<m; i++){
                    newSentence = newSentence + pronoun.charAt(j);
                }
            }
            else{
                newSentence = newSentence + sentence.charAt(i);
            }
        }
        return newSentence;


    }

    String removePID(String input){
        String newinput = "";
        for(int i = 0, n = input.length(); i<n; i++){
            if(input.charAt(0) != '*' && input.charAt(0) != '!' ){
                newinput = newinput+input.charAt(i);
            }
        }
        return newinput;
    }

    String getPronoun (String person){
        if(person.charAt(0) == '*' ){
            return "she";
        }
        if(person.charAt(0) == '!' ){
            return "he";
        }
        else{
            return "they";
        }
    }
}


