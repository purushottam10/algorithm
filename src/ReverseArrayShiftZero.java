

/**
 * arr ={0,1,3,0,2,4,0}; put all zeros at the end of array without changing sorting order of order of other element and without using inbult fucntion
 * out = {1,3,2,4,0,0,0}
 */
public class ReverseArrayShiftZero {
    public static void main(String[] args) {
       int []arry={0,1,3,0,2,4,0};
       int n=arry.length;
       int temp;
       for(int i=0;i<n/2;i++){
           temp=arry[i];
           arry[i]=arry[n-1-i];
           arry[n-1-i]=temp;
       }

       for (int j=0;j<n;j++){
           System.out.println(arry[j]);
       }
        zeroSeprater(arry);
    }

    public static int[] zeroSeprater(int a[]){
        int n=a.length;
        int count=0;
        int pt=0;
        int temp[]=new int [n];
        for(int i=0;i<n;i++){
            if(a[i]==0){
                count++;
                temp[n-count]=0;
            } else {
                temp[pt]=a[i];
                pt++;
            }
        }

        return temp;
    }

}

