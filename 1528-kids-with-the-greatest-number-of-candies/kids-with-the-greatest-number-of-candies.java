class Solution {

public static List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        List <Boolean> reslut = new ArrayList<>();
        int max = 0 ;
        for (int candy :candies ){
            if (candy>max )
            max = candy ;
        }
        for (int candy :candies ){
            reslut.add(candy+extraCandies>=max);
        }
        return reslut;
    }

       public static void main(String[] args) {
        int[] candies = {2, 3, 5, 1, 3};
        int extraCandies = 3;

        List<Boolean> output = kidsWithCandies(candies, extraCandies);
        System.out.println(output); 
    }
};