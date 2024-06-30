import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ContactManager {
    static List<Contact> contacts = new ArrayList<>();

    public static void main(String[] args) {
        ContactManager contactManager = new ContactManager();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Contact Manager");
            System.out.println("1. Add Contact");
            System.out.println("2. View Contacts");
            System.out.println("3. Update Contact");
            System.out.println("4. Delete Contact");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    contactManager.addContact(scanner);
                    break;
                case 2:
                    contactManager.viewContacts();
                    break;
                case 3:
                    contactManager.updateContact(scanner);
                    break;
                case 4:
                    contactManager.deleteContact(scanner);
                    break;
                case 5:
                    System.out.println("Goodbye!");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private void addContact(Scanner scanner) {
        System.out.print("Enter name: ");
        String name = scanner.next();
        System.out.print("Enter phone number: ");
        String phoneNumber = scanner.next();
        System.out.print("Enter email address: ");
        String emailAddress = scanner.next();

        Contact contact = new Contact(name, phoneNumber, emailAddress);
        contacts.add(contact);
        System.out.println("Contact added successfully!");
    }

    private void viewContacts() {
        if (contacts.isEmpty()) {
            System.out.println("No contacts found.");
        } else {
            System.out.println("Contacts:");
            for (Contact contact : contacts) {
                System.out.println(contact);
            }
        }
    }

    private void updateContact(Scanner scanner) {
        System.out.print("Enter contact ID to update: ");
        int id = scanner.nextInt();
        Contact contact = getContactById(id);
        if (contact == null) {
            System.out.println("Contact not found.");
            return;
        }

        System.out.print("Enter new name: ");
        String name = scanner.next();
        System.out.print("Enter new phone number: ");
        String phoneNumber = scanner.next();
        System.out.print("Enter new email address: ");
        String emailAddress = scanner.next();

        contact.setName(name);
        contact.setPhoneNumber(phoneNumber);
        contact.setEmailAddress(emailAddress);
        System.out.println("Contact updated successfully!");
    }

    private void deleteContact(Scanner scanner) {
        System.out.print("Enter contact ID to delete: ");
        int id = scanner.nextInt();
        Contact contact = getContactById(id);
        if (contact == null) {
            System.out.println("Contact not found.");
            return;
        }

        contacts.remove(contact);
        System.out.println("Contact deleted successfully!");
    }

    private Contact getContactById(int id) {
        for (Contact contact : contacts) {
            if (contact.getId() == id) {
                return contact;
            }
        }
        return null;
    }
}

class Contact {
    private int id;
    private String name;
    private String phoneNumber;
    private String emailAddress;

    public Contact(String name, String phoneNumber, String emailAddress) {
        this.id = ContactManager.contacts.size() + 1;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.emailAddress = emailAddress;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    @Override
    public String toString() {
        return "Contact{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", emailAddress='" + emailAddress + '\'' +
                '}';
    }
}

