### 题目

输入一个非负整数数组，把数组里所有数字拼接起来排成一个数，打印能拼接出的所有数字中最小的一个。

 

示例 1:

输入: [10,2]
输出: "102"
示例 2:

输入: [3,30,34,5,9]
输出: "3033459"

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/ba-shu-zu-pai-cheng-zui-xiao-de-shu-lcof
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。



### 代码

```java
class Solution {
    public String minNumber(int[] nums) {
        String[] strs=new String[nums.length];
        for(int i=0;i<nums.length;i++){
            strs[i]=String.valueOf(nums[i]);
        }

        //排序
        Arrays.sort(strs,new Comparator<String>(){
            @Override
            public int compare(String s1,String s2){
                return (s1+s2).compareTo(s2+s1);
            }
        });

        
        // Arrays.sort(strs,(x,y)->(x+y).compareTo(y+x));

        StringBuilder res=new StringBuilder();

        for(String s:strs){
            res.append(s);
        }

        return res.toString();
    }
}
```

### 代码

```java
class Solution {
    public String minNumber(int[] nums) {
        String[] strs=new String[nums.length];
        for(int i=0;i<nums.length;i++){
            strs[i]=String.valueOf(nums[i]);
        }

        quickSort(strs,0,nums.length-1);

        StringBuilder res=new StringBuilder();
        for(String s:strs){
            res.append(s);
        }

        return res.toString();
    }

    void quickSort(String[] strs,int l,int r){
        if(l>=r){
            return;
        }

        int i=l;
        int j=r;
        String key=strs[l];

        while(i<j){
            
            while((strs[j]+strs[l]).compareTo(strs[l]+strs[j])>=0&&i<j){
                j--;
            }
            while((strs[i]+strs[l]).compareTo(strs[l]+strs[i])<=0&&i<j){
                i++;
            }

            String tmp=strs[i];
            strs[i]=strs[j];
            strs[j]=tmp;
        }
        strs[l]=strs[i];
        strs[i]=key;
        quickSort(strs, l, i - 1);
        quickSort(strs, i + 1, r);
    }
}
```

