package prj5;

/**
 * The Engagement Calculator class
 *
 * @author Emanda Seifu
 * @author Shreyas Kunaparaju
 * @author Arnav Sharma
 * @version 04.28.2023
 */

public class EngagementCalculator {

    /**
     * The engagement rate calculated as a percentage of total engagements
     * (likes and comments) to total followers.
     */
    public double rate = 0;

    /**
     * The engagement reach calculated as a percentage of total engagements
     * to total views.
     */
    public double reach = 0;

    /**
     * The sum of total likes and comments.
     */
    private double sum = 0;

    /**
     * The total number of engagements (likes and comments).
     */
    private int totalEng = 0;

    /**
     * The total number of followers.
     */
    private int totalFol = 0;

    /**
     * The statistics used for the calculation.
     */
    private Statistics stats;

    /**
     * The engagement rate constant.
     */
    public static final int RATE = 3;

    /**
     * Creates a new instance of the EngagementCalculator class.
     * 
     * @param stats
     *            The statistics used for the calculation.
     */
    public EngagementCalculator(Statistics stats) {
        this.stats = stats;
        totalEng = stats.getComments() + stats.getLikes();
        totalFol = stats.getFollowers();
    }


    /**
     * Gets the engagement rate as a percentage of total engagements (likes and
     * comments) to total followers.
     * 
     * @return The engagement rate as a percentage.
     */
    public double getEngagementRate() {
        rate = (totalEng / (double)totalFol) * 100;
        return rate;
    }


    /**
     * Gets the engagement reach as a percentage of total engagements to total
     * views.
     * 
     * @return The engagement reach as a percentage.
     */
    public double getEngagementReach() {
        reach = (totalEng / (double)stats.getViews()) * 100;
        return reach;
    }


    /**
     * Gets the total number of engagements (likes and comments).
     * 
     * @return The total number of engagements.
     */
    public double getEngagement() {
        sum = stats.getComments() + stats.getLikes();
        return sum;
    }


    /**
     * Gets the total number of followers.
     * 
     * @return The total number of followers.
     */
    public int getFollowers() {
        return stats.getFollowers();
    }


    /**
     * Gets the total number of views for the given statistics.
     * 
     * @param stats
     *            The statistics object to get views from
     * @return The total number of views
     */
    public int getReach(Statistics stats) {
        return stats.getViews();
    }
}
