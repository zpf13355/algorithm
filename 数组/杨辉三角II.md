### 题目

```
输入: 3
输出: [1,3,3,1]
```

### 代码

```
class Solution {
    public List<Integer> getRow(int rowIndex) {
      
        List<Integer> list=new ArrayList<>();
        list.add(1);
        for(int i=0;i<rowIndex;i++){ 
            for(int j=i;j>=1;j--){
                list.set(j,list.get(j)+list.get(j-1));
            }
            list.add(1);
        }
        return list;
     
       
        
       
    }
}
```

