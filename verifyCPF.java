import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;
public class verifyCPF {
    public static void main(String[] args) throws FileNotFoundException {
        String[] array=new String[3];
        Scanner s = new Scanner(new BufferedReader(new FileReader("test.txt")));
        for(int i = 0; i < array.length;i++){
            array[i] = s.nextLine();
        }
        int numcpf=0;
        for (String a : array) {
            if(a.length()==9){
                int dig10=verify10(a);
                String b=a+dig10;
                int dig11=verify11(b);
                String cpf=b+dig11;
                numcpf++;
                System.out.println("CPF 9 dígitos: "+cpf);
            }
            if(a.length()==10){
                int dig10=verify10(a);
                if(dig10==a.charAt(9)-'0'){
                    int dig11=verify11(a);
                    String cpf=a+dig11;
                    numcpf++;
                    System.out.println("CPF 10 dígitos: "+cpf);    
                }
            }
            if(a.length()==11){
                int dig10=verify10(a);
                int dig11=verify11(a);
                if(dig10==a.charAt(9)-'0'&&dig11==a.charAt(10)-'0'){
                    numcpf++;
                    System.out.println("CPF 11 dígitos: "+a); 
                }
            }
        }
        System.out.println(numcpf);
    }
    public static int verify10(String a){
        int soma=0;
        int val=10;
        for(int i=0;i<9;i++){
            int num=a.charAt(i)-'0';
            soma+=num*val;
            val--;
        }
        int dig10=(soma*10)%11;
        if(dig10>9){dig10=0;}  
        return dig10;
    }
    public static int verify11(String a){
        int soma=0;
        int val=11;
        for(int i=0;i<10;i++){
            int num=a.charAt(i)-'0';
            soma+=num*val;
            val--;
        }
        int dig11=(soma*10)%11; 
        if(dig11>9){dig11=0;} 
        return dig11; 
    }
}