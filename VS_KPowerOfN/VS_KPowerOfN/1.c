#define _CRT_SECURE_NO_WARNINGS 1
#include<stdio.h>
#include<stdlib.h>

int main() {
	printf("%d ", K_PowerOf_N(3, 4));
	system("pause");
}
int K_PowerOf_N(int n,int k) {
	if (k == 1) {
		return n;
	}
	else {
		return K_PowerOf_N(n, k - 1) * n;
	}
}