#include <sys/types.h>
#include <sys/stat.h>
#include <fcntl.h>
#include <unistd.h>
#include <stdlib.h>
#include <stdio.h>

char* read_file(const char* filename)
{
	int fd = -1;
	fd = open(filename, O_RDONLY);
	if(fd == -1){
		return nullptr;
	}
	off_t size = lseek(fd, 0, SEEK_END);
	lseek(fd, 0, SEEK_SET);
	char *file = new char[size+1]();
	read(fd, file, size+1);
	//file[size+1] = '\0';
	close(fd);
	return file;
}

