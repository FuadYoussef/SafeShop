package tech.youssef.safeshop;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class Business {
    private String name;
    private int numCustomers;
    private int numShopping;
    private int numWaiting;
    private int maxOccupancy;
    private ArrayList<String> reviews;
    private ArrayList<String> policies;
    private double rating;
    private int ratingSum;
    private int numRating;
    private String type;
    private int range;

    public Business(String name, int maxOccupancy, int range, String type, ArrayList<String> reviews, ArrayList<String> policies) {
        this.name = name;
        this.numCustomers = 0;
        this.numShopping = 0;
        this.numWaiting = 0;
        this.maxOccupancy = maxOccupancy;

        this.rating = 0;
        this.ratingSum = 0;
        this.numRating = 0;
        this.reviews = reviews;
        this.policies = policies;
        this.type = type;
        this.range = range;
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

    public void addRating(int customerRating, String review) {
        numRating++;
        ratingSum += customerRating;
        rating = (double)ratingSum/(double)numRating;

        reviews.add(review);
    }

    public void addPolicy(String policy) {
        policies.add(policy);
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

    public ArrayList<String> getReviews() {
        return reviews;
    }

    public ArrayList<String> getPolicies() {
        return policies;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public int getRange() {
        return range;
    }

    public void setNumWaiting(int i) {
        this.numWaiting = i;
        this.numCustomers = numWaiting+numShopping;
    }
    public void setNumShopping(int i) {
        this.numShopping = i;
        this.numCustomers = numWaiting+numShopping;
    }
}
