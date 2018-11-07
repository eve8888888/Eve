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
int main() {
	int t = 0;
	printf("%d \n", fun(4));
	int x = fun(4);
	//for (int i = 1; i <=3; i++) {
	//	t += fun(i);
	//}
	for (int i = 4; i > 1; i--) {
		x = x / i;
		t += x;
	}

	printf("1! + 2! + ... +10! = %d \n", t+fun(4));
	system("pause");
	return 0;
}