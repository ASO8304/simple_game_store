package ir.ac.kntu;

import java.util.Objects;

public class Controller extends Accessory {

    private boolean wireless;

    private int number;

    public Controller(String name, double price, boolean wireless, int number) {
        super(name, price);
        this.wireless = wireless;
        this.number = number;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public boolean isWireless() {
        return wireless;
    }

    public void setWireless(boolean wireless) {
        this.wireless = wireless;
    }

    @Override
    public String toString() {
        if (wireless) {
            return "Name: " + this.getName() +
                    "\nWireless" +
                    "\nAvailable: " + number +
                    "\nPrice: " + this.getName();
        } else {
            return "Name: " + this.getName() +
                    "\nWith wire" +
                    "\nAvailable: " + number +
                    "\nPrice: " + this.getName();
        }
    }

    @Override
    public boolean equals(Object o) {

        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Controller that = (Controller) o;
        return wireless == that.wireless && number == that.number;
    }

    @Override
    public int hashCode() {
        return Objects.hash(wireless, number);
    }
}
