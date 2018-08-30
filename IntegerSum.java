
import java.lang.Math; // headers MUST be above the first class

// one class needs to have a main() method
public class IntegerSum
{
  // arguments are passed using the text field below this editor
  public static void main(String[] args)
  {
    int num=1234567;
    int sum=0;
    int sSum=0;
    
    for (int i=0; i<7;i++){
      sum=sum+num%10;
      num=num/10;
    
  }
    System.out.print("Sum of the numbers : "+sum);
    int sumlen=String.valueOf(sum).length();
    
    for(int j=0; j<sumlen;j++){
      sSum=sSum+sum%10;
      sum=sum/10;
      
    }
    System.out.print("\n"+"Digits Sum : "+sSum);
}


}