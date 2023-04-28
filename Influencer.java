package prj5;

/**
 * The Influencer class holds the
 * names of influencers and their
 * social media accounts.
 *
 * @author Emanda Seifu
 * @author Shreyas Kunaparaju
 * @author Arnav Sharma
 * @version 04.28.2023
 */
public class Influencer {

    /**
     * Represents the name
     */
    private String name;

    /**
     * Represents the channel
     */
    private String channel;

    /**
     * Represents the country
     */
    private String country;

    /**
     * Represents the topic
     */
    private String topic;

    /**
     * Represents the months
     * 
     * private Months months;
     */

    /**
     * Represents the Array of the Statistics
     */
    @SuppressWarnings("rawtypes")
    private Statistics[] myArray;

    /**
     * Creates the Influencer objects
     * 
     * @param months
     *            the number of months the statistics cover
     * @param name
     *            the name of the influencer
     * @param channel
     *            the channel/platform the influencer uses
     * @param country
     *            the country the influencer is based in
     * @param topic
     *            the topic/niche the influencer focuses on
     * @param li
     *            the number of likes on the influencer's posts
     * @param pt
     *            the number of post shares
     * @param fw
     *            the number of followers the influencer has
     * @param ct
     *            the number of comments on the influencer's posts
     * @param vw
     *            the number of views on the influencer's posts
     */
    public Influencer(
        Months months,
        String name,
        String channel,
        String country,
        String topic,
        int li,
        int pt,
        int fw,
        int ct,
        int vw) {
        this.name = name;
        this.channel = channel;
        this.country = country;
        this.topic = topic;

        myArray = new Statistics[3];
        myArray[0] = new Statistics(months, li, pt, fw, ct, vw);

    }


    /**
     * @return name
     *         retrieves the name
     */
    public String getName() {
        return name;
    }


    /**
     * @return channel
     *         retrieves the channel
     */
    public String getChannel() {
        return channel;
    }


    /**
     * @return country
     *         retrieves the country
     */
    public String getCountry() {
        return country;
    }


    /**
     * @return topic
     *         retrieves the topic
     */
    public String getTopic() {
        return topic;
    }


    /**
     * @return myArray
     *         retrieves the Statistics
     */
    public Statistics[] getStats() {
        return myArray;
    }


    /**
     * Sorts the array of statistics based on the influencer's name.
     *
     * @param args
     *            The influencer to sort.
     * @param other
     *            The statistics used to initialize the sorted array.
     */
    public void nameSort(Influencer args, Statistics other) {
        Statistics temp;
        for (int j = 0; j < myArray.length; j++) {
            for (int i = j + 1; i < myArray.length; i++) {
                if (myArray[0].compareTo(myArray[1]) < 0) {
                    temp = myArray[j];
                    myArray[j] = myArray[i];
                    myArray[i] = temp;

                }
                if (this.name.equals(this.channel)) {
                    myArray[0] = new Statistics(Months.JANUARY, other
                        .getComments(), other.getFollowers(), other.getLikes(),
                        other.getPosts(), other.getViews());
                    myArray[1] = new Statistics(Months.FEBRUARY, other
                        .getComments(), other.getFollowers(), other.getLikes(),
                        other.getPosts(), other.getViews());
                    myArray[2] = new Statistics(Months.MARCH, other
                        .getComments(), other.getFollowers(), other.getLikes(),
                        other.getPosts(), other.getViews());

                }
            }
        }
    }


    /**
     * Sorts the rate of the specific influencer by calculating their statistics
     * 
     * @param calc
     *            Engagement calculator to use for calculating reach.
     * @param other
     *            Statistics to use for filling the sorted array.
     */
    public void rateSort(EngagementCalculator calc, Statistics other) {
        Statistics temp;
        for (int j = 0; j < myArray.length; j++) {
            for (int i = j + 1; i < myArray.length; i++) {
                if (myArray[j].compareTo(myArray[i]) < 0) {
                    temp = myArray[j];
                    myArray[j] = myArray[i];
                    myArray[i] = temp;
                }
            }
        }
        if (this.name.equals(this.channel)) {
            if (calc.getEngagementRate() == calc.rate) {
                myArray[0] = new Statistics(Months.JANUARY, other.getComments(),
                    other.getFollowers(), other.getLikes(), other.getPosts(),
                    other.getViews());
                myArray[1] = new Statistics(Months.FEBRUARY, other
                    .getComments(), other.getFollowers(), other.getLikes(),
                    other.getPosts(), other.getViews());
                myArray[2] = new Statistics(Months.MARCH, other.getComments(),
                    other.getFollowers(), other.getLikes(), other.getPosts(),
                    other.getViews());
            }
        }
    }


    /**
     * Sorts the traditional rate of the specific influencer by calculating
     * their statistics
     * 
     * @param calc
     *            Engagement calculator to use for calculating reach.
     * @param other
     *            Statistics to use for filling the sorted array.
     */
    public void traditionalSort(EngagementCalculator calc, Statistics other) {
        Statistics temp;
        for (int j = 0; j < myArray.length; j++) {
            for (int i = j + 1; i < myArray.length; i++) {
                if (myArray[j].compareTo(myArray[i]) < 0) {
                    temp = myArray[j];
                    myArray[j] = myArray[i];
                    myArray[i] = temp;
                }
            }
        }
        if (this.name.equals(this.channel)) {
            if (calc.getEngagementRate() == calc.rate) {
                myArray[0] = new Statistics(Months.JANUARY, other.getComments(),
                    other.getFollowers(), other.getLikes(), other.getPosts(),
                    other.getViews());
                myArray[1] = new Statistics(Months.FEBRUARY, other
                    .getComments(), other.getFollowers(), other.getLikes(),
                    other.getPosts(), other.getViews());
                myArray[2] = new Statistics(Months.MARCH, other.getComments(),
                    other.getFollowers(), other.getLikes(), other.getPosts(),
                    other.getViews());
            }
        }
    }


    /**
     * Sorts the statistics of the influencer by reach using the given
     * engagement calculator.
     * 
     * @param calc
     *            Engagement calculator to use for calculating reach.
     * @param other
     *            Statistics to use for filling the sorted array.
     */
    public void reachSort(EngagementCalculator calc, Statistics other) {
        Statistics temp;
        for (int j = 0; j < myArray.length; j++) {
            for (int i = j + 1; i < myArray.length; i++) {
                if (myArray[0].compareTo(myArray[1]) < 0) {
                    temp = myArray[j];
                    myArray[j] = myArray[i];
                    myArray[i] = temp;
                }
                if (this.name.equals(this.channel)) {
                    if (calc.reach == (calc.getEngagementReach())) {
                        myArray[0] = new Statistics(Months.JANUARY, other
                            .getComments(), other.getFollowers(), other
                                .getLikes(), other.getPosts(), other
                                    .getViews());
                        myArray[1] = new Statistics(Months.FEBRUARY, other
                            .getComments(), other.getFollowers(), other
                                .getLikes(), other.getPosts(), other
                                    .getViews());
                        myArray[2] = new Statistics(Months.MARCH, other
                            .getComments(), other.getFollowers(), other
                                .getLikes(), other.getPosts(), other
                                    .getViews());
                    }
                }
            }
        }
    }


    /**
     * Sorts the statistics of the influencer by Janurary statistics.
     * 
     * @param other
     *            the Statistics object to be used for sorting
     */
    public void janSort(Statistics other) {
        Statistics temp;
        for (int j = 0; j < myArray.length; j++) {
            for (int i = j + 1; i < myArray.length; i++) {
                if (myArray[0].compareTo(myArray[1]) < 0) {
                    temp = myArray[j];
                    myArray[j] = myArray[i];
                    myArray[i] = temp;

                }
                if ((other.getMonths().equals(Months.JANUARY))) {
                    myArray[0] = new Statistics(Months.JANUARY, other
                        .getComments(), other.getFollowers(), other.getLikes(),
                        other.getPosts(), other.getViews());

                }
            }

        }

    }


    /**
     * Sorts the statistics of the influencer by February statistics.
     * 
     * @param other
     *            the Statistics object to be used for sorting
     */
    public void febSort(Statistics other) {
        Statistics temp;
        for (int j = 0; j < myArray.length; j++) {
            for (int i = j + 1; i < myArray.length; i++) {
                if (myArray[0].compareTo(myArray[1]) < 0) {
                    temp = myArray[j];
                    myArray[j] = myArray[i];
                    myArray[i] = temp;

                }
                if ((other.getMonths().equals(Months.FEBRUARY))) {
                    myArray[0] = new Statistics(Months.FEBRUARY, other
                        .getComments(), other.getFollowers(), other.getLikes(),
                        other.getPosts(), other.getViews());

                }
            }
        }
    }


    /**
     * Sorts the statistics of the influencer by March statistics.
     * 
     * @param other
     *            the Statistics object to be used for sorting
     */
    public void marSort(Statistics other) {
        Statistics temp;
        for (int j = 0; j < myArray.length; j++) {
            for (int i = j + 1; i < myArray.length; i++) {
                if (myArray[0].compareTo(myArray[1]) < 0) {
                    temp = myArray[j];
                    myArray[j] = myArray[i];
                    myArray[i] = temp;

                }
                if ((other.getMonths().equals(Months.MARCH))) {
                    myArray[0] = new Statistics(Months.MARCH, other
                        .getComments(), other.getFollowers(), other.getLikes(),
                        other.getPosts(), other.getViews());
                }
            }
        }

    }


    /**
     * Sorts the statistics of the influencer by quarter months statistics.
     * 
     * @param other
     *            the Statistics object to be used for sorting
     */
    public void quarterSort(Statistics other) {
        Statistics temp;
        for (int j = 0; j < myArray.length; j++) {
            for (int i = j + 1; i < myArray.length; i++) {
                if (myArray[0].compareTo(myArray[1]) < 0) {
                    temp = myArray[j];
                    myArray[j] = myArray[i];
                    myArray[i] = temp;

                }
                if ((other.getMonths().equals(Months.JANUARY)) && (other
                    .getMonths().equals(Months.FEBRUARY)) && (other.getMonths()
                        .equals(Months.MARCH))) {
                    myArray[0] = new Statistics(Months.JANUARY, other
                        .getComments(), other.getFollowers(), other.getLikes(),
                        other.getPosts(), other.getViews());
                    myArray[1] = new Statistics(Months.FEBRUARY, other
                        .getComments(), other.getFollowers(), other.getLikes(),
                        other.getPosts(), other.getViews());
                    myArray[2] = new Statistics(Months.MARCH, other
                        .getComments(), other.getFollowers(), other.getLikes(),
                        other.getPosts(), other.getViews());

                }
            }
        }

    }


    /**
     * Compares this Influencer object to the specified object for equality.
     * 
     * @param obj
     *            the object to compare this Influencer object against
     * @return true if the given object represents an Influencer equivalent to
     *         this Influencer, false otherwise
     */
    public boolean equals(Object obj) {

        if (obj == null) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        if (this.getClass() == obj.getClass()) {
            return this.getName().equals(((Influencer)obj).getName()) && this
                .getName().equals(((Influencer)obj).getName()) && this
                    .getChannel().equals(((Influencer)obj).getChannel()) && this
                        .getCountry().equals(((Influencer)obj).getCountry())
                && this.getTopic().equals(((Influencer)obj).getTopic()) && this
                    .getStats().equals(((Influencer)obj).getStats());
        }
        else {
            return false;
        }
    }
    /**
     * This method sorts the channels in the array by name first, and then engagement
     */
    Public void sortChannels()
{
for (int i = 0; i < myArray.length - 1; i++) {
        for (int j = i + 1; j < myArray.length; j++) {
            if (myArray[i].getChannelName().compareTo(myArray[j].getChannelName()) > 0) {
                Channel temp = myArray[i];
                myArray[i] = myArray[j];
                myArray[j] = temp;
            }
           else if (myArray[i].getChannelName().compareTo(myArray[j].getChannelName()) == 0) {
                if (myArray[i].getEngagement() < myArray[j].getEngagement()) {
                    Channel temp = myArray[i];
                    myArray[i] = myArray[j];
                    myArray[j] = temp;
                }
            }
        }
    }
}

}
