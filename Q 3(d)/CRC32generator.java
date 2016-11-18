import java.util.Random;

public class CRC32generator {

	

	public static void main(String[] args) 
	{
		System.out.println("Experimentation Mode Selected");
		ExpMode();
					
					
	}
	
	
	private static void ExpMode() 
	{
		String divisor = "100111100110000010001000110111111";
		int Error16 = 0, Error32 = 0, Error64 = 0;
		for(int i = 0 ; i < 1000 ; i++)
		{
			Boolean Error16Check = CheckCRC(divisor , 16);
			if(!Error16Check)
				Error16 ++;
		}
		for(int i = 0 ; i < 1000 ; i++)
		{
			Boolean Error32Check = CheckCRC(divisor , 32);
			if(!Error32Check)
				Error32 ++;
		}
		for(int i = 0 ; i < 1000 ; i++)
		{
			Boolean Error64Check = CheckCRC(divisor , 64);
			if(!Error64Check)
				Error64 ++;
		}
		
		System.out.println();
		System.out.println("Burst Error Length: <32 bits");
		System.out.println("Number of frames: 1000");
		System.out.println("Error Detection Rate: "+(Error16/1000)*100);
		
		System.out.println();
		System.out.println("Burst Error Length: 32 bits");
		System.out.println("Number of frames: 1000");
		System.out.println("Error Detection Rate: "+(Error32/1000)*100);
		
		System.out.println();
		System.out.println("Burst Error Length: >32 bits");
		System.out.println("Number of frames: 1000");
		System.out.println("Error Detection Rate: "+(Error64/1000)*100);
	}

	private static Boolean CheckCRC(String divisor, int ErrLength) 
	{
		Boolean IsValid = true;
		Random RandByte = new Random(); 
		byte[] MsgByte = new byte[1524];	
		RandByte.nextBytes(MsgByte);
		String OriginalMsg = BytetoBinary(MsgByte);
		
		int OriginalMsgBinary[] = new int [OriginalMsg.length() + divisor.length() - 1];
		int divisorBinary[] = new int [divisor.length()];
		for(int i = 0 ; i < OriginalMsg.length() ; i++)
			OriginalMsgBinary[i] = Integer.parseInt(String.valueOf(OriginalMsg.charAt(i)));
		for(int i = 0 ; i < divisor.length() ; i++)
			divisorBinary[i] = Integer.parseInt(String.valueOf(divisor.charAt(i)));
		
		for (int i = 0; i < OriginalMsg.length(); i++)
        {
            if (OriginalMsgBinary[i] == 1)
                for (int j = 0; j < divisorBinary.length; j++)
                	OriginalMsgBinary[i + j] ^= divisorBinary[j];
        }
		
        int BurstBit = (int) (Math.random() * 1.99);
        int RecvMsgBinary[] = IntroduceBurst(OriginalMsgBinary , ErrLength , BurstBit);
        
        for (int i = 0; i < OriginalMsg.length(); i++)
        {
            if (RecvMsgBinary[i] == 1)
                for (int j = 0; j < divisorBinary.length; j++)
                	RecvMsgBinary[i + j] ^= divisorBinary[j];
        }
		
		for (int i = 0; i < RecvMsgBinary.length; i++)
        {
			if (RecvMsgBinary[i] == 1)
			{
				IsValid = false;
				break;
			}
        }
		return IsValid;
	}

	private static int[] IntroduceBurst(int[] OriginalMsgBinary , int MaxIndex , int BurstBit) 
	{
		int BurstErrStartIdx = (int) (Math.random() * (OriginalMsgBinary.length - MaxIndex));
		int RecvMsgBinary[] = new int [OriginalMsgBinary.length];
		RecvMsgBinary = OriginalMsgBinary;
		
		for(int i = BurstErrStartIdx ; i <  BurstErrStartIdx + MaxIndex ; i++)
			RecvMsgBinary[i] = BurstBit;
		
		return RecvMsgBinary;
	}

	private static String BytetoBinary(byte[] MsgByte) 
	{
		StringBuilder sb = new StringBuilder(MsgByte.length * Byte.SIZE);
	    for( int i = 0; i < Byte.SIZE * MsgByte.length; i++ )
	        sb.append((MsgByte[i / Byte.SIZE] << i % Byte.SIZE & 0x80) == 0 ? '0' : '1');
	    return sb.toString();
	}

}


