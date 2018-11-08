#define _CRT_SECURE_NO_WARNINGS 1
#include<stdio.h>
#include<stdlib.h>

int main() {
	int n = 14;
	for (int i = 0; i < n; i++) {
		for (int j = 0; j < n - i; j++) {
			printf(" ");
		}
		for (int k = 0; k <= 2 * i; k++) {
			printf("*");
		}
		printf("\n");
	}
	for (int i = 0; i <= n; i++) {
		for (int j = 0; j < i; j++) {
			printf(" ");
		}
		for (int k = 0; k <= (n - i) * 2; k++) {
			printf("*");
		}
		printf("\n");
	}
	system("pause");
	return 0;
}

