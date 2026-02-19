package com.dsaproblems.varsha.greedyAlgorithmTechnique;

import java.util.Arrays;

public class JobSequencingProblem {

    public static class Job{
        int id;
        int deadline;
        int profit;

        public Job(int id, int deadline, int profit) {
            this.id = id;
            this.deadline = deadline;
            this.profit = profit;
        }
    }

    private static int[] scheduleJobs(Job[] jobs) {

        //Sort the jobs in descending order of the profit
        Arrays.sort(jobs, (a,b)->b.profit-a.profit);

        int maxDeadline = 0;
        //To find the maximum deadline
        for(Job job:jobs){
            maxDeadline = Math.max(maxDeadline, job.deadline);
        }

        //creating the slot array woth size of maxDeadline+1
        int[] slots =  new int[maxDeadline+1];
        Arrays.fill(slots, -1);

        int count = 0;
        int totalProfit = 0;

        for(Job job:jobs){

            //placing the job at latest possible slot i.e means as far as possible
            for(int s = Math.min(job.deadline,maxDeadline); s>=1; s--){
                if(slots[s]==-1){
                    slots[s] = job.id;
                    count++;
                    totalProfit += job.profit;
                    break;
                }
            }
        }

        int[] result = {count,totalProfit};

        return result;

    }

    public static void main(String[] args) {

        Job[] jobs = {
                new Job(1, 2, 100),
                new Job(2, 1, 19),
                new Job(3, 2, 27),
                new Job(4, 1, 25),
                new Job(5, 3, 15)
        };

        int[] ans = scheduleJobs(jobs);
        System.out.println("Jobs done = " + ans[0] + ", Total profit = " + ans[1]);

    }
}
