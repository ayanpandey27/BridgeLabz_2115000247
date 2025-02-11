class Task {
    int taskId;
    String taskName;
    int priority;
    String dueDate;
    Task next;

    public Task(int taskId, String taskName, int priority, String dueDate) {
        this.taskId = taskId;
        this.taskName = taskName;
        this.priority = priority;
        this.dueDate = dueDate;
        this.next = null;
    }
}

class CircularTaskScheduler {
    private Task head = null;
    private Task tail = null;
    private Task currentTask = null;

    public void addTaskAtBeginning(int taskId, String taskName, int priority, String dueDate) {
        Task newTask = new Task(taskId, taskName, priority, dueDate);
        if (head == null) {
            head = tail = newTask;
            tail.next = head;
        } else {
            newTask.next = head;
            head = newTask;
            tail.next = head;
        }
    }

    public void addTaskAtEnd(int taskId, String taskName, int priority, String dueDate) {
        Task newTask = new Task(taskId, taskName, priority, dueDate);
        if (head == null) {
            head = tail = newTask;
            tail.next = head;
        } else {
            tail.next = newTask;
            tail = newTask;
            tail.next = head;
        }
    }

    public void removeTaskById(int taskId) {
        if (head == null) return;
        Task temp = head, prev = null;
        do {
            if (temp.taskId == taskId) {
                if (temp == head) {
                    head = head.next;
                    tail.next = head;
                } else if (temp == tail) {
                    tail = prev;
                    tail.next = head;
                } else {
                    prev.next = temp.next;
                }
                return;
            }
            prev = temp;
            temp = temp.next;
        } while (temp != head);
    }

    public void viewCurrentTaskAndMoveNext() {
        if (currentTask == null) currentTask = head;
        if (currentTask != null) {
            System.out.println("Current Task: " + currentTask.taskName + " (Priority: " + currentTask.priority + ")");
            currentTask = currentTask.next;
        }
    }

    public void displayAllTasks() {
        if (head == null) {
            System.out.println("No tasks scheduled.");
            return;
        }
        Task temp = head;
        do {
            System.out.println("Task ID: " + temp.taskId + ", Name: " + temp.taskName + ", Priority: " + temp.priority + ", Due: " + temp.dueDate);
            temp = temp.next;
        } while (temp != head);
    }

    public void searchTaskByPriority(int priority) {
        if (head == null) return;
        Task temp = head;
        boolean found = false;
        do {
            if (temp.priority == priority) {
                System.out.println("Task ID: " + temp.taskId + ", Name: " + temp.taskName + ", Due: " + temp.dueDate);
                found = true;
            }
            temp = temp.next;
        } while (temp != head);
        if (!found) System.out.println("No tasks with priority " + priority + " found.");
    }
}

public class TaskScheduler {
    public static void main(String[] args) {
        CircularTaskScheduler scheduler = new CircularTaskScheduler();

        scheduler.addTaskAtBeginning(1, "Design UI", 3, "2025-02-15");
        scheduler.addTaskAtEnd(2, "Implement Backend", 1, "2025-02-20");
        scheduler.addTaskAtEnd(3, "Write Tests", 2, "2025-02-25");
        
        System.out.println("All Tasks:");
        scheduler.displayAllTasks();
        
        System.out.println("Viewing current task and moving to next:");
        scheduler.viewCurrentTaskAndMoveNext();
        scheduler.viewCurrentTaskAndMoveNext();
        
        System.out.println("Searching for priority 2 tasks:");
        scheduler.searchTaskByPriority(2);
        
        System.out.println("Removing Task ID 2");
        scheduler.removeTaskById(2);
        scheduler.displayAllTasks();
    }
}
