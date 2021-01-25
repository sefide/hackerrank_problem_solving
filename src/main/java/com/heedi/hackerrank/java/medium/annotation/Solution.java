package com.heedi.hackerrank.java.medium.annotation;

/**
 * https://www.hackerrank.com/challenges/java-annotations/problem
 * https://docs.oracle.com/javase/tutorial/java/annotations/
 * https://docs.oracle.com/javase/7/docs/api/java/lang/annotation/RetentionPolicy.html
 */
import java.lang.annotation.*;
import java.lang.reflect.*;
import java.util.*;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@interface FamilyBudget {
    String userRole() default "GUEST";
    int budgetLimit() default 1;
}

/*
    @Target : 해당 어노테이션이 어디에 사용할 수 있는지 결정 (FIELD, METHOD, CLASS, PARAMETER 등)
    @Retention : 어느 시점까지 어노테이션의 메모리를 가져갈지 결정 (CLASS, RUNTIME, SOURCE)
        CLASS(default) : 컴파일까지 메모리 보유하다 런타임 시 제거
        RUNTIME : 컴파일 후 런타임 종료 시까지 메모리 보유
        SOURCE : 컴파일할 때 제거
 */

class FamilyMember {
    @FamilyBudget(userRole = "SENIOR", budgetLimit = 100)
    public void seniorMember(int budget, int moneySpend) {
        System.out.println("Senior Member");
        System.out.println("Spend: " + moneySpend);
        System.out.println("Budget Left: " + (budget - moneySpend));
    }

    @FamilyBudget(userRole = "JUNIOR", budgetLimit = 50)
    public void juniorUser(int budget, int moneySpend) {
        System.out.println("Junior Member");
        System.out.println("Spend: " + moneySpend);
        System.out.println("Budget Left: " + (budget - moneySpend));
    }
}

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int testCases = Integer.parseInt(in.nextLine());
        while (testCases > 0) {
            String role = in.next();
            int spend = in.nextInt();
            try {
                Class annotatedClass = FamilyMember.class;
                Method[] methods = annotatedClass.getMethods();
                for (Method method : methods) {
                    if (method.isAnnotationPresent(FamilyBudget.class)) {
                        FamilyBudget family = method
                                .getAnnotation(FamilyBudget.class);
                        String userRole = family.userRole();
                        int budgetLimit = family.budgetLimit();
                        if (userRole.equals(role)) {
                            if(spend <= budgetLimit){
                                method.invoke(FamilyMember.class.newInstance(),
                                        budgetLimit, spend);
                            }else{
                                System.out.println("Budget Limit Over");
                            }
                        }
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            testCases--;
        }
    }
}
