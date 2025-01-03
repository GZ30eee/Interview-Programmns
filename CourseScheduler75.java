import java.util.*;

public class CourseScheduler75 {
    
    public static int maxCourses(int[][] courses) {
        // Sort courses by last day and then by duration
        Arrays.sort(courses, (a, b) -> {
            if (a[1] != b[1]) {
                return Integer.compare(a[1], b[1]); // Sort by lastDay
            }
            return Integer.compare(a[0], b[0]); // Sort by duration
        });

        // Min-heap to keep track of course durations
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        int totalDuration = 0;

        for (int[] course : courses) {
            int duration = course[0];
            int lastDay = course[1];

            // Add current course duration to totalDuration
            totalDuration += duration;
            minHeap.add(duration);

            // If totalDuration exceeds lastDay, remove the longest course
            if (totalDuration > lastDay) {
                totalDuration -= minHeap.poll(); // Remove longest course from heap
            }
        }

        // The size of minHeap is the maximum number of courses that can be taken
        return minHeap.size();
    }

    public static void main(String[] args) {
        int[][] courses = {
            {100, 200},
            {200, 1300},
            {1000, 1250},
            {2000, 3200}
        };

        int result = maxCourses(courses);
        System.out.println("Maximum number of courses that can be taken: " + result); // Output: 3
    }
}
