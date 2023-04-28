package prj5;

import cs2.Button;
import cs2.CircleShape;
import cs2.Shape;
import cs2.TextShape;
import cs2.Window;
import cs2.WindowSide;
import java.awt.Color;

/**
 * The Window class
 *
 * @author Emanda Seifu
 * @author Shreyas Kunaparaju
 * @author Arnav Sharma
 * @version 04.28.2023
 */
public class Window {
    
    private Window window;
    private GUI gui;
    
    public Window(ChannelReader reader) {
        gui = new GUI(reader);
        this.window = new Window("Social Media Visualization");
        
        addButtons();
        addShapes();
        
        window.onClick(gui, "clickedNameSort");
    }
    
    /**
     * Add buttons to the window
     */
    private void addButtons() {
        window.addButton(gui.getNameSortButton(), WindowSide.NORTH);
        window.addButton(gui.getRateSortButton(), WindowSide.NORTH);
        window.addButton(gui.getQuitButton(), WindowSide.NORTH);
        window.addButton(gui.getTraditionalButton(), WindowSide.WEST);
        window.addButton(gui.getReachButton(), WindowSide.WEST);
        window.addButton(gui.getJanButton(), WindowSide.SOUTH);
        window.addButton(gui.getFebButton(), WindowSide.SOUTH);
        window.addButton(gui.getMarButton(), WindowSide.SOUTH);
        window.addButton(gui.getQuarterButton(), WindowSide.SOUTH);
    }
    
    /**
     * Add shapes to the window
     */
    private void addShapes() {
        TextShape title = new TextShape(200, 20, "Social Media Visualization");
        title.setBackgroundColor(Color.WHITE);
        window.addShape(title);
        
        CircleShape shape = new CircleShape(200, 100, 50, Color.BLUE);
        window.addShape(shape);
    }
    
    public static void main(String[] args) {
        ChannelReader reader = new ChannelReader();
        Window window = new Window(reader);
    }
    
}
