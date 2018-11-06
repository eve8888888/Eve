#define _CRT_SECURE_NO_WARNINGS 1
#include<stdio.h>
#include<stdlib.h>
#include<math.h>
int main() {
	float sum = 0.0;
	for (int i = 1; i <= 100; i++) {
		sum += (1.0 / i) * pow((-1),i - 1);
	}
	printf("%f", sum);
	system("pause");
	return 0;
}