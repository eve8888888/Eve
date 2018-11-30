document.write("<table border=1 >")

for(i=1;i<=r;i++)

{

    document.write("<tr>")

    for(j=1;j<=c;j++)

        document.write("<td>"+Math.pow(j,i))  //输出数组

    document.write("</tr>")

}

document.write("</table>")