#define _CRT_SECURE_NO_WARNINGS 1
#include<stdio.h>
#include<stdlib.h>
int  fun() {
	int sum = 0;
	int ret = 1;
	int j;
	int k;
	for (j = 1; j <= 3; j++) {
		for (k = 1; k <= j; k++) {
			ret *= k;
		}
		sum += ret;
		ret = 1;
	}
	return sum;
}
int main() {
	printf("%d \n", fun());
	system("pause");
	return 0;
}
