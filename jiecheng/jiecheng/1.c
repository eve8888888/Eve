#define _CRT_SECURE_NO_WARNINGS 1
#include<stdio.h>
#include<stdlib.h>
int fun(int i) {
	int sum = 1;
	for (int k = 1; k <= i; k++) {
		sum *= k;
	}
	return sum;
}
int fun_digui(int i) {
	if (i == 1) {
		return 1;
	}
	return fun_digui(i - 1) * i;
}
int main() {
	printf("%d \n", fun(10));
	printf("%d \n", fun_digui(10));
	system("pause");
	return 0;
}