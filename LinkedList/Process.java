class Process {
    int processId;
    int burstTime;
    int priority;
    Process next;

    public Process(int processId, int burstTime, int priority) {
        this.processId = processId;
        this.burstTime = burstTime;
        this.priority = priority;
        this.next = null;
    }
}

class RoundRobinScheduler {
    private Process head = null;
    private Process tail = null;
    private int timeQuantum;

    public RoundRobinScheduler(int timeQuantum) {
        this.timeQuantum = timeQuantum;
    }

    public void addProcess(int processId, int burstTime, int priority) {
        Process newProcess = new Process(processId, burstTime, priority);
        if (head == null) {
            head = tail = newProcess;
            tail.next = head; // Circular link
        } else {
            tail.next = newProcess;
            newProcess.next = head;
            tail = newProcess;
        }
    }

    public void removeProcess(int processId) {
        if (head == null) return;
        Process temp = head, prev = null;
        do {
            if (temp.processId == processId) {
                if (temp == head && temp == tail) {
                    head = tail = null;
                } else {
                    if (temp == head) head = head.next;
                    if (temp == tail) tail = prev;
                    if (prev != null) prev.next = temp.next;
                    tail.next = head; // Maintain circular link
                }
                return;
            }
            prev = temp;
            temp = temp.next;
        } while (temp != head);
    }

    public void executeRoundRobin() {
        if (head == null) return;
        Process current = head;
        System.out.println("Executing Round Robin Scheduling:");
        while (head != null) {
            System.out.println("Processing ID: " + current.processId + " with Burst Time: " + current.burstTime);
            if (current.burstTime > timeQuantum) {
                current.burstTime -= timeQuantum;
                current = current.next;
            } else {
                System.out.println("Process " + current.processId + " completed execution.");
                removeProcess(current.processId);
                current = head;
            }
            if (head == null) break;
        }
    }

    public void displayProcesses() {
        if (head == null) {
            System.out.println("No processes in queue.");
            return;
        }
        Process temp = head;
        System.out.println("Processes in Round Robin Queue:");
        do {
            System.out.println("Process ID: " + temp.processId + ", Burst Time: " + temp.burstTime + ", Priority: " + temp.priority);
            temp = temp.next;
        } while (temp != head);
    }
}

public class RoundRobinSystem {
    public static void main(String[] args) {
        RoundRobinScheduler scheduler = new RoundRobinScheduler(4);
        scheduler.addProcess(1, 10, 2);
        scheduler.addProcess(2, 5, 1);
        scheduler.addProcess(3, 8, 3);
        
        scheduler.displayProcesses();
        scheduler.executeRoundRobin();
    }
}
