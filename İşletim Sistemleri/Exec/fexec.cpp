#include <stdio.h>
#include <unistd.h>
#include <wait.h>

int main(void)
{
    char * argv[2]={"l",NULL};
    
    int pid=fork();
    if(pid==0)
    {
        execvp("ls",argv);
        
    }
    
    wait(NULL);
    
    printf("Finished executing the parent process- the child wont get the result\n");
    
    return 0;
    
}
