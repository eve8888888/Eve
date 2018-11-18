#define _CRT_SECURE_NO_WARNINGS 1
#include<stdio.h>
#include<stdlib.h>
int count = 0;
int main() {
	//printf("%d  \n", digui(40));
	printf("%d  ", feidigui(40));
	//printf("\ncount = %d", count);
	system("pause");
}
int digui(int n) {
	if (n == 1) {
		return 1;
	}
	if (n == 2) {
		return 1;
	}
	if (n == 3) {
		count++;
	}
	return digui(n - 1) + digui(n - 2);
}

int feidigui(int n) {
	if (n == 1) {
		return 1;
	}
	if (n == 2) {
		return 1;
	}

	int pprev = 1;
	int prev = 1;
	int sum = 0;
	for (int i = 3; i <= n; i++) {
		sum = prev + pprev;
		pprev = prev;
		prev = sum;
	}
	return sum;
}