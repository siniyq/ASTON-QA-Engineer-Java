public class Person {
    private String fullName;
    private String position;
    private String email;
    private String phone;
    private int salary;
    private int age;

    public Person(String fullName, String position, String email, String phone, int salary, int age) {
        this.fullName = fullName;
        this.position = position;
        this.email = email;
        this.phone = phone;
        this.salary = salary;
        this.age = age;
    }

    public void printInfo() {
        System.out.println("ФИО: " + fullName);
        System.out.println("Должность: " + position);
        System.out.println("Email: " + email);
        System.out.println("Телефон: " + phone);
        System.out.println("Зарплата: " + salary);
        System.out.println("Возраст: " + age);
        System.out.println();
    }

    public static void main(String[] args) {
        Person[] persArray = new Person[5];
        persArray[0] = new Person("Ivanov Ivan", "Engineer", "ivivan@mailbox.com", "892312312", 30000, 30);
        persArray[1] = new Person("Petrov Petr", "Manager", "petrov@mailbox.com", "892312313", 40000, 35);
        persArray[2] = new Person("Sidorov Sidr", "Developer", "sidorov@mailbox.com", "892312314", 50000, 28);
        persArray[3] = new Person("Smirnov Smirn", "Designer", "smirnov@mailbox.com", "892312315", 35000, 40);
        persArray[4] = new Person("Kuznetsov Kuznets", "Tester", "kuznetsov@mailbox.com", "892312316", 32000, 25);

        for (Person person : persArray) {
            person.printInfo();
        }
    }
}

