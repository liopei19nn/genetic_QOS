/**
 *
 */
package model;

/**
 * @author Li Pei
 *
 * Andrew ID : lip
 */
public class WebService {
    private String name;
    private double cost;
    private double time;
    private double reliability;
    private double availability;

    public WebService(String name, double cost, double reliability, double time, double availability) {
        this.name = name;
        this.cost = cost / 53;
        this.reliability = reliability;
        this.time = time / 23;
        this.availability = availability;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name
     *            the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the cost
     */
    public double getCost() {
        return cost;
    }

    /**
     * @param cost
     *            the cost to set
     */
    public void setCost(int cost) {
        this.cost = cost;
    }

    /**
     * @return the time
     */
    public double getTime() {
        return time;
    }

    /**
     * @param time
     *            the time to set
     */
    public void setTime(int time) {
        this.time = time;
    }

    /**
     * @return the reliability
     */
    public double getReliability() {
        return reliability;
    }

    /**
     * @param reliability
     *            the reliability to set
     */
    public void setReliability(double reliability) {
        this.reliability = reliability;
    }

    /**
     * @return the availability
     */
    public double getAvailability() {
        return availability;
    }

    /**
     * @param availability
     *            the availability to set
     */
    public void setAvailability(double availability) {
        this.availability = availability;
    }

}
