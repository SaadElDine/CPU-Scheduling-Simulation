package com.saadbonus_7370.bonus_isa;
// Imp Libs
import java.util.*;

// t3reef ya3ny eh proc as required >> (ID, BT)
class CurrentProcessbySaadeldine2002 {
    int processIDbySaadeldine2002;
    int burstTimebySaadeldine2002;

    // Constructor
    public CurrentProcessbySaadeldine2002(int processIDbySaad, int burstTimebySaad) {
        this.processIDbySaadeldine2002 = processIDbySaad;
        this.burstTimebySaadeldine2002 = burstTimebySaad;
    }
}


class Bonus_ISA {
    static Queue<CurrentProcessbySaadeldine2002> JobQueue_bySaadeldine2002 = new LinkedList<>();
    static Random randombySaadeldine2002 = new Random(); 
    static List<Integer> completedProcesses_bySaadeldine2002 = new ArrayList<>(); // For Table Printing

    public static void main(String[] args) {
        System.out.println("_____________<Bonus Project>____________");
        System.out.println("");
        System.out.println("Name: Saad El Dine Ahmed Saad ");
        System.out.println("ID: 7370");
        System.out.println("_________________________________________");
        System.out.println("");
        System.out.println("- Multilevel Feedback Queue:");
        System.out.println("  >> Queue 1: RoundRobbin (RR), q = 8 .");
        System.out.println("  >> Queue 2: RoundRobbin (RR), q = 16.");
        System.out.println("  >> Queue 3: First Come First Serve (FCFS).");
        System.out.println("_________________________________________");
        System.out.println("");
        System.out.println("- CPU will serve Queue 1 by 50%");
        System.out.println("- CPU will serve Queue 2 by 30%");
        System.out.println("- CPU will serve Queue 3 by 20%");
        System.out.println("- Promotion or Demotion is done by randomness of 50%");
        System.out.println("- Assumed CPU time = 160 (a number it's 50% is multiple of 8 and it's 30% is mul;tiple of 16)");
        System.out.println("_________________________________________");
        System_bySaadeldine2002(); // Call The Logic 
        printExitOrderTable_bySaadeldine2002(); // Print the final table comparing entrance and exit orders
    }

    static void Prc_generator_bySaadeldine2002(Queue<CurrentProcessbySaadeldine2002> QueueNB1bySaad) {
        int itrbySaadeldine = 1; 
        while(itrbySaadeldine <= 100) {
            int burstTimebySaad = randombySaadeldine2002.nextInt(100) + 1;
            if (QueueNB1bySaad.size() < 10) {
                QueueNB1bySaad.add(new CurrentProcessbySaadeldine2002(itrbySaadeldine, burstTimebySaad));
            } else {
                JobQueue_bySaadeldine2002.add(new CurrentProcessbySaadeldine2002(itrbySaadeldine, burstTimebySaad));
            }
            itrbySaadeldine++;
        }
    }

    static void First_Queue_FUNCTION_bySaadeldine2002(Queue<CurrentProcessbySaadeldine2002> QueueNB1bySaad, Queue<CurrentProcessbySaadeldine2002> QueueNB2bySaad) {
        if (!QueueNB1bySaad.isEmpty()) {
            CurrentProcessbySaadeldine2002 CurrentPrbySaad = QueueNB1bySaad.peek();
            CurrentPrbySaad.burstTimebySaadeldine2002 -= 8; // update BT 
            if (CurrentPrbySaad.burstTimebySaadeldine2002 <= 0) {
                ProcessOut_bySaadeldine2002(1, CurrentPrbySaad.processIDbySaadeldine2002); // Good BYE!!!
                QueueNB1bySaad.poll();
                if (!JobQueue_bySaadeldine2002.isEmpty()) {
                    QueueNB1bySaad.add(JobQueue_bySaadeldine2002.poll());  // Insert New Process From job queue
                }
            } else {
                QueueNB1bySaad.poll();
                if (QueueNB2bySaad.size() < 20) {   // Promotion But If available!
                    QueueNB2bySaad.add(CurrentPrbySaad); 
                    if (!JobQueue_bySaadeldine2002.isEmpty()) {
                        QueueNB1bySaad.add(JobQueue_bySaadeldine2002.poll());  // Insert New Process From job queue
                    }
                } else {
                    QueueNB1bySaad.add(CurrentPrbySaad);  // Stays in Q1
                }
            }
        }
    }

    static void Second_Queue_FUNCTION_bySaadeldine2002(Queue<CurrentProcessbySaadeldine2002> QueueNB2bySaad, Queue<CurrentProcessbySaadeldine2002> QueueNB1bySaad, Queue<CurrentProcessbySaadeldine2002> QueueNB3bySaad) {
        if (!QueueNB2bySaad.isEmpty()) {
            CurrentProcessbySaadeldine2002 CurrentPrbySaad = QueueNB2bySaad.peek();
            CurrentPrbySaad.burstTimebySaadeldine2002 -= 16; // update BT 
            if (CurrentPrbySaad.burstTimebySaadeldine2002 <= 0) {
                ProcessOut_bySaadeldine2002(2, CurrentPrbySaad.processIDbySaadeldine2002); // Good BYE!!!
                QueueNB2bySaad.poll();
            } else {
                QueueNB2bySaad.poll();
                if (getRandomBooleanbySaadeldine2002()) {  // 50% Promotion And 50% Demotion (T/F) if available!!
                    if (QueueNB3bySaad.size() < 30) {  
                        QueueNB3bySaad.add(CurrentPrbySaad);       // Promotion
                    } else if (QueueNB1bySaad.size() < 10) {
                        QueueNB1bySaad.add(CurrentPrbySaad);       // Demotion
                    } else {
                        QueueNB2bySaad.add(CurrentPrbySaad);       // Stays in Q2
                    }
                } else if (QueueNB1bySaad.size() < 10) {  
                    QueueNB1bySaad.add(CurrentPrbySaad);           // Demotion
                } else {
                    QueueNB2bySaad.add(CurrentPrbySaad);           // Stays in Q2
                }
            }
        }
    }

    static void Third_Queue_Function_bySaadeldine2002(Queue<CurrentProcessbySaadeldine2002> QueueNB3bySaad) {
        if (!QueueNB3bySaad.isEmpty()) {
            CurrentProcessbySaadeldine2002 CurrentPrbySaad = QueueNB3bySaad.peek();
            CurrentPrbySaad.burstTimebySaadeldine2002-=32;  // Update BT with (20% of cpu time, assumed 1 itteration)
            if (CurrentPrbySaad.burstTimebySaadeldine2002 <= 0) {
                ProcessOut_bySaadeldine2002(3, CurrentPrbySaad.processIDbySaadeldine2002); // Good BYE!!!
                QueueNB3bySaad.poll();
            }
        }
    }
    
    static void System_bySaadeldine2002() {
        // Qu's Declarations
        Queue<CurrentProcessbySaadeldine2002> queue1bySaadeldine2002 = new LinkedList<>();
        Queue<CurrentProcessbySaadeldine2002> queue2bySaadeldine2002 = new LinkedList<>();
        Queue<CurrentProcessbySaadeldine2002> queue3bySaadeldine2002 = new LinkedList<>();

        Prc_generator_bySaadeldine2002(queue1bySaadeldine2002);
        
        // Assume CPU_T = 160 (number it's 50% is multiple of 8 and it's 30% is mul;tiple of 16)
        int totalCPUTIMEbySaadeldine2002 = 160;
        int cyclesbySaadeldine2002 = 0;
        
        // MAIN LOOP INSIDE THE SYSTEM (Untill All QU's becomes Empty)
        while (!queue1bySaadeldine2002.isEmpty() || !queue2bySaadeldine2002.isEmpty() || !queue3bySaadeldine2002.isEmpty()) {
            
            int cpuTimeforQ1_bySaadeldine2002 = (int) ((50.0 / 100) * totalCPUTIMEbySaadeldine2002 / 8);
            int cpuTimeforQ2_bySaadeldine2002 = (int) ((30.0 / 100) * totalCPUTIMEbySaadeldine2002 / 16);
            int cpuTimeforQ3_bySaadeldine2002 = (int) ((20.0 / 100) * totalCPUTIMEbySaadeldine2002 / 32); // Assume it will be one itr with time -= 32

            
            if (!queue1bySaadeldine2002.isEmpty()) {
                while (cpuTimeforQ1_bySaadeldine2002 > 0){   // CPU SERVES Q1 BY 50% (of the MAIN LOOP)
                    First_Queue_FUNCTION_bySaadeldine2002(queue1bySaadeldine2002, queue2bySaadeldine2002);
                    cpuTimeforQ1_bySaadeldine2002--;
                }
            } else if (!queue2bySaadeldine2002.isEmpty()) { 
                while (cpuTimeforQ2_bySaadeldine2002 > 0){  // CPU SERVES Q2 BY 30% (of the MAIN LOOP)
                    Second_Queue_FUNCTION_bySaadeldine2002(queue2bySaadeldine2002, queue1bySaadeldine2002, queue3bySaadeldine2002);
                    cpuTimeforQ2_bySaadeldine2002--;
                }
            } else if (!queue3bySaadeldine2002.isEmpty()) {
                while (cpuTimeforQ3_bySaadeldine2002 > 0) { // CPU SERVES Q3 BY 20% (of the MAIN LOOP)
                    Third_Queue_Function_bySaadeldine2002(queue3bySaadeldine2002);
                    cpuTimeforQ3_bySaadeldine2002--;
                }
            }
            cyclesbySaadeldine2002++;
            System.out.println("CPU Cycle #" + cyclesbySaadeldine2002 + " finished!");
            System.out.println("----------------------------------------------------------");
        }
    }

    static void ProcessOut_bySaadeldine2002(int queueNumber, int processID) {
        completedProcesses_bySaadeldine2002.add(processID); // Append completed process ID to the list
        System.out.println("Process #" + processID + " Exits the System from Queue number " + queueNumber + ", Good BYE!.");
    }

    static void printExitOrderTable_bySaadeldine2002() {
        System.out.println("");
        System.out.println("Entrance Order | Exit Order");
        System.out.println("---------------------------");
        for (int s = 0; s < completedProcesses_bySaadeldine2002.size(); s++) {
            System.out.printf("%-14d | %-10d%n", s + 1, completedProcesses_bySaadeldine2002.get(s));
        }
        System.out.println("---------------------------_______________________-------------------------------");
        }

    static boolean getRandomBooleanbySaadeldine2002() {
        return randombySaadeldine2002.nextBoolean();
    }
}