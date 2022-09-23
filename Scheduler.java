import java.util.Random;

public class Scheduler {

    static void mySleep(int seconds) {
        try {
            Thread.sleep(seconds * 1000);
        } catch (Exception e) {
            System.out.println("WHAT!? I didn't plan for exceptions!");
        }
    }

    static class Process {
        int instructions[];
        int counter;
        StringBuilder state;
        int pid;
        int nthreads;
        public Process(int pid, int nthreads) {
            this.pid = pid;
            this.nthreads = nthreads;
        }
    }

    static class MyThread {
        int instructions[];
        int thread_number;
        StringBuilder state;
        int pid;

        public MyThread(int instructions[], int thread_number, StringBuilder state, int pid, int sleep_time) {
            this.instructions = instructions;
            this.thread_number = thread_number;
            this.state = state;
            this.pid = pid;

            System.out.printf("Creating thread #: %d in process with PID: %d\n", thread_number, pid);
            mySleep(sleep_time);
            // System.out.printf("Finished thread #: %d in process with PID: %d\n", thread_number, pid);
            
        }
    }

    static class ProcessCapsule {
        Process process;
        MyThread threads[];
        public ProcessCapsule(int pid, int nthreads) {
            this.process = new Process(pid, nthreads);
            this.threads = new MyThread[nthreads];
            int thread_num = 0;
            Random rand = new Random();
            for (int i = 0; i < this.threads.length; i++) {
                this.threads[i] = new MyThread(new int[]{0,1}, thread_num++, new StringBuilder(), pid, rand.nextInt(8));
            }

        }
    }

    public static void main(String[] args) {

        Random rand = new Random();
        int n_procs = 52;
        ProcessCapsule processes[] = new ProcessCapsule[n_procs];

        int nthreads;

        for (int i = 0; i < n_procs; i++) {
            nthreads = rand.nextInt(7);
            processes[i] = new ProcessCapsule(i, nthreads);
        }

    }
}