public class Scheduler {
    class Process {
        int instructions[];
        int counter;
        StringBuffer state;
        int pid;
        int nthreads;
    }

    class Thread {
        int instructions[];
        int thread_number;
        StringBuffer state;
        int pid;
    }

    class ProcessCapsule {
        Process process;
        Thread threads[];
    }


    public static void main(String[] args) {
        
    }
}