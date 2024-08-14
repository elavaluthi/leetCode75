package string;

//Link:https://leetcode.com/problems/group-anagrams/
//TimeComplexity:O(n)
//Type:Medium
import java.util.*;
public class P5_L49_GroupAnagrams {
	
	public static List<List<String>> groupAnagrams(String strArray[]){
		if(strArray==null||strArray.length==0) {
			return new ArrayList<>();
		}
		
		Map<String, List<String>> groupMap=new HashMap<>();
		
		for(String str:strArray) {
			char ch[]=str.toCharArray();
			Arrays.sort(ch);
			String strVal=new String(ch);
			if(!groupMap.containsKey(strVal)) {
				groupMap.put(strVal, new ArrayList<>());
			}
			groupMap.get(strVal).add(str);
		}
		
		return new ArrayList<>(groupMap.values());
	}
	
	public static void main(String[] args) {
        
        String[] strs1 = {"eat", "tea", "tan", "ate", "nat", "bat"};
        System.out.println(groupAnagrams(strs1));
        
        String[] strs2 = {""};
        System.out.println(groupAnagrams(strs2));
        
        String[] strs3 = {"a"};
        System.out.println(groupAnagrams(strs3));
    }


}
