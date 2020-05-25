#include "read_file.h"
#include <iostream>
#include <sstream>
#include <string>
#include <stdlib.h>


int main(int argc, char *argv[])
{
        
        char* string = NULL;

	if(argc > 2){
		std::cout << "Error: One File At A Time" << std::endl;
		return -1;
	}

        string = read_file(argv[1]);

        if(string != nullptr){
                std::cout << string << std::endl;
        }
        else{
                std::cout << "Error: File Not Found" << std::endl;
        }

        delete [] string;

        return 0;
}
