/*
1.)	Create a Process as an object in your language of choice.  The process must have the following:
a.	An array (for instructions), 
b.	int (as our counter), 
c.	mutable string (as our state), 
d.	int (for the process ID)
e.	int (number of Threads)
2.)	Create a Thread as an object.  The thread must have the following:
a.	An Array (for instruction)
b.	Int (as our thread #)
c.	Mutable string (as our state)
d.	Int (for the Process ID it links to)
3.)	Create a method that randomly creates processes and then creates threads inside of those processes.
4.)	Print to the screen the IDs of the processes it created and then randomly terminate processes.
5.)	Have your program run for 10 minutes – randomly creating and terminating processes.

*/
#ifdef _WIN32
#include <Windows.h>
#else
#include <unistd.h>
#endif


#include <vector>

#include <iostream>
#include <cstdlib>

using namespace std;

struct Process {
    Process(int pid, int nthreads) : pid(pid), nthreads(nthreads) {}
    // int* instructions;
    vector<int> instructions;
    int counter;
    // char* state;
    string state;
    int pid;
    int nthreads;
};


struct Thread {
    Thread(int pid, int thread_n, int seconds) : pid(pid) {
        cout << "Created Thread " << thread_n << " under process pid " << pid << "\n";
        sleep(seconds);
        cout << "Stopped Thread " << thread_n << " under process pid " << pid << "\n";
    }
    vector<int> instructions;
    int thread_n;
    string state;
    int pid;
};

struct ProcessCapsule {
    Process process;
    vector<Thread> threads;
};

Process create_random_processes() {
    for (int i = 0; i < 20; i++) {
        int proc_counter = 3;

        int nthreads = rand() % 10;
        int sleep_time;
        Process process(proc_counter, nthreads);
        int thread_counter = 0;

        vector<Thread> threads = vector<Thread>();
        for (int j = 0; j < nthreads; j++) {
            sleep_time = rand() % 10 + 1;

            threads.push_back((Thread *)(new Thread(proc_counter, thread_counter)));
            thread_counter++;
        }
        proc_counter++;
    }
}


int main (int argc, char** argv) {

    
    cout << "Helllo Testting" << "\n";
    return 0;
}

