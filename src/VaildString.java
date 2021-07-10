
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import static java.util.Comparator.comparing;


public class VaildString {

    /**
     * to count the Char frequency
     * @param strArray
     * @return
     */
    public   HashMap<Character,Integer> getTCharacterFrequency(Character[] strArray){
    HashMap<Character,Integer> strFrequency= new HashMap<>();
    for(Character s: strArray){
        strFrequency.put(s,Collections.frequency(Arrays.asList(strArray),s));
    }
    return strFrequency;
}

  public static void main(String[] args) {
    VaildString vaildString = new VaildString();
      Character str[] ={'a','b','c','a','d','a','d'};
     HashMap<Character,Integer> strFrequency= vaildString.getTCharacterFrequency(str);
     List<String> orgList= new ArrayList<>();
     orgList.add("abcdf");
     orgList.add("abcaad");
     orgList.add("abcdada");
     List<String> validStr =vaildString.getValidString(orgList,str,strFrequency);
    System.out.println(validStr.stream().max(comparing(String::length)).get());
  }

    /**
     * to find the Valid String
     * @param stringList
     * @param orgChar
     * @param charFrequency
     * @return
     */
  public List<String> getValidString(List<String> stringList, Character[] orgChar, HashMap<Character,Integer> charFrequency){
    List<Character> orgList=Arrays.asList(orgChar);
    List<String> validString= new ArrayList<>();
    for (int i=0;i<stringList.size();i++){
        if(checkCorrectChar(stringList.get(i),orgList,charFrequency)){
            validString.add(stringList.get(i));
        }
    }
    return  validString;
  }

    /**
     * to check the String is valid
     * @param str
     * @param orgList
     * @param charFrequency
     * @return
     */
  public  boolean checkCorrectChar(String str, List<Character> orgList,HashMap<Character,Integer> charFrequency){
    List<Character> comStr=str.chars().mapToObj(e -> (char) e).collect(Collectors.toList());
    if(orgList.containsAll(comStr)){
        if(checkFrequency(comStr,charFrequency)){
        return true;
        }
    }
    return  false;
  }

    /**
     * to check the frequency of Char
     * @param comList
     * @param charFrequency
     * @return
     */
  public boolean checkFrequency(List<Character> comList, HashMap<Character,Integer> charFrequency){
    Set<Character> chrSet= new HashSet<>();
    chrSet.addAll(comList);
    for(Character c:chrSet){
        if (Collections.frequency(comList,c)>charFrequency.get(c)){
            return false;
        }
    }
    return true;
  }
}
