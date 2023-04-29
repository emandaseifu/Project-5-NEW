package prj5;

import cs2.Button;
import cs2.CircleShape;
import cs2.Shape;
import cs2.TextShape;
import cs2.Window;
import cs2.WindowSide;
import java.awt.Color;
import java.util.Scanner;

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

    /**
     * 
     * @param calc
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
    }

    /**
     * 
     */
    public void clickedQuit(Button button) {
        System.exit(0);
    }

    /**
     * 
     */
    public void clickedNameSort(Shape shape) {
        if (nameSort == null) {
            TextShape text = new TextShape(0, 0, "Sort by Channel Name");
            int x = window.getGraphPanelWidth() / 2 - text.getWidth() / 2;
            int y = window.getGraphPanelHeight() / 2 - text.getHeight() / 2;
            text.setX(x);
            text.setY(y);

            window.addShape(text);
        }
        else {
            int minSize = 50;
            int maxSize = 100;
            int size = minSize + randomGenerator.nextInt(maxSize - minSize);
            int x = randomGenerator.nextInt(window.getGraphPanelWidth() - size);
            int y = randomGenerator.nextInt(window.getGraphPanelHeight()
                - size);
            nameSort = new Shape(x, y, size, Color.GRAY);

            nameSort.onClick(this, "clickedQuit");
            window.addButton(quitButton, WindowSide.NORTH);

            currentShape = new CircleShape(x, y, size, Color.RED);
        }
    }

    /**
     * 
     */
    public void clickedRateSort() {
        window.removeShape(shape);
        bag.remove(shape);

        Shape nextShape = bag.pick();
        if (nextShape == null) {
            TextShape text = new TextShape(0, 0, "Sort by Rate");
            int x = window.getGraphPanelWidth() / 2 - text.getWidth() / 2;
            int y = window.getGraphPanelHeight() / 2 - text.getHeight() / 2;
            text.setX(x);
            text.setY(y);

            window.addShape(text);
        }
        else {
            window.addShape(nextShape);
        }
    }
    
    
    /**
     * 
     */
    public void clickedTraditional() {
        window.removeShape(shape);
        bag.remove(shape);

        Shape nextShape = bag.pick();
        if (nextShape == null) {
            TextShape text = new TextShape(0, 0, "Traditional Engagement Rate");
            int x = window.getGraphPanelWidth() / 2 - text.getWidth() / 2;
            int y = window.getGraphPanelHeight() / 2 - text.getHeight() / 2;
            text.setX(x);
            text.setY(y);

            window.addShape(text);
        }
        else {
            window.addShape(nextShape);
        }
    }


    /**
     * 
     */
    public void clickedReach() {
        window.removeShape(shape);
        bag.remove(shape);

        Shape nextShape = bag.pick();
        if (nextShape == null) {
            TextShape text = new TextShape(0, 0, "Reach Engagement Rate");
            int x = window.getGraphPanelWidth() / 2 - text.getWidth() / 2;
            int y = window.getGraphPanelHeight() / 2 - text.getHeight() / 2;
            text.setX(x);
            text.setY(y);

            window.addShape(text);
        }
        else {
            window.addShape(nextShape);
        }
    }


    /**
     * 
     */
    public void clickedJan() {
        window.removeShape(shape);
        bag.remove(shape);

        Shape nextShape = bag.pick();
        if (nextShape == null) {
            TextShape text = new TextShape(0, 0, "January");
            int x = window.getGraphPanelWidth() / 2 - text.getWidth() / 2;
            int y = window.getGraphPanelHeight() / 2 - text.getHeight() / 2;
            text.setX(x);
            text.setY(y);

            window.addShape(text);
        }
        else {
            window.addShape(nextShape);
        }
    }


    /**
     * 
     */
    public void clickedFeb() {
        window.removeShape(shape);
        bag.remove(shape);

        Shape nextShape = bag.pick();
        if (nextShape == null) {
            TextShape text = new TextShape(0, 0, "February");
            int x = window.getGraphPanelWidth() / 2 - text.getWidth() / 2;
            int y = window.getGraphPanelHeight() / 2 - text.getHeight() / 2;
            text.setX(x);
            text.setY(y);

            window.addShape(text);
        }
        else {
            window.addShape(nextShape);
        }
    }

    /**
     * 
     */
    public void clickedMar() {
        window.removeShape(shape);
        bag.remove(shape);

        Shape nextShape = bag.pick();
        if (nextShape == null) {
            TextShape text = new TextShape(0, 0, "March");
            int x = window.getGraphPanelWidth() / 2 - text.getWidth() / 2;
            int y = window.getGraphPanelHeight() / 2 - text.getHeight() / 2;
            text.setX(x);
            text.setY(y);

            window.addShape(text);
        }
        else {
            window.addShape(nextShape);
        }
    }

    /**
     * 
     */
    public void clickedQuarter() {
        window.removeShape(shape);
        bag.remove(shape);

        Shape nextShape = bag.pick();
        if (nextShape == null) {
            TextShape text = new TextShape(0, 0, "First Quarter (Jan - March)");
            int x = window.getGraphPanelWidth() / 2 - text.getWidth() / 2;
            int y = window.getGraphPanelHeight() / 2 - text.getHeight() / 2;
            text.setX(x);
            text.setY(y);

            window.addShape(text);
        }
        else {
            window.addShape(nextShape);
        }
    }
}
