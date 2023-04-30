package prj5;

/**
 * The Statistics class
 *
 * @author Emanda Seifu
 * @author Shreyas Kunaparaju
 * @author Arnav Sharma
 * @version 04.28.2023
 */

/**
 * This class represents social media statistics for a certain month.
 */
public class Statistics implements Comparable<Statistics> {

    private int likes;
    private int posts;
    private int followers;
    private int comments;
    private int views;
    private Months months;

    /**
     * Constructs a new Statistics object with the given values.
     *
     * @param mon
     *            the month associated with these statistics
     * @param li
     *            the number of likes
     * @param pt
     *            the number of posts
     * @param fw
     *            the number of followers
     * @param ct
     *            the number of comments
     * @param vw
     *            the number of views
     */
    public Statistics(Months mon, int li, int pt, int fw, int ct, int vw) {
        likes = li;
        posts = pt;
        followers = fw;
        comments = ct;
        views = vw;
        months = mon;
    }


    /**
     * Returns number of likes.
     *
     * @return the number of likes
     */
    public int getLikes() {
        return likes;
    }


    /**
     * Returns number of posts.
     *
     * @return the number of posts
     */
    public int getPosts() {
        return posts;
    }


    /**
     * Returns number of followers.
     *
     * @return the number of followers
     */
    public int getFollowers() {
        return followers;
    }


    /**
     * Returns number of comments.
     *
     * @return the number of comments
     */
    public int getComments() {
        return comments;
    }


    /**
     * Returns number of views.
     *
     * @return the number of views
     */
    public int getViews() {
        return views;
    }


    /**
     * Returns month associated with these statistics.
     *
     * @return the month associated with these statistics
     */
    public Months getMonths() {
        return months;
    }


    /**
     * Checks if these statistics are less than or equal to the other
     * statistics.
     *
     * @param other
     *            the other statistics to compare to
     * @return true if these statistics are less than or equal to the other
     *         statistics, false otherwise
     */
    public boolean isLessThanOrEqualTo(Statistics other) {
        return (this.likes <= other.likes) && (this.posts <= other.posts)
            && (this.followers <= other.followers)
            && (this.comments <= other.comments) && (this.views <= other.views);
    }


    /**
     * Compares this Statistics object with the other Statistics object.
     * Returns -1, 0, or 1 if this object is less than, equal to, or greater
     * than the other object, respectively.
     *
     * @param stats
     *            the other Statistics object to compare to
     * @return -1, 0, or 1 if this object is less than, equal to, or greater
     *         than the other object, respectively
     */
    @Override
    public int compareTo(Statistics stats) {
        if (stats == null) {
            throw new IllegalArgumentException();
        }
        int otherTotal = 0;
        int total = 0;

        if (this.likes < stats.likes) {
            return -1;
        }
        if (this.likes > stats.likes) {
            return 1;
        }
        if (this.posts < stats.posts) {
            return -1;
        }
        if (this.posts > stats.posts) {
            return 1;
        }
        if (this.followers < stats.followers) {
            return -1;
        }
        if (this.followers > stats.followers) {
            return 1;
        }
        if (this.comments < stats.comments) {
            return -1;
        }
        if (this.comments > stats.comments) {
            return 1;
        }
        if (this.views < stats.views) {
            return -1;
        }
        if (this.views > stats.views) {
            return 1;
        }

        return 0;

    }
}
