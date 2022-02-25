package date_one;

import java.util.Arrays;

/**
 * @DATE 2022/2/22
 * @Created by zhangzhi
 */

public class sort {

    /**
     * @return void
     * @create zhangzhi
     * @time 2022/2/22 19:35
     * @description 交换方法
     */
   public static void Swap(int[] arr, int i, int j){
       int temp = arr[i];
       arr[i] = arr[j];
       arr[j] = temp;
   }


    /**
     * @param
     * @return a
     * @create zhangzhi
     * @date 2022/2/22
     * @time 20:01
     * @description 数组发生器
     */
   public static int[] CreateArr(){
       int max = 10000;
       int size = (int)(Math.random()*max);
       System.out.println("数组大小为:"+size);
       int[] arr = new int[size];
       for(int i = 0;i<size;i++){
           arr[i] = (int)(Math.random()*max);
       }
       return arr;
   }

    /**
     * @param   arr 整型数组
     * @return void
     * @create zhangzhi
     * @date 2022/2/22
     * @time 20:14
     * @description 选择排序
     */
   public static void SelectSort(int[] arr){
       int i,j;
       for(i=0;i<arr.length-1;i++){
           //先假设每次循环时，最小的索引为i
           int smallIndex = i;
           //每一个元素都和剩下的未排序的元素比较
           for(j=i+1;j<arr.length;j++){
               if(arr[smallIndex]>arr[j]){//寻找最小数
                   smallIndex = j;//将最小数的索引保存
               }
           }
           //经过一轮循环，就可以找出一个最小值的索引，然后把最小值放到i的位置
           Swap(arr,i,smallIndex);
       }
   }

    /**
     * @param arr 整型数组
     * @return void
     * @create zhangzhi
     * @date 2022/2/22
     * @time 20:51
     * @description 冒泡排序
     */
   public static void BubbleSort(int[] arr){
       for(int i = 0; i<arr.length;i++){
           for(int j=0; j < arr.length-1-i; j++){
               if(arr[j]>arr[j+1]){
                   Swap(arr,j,j+1);
               }
           }
       }
   }

    /**
     * @param arr 整型数组
     * @return void
     * @create zhangzhi
     * @date 2022/2/22
     * @time 21:02
     * @description 插入排序
     */
   public static void InsertSort(int[] arr){
       for(int i=0;i<arr.length;i++){
           int min = arr[i];//假设当前元素是最小值
           int j;//j用于前面的元素比较大小
           for(j = i;j>0&&min<arr[j-1];j--){
               arr[j] = arr[j-1];//如果当前min小于前一个元素,前一个元素后退一格
           }
           arr[j] = min;//找到min的位置后,就直接赋值
       }
   }

   public static void main(String[] args) {
       int[] arr = CreateArr();
       int[] arr2 = Arrays.copyOf(arr,arr.length);
       System.out.println(Arrays.equals(arr, arr2));
       //选择排序
       //SelectSort(arr);
       //冒泡排序
       //BubbleSort(arr);
       //插入排序
       InsertSort(arr);
       System.out.println(Arrays.toString(arr));
       Arrays.sort(arr2);
       System.out.println(Arrays.toString(arr2));
       System.out.println(Arrays.equals(arr,arr2));
   }
}
