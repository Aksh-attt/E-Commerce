package java_core;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class oop {
    abstract static class User {
            private String name;
            private String email;
            private String password;
            
                User(String name, String email, String password) {
                    if(password == null || password.isEmpty()) {
                            throw new IllegalArgumentException("Password cannot be empty.");
                        }
                    this.name = name;
                    this.email = email;
                    this.password = password;
                }
                String getName() {
                    return name;
                }
                String getEmail() {
                    return email;
                }

                void setName(String name) {
                    this.name = name;
                }
                void setEmail(String email) {
                    this.email = email;
                }
                void setPassword(String password) {
                    this.password = password;
                }
                void register(){
                    System.out.println(name + " registered!");
                }
                abstract void login();
            }
    static class Customer extends User {
                    String address;

                    List<String> cart = new ArrayList<>();

                    Customer(String name, String email, String password, String address) {
                        super(name, email, password);
                        this.address = address;
                    }

                    @Override
                    void login() {
                        System.out.println("Customer login: Welcome, " + getName() + "!");
                    }

                    void addToCart(String item) {
                        cart.add(item);
                        System.out.println(item + " added to cart.");
                    }
                
                    void PlaceOrder(){
                        System.out.println(getName() + " placed an order.");
                    }
                }
    static class Admin extends User{
            Admin(String name, String email, String password) {
                super(name, email, password);
            }
            @Override
            void login() {
                System.out.println("Admin login: Welcome, " + getName() + "!");
            }
    }
    public static void main(String[] args) {
        try{
            Customer c1 = new Customer("Akshat", "akshat@gmail.com", "1234", "Noida");
            c1.login();
            c1.PlaceOrder();
        }catch(IllegalArgumentException e){
            System.out.println(e.getMessage());
        }try{
            Admin a1 = new Admin("Admin", "admin@gmail.com", "admin123");
            a1.login();
        }catch(IllegalArgumentException e){
            System.out.println(e.getMessage());
        }
        
    }
}