
import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
public class TextToBinary{
public static void main( String args[] ) throws IOException{

	Path path = Paths.get("input.txt"); 
	byte[] data = Files.readAllBytes(path);
	
	String binary = "";
	for(byte character : data){
		String temp = Integer.toBinaryString(character);
		while(temp.length()!=8){
			temp = "0" + temp;
		}
		binary = binary + temp;
	}
	binary = binary.replace("11111", "111110");
	
	try (Writer writer = new BufferedWriter(new OutputStreamWriter(
            new FileOutputStream("filename.txt"), "utf-8"))) {
 writer.write(binary);
}
	System.out.println(binary);
	
	
}

}
