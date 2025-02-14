import java.util.*;
class ProductOfNumbers {
    List<Integer> nums ;
    public ProductOfNumbers() {
        nums = new ArrayList<>();
    }
    
    public void add(int num) {
        if(num == 0) nums =  new ArrayList<>();
        else{
            int prev = 1;
            if(!nums.isEmpty())
                prev = nums.get(nums.size()-1);
            nums.add(prev*num);
        }
    }
    
    public int getProduct(int k) {
        if(k > nums.size()) return 0;
        if(k == nums.size()) return nums.get(nums.size()-1);
        return nums.get(nums.size()-1) / nums.get(nums.size()-1-k);
    }
}
