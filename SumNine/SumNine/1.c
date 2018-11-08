#define _CRT_SECURE_NO_WARNINGS 1
#include<stdio.h>
#include<stdlib.h>
int main() {
	int sum = 0;
	for (int i = 1; i <= 100; i++) {

			if (i % 10 == 9) {
				sum++;
			}
			if (i / 10 == 9) {
				sum++;
			}
	}
	printf("%d ", sum);
	system("pause");
	return 0;
}