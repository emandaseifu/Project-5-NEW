package prj5;

import java.io.FileNotFoundException;
import java.text.ParseException;
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

    public static void main(String[] args) {
        try {
            if (args.length == 1) {
                ChannelReader reader = new ChannelReader(args[0]);
                DLList<String> channelView = reader.getChannel();
            }
            else {
                ChannelReader reader = new ChannelReader(
                    "SampleInput1_2022.csv");
                DLList<String> channelView = reader.getChannel();
            }
        }
        catch (FileNotFoundException e) {
            System.out.println("File not found: " + e.getMessage());
        }
        catch (ParseException e) {
            System.out.println(
                "An error occurred while parsing the input file: " + e
                    .getMessage());
        }
    }

}
