#define _CRT_SECURE_NO_WARNINGS 1
#include<stdio.h>

void swap(int *x, int *y) {
	int temp = 0;
	temp = *x;
	*x = *y;
	*y = temp;
}

int main() {
	int x = 2;
	int y = 1;
	int z = 3;

	if (x < y) {
		swap(&x, &y);
	}
	if (x < z) {
		swap(&x, &z);
	}
	if (y < z) {
		swap(&y, &z);
	}
	printf("%d %d %d", x, y, z);
	return 0;
}
