#include <stdio.h>
#include <unistd.h>
#include <stdlib.h>
#include <sys/types.h>
#include <sys/wait.h>

int main()
{
    pid_t c_pid1, c_pid2, pid;
    int status;
    c_pid1=fork();
  
    if(c_pid1 >0)
    {
        c_pid2=fork();
        if(c_pid2>0)
        {
            pid=wait(&status);
            if(WIFEXITED(status))
            {
                printf("Parent: Child %d exited with status : %d \n", pid, WEXITSTATUS(status));
            }
            pid=wait(&status);
            if(WIFEXITED(status))
            {
                printf("Parent: Child %d exited with status : %d \n", pid, WEXITSTATUS(status));
            }
        }
        
    }
    if(c_pid1==0 || c_pid2==0)
    {
        pid=getpid();
        printf("Child: %d\n",getpid());
        printf("Child: sleeping for 2 seconds, then exiting with status 12 \n");
        sleep(2);
        exit(12);
        
    }
    
    
    else{
        
        printf("Fork failed\n");
    }
    
    
    return 0;
    
}
