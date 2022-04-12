package edu.cuny.citytech.cst.retirement.model;

import java.util.List;

public class RichClient {
    private List<Client> results;
    private float total;
    private float totalCount;
    private float totalPercentage;

    public List<Client> getResults() {
        return results;
    }

    public void setResults(List<Client> results) {
        this.results = results;
    }

    public float getTotal() {
        return total;
    }

    public void setTotal(float total) {
        this.total = total;
    }

    public float getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(float totalCount) {
        this.totalCount = totalCount;
    }

    public float getTotalPercentage() {
        return totalPercentage;
    }

    public void setTotalPercentage(float totalPercentage) {
        this.totalPercentage = totalPercentage;
    }

    @Override
    public String toString() {
        return "ServerData{" +
                "results=" + results +
                ", total=" + total +
                ", totalCount=" + totalCount +
                ", totalPercentage=" + totalPercentage +
                '}';
    }
}
