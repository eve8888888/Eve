#define _CRT_SECURE_NO_WARNINGS 1
#include<stdio.h>
#include<stdlib.h>
int main() {
	char str[] = "heldsdzzzawdalo6666555world";
	printf("%d ", strlen(str));
	printf("%d ", feidigui(str));
	printf("%d ", digui(str));
	system("pause");
}
int feidigui(char * string) {
	char c = EOF;
	int i = 0;
	while (c != '\0')
	{
		c = string[i];
		i++;
	}
	return i - 1;
}
int digui(char * string) {
	int static i = 0;
	if (string == NULL || *string == '\0') {
		return i;
	}
	digui(string + 1);
	i++;
}
