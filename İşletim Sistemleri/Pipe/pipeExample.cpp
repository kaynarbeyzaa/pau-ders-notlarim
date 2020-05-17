#include <stdio.h>
#include <unistd.h>
#include <string.h>
#include <sys/types.h>

int main()
{
    int fd[2], nbytes;
    pid_t childpid;
    char string[]="Hello World \n";
    char readBuffer[80];
    
    pipe(fd);
    childpid=fork();
    if(childpid==-1)
    {
        
        printf("Fork error !\n");
    }
    if(childpid==0)
    {
        /*Child process is executing*/
        
        close(fd[0]);
        printf("Child is writing to pipe \n");
        write(fd[1],string, (strlen(string)+1));
        //exit(0);
        
        
    }
    else
    {
        close(fd[1]);
        printf("parent is reading FromPipe \n");
        nbytes=read(fd[0],readBuffer, sizeof(readBuffer));
        printf("Received String %s\n",readBuffer);
        
    }
    
    
}
