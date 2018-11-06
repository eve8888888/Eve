#define _CRT_SECURE_NO_WARNINGS 1
#include<stdio.h>
#include<stdlib.h>
int main() {
	int max;
	int n[10] = { 1,2,3,4,5,6,7,8,9,10 };
	for (int i = 0; i < sizeof(n) / sizeof(n[0]); i++){
		max = 0;
		if (n[i] > max) {
			max = n[i];
		}
	}
	printf("max = %d\n", max);
	system("pause");
	return 0;
}
