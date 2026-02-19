package com.dsaproblems.varsha.binarySearch;

public class AllocationOfPages {

    public static int allocatioOfPages(int[] arr, int pages){
        int students = 1;
        int pagesAllocated = 0;

        for(int page : arr){

            if(page + pagesAllocated <= pages){
                pagesAllocated += page;
            }
            else{
                students++;
                pagesAllocated += page;
            }
        }

        return students;
    }

    public static int minimumOfMaximumPagesAllocated(int[] arr, int students){

        if(students > arr.length){
            return -1;
        }

        int low = 0; //it will be the maximum page a student should hold
        int high = 0; //it will the sum of all pages a student can hold

        for(int page : arr){
            low = Math.max(low, page);
            high += page;
        }

        while(low <= high){

            int mid = low + (high - low)/2;

            int student =  allocatioOfPages(arr, mid);

            if(student > students){ //this more pages can be assigned to one student then we will move towards right
                low = mid + 1;
            }
            else{
                high = mid - 1;
            }
        }

        return low;
    }

    public static void main(String[] args) {

        int[] arr = {12,34,67,90};
        int students = 2;

        System.out.println(minimumOfMaximumPagesAllocated(arr, students));
    }
}
