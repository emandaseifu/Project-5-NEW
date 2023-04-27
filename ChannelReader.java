package prj5;

import java.io.FileNotFoundException;
import java.io.File;
import java.util.Scanner;

/**
 * The Channel Reader class
 *
 * @author Emanda Seifu
 * @author Shreyas Kunaparaju
 * @author Arnav Sharma
 * @version 04.28.2023
 */
public class ChannelReader {
    private DLList<Influencer> influencers;
    private String filename;

    public ChannelReader(String influencerFileName)
        throws FileNotFoundException {
        influencers = readDataFile(influencerFileName);

    }
    
    public DLList<Influencer> getInfluencers(){
        return influencers;
    }

    

    private DLList<Influencer> readDataFile(String fileName)
        throws FileNotFoundException {
        DLList<Influencer> localInfluencers = new DLList<Influencer>();
        Scanner file = new Scanner(new File(fileName));
        int lineCount = 0;
        int dataCount = 0;
        boolean firstLine = true;
        while (file.hasNextLine()) {
            String read = file.nextLine();
            if (firstLine) {
                firstLine = false;
            }
            else {

                String tokens[] = read.split(",");
                int tokenCount = 0;

                Months months = null;
                if (tokens[0].equals("January")) {
                    months = Months.JANUARY;
                }
                else if (tokens[1].equals("February")) {
                    months = Months.FEBRUARY;
                }
                else if (tokens[2].equals("March")) {
                    months = Months.MARCH;
                }
                /**
                 * once we have month, check if it is already in the class
                 */
                String name = String.valueOf(tokens[1]);
                String channel = String.valueOf(tokens[2]);
                String country = String.valueOf(tokens[3]);
                String topic = String.valueOf(tokens[4]);
                int li = Integer.valueOf(tokens[5]);
                int pt = Integer.valueOf(tokens[6]);
                int fw = Integer.valueOf(tokens[7]);
                int ct = Integer.valueOf(tokens[8]);
                int vw = Integer.valueOf(tokens[9]);

                Influencer inf = new Influencer(months, name, channel,
                    country, topic, li, pt, fw, ct, vw);
                
                localInfluencers.add(inf);
            }

        }

        file.close();
        return localInfluencers;
    }


    public DLList<String> getChannel() throws FileNotFoundException {
        DLList<String> channels = new DLList<>();
        Scanner scanner = new Scanner(new File(filename));
        scanner.nextLine(); // skip header row

        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            String[] tokens = line.split(",");

            channels.add(tokens[0]);
        }

        scanner.close();
        return channels;
    }
}
