#define _CRT_SECURE_NO_WARNINGS 1
#include<stdio.h>
#include<stdlib.h>
int main() {
	char password[20] = "123456";
	int n = 3;
	char pwd[20] = "";
	for (int i = 0; i < 3;i++){
		printf("请输入密码：(剩余%d次)\n", 2 - i);
		scanf("%s", pwd);
		if (strcmp(pwd, password) != 0) {
			
			if (i == 2) {
				printf("已经错误3次，退出程序\n");
				break;
			}
			printf("密码错误，请重新输入：\n");
		}
		else 
		{
			printf("密码正确！\n");
			break;
		}

	}
	system("pause");
	return 0;
}
