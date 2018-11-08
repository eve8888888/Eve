#define _CRT_SECURE_NO_WARNINGS 1
#include<stdio.h>
#include<stdlib.h>

int binarySearch(int a[]) {
	int left = 0;
	int right = sizeof(a)/sizeof(a[0]);
	//printf("%d ", right);
	return right;
}
int main() {
	int a[] = { 1,2,3,4,5,6,7,8,9,10 };
	printf("%d", binarySearch(a));

	system("pause");
	return 0;
}