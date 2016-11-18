import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
public class ErrorCheck {
public static void main(String[] args) throws IOException
{
BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
int[] data;
int[] div;
int[] rem;
int[] divisor;
int[] crc;
int data_bits, divisor_bits, total_length;

System.out.println("Enter number of CRC bits");
data_bits = Integer.parseInt(br.readLine());
data = new int[data_bits];

System.out.println("Enter CRC Bits");
for(int i=0;i<data_bits;i++){
	data[i] = Integer.parseInt(br.readLine());
}
System.out.println("Enter number of bits for divisor");
	divisor_bits = Integer.parseInt(br.readLine());
	divisor = new int[divisor_bits];
	
System.out.println("Enter bits for divisor");
	for(int j=0;j<divisor_bits;j++){
		divisor[j] = Integer.parseInt(br.readLine());	
}

	total_length = data_bits + divisor_bits - 1;
	
	div = new int[total_length];
	rem = new int[total_length];
	crc = new int[total_length];

	//putting data bits into div.
	for(int i=0;i<data.length;i++){
		div[i] = data[i];	
	}

	

	rem = divide(div,divisor,rem);
	
for(int i=0;i<rem.length;i++){
	if(rem[i]!=0){
		System.out.println("Error");
		break;
	}
	if(i==rem.length-1)
		System.out.println("Error in Data");
}
	

}



static int[] divide(int div[],int divisor[],int rem[])
{
	int current = 0;
	while(true)
	{
		for(int i=0;i<divisor.length;i++){
			rem[current+i] = (rem[current+i]^divisor[i]);
		}		
			while(rem[current] == 0 && current!=rem.length-1)
		current++;
		
		if((rem.length-current)<divisor.length)
			break;
		
	}
	return rem;
    
}
}



