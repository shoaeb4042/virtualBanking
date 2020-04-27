package Shoaeb.user;
import java.util.Random;


 public class  Code {

  public static String getcode(){
    Random cd=new Random();
    int num;
    String rand="";
    for(int c=1;c<=6;c++){
    	num=cd.nextInt(6);
    	
    	rand+=Integer.toString(num);
    }
   
	return rand;
  }
  public static String getac(){
	    Random cd=new Random();
	    int num;
	    String rand="";
	    for(int c=1;c<=10;c++){
	    	num=cd.nextInt(10);
	    	
	    	rand+=Integer.toString(num);
	    }
	   
		return rand;
	  }
} 