#define _CRT_SECURE_NO_WARNINGS 1
#include<stdio.h>
#include<stdlib.h>
int main() {
	printf("%d  \n", digui(30));
	printf("%d  ", feidigui(30));
	system("pause");
}
int digui(int n) {
	if (n == 1) {
		return 1;
	}
	if (n == 2) {
		return 1;
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