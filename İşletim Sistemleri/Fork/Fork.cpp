#include  <stdio.h>
#include  <sys/types.h>
int main()
{
    
    fork();
    fork();
    fork();
    fork();
    printf("hello from %d my parent %d \n",getpid());
    return 0;
}
