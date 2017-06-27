package com.java8.array;

public class Testarray3 {
	public static void main(String args[]){  
		  
		//declaring and initializing 2D array  
		/*int arr[][][]={  { {1,   2,  3}, { 4,  5,  6}, { 7,  8,  9} },
			       { {10, 11, 12}, {13, 14, 15}, {16, 17, 18} },
			       { {19, 20, 21}, {22, 23, 24}, {25, 26, 27} } };  
		*/
		/*int ar[][][][]={
				{
					{1,2,3,4},{5,6,7,8},{9,1,2,3},{4,5,6,7}
				},
				{
					{11,22,33,44},{55,66,77,88},{99,11,22,33,},{44,55,66,77}
				},
				{
					{111,222,333,444},{555,666,777,888},{999,111,222,333},{444,555,666,777}
				},
				{
					{1111,2222,3333,4444},{5555,6666,7777,8888},{9999,1111,2222,3333},{4444,5555,6666,7777}
				}
		};*/
		String[][] names = { {"Sam", "Smith"}, {"Robert", "Delgro"}, {"James", "Gosling"}, };
		// how to initialize two dimensional array in Java // using for loop 
		int[][] board = new int[3][3]; 
		int i,j;
		for (i = 0; i < board.length; i++) {
			System.out.println("Value of board.length :"+board.length);
			System.out.println("Value of I :"+i);
			for ( j = 0; j < board[i].length; j++) {
				System.out.println("Value of board[i].length :"+board[i].length);
				System.out.println("Value of I :"+i);
				System.out.println("Value of J :"+j);
				board[i][j] = i + j;
				System.out.println("Output :"+board[i][j]);
				} 
			//System.out.println("Output :"+board[i][j]);
			}

		

		/*Read more: http://www.java67.com/2014/10/how-to-create-and-initialize-two-dimensional-array-java-example.html#ixzz4khPujHGr
		int[][][][] a2 = new int[2][3][3][4];
		 // print array in rectangular form
		   for (int i=0; i<a2.length; i++) {
			   System.out.println("a2.length :"+a2.length);
		     for (int j=0; j<a2[i].length; j++) {
		    	 System.out.println("value of i :"+i+" value of j "+j+" a2[i].length :"+a2[i].length);
		         for (int x=0; x<3; x++){
		        	 System.out.println("X :"+x);
		             for (int y=0; y<3; y++){
		            	 System.out.println("Y :"+y);
		                System.out.print(" " + a2[i][j][x][y]);
		             }
		         }
		     }
		     System.out.println("");
		   }
		 }*/
		  
		/*//printing 2D array  
		for(int i=0;i<4;i++){  
		 for(int j=0;j<4;j++){
			 for(int k=0;k<4;k++){
				 for (int l=0;l<4;l++){
		   System.out.print(ar[i][j][k][l]+" ");  
		 }  
		   
		}
		 System.out.println();
		} 
		  
		}
	}*/
}
}
