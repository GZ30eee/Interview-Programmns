import java.util.Arrays;
import java.util.Comparator;

class Job {
    int id;      // Job Id
    int deadline; // Deadline of job
    int profit;   // Profit if job is completed before or on deadline

    public Job(int id, int deadline, int profit) {
        this.id = id;
        this.deadline = deadline;
        this.profit = profit;
    }
}

public class JobSequencing60 {

    // Function to perform job sequencing
    public static void jobScheduling(Job[] jobs) {
        // Sort jobs according to decreasing order of profit
        Arrays.sort(jobs, new Comparator<Job>() {
            public int compare(Job j1, Job j2) {
                return j2.profit - j1.profit; // Sort by profit in descending order
            }
        });

        int n = jobs.length;
        boolean[] result = new boolean[n]; // To keep track of free time slots
        int[] jobOrder = new int[n]; // To store result (job ids)
        
        // Initialize all slots as free
        for (int i = 0; i < n; i++) {
            result[i] = false;
        }

        // Iterate through all given jobs
        for (int i = 0; i < n; i++) {
            // Find a free slot for this job (we traverse backwards)
            for (int j = Math.min(n, jobs[i].deadline) - 1; j >= 0; j--) {
                if (!result[j]) { // If slot is free
                    result[j] = true; // Mark this slot as filled
                    jobOrder[j] = jobs[i].id; // Assign job id to the slot
                    break;
                }
            }
        }

        // Print the scheduled jobs
        System.out.println("Scheduled jobs:");
        for (int i = 0; i < n; i++) {
            if (result[i]) {
                System.out.print(jobOrder[i] + " ");
            }
        }
        
        System.out.println();
    }

    public static void main(String[] args) {
        Job[] jobs = new Job[]{
            new Job(1, 2, 100),
            new Job(2, 1, 19),
            new Job(3, 2, 27),
            new Job(4, 1, 25),
            new Job(5, 3, 15)
        };

        jobScheduling(jobs);
    }
}
