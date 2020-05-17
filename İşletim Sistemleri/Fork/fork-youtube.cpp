#include <stdio.h>
#include <unistd.h>
#include <wait.h>

int main() {
	int pid;
	pid=fork();
	if(pid>0)
	{
		//parent
		wait(NULL);
		printf("parent: %d benim pid:%d\n",pid,getpid());
	}
	if(pid==0)
	{
		//child
		printf("child: %d benim pid:%d\n",pid,getpid());
	}
	if (pid<0)
	{
		//error
	}
}