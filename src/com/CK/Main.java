package com.CK;

public class Main {

    public static void main(String[] args) {
	// write your code here
    }
}

class Solution {
    public List<List<String>> findDuplicate(String[] paths) {
        Map<String, List<String>> contentMap = new HashMap<>();
        List<List<String>> res = new ArrayList<>();

        for (int i = 0; i < paths.length; i++) {
            String[] sArr = paths[i].split(" ");
            String dir = sArr[0];
            for (int j = 1; j < sArr.length; j++) {
                String[] fileArr = sArr[j].split("\\(");
                String file = fileArr[0];
                String[] contentArr = fileArr[1].split("\\)");
                String content = contentArr[0];
                String route = dir + "/" + file;
                contentMap.putIfAbsent(content, new ArrayList<>());
                contentMap.get(content).add(route);
            }
        }

        for (String key : contentMap.keySet()) {
            if (contentMap.get(key).size() > 1){
                res.add(contentMap.get(key));
            }
        }
        return res;
    }
}