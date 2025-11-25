import java.util.*;

// Task class
class Task implements Comparable<Task> {
    String title;
    int priority;   // 1 = High, 2 = Medium, 3 = Low
    String deadline;

    public Task(String title, int priority, String deadline) {
        this.title = title;
        this.priority = priority;
        this.deadline = deadline;
    }

    @Override
    public int compareTo(Task t) {
        return Integer.compare(this.priority, t.priority);
    }

    @Override
    public String toString() {
        String p = "";
        if(priority == 1) p = "High";
        else if(priority == 2) p = "Medium";
        else p = "Low";

        return "Task: " + title + " | Priority: " + p + " | Deadline: " + deadline;
    }
}

// Main class
public class TaskScheduler {

    static PriorityQueue<Task> tasks = new PriorityQueue<>();
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        while (true) {
            System.out.println("\n===== SMART TASK SCHEDULER =====");
            System.out.println("1. Add Task");
            System.out.println("2. View All Tasks (By Priority)");
            System.out.println("3. Delete Highest Priority Task");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");

            int choice = sc.nextInt();
            sc.nextLine();  // clear buffer

            switch (choice) {
                case 1:
                    addTask();
                    break;

                case 2:
                    viewTasks();
                    break;

                case 3:
                    deleteTask();
                    break;

                case 4:
                    System.out.println("Exiting Task Scheduler...");
                    return;

                default:
                    System.out.println("Invalid choice!");
            }
        }
    }

    // Add Task
    public static void addTask() {
        System.out.print("Enter task title: ");
        String title = sc.nextLine();

        System.out.print("Enter deadline (dd-mm-yyyy): ");
        String deadline = sc.nextLine();

        System.out.print("Enter priority (1-High, 2-Medium, 3-Low): ");
        int priority = sc.nextInt();

        Task t = new Task(title, priority, deadline);
        tasks.add(t);

        System.out.println("Task added successfully!");
    }

    // View Tasks
    public static void viewTasks() {
        if (tasks.isEmpty()) {
            System.out.println("No tasks available!");
            return;
        }

        System.out.println("\n--- TASK LIST (Sorted by Priority) ---");
        for (Task t : tasks) {
            System.out.println(t);
        }
    }

    // Delete Task
    public static void deleteTask() {
        if (tasks.isEmpty()) {
            System.out.println("No tasks to delete!");
            return;
        }

        Task removed = tasks.poll();
        System.out.println("Removed Task: " + removed);
    }
}
