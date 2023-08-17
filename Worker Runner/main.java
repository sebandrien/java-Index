public class WorkerRunner {

    public static class Worker {
        private String name;
        private int hours;

        public Worker(String name, int hours) {
            this.name = name;
            this.hours = hours;
        }

        public void whoAreYou() {
            System.out.println("My name is " + name + " and I work " + hours + " hours a week.");
        }

        public void updateHours(int hours) {
            this.hours = hours;
        }

        public void work() {
            System.out.println("I am " + name + " and I am doing my duty as the general worker for " + hours + " hours a week.");
        }
    }

    public static class CampCounselor extends Worker {
        private double rate;

        public CampCounselor(String name, int hours, double rate) {
            super(name, hours);
            this.rate = rate;
        }

        @Override
        public void work() {
            System.out.println("I am a camp counselor and work " + hours + " hours a week for $" + rate + " per hour.");
        }

        public void activity() {
            System.out.println("Let's race across the pool!");
        }
    }

    public static class Doctor extends Worker {
        private String type;

        public Doctor(String name, int hours, String type) {
            super(name, hours);
            this.type = type;
        }

        @Override
        public void work() {
            System.out.println("I am a " + type + " and work " + hours + " hours a week.");
        }

        public void checkUp() {
            System.out.println("Checking on patient.");
        }
    }

    public static class Teacher extends Worker {
        private int numstudents;

        public Teacher(String name, int hours, int numstudents) {
            super(name, hours);
            this.numstudents = numstudents;
        }

        @Override
        public void work() {
            System.out.println("I have " + numstudents + " students and work " + hours + " hours a week.");
        }

        public void grade() {
            System.out.println("Grading papers. The class did very well.");
        }
    }

    private static void printSeparator() {
        System.out.println("*************************************************************************");
    }

    public static void main(String[] args) {
        System.out.println("Begin Testing the Worker Class...");
        Worker worker1 = new Worker("John", 35);
        worker1.whoAreYou();
        worker1.work();
        printSeparator();

        System.out.println("Begin Testing the Teacher Class...");
        Teacher worker2 = new Teacher("Hannah", 40, 35);
        worker2.whoAreYou();
        worker2.work();
        worker2.grade();
        printSeparator();

        System.out.println("Begin Testing the Doctor Class...");
        Doctor worker3 = new Doctor("Jane", 40, "Gastroenterologist");
        worker3.whoAreYou();
        worker3.work();
        worker3.checkUp();
        printSeparator();

        System.out.println("Begin Testing the CampCounselor Class...");
        CampCounselor worker4 = new CampCounselor("Peter", 10, 13.52);
        worker4.whoAreYou();
        worker4.work();
        worker4.activity();
        printSeparator();

        worker1.updateHours(38);
        worker4.updateHours(20);

        worker1.whoAreYou();
        worker4.whoAreYou();
        System.out.println("End of testing...");
    }
}
