package prj5;

import cs2.Button;
import cs2.CircleShape;
import cs2.Command;
import cs2.Shape;
import cs2.TextShape;
import cs2.Window;
import cs2.WindowSide;
import java.awt.Color;
import java.io.FileNotFoundException;
import java.util.Comparator;
import java.util.Scanner;
import acm.util.RandomGenerator;

/**
 * The GUI class
 *
 * @author Emanda Seifu
 * @author Shreyas Kunaparaju
 * @author Arnav Sharma
 * @version 04.28.2023
 */
public class GUI {
    private Window window;
    private Button quit;
    private Button nameSort;
    private Button rateSort;
    private Button traditional;
    private Button reach;
    private Button jan;
    private Button feb;
    private Button mar;
    private Button quarter;
    private EngagementCalculator calculator;
    private ChannelReader reader;
    private RandomGenerator randomGenerator;
    private Influencer influencer;
    private DLList<Influencer> list;
    private final int MAX_BAR_HEIGHT = 100;

    /**
     * This is the GUI class for the project which handles the buttons and other
     * things
     * 
     * @param reader
     *            is the reader for the channel
     */
    public GUI(ChannelReader reader) {
        this.reader = reader;
        window = new Window("Social Media Visualization");

        nameSort = new Button("Sort by Channel Name");
        this.window.addButton(nameSort, WindowSide.NORTH);

        rateSort = new Button("Sort by Engagement Rate");
        this.window.addButton(rateSort, WindowSide.NORTH);

        quit = new Button("Quit");
        this.window.addButton(quit, WindowSide.NORTH);
        quit.onClick(this, "clickedQuit");

        traditional = new Button("Traditional Engagement Rate");
        this.window.addButton(traditional, WindowSide.WEST);

        reach = new Button("Reach Engagement Rate");
        this.window.addButton(reach, WindowSide.WEST);

        jan = new Button("January");
        this.window.addButton(jan, WindowSide.SOUTH);

        feb = new Button("February");
        this.window.addButton(feb, WindowSide.SOUTH);

        mar = new Button("March");
        this.window.addButton(mar, WindowSide.SOUTH);

        quarter = new Button("First Quarter (Jan - March)");
        this.window.addButton(quarter, WindowSide.SOUTH);
        randomGenerator = new RandomGenerator();

        DLList<Influencer> list = new DLList<Influencer>();
        list.add(new Influencer(Months.JANUARY, "A", "A", "A", "A", 1000000,
            1000000, 1000000, 10000000, 10000));
        list.add(new Influencer(Months.JANUARY, "A", "A", "A", "A", 1000000,
            1000000, 1000000, 10000000, 10000));
        list.add(new Influencer(Months.JANUARY, "A", "A", "A", "A", 1000000,
            1000000, 1000000, 10000000, 10000));
        list.add(new Influencer(Months.JANUARY, "A", "A", "A", "A", 1000000,
            1000000, 1000000, 10000000, 10000));
        drawShapes(list);
        influencer = new Influencer(Months.JANUARY, "A", "A", "A", "A", 1000000,
            1000000, 1000000, 10000000, 10000);
    }


    /**
     * this method acts as the quit function for the terminal 
     */

    public void clickedQuit(Button button) {
        System.exit(0);
    }


    /**
     * this method acts as  the sort by username method 
     * @button as a button 
     */
    public void clickedNameSort(Button button) {

        try {
            ChannelReader reader = new ChannelReader("SampleInput1_2022.csv");
            DLList<Influencer> list = reader.getInfluencers();
            this.drawShapes(list);
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + e.getMessage());
        }

    }
 

    /**
     * uses the insertion comparator to filter through the channel names
     * @param nameSort as a button 
     */
    public void clickedChannelName(Button nameSort) {
        DLList<Influencer> listJan = new DLList<Influencer>();
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getMonths() == Months.JANUARY) {
                Influencer atI = list.getValueAt(i);
                listJan.add(atI);
            }

        }
        list.insertionSort(new ChannelNameComparator());
        this.drawShapes(list);

    }


    /**
     * uses the insertion comparator to filter through the engagement calculator
     * values
     * @param btn as a button 
     */
    public void clickedTraditional(Button btn) {
        list.insertionSort((Comparator<Influencer>)new EngagementComparator());
        this.drawShapes(list);
    }


    /**
     * draw shapes
     * @param list as a DLList
     * 
     * @return
     */
    public void drawShapes(DLList<Influencer> list) {
        window.removeAllShapes();
        Shape[] bars = new Shape[list.size()];
        TextShape[] textShapes1 = new TextShape[list.size()];
        TextShape[] textShapes2 = new TextShape[list.size()];
        double maxEngagementRate = getMaxEngagementRate(list);

        for (int i = 0; i < list.size(); i++) {
            double scaledEngagementRate = list.get(i).getEngagementRate() / maxEngagementRate;
            int barHeight = (int) (scaledEngagementRate * MAX_BAR_HEIGHT);

            bars[i] = new Shape(50 * (i + 1), 100 + MAX_BAR_HEIGHT - barHeight, 10, barHeight, Color.RED);
            textShapes1[i] = new TextShape(50 * (i + 1), bars[i].getY()
                + bars[i].getHeight() + 20, list.get(i).getChannel());
            textShapes2[i] = new TextShape(50 * (i + 1), textShapes1[i].getY()
                + textShapes1[i].getHeight() + 20, Double.toString(list.get(i).getEngagementRate()));

            window.addShape(bars[i]);
            window.addShape(textShapes1[i]);
            window.addShape(textShapes2[i]);
        }
    }

    private double getMaxEngagementRate(DLList<Influencer> list) {
        double maxEngagementRate = 0;
        for (int i = 0; i < list.size(); i++) {
            Influencer influencer = list.get(i);
            if (influencer.getEngagementRate() > maxEngagementRate) {
                maxEngagementRate = influencer.getEngagementRate();
            }
        }
        return maxEngagementRate;
    }
}
