
import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
public class BinarytoText{
public static void main( String args[] ) throws IOException{

	Path path = Paths.get("binary.txt"); 
	byte[] data = Files.readAllBytes(path);
	String s1 = new String(data);
	s1 = s1.replace("111110", "11111");
	String str = "";
	for (int j = 0; j < s1.length()/8; j++) {

        int a = Integer.parseInt(s1.substring(8*j,(j+1)*8),2);
        str += (char)(a);
    }
	System.out.print(str);
	try (Writer writer = new BufferedWriter(new OutputStreamWriter(
            new FileOutputStream("Text.txt"), "utf-8"))) {
 writer.write(str);
}
}
}