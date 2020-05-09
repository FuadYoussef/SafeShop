package tech.youssef.safeshop;

public class Business {
    private String name;
    private int numCustomers;
    private int numShopping;
    private int numWaiting;
    private int maxOccupancy;
    private double rating;
    private int ratingSum;
    private int numRating;

    public Business(String name, int maxOccupancy) {
        this.name = name;
        this.numCustomers = 0;
        this.numShopping = 0;
        this.numWaiting = 0;
        this.maxOccupancy = maxOccupancy;

        this.rating = 0;
        this.ratingSum = 0;
        this.numRating = 0;
    }

    public void addCustomer() {
        numCustomers++;
        if(numCustomers < maxOccupancy) {
            numShopping = numCustomers;
        } else {
            numShopping = maxOccupancy;
            numWaiting = numCustomers - numShopping;
        }
    }

    public void reduceCustomer() {
        numCustomers--;
        if(numCustomers < 0) {
            numCustomers = 0;
            numShopping = 0;
            numWaiting = 0;
        } else {
            numWaiting--;
            if (numWaiting < 0) {
                numWaiting = 0;
                numShopping--;
            }
        }
    }

    public void addRating(int customerRating) {
        numRating++;
        ratingSum += customerRating;
        rating = (double)ratingSum/(double)numRating;
    }

    public int getNumCustomers() {
        return numCustomers;
    }

    public int getNumWaiting() {
        return numWaiting;
    }

    public int getNumShopping() {
        return numShopping;
    }

    public double getRating() {
        if (numRating == 0) {
            return 0;
        }
        return rating;
    }
}
