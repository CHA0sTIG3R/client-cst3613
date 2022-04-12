package edu.cuny.citytech.cst.retirement.model;

public class Client implements IPie, Comparable<Client> {
    private String clientId;
    private float amount;
    private float percentage;

    public Client() {
    }

    public Client(String clientId, float amount) {
        this.clientId = clientId;
        this.amount = amount;
    }

    public float getPercentage() {
        return percentage;
    }

    public void setPercentage(float percentage) {
        this.percentage = percentage;
    }

    public String getClientId() {
        return clientId;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    public float getAmount() {
        return amount;
    }

    public void setAmount(float amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "Client{" +
                "clientId='" + clientId + '\'' +
                ", amount=" + amount +
                ", percentage=" + percentage +
                '}';
    }

    @Override
    public String getId() {
        return this.clientId;
    }

    @Override
    public Number getValue() {
        return this.amount;
    }

    @Override
    public Number getPercent() {
        return this.percentage;
    }

    @Override
    public int compareTo(Client pClient) {
        return Float.compare(this.getAmount(), pClient.getAmount());
    }
}
