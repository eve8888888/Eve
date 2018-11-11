#define _CRT_SECURE_NO_WARNINGS 1
#include<stdio.h>
#include<stdlib.h>

void output(int n) {
	for (int i = 1; i <= n; i++) {
		for (int j = 1; j <= i; j++) {
			printf("%d * %d = %2d  ", j, i, i*j);
		}
		printf("\n");
	}
}
int main() {
	int n = 0;
	printf("输入乘法口诀表的阶数：");
	scanf("%d", &n);
	output(n);
	system("pause");
	return 0;
}