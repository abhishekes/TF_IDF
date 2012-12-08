import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;
import java.io.*;


public class term_freq {
    //Method to invoke : java term_freq <input_filename> <output_file_name>
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
        HashMap<String, Integer> wordmap = new HashMap<String, Integer>();
		Integer totalCount = 0;
        try {
			while ((line = br.readLine()) != null) {
			   
				String[] tokens = line.toLowerCase().split("[^a-z\n]");
				
				for (String word : tokens) {
					Integer count = 1;
					if (word.trim().equals("")) {
						continue;
					}
					totalCount++;
					if (wordmap.containsKey(word)) {
                        count += (Integer)wordmap.get(word);
                        wordmap.remove(word);
					}
					wordmap.put(word, count);
				}
			}
			
			Iterator<String> iterator = wordmap.keySet().iterator();
	
			
			while (iterator.hasNext()) {
				String keyString =  (String) iterator.next();
				FileWriter fstream = new FileWriter(new String ("inter_" + args[1] + "_" +  keyString), true);
				BufferedWriter output = new BufferedWriter(fstream);
				//String key = (String) iterator.next();
				Integer count = wordmap.get(keyString);
				//output.write(key + ":"+ count.doubleValue()/totalCount.doubleValue() + "\n");
				output.write(keyString + ":"+ args[0] + " , " + count.doubleValue()/totalCount.doubleValue() + "\n");
				output.close();
			}
			
			
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