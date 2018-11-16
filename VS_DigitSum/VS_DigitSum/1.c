#define _CRT_SECURE_NO_WARNINGS 1
#include<stdio.h>
#include<stdlib.h>
int main() {
	printf("%d \n", DigitSum(1729));
	system("pause");
}
int DigitSum(int n) {
	int sum = 0;
	while (n >= 1) {
		sum += n % 10;
		n /= 10;
	}
	return sum;
}