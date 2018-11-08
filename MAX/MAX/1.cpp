#define _CRT_SECURE_NO_WARNINGS 1
#include<stdio.h>
#include<stdlib.h>
int main() {
	int max = 0;;
	int n[10] = { 1,2,3,4,15,6,17,8,9,10 };
	for (int i = 0; i < sizeof(n) / sizeof(n[0]); i++){
		max = n[i] > max ? n[i] : max;
	}
	printf("max = %d\n", max);
	system("pause");
	return 0;
}
