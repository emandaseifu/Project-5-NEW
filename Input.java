
package prj5;

import java.io.FileNotFoundException;
import java.io.File;

/**
 * The Input class
 *
 * @author Emanda Seifu
 * @author Shreyas Kunaparaju
 * @author Arnav Sharma
 * @version 04.28.2023
 */
public class Input {
    public static void main(String[] args) throws FileNotFoundException {
        /**
         * This is the main method for this project and it allows the project to run
         */
        if (args.length == 1) {
            ChannelReader reader = new ChannelReader(args[0]);
            DLList<Influencer> channelView = reader.getInfluencers();
            // channelView.sortbyChannel();

        }
        else {
            ChannelReader reader = new ChannelReader("SampleInput1_2022.csv");
            DLList<Influencer> channelView = reader.getInfluencers();
            for (int i = 0; i < channelView.size(); i++) {
                System.out.println(channelView.get(i));
            }
            GUI gui = new GUI(reader);
        }
    }

}
