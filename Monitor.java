package ir.ac.kntu;

import java.util.Objects;

public class Monitor extends Accessory {

    private int refreshRate;

    private int size;

    private int responseTime;

    private int number;

    public Monitor(String name, double price, int refreshRate, int size, int responseTime, int number) {
        super(name, price);
        this.refreshRate = refreshRate;
        this.size = size;
        this.responseTime = responseTime;
        this.number = number;
    }

    public int getRefreshRate() {
        return refreshRate;
    }

    public void setRefreshRate(int refreshRate) {
        this.refreshRate = refreshRate;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public int getResponseTime() {
        return responseTime;
    }

    public void setResponseTime(int responseTime) {
        this.responseTime = responseTime;
    }

    @Override
    public String toString() {
        return  ("Name: " + this.getName() +
                "\nRefreshRate: " + refreshRate +
                "\nSize: " + size +
                "\nResponseTime: " + responseTime +
                "\nNumber: " + number +
                "\nPrice: " + this.getPrice());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Monitor monitor = (Monitor) o;
        return refreshRate == monitor.refreshRate && size == monitor.size && responseTime == monitor.responseTime && number == monitor.number;
    }

    @Override
    public int hashCode() {
        return Objects.hash(refreshRate, size, responseTime, number);
    }
}
