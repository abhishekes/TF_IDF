import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.*;


public class inv_doc_freq {
    //Method to invoke : java inv_doc_freq <input_filename> <task_id>
        public static void main(String[] args) {

		BufferedReader br=null;
		try {
			br = new BufferedReader(new FileReader(args[0]));
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			System.out.println("The specified file " + args[0] + "was not found");
			e1.printStackTrace();
		}
        String line = "";
        //HashMap<String, Integer> wordmap = new HashMap<String, Integer>();
		Integer totalCount = 0;
        try {
			while ((line = br.readLine()) != null) {
			    totalCount++;
			}
            br.close();
            br = new BufferedReader(new FileReader(args[0]));
            Double multiplier = Math.log (1/totalCount.doubleValue());
            FileWriter fstream = new FileWriter("juice_inter_" + args[1], true);
			BufferedWriter output = new BufferedWriter(fstream);
            while ((line = br.readLine()) != null) {
			    String[] values = line.split(":")[1].split(",");
			    String  fileName = values[0];
			    String  tf_string = values[1];
			    Double tf = Double.parseDouble(tf_string);
			    Double result = tf * multiplier;
			    output.write( line.split(":")[0]+ " , " + fileName + " : " + result + "\n");
			    
			}
            output.close();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			br.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
