#include <stdio.h>
#include <unistd.h>
#include <sys/types.h>
#include <wait.h>
#include <cstdlib>
#include <openssl/md5.h>
#include <cstring>


#define BUFFER_SIZE 1000
#define READ_END 0
#define WRITE_END 1

char * calculateMd5(const char *filename) {
	unsigned char c[MD5_DIGEST_LENGTH];
	int i;
	MD5_CTX mdContext;
	int bytes;
	unsigned char data[1024];
	char *filemd5 = (char*) malloc(33 *sizeof(char));

	FILE *inFile = fopen (filename, "rb");
	if (inFile == NULL) {
		perror(filename);
		return 0;
	}


	MD5_Init (&mdContext);

	while ((bytes = fread (data, 1, 1024, inFile)) != 0)

	MD5_Update (&mdContext, data, bytes);

	MD5_Final (c,&mdContext);

	for(i = 0; i < MD5_DIGEST_LENGTH; i++) {
		sprintf(&filemd5[i*2], "%02x", (unsigned int)c[i]);
	}

	printf("calculated md5:%s ", filemd5);
	printf (" %s\n", filename);
	fclose (inFile);
	return filemd5;
}
 

int main(int argc, char **argv)
{
    int  fd[2];
    char writeMessage[BUFFER_SIZE];
  	char readMessage[BUFFER_SIZE];
    int pid1, pid2;
    char c[1000];
    
    
    if (pipe(fd) == -1)
  	{
    	fprintf(stderr, "pipe failed");
  	}

    pid1 = fork(); // first fork
        
    if(pid1 < 0)
    {
        printf("fork failed");
    }

    if(pid1 > 0) //parent
    {	
    	wait(NULL);
    	pid2 = fork(); //second fork
    	if(pid2 == 0) //child 2
    	{	
    		printf("Child 2 reading...\n");
    		close(fd[WRITE_END]);
    		read(fd[READ_END], readMessage, sizeof(readMessage));
    		close(fd[READ_END]);
    		printf("Message: %s\n\n", readMessage);

    		printf("Child 2 writing...\n\n");
    		FILE *ffw = fopen("OperatingSystemNotes2.txt", "w");
    		fprintf(ffw,"%s\n", readMessage);
    		fclose(ffw);

    		close(fd[READ_END]);
    		write(fd[WRITE_END], writeMessage, sizeof(writeMessage));
    		close(fd[WRITE_END]);

    		char * file1 = calculateMd5("OperatingSystemNotes.txt");
    		char * file2 = calculateMd5("OperatingSystemNotes2.txt");
 
        	if (!strcmp(file1, file2)) 
        	{
            	printf("\nMATCHED\n");
        	} 
        	else 
        	{
            	printf("\nNOT MATCHED\n");
        	}
    	}
    }

    if(pid1 == 0) //child 
    {	
        char c;
        int i=0;
        printf("Child 1 reading...\n");
        FILE *ffr = fopen("OperatingSystemNotes.txt", "r");
        if (ffr == NULL) 
        {
            printf("file failed\n");
            return 0;
        }
        for(i=0; (c = fgetc(ffr)) != EOF; i++){
            writeMessage[i]=c;
        }
        writeMessage[i-1]=NULL;

        fclose(ffr);

    	close(fd[READ_END]);
    	write(fd[WRITE_END], writeMessage, sizeof(writeMessage));
    	close(fd[WRITE_END]);
    	printf("Data : %s\n\n", writeMessage);
    }
        
    return(0);
}
