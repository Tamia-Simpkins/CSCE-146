/*
 * Written by Tamia Simpkins
 */
public class ProcessScheduler {
	    private LLQueue<Process> Pqueue;
	    private Process Cprocess; 

	    public ProcessScheduler() {
	        Pqueue = new LLQueue<>();
	        Cprocess = null;
	    }

	    public Process getCurrentProcess() {
	        return Cprocess;
	    }

	    public void addProcess(Process process) {
	        if (Cprocess == null) {
	            Cprocess = process; 
	        } else {
	            Pqueue.enqueue(process); 
	        }
	    }

	    public void runNextProcess() {
	        Cprocess = Pqueue.dequeue(); 
	    }

	    public void cancelCurrentProcess() {
	        if (Cprocess != null) {
	            Cprocess = Pqueue.dequeue();
	        }
	    }

	    public void printProcessQueue() {
	        Pqueue.print();
	    }
	}

