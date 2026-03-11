package java_core_only;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.Map;
import java.util.HashMap;

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

                    void viewCart() {
                        System.out.println("Cart contents: " + cart);
                    }
                
                    void PlaceOrder(){
                        System.out.println(getName() + " placed an order.");
                    }
                }
    static class Admin extends User{
            Set<String> Registeredemails = new HashSet<>();
            Map<Integer, String> UserDatabase = new HashMap<>();

            void AddUser(int id, String email, String name) {
                Registeredemails.add(email);
                UserDatabase.put(id, name);
                System.out.println("User added: " + name + " with email: " + email);
            }
            Admin(String name, String email, String password) {
                super(name, email, password);
            }
            void ViewUsers(){
                System.out.println("User Database: " + UserDatabase);
                System.out.println("Registered Emails: " + Registeredemails);
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
            a1.AddUser(1, "Akshat", "akshat@gmail.com");
            a1.AddUser(2, "Rahul", "rahul@gmail.com");
            a1.AddUser(3, "Sneha", "akshat@gmail.com"); // duplicate email!
            a1.ViewUsers();
        }catch(IllegalArgumentException e){
            System.out.println(e.getMessage());
        }
        
    }
}