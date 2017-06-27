import java.util.StringTokenizer;


public class Calculation {
	
	public static int findMax(int arr[]){  
        int max=arr[0];  
        for(int i=1;i<arr.length;i++){  
            if(max<arr[i])  
                max=arr[i];  
        }  
        return max;  
    }
	//method that returns cube of the given number  
    public static int cube(int n){  
        return n*n*n;  
    }  
    //method that returns reverse words   
    public static String reverseWord(String str){  
    	StringBuilder string = new StringBuilder();
    	string.append(str);
    	string=string.reverse();
    	System.out.println("Reversed String : " +string);
    	/*for (int i=0; i<str.length();i++){
    		System.out.println(str.charAt(i));
    	}*/
    	return string.toString();
        /*StringBuilder result=new StringBuilder();  
        StringTokenizer tokenizer=new StringTokenizer(str," ");  
  
        while(tokenizer.hasMoreTokens()){  
        StringBuilder sb=new StringBuilder();  
        sb.append(tokenizer.nextToken());  
        sb.reverse(); 
        System.out.println("Reverse : "+sb.reverse());
  
        result.append(sb);  
        result.append(" ");
        System.out.println("Result : "+result.append(sb));
        }  */
    	
       // return result.toString();
    
    	
    	
    }  
    

}
