package com.dsaproblems.varsha.greedyAlgorithmTechnique;

import com.dsaproblems.varsha.arrays.CommonFunctionality;

import java.util.Arrays;

public class LemonadeChangeProblem {

    private static boolean lemonadeChange(int[] arr) {

        //maintaining the counter of five and 10 change
        int five =0;
        int ten = 0;

        for(Integer i:arr){
            if(i==5){ //if it is 5 simply add the in five counter
                five++;
            }
            else if(i==10){ //if it is 10 add in tem counter an d decrease the counter by 1
                if(five == 0){
                    return false;
                }
                five--;
                ten++;
            }
            else{ //if it is 20
                if(five >0 & ten>0){ //check if 1 10 and 1 5 are available if yes decrease  and 10 counter by 1
                    five--;
                    ten--;
                } else if (five >= 3) {//if not check if 3 fives are available
                    five -= 3; //if yes decrease the five counter by 3
                }
                else{
                    return false;
                }
            }
        }

        return true;
    }

    public static void main(String[] args) {

        int[] arr = CommonFunctionality.getInputArray();

        System.out.println(lemonadeChange(arr));
    }
}
