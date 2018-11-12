#define _CRT_SECURE_NO_WARNINGS 1
#include<stdio.h>
#include<stdlib.h>
#include<time.h>
void menu() {
	printf("***********************************\n");
	printf("************ 1.猜数字 *************\n");
	printf("************ 2.退  出 *************\n");
	printf("***********************************\n");
}

void game() {
	int num = rand() % 100 + 1;
	int n = 0;
	printf("please guess number\n");
	while (1) {
		scanf("%d",&n);
		if (n > num) {
			printf("猜大了\n");
		}
		else if (n < num) {
			printf("猜小了\n");
		}
		else
		{
			printf("猜对了\n");
			break;
		}
	}
}
int main() {
	int input = 0;
	srand((unsigned int)time(NULL));
	do {
		menu();
		scanf("%d", &input);
		switch (input)
		{
		case 1:
			game();
			break;
		case 2:
			printf("exit game\n");
			break;
		default:
			printf("input error\n");
		}
	} while (input != 2);
	return 0;
}