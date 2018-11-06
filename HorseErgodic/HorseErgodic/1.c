#define _CRT_SECURE_NO_WARNINGS 1
#include<stdio.h>
#include<stdlib.h>
#include<stdio.h>
int n = 5;
int m = 4;
int count = 0;
int fx[8] = { 1,2,2,1,-1,-2,-2,-1 };
int fy[8] = { 2,1,-1,-2,-2,-1,1,2 };
int a[5][4] = { 0 };

int check(int x, int y)
{
	if (x >= 0 && y >= 0 && x  < n && y  < m && a[x][y] == 0)
		return 1;
	return 0;
}

void output()
{
	int i, j;
	count++;
	printf("\ncount=%d", count);
	for (i = 0; i<n; i++)
	{
		printf("\n");
		for (j = 0; j<m; j++)
			printf("%d\t", a[i][j]);
	}
}

void find(int x, int y, int dep)
{
	int i, xx, yy;
	for (i = 0; i<8; i++)
	{
		xx = x + fx[i];
		yy = y + fy[i];
		if (check(xx, yy) == 1)
		{
			a[xx][yy] = dep;
			if (dep == n*m)
				output();
			else
				find(xx, yy, dep + 1);
			a[xx][yy] = 0;
		}
	}
}

int main()
{
	int x, y;
	printf("input x,y:");
	scanf_s("%d,%d", &x, &y);
	if (x>n || y>m || x<0 || y<0)
	{
		printf("input error!\n");
		return 1;
	}
	a[x][y] = 1;
	find(x, y, 2);
	if (count == 0)
		printf("no solution!\n");
	else
		printf("\ncount=%d\n", count);
	system("pause");
	return 0;
}
