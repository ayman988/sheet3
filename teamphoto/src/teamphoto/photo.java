package teamphoto;

import java.util.Scanner;

public class photo {

	static int p[][]=new int[50][2];
	static int s,i1,j1,i2,j2,varx,vary;
public static void max(char[][]a,int x,int y,char team) {

	if(x!=a.length&&y!=a[0].length&&a[x][y]==team) {	
		varx=x;
		vary=y;
	 max(a,x+1,y,team);
	 max(a,x,y+1,team);
	}
	if(x==0||y==a[0].length) {p[s][0]=x;
		p[s][1]=y-1;
		s++;}
	else if(y==0||x==a.length) {p[s][0]=x-1;
	p[s][1]=y;
	s++;}
	else if(a[x-1][y]==team&&x-1>=i1&&y==vary) {p[s][0]=x-1;
	p[s][1]=y;
	s++;}
	else if(a[x][y-1]==team&&y-1>=j1&&x==varx) {p[s][0]=x;
p[s][1]=y-1;
s++;}


}

public static void max2(char[][]a,int x,int y,char team) {

	if(x!=a.length&&y>=0&&a[x][y]==team) {	
		varx=x;
		vary=y;
	 max2(a,x+1,y,team);
	 max2(a,x,y-1,team);
	}
	if(x==0||y<0) {p[s][0]=x;
		p[s][1]=y+1;
		s++;}
	else if(y==a[0].length-1||x==a.length) {p[s][0]=x-1;
	p[s][1]=y;
	s++;}
	else if(a[x-1][y]==team&&x-1>=i1&&y==vary) {p[s][0]=x-1;
	p[s][1]=y;
	s++;}
	else if(a[x][y+1]==team&&y+1<=j1&&x==varx) {p[s][0]=x;
p[s][1]=y+1;
s++;}


}
public static int[][] findplayer(char[][]a,int team,int threshold){
	 int i,j,temp,f,k,xm,yl,yr,co=0,row=0;
	int r=a.length;
	int c=a[0].length;
	int[][] points=new int[50][2];
	 char player=(char)(team+'0');
	   for(i=0;i<r;i++) {
		   for(j=0;j<c;j++) {
			   if(a[i][j]==player) {
				   s=0;
				   i1=i;
				   j1=j;
				   co=0;
				   for(k=0;k<50;k++) {p[k][0]=0;
				   p[k][1]=0;}
				   max(a,i,j,player);
			   for(f=0;f<s+2;f++) {
				   if(p[f][0]>p[f+1][0]) {temp=p[f][0];
				   p[f][0]=p[f+1][0];
				   p[f+1][0]=temp;}}
				   for(f=0;f<s+2;f++) {
					   if(p[f][1]>p[f+1][1]) {temp=p[f][1];
					   p[f][1]=p[f+1][1];
					   p[f+1][1]=temp;}}
				   xm=p[s+2][0];
				   yr=p[s+2][1];
				   for(k=0;k<50;k++) {p[k][0]=0;
				   p[k][1]=60;}
				   s=0;
				   max2(a,i,j,player);
			   for(f=0;f<s+2;f++) {
				   if(p[f][0]>p[f+1][0]) {temp=p[f][0];
				   p[f][0]=p[f+1][0];
				   p[f+1][0]=temp;}}
				   for(f=0;f<s+2;f++) {
					   if(p[f][1]<p[f+1][1]) {temp=p[f][1];
					   p[f][1]=p[f+1][1];
					   p[f+1][1]=temp;}}
				   if(p[s+2][0]>xm) {xm=p[s+2][0];}
				   yl=p[s+2][1];
				 for(k=i;k<=xm;k++) {
					 for(f=yl;f<=yr;f++) {
						 if(a[k][f]==player) {co++;}}}
				if(co*4>=threshold) {
					 for(k=i;k<=xm;k++) {
						 for(f=yl;f<=yr;f++) {
							 if(a[k][f]==player) {a[k][f]='z';}}}
					 points[row][0]=yl+yr+1;
					 points[row][1]=i+xm+1;
					 }
				}}}
	   for(i=0;i<row;i++) {
		   for(j=0;j<row-1;j++) {
			   if(points[j][0]>points[j+1][1]) {
				   temp=points[j][0];
				   points[j][0]=points[j+1][1];
				   points[j+1][1]=temp;}}}
	   co=0;
	  for(i=0;i<row-1;i++) {
		  co=0;
		  while(points[i][0]==points[i+1][0]) {
			  co++;}
		  for(j=i;j<i+co-1;j++) {
			  if(points[j][1]>points[j+1][1]) {
				  temp=points[j][1];
				  points[j][1]=points[j+1][1];
				  points[j+1][1]=temp;
			  }
		  }
	  }
	   
	   return points;
	   
	   
			   }
		   
	   
	
	


public static void main(String[] agrs) {
	  Scanner input=new Scanner(System.in);
	  int r,c,i,j,temp,f,k,xm,yl,yr,co=0;
	  
	 
	  r=input.nextInt();
	  c=input.nextInt();
	  char a[][]=new char[r][c];
	  int team,threshold;
	 for(i=0;i<r;i++) {
		 for(j=0;j<c;j++) {a[i][j]=input.next(".").charAt(0);}}
	 team=input.nextInt();
	 threshold=input.nextInt();
	 char player=(char)(team+'0');
   for(i=0;i<r;i++) {
	   for(j=0;j<c;j++) {
		   if(a[i][j]==player) {
			   s=0;
			   i1=i;
			   j1=j;
			   co=0;
			   for(k=0;k<50;k++) {p[k][0]=0;
			   p[k][1]=0;}
			   max(a,i,j,player);
		   for(f=0;f<s+2;f++) {
			   if(p[f][0]>p[f+1][0]) {temp=p[f][0];
			   p[f][0]=p[f+1][0];
			   p[f+1][0]=temp;}}
			   for(f=0;f<s+2;f++) {
				   if(p[f][1]>p[f+1][1]) {temp=p[f][1];
				   p[f][1]=p[f+1][1];
				   p[f+1][1]=temp;}}
			   xm=p[s+2][0];
			   yr=p[s+2][1];
			   for(k=0;k<50;k++) {p[k][0]=0;
			   p[k][1]=60;}
			   s=0;
			   max2(a,i,j,player);
		   for(f=0;f<s+2;f++) {
			   if(p[f][0]>p[f+1][0]) {temp=p[f][0];
			   p[f][0]=p[f+1][0];
			   p[f+1][0]=temp;}}
			   for(f=0;f<s+2;f++) {
				   if(p[f][1]<p[f+1][1]) {temp=p[f][1];
				   p[f][1]=p[f+1][1];
				   p[f+1][1]=temp;}}
			   if(p[s+2][0]>xm) {xm=p[s+2][0];}
			   yl=p[s+2][1];
			 for(k=i;k<=xm;k++) {
				 for(f=yl;f<=yr;f++) {
					 if(a[k][f]==player) {co++;}}}
			if(co*4>=threshold) {
				 for(k=i;k<=xm;k++) {
					 for(f=yl;f<=yr;f++) {
						 if(a[k][f]==player) {a[k][f]='z';}}}
				 System.out.println((yr+1+yl)+" "+(i+xm+1));}
			}}}		 
			
		
	   
}
	
	
}
