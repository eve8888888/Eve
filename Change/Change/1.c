#define _CRT_SECURE_NO_WARNINGS 1
#include<stdio.h>
#include<stdlib.h>
int main() {
	int x = 10;
	int y = 20;
	//int temp = 0;
	//temp = x;
	//x = y;
	//y = temp;
	printf("x = %d  y = %d\n", x, y);

	//x = x + y;
	//y = x - y;
	//x = x - y;

	x = x ^ y;
	y = x ^ y;
	x = x ^ y;
	printf("x = %d  y = %d\n", x, y);
	system("pause");
	return 0;
}
