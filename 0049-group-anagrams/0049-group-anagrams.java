class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String ,List<String>> map = new HashMap<>();

        for(String str : strs){
            String key = sortString(str);

            map.putIfAbsent(key , new ArrayList<>());
            map.get(key).add(str);
        }

        return new ArrayList<>(map.values());


    }

        public String sortString(String str){
            char arr[] = str.toCharArray();
        for(int i=0;i<arr.length;i++){
            for(int j=i+1;j<arr.length;j++){
                if(arr[i] > arr[j]){
                    char temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }
        return new String(arr);
    }
}