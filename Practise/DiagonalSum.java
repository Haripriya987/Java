public class DiagonalSum {
  public static int diagonalSum(int arr[][]){
  
    int r=arr.length;
    int c=arr[0].length;
    int sum=0;
    for(int i=0;i<r;i++){
      for(int j=0;j<c;i++){
          if(i==j)
          sum+=arr[i][j];
    }
  }
  return sum;
  }
  public static void main(String args[]){
   int arr[][]={{1,2,3},{4,5,6},{7,8,9}};
   System.out.println(diagonalSum(arr));
   
  }
  
}
