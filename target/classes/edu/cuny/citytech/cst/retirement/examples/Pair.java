package edu.cuny.citytech.cst.retirement.examples;

public class Pair {
    private String key;
    private float amount;

    public Pair(String key, float amount) {
        this.key = key;
        this.amount = amount;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public float getAmount() {
        return amount;
    }

    public void setAmount(float amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "Pair{" +
                "key='" + key + '\'' +
                ", amount=" + amount +
                '}';
    }
}
