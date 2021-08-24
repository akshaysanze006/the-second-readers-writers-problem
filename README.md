# the-second-readers-writers-problem

In computer science, the readers-writers problems are examples of a common computing problem  in concurrency. There are at least three variations of the problems, which deal with situations in  which many threads try to access the same shared resource at one time. Some threads may read  and some may write, with the constraint that no process may access the shared resource for either  reading or writing while another process is in the act of writing to it. The solution for first readers 
writers problem is suboptimal, because it is possible that a reader R1 might have the lock, a  writer W be waiting for the lock, and then a reader R2 requests access. It would be unfair for R2 to  jump in immediately, ahead of W; if that happened often enough, W would starve.  Instead, W should start as soon as possible. This is the motivation for the second readers-writers  problem, in which the constraint is added that no writer, once added to the queue, shall be kept  waiting longer than absolutely necessary. This is also called writers-preference. 


Algorithm 
Step 1: Start  
Step 2: In writer process, 
• Writer requests the entry to critical section. 
• If allowed i.e. wait() gives a true value, it enters and performs the write. If not allowed, it  keeps on waiting. 
• It exits the critical section. 
Step 3: In reader process, 
• Reader requests the entry to critical section. 
• If allowed: 
o It increments the count of number of readers inside the critical section. If this  reader is the first reader entering, it locks the semaphore to restrict the entry of  writers if any reader is inside. 
o It then, signals mutex as any other reader is allowed to enter while others are  already reading. 
o After performing reading, it exits the critical section. When exiting, it checks if no  more reader is inside, it signals the semaphore as now, writer can enter the  critical section. 
• If not allowed, it keeps on waiting. 
Step 4: Stop 
