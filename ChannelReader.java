package prj5;

import java.io.File;
import java.io.FileNotFoundException;
import java.text.ParseException;
import java.util.Scanner;

/**
 * The Channel Reader class 
 *
 * @author Emanda Seifu
 * @author Shreyas Kunaparaju
 * @author Arnav Sharma
 * @version 04.28.2023
 */
public class ChannelReader 
{
    private DLList<Influencer> person;

    public ChannelReader(String influencerFileName)
        throws java.text.ParseException,
        FileNotFoundException {
        person = readDataFile(influencerFileName);

    }

    private DLList<Influencer> readDataFile(String fileName) throws
    FileNotFoundException,
    java.text.ParseException {
        person = new DLList<Influencer>();
        Scanner file = new Scanner(new File(fileName));
        int lineCount = 0;
        int dataCount = 0;
        while (file.hasNextLine() && lineCount < 2) {
            String read = file.nextLine();
            Scanner currLine = new Scanner(read).useDelimiter(",");
            String tokens[] = new String[10];
            int tokenCount = 0;
            
            Months months = Months.valueOf(tokens[0]);
            if (tokens[0].equals("Januarary")) {
                months = Months.JANUARY;
            }
            else if (tokens[1].equals("Februaray")) {
                months = Months.FEBRUARY;
            }
            else if (tokens[2].equals("March")) {
                months = Months.MARCH;
            }
            
            String name = String.valueOf(tokens[1]);
            String channel = String.valueOf(tokens[2]);
            String country = String.valueOf(tokens[3]);
            String topic = String.valueOf(tokens[4]);
            int li = Integer.valueOf(tokens[5]);
            int pt = Integer.valueOf(tokens[6]);
            int fw = Integer.valueOf(tokens[7]);
            int ct = Integer.valueOf(tokens[8]);
            int vw = Integer.valueOf(tokens[9]);
            
            while (currLine.hasNext() && tokenCount < 10) {
                tokens[tokenCount++] = currLine.next();
            }
            currLine.close();
            
            if (tokenCount == 10) {
                Influencer inf = new Influencer(months, tokens[1], tokens[2],
                    tokens[3], tokens[4], li, pt, fw, ct, vw);
            }
            
            else {
                throw new java.text.ParseException("parse exception", 1);
            }
            
            lineCount++;
        }

        file.close();
        return person;
    }
}