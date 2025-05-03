package ir.ac.kntu;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Objects;

public class Seller implements Serializable {

    private ArrayList<Accessory> accessories = new ArrayList<>();

    private String username;

    private String password;

    public Seller(String username, String password) {
        this.username = username;
        this.password = password;
        updateSeller();
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
        updateSeller();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void addAccessory(Accessory accessory) {
        accessories.add(accessory);
        updateSeller();
    }

    public void deleteAccessory(Accessory accessory) {
        if(accessories.contains(accessory)) {
            accessories.remove(accessory);
            updateSeller();
        }
    }

    public ArrayList<Accessory> getAccessories() {
        return new ArrayList<>(accessories);
    }

    public void addSeller() {
        Main.sellers.add(this);
        updateSeller();
    }

    public void deleteSeller() {
        if (Main.sellers.contains(this)) {
            Main.sellers.remove(this);
            updateSeller();
        }
    }

    public void updateSeller() {
        new DataBase().saveSellerInfos(Main.sellers);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Seller seller = (Seller) o;
        return Objects.equals(accessories, seller.accessories) && Objects.equals(username, seller.username) && Objects.equals(password, seller.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(accessories, username, password);
    }
}
