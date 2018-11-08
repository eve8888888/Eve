#define _CRT_SECURE_NO_WARNINGS 1
#include<stdio.h>
#include<stdlib.h>
void swap(int *x, int *y) {
	int temp = 0;
	temp = *x;
	*x = *y;
	*y = temp;
}
int main() {
	int x = 40;
	int y = 30;
	int temp = 1;
	if (x > y) {
		swap(&x, &y);
	}
	while (temp != 0)
	{
		temp = y % x;
		if (temp == 0) {
			printf("%d",x);
		}
		else{
			y = x;
			x = temp;
		}
	}
	system("pause");
	return 0;
}
