题目描述：

给定一个非负整数数组 A， A 中一半整数是奇数，一半整数是偶数。
对数组进行排序，以便当 A[i] 为奇数时，i 也是奇数；当 A[i] 为偶数时， i 也是偶数。
你可以返回任何满足上述条件的数组作为答案。
示例：
输入：[4,2,5,7]
输出：[4,5,2,7]
解释：[4,7,2,5]，[2,5,4,7]，[2,7,4,5] 也会被接受。
解题思路

双指针：
创建一个数组，两个下标一个奇数下标，一个偶数下标，遍历给定的数组判断奇偶，
奇数就放在奇下标的位置，偶数就放在偶下标的位置。
代码

class Solution {
    public int[] sortArrayByParityII(int[] A) {
        int length=A.length;
        int []result=new int[length];
        int j=0;
        int k=1;
        for(int i=0;i<length;i++){
            int current=A[i];
            if(0==current%2){
                result[j]=current;
                j+=2;
            }else{
                result[k]=current;
                k+=2;
            }
        }
        return result; 
    }
}

