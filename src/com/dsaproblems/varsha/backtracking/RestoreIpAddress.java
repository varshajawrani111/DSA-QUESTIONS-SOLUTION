package com.dsaproblems.varsha.backtracking;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class RestoreIpAddress {

    public static void findIPAddress(String str, int par, int index, String path, List<String> res){

        //Base case to validate if we have reached the end of the string and par are 4
        if(index == str.length()){
            if(par == 4){
                res.add(path.substring(0, path.length()-1));
            }
            return;
            // writing this outside of nested if because-if we reach the end of the string (index == str.length()):
            //If exactly 4 parts formed → add to result
            //Regardless of valid or invalid, stop further recursion
        }

        //Recursively calling the function to form valid IP address
        //To move index by 1
        findIPAddress(str, par+1, index+1, path+str.charAt(index)+".", res);

        //To move index by 2
        if(index+2 <= str.length() && isValid(str.substring(index, index+2))){
            findIPAddress(str, par+1, index+2, path+str.substring(index,index+2)+".", res);
        }

        //To move index by 3
        if(index+3 <= str.length() && isValid(str.substring(index, index+3))){
            findIPAddress(str, par+1, index+3, path+str.substring(index,index+3)+".", res);
        }
    }

    public static boolean isValid(String str){

        //To check if the string doesn't have a leading zeros
        if(str.charAt(0) == '0' && str.length() > 1){
            return false;
        }

        //To validate the number is between 0 and 255
        int num = Integer.parseInt(str);
        return num>=0 && num<=255;
    }

    public static void main(String[] args) {

        System.out.println("Enter String: ");
        String str = new Scanner(System.in).nextLine();

        List<String> res =new ArrayList<>();
        findIPAddress(str,0,0,"",res);

        System.out.println(res);
    }
}
