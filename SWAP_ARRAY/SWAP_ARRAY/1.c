#define _CRT_SECURE_NO_WARNINGS 1
#include<stdio.h>
#include<stdlib.h>
int main() {
	int a[] = { 1,2,3,4,5 };
	int b[] = { 6,7,8,9,10 };
	int i;
	for(i = 0; i < sizeof(a) / sizeof(a[0]); i++) {
		int temp = 0;
		temp = a[i];
		a[i] = b[i];
		b[i] = temp;
	}
	for (i = 0; i < sizeof(a) / sizeof(a[0]); i++) {
		printf("%d ", a[i]);
	}
	printf("\n");
	for (i = 0; i < sizeof(a) / sizeof(a[0]); i++) {
		printf("%d ", b[i]);
	}
	system("pause");
	return 0;
}