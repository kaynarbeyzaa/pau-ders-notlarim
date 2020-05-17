    #include <stdio.h>
	#include <unistd.h>
	#include <stdlib.h>
	#include <sys/types.h>
	
	int main ()

	{
    
    	int pid,pid2,pid3;
    	printf ("I'm the original process with PID %d and PPID %d.\n",getpid (), getppid ());
    	pid = fork ();
    	pid2 =fork();
    	execv("/bin/ls", "ls", "-l", NULL);
    	pid3=fork();
    	printf ("PID %d terminates.\n", getpid () );
    	return 0;
	}
