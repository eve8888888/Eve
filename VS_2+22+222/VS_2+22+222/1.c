#define _CRT_SECURE_NO_WARNINGS 1
#include<stdio.h>
#include<stdlib.h>

int main() {
	int sum = 2;
	for (int i = 0; i < 4; i++) {
		sum += sum * 10 + 2;
	}
	printf("%d", sum);
	system("pause");
	return 0;
}