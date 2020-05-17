    #include <stdio.h>
	#include <stdlib.h>
#include <unistd.h>
#include <wait.h>

	int main ()

	{
    
    			int pid,pid2,pid3;
    			printf ("I'm the original process with PID %d and 
                PPID %d.\n",getpid (), getppid ());
    			pid = fork ();
    			pid2 =fork();
    			execl("/bin/ls", "ls", "-l", NULL);
    			pid3=fork();
    			printf ("PID %d terminates.\n", getpid () );
    			return 0;
	}
