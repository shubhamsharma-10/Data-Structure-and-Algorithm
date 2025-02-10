import java.util.Scanner;

public class Linear_search {

	public static void search () {
		Scanner s = new Scanner (System.in);
		
		System.out.print("Enter size of array: ");
        int size = s.nextInt();
        int arr[] = new int [size];
        System.out.print("Enter the numbers: ");
            for (int i = 0; i<size;i++) {
        	    arr[i]= s.nextInt();
              }
      
        System.out.print("Enter the number to search: ");
           int X = s.nextInt();
       
          boolean y = true;
        
          for (int i = 0; i<size;i++) {
        	  if (arr[i]==X) {
                  y=true;
               System.out.print("The number is at index: ");
                System.out.println(i);
                 break;
        	}
        	else {
        		y = false;
        	}
        }
        if(y==false) {
        	
        	System.out.println("Number NOT found");
//        	System.out.println("-1");
        }
	}
	
	  public static void main(String[] args) {
              search();
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
//		      Scanner s = new Scanner (System.in);
//            int size = s.nextInt();
//            int arr[] = new int [size];
//            for (int i = 0; i<size;i++) {
//            	arr[i]= s.nextInt();
//            }
//            int X = s.nextInt();
//            for (int i = 0; i<size;i++) {
//            	if (arr[i]==X) {
//                     System.out.println(i);
//                     break;
//            	}
//            	if (i==size) {
//            		System.out.println("-1");
//            	}
//            }
           

	}

}
