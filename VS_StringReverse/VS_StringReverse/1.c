#define _CRT_SECURE_NO_WARNINGS 1
#include<stdio.h>
#include<stdlib.h>

void reverse_string(char * string) {
	char c = EOF;
	int i = 0;
	while (c != '\0')
	{
		c = string[i];
		i++;
	}
	if (i == 1) {
		return string;
	}
	char temp = string[0];
	string[0] = string[i - 2];
	string[i - 2] = '\0';
	reverse_string(string + 1);
	string[i - 2] = temp;
}
int main() {
	char str[] = "hello world";
	reverse_string(str);
	printf("%s", str);
	system("pause");
}
