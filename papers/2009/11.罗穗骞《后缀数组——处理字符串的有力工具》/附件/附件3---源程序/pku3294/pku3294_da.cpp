#include "stdio.h"
#include "string.h"
#define maxn 100101

int wa[maxn],wb[maxn],wv[maxn],ws[maxn];
int cmp(int *r,int a,int b,int l)
{return r[a]==r[b]&&r[a+l]==r[b+l];}
void da(int *r,int *sa,int n,int m)
{
     int i,j,p,*x=wa,*y=wb,*t;
     for(i=0;i<m;i++) ws[i]=0;
     for(i=0;i<n;i++) ws[x[i]=r[i]]++;
     for(i=1;i<m;i++) ws[i]+=ws[i-1];
     for(i=n-1;i>=0;i--) sa[--ws[x[i]]]=i;
     for(j=1,p=1;p<n;j*=2,m=p)
     {
       for(p=0,i=n-j;i<n;i++) y[p++]=i;
       for(i=0;i<n;i++) if(sa[i]>=j) y[p++]=sa[i]-j;
       for(i=0;i<n;i++) wv[i]=x[y[i]];
       for(i=0;i<m;i++) ws[i]=0;
       for(i=0;i<n;i++) ws[wv[i]]++;
       for(i=1;i<m;i++) ws[i]+=ws[i-1];
       for(i=n-1;i>=0;i--) sa[--ws[wv[i]]]=y[i];
       for(t=x,x=y,y=t,p=1,x[sa[0]]=0,i=1;i<n;i++)
       x[sa[i]]=cmp(y,sa[i-1],sa[i],j)?p-1:p++;
     }
     return;
}
int rank[maxn],height[maxn];
void calheight(int *r,int *sa,int n)
{
     int i,j,k=0;
     for(i=1;i<=n;i++) rank[sa[i]]=i;
     for(i=0;i<n;height[rank[i++]]=k)
     for(k?k--:0,j=sa[rank[i]-1];r[i+k]==r[j+k];k++);
     return;
}

int r[maxn],sa[maxn];
int who[maxn],yes[101]={0},ii=0;
int len,n,nn;
int ans[maxn],ss;
int check(int mid)
{
    int i,j,k,t,s,flag=0;
    for(i=2;i<=len;i=j+1)
    {
      for(;height[i]<mid && i<=len;i++);
      for(j=i;height[j]>=mid;j++);
      if(j-i+1<nn) continue;
      ii++;s=0;
      for(k=i-1;k<j;k++)
      if((t=who[sa[k]])!=0)
      if(yes[t]!=ii) yes[t]=ii,s++;
      if(s>=nn) if(flag) ans[++ss]=sa[i-1];
      else ans[ss=1]=sa[i-1],flag=1;
    }
    return(flag);
}
char st[1010];
int main()
{
    int i,j,k,flag=0,min,mid,max;
    scanf("%d",&n);
    while(n!=0)
    {
      len=0;
      for(i=1;i<=n;i++)
      {
        scanf("%s",st);
        k=strlen(st);
        for(j=0;j<k;j++)
        {
          r[j+len]=st[j]+100;
          who[j+len]=i;
        }
        r[len+k]=i;
        who[len+k]=0;
        len+=k+1;
      }
      len--;
      r[len]=0;
      da(r,sa,len+1,227);
      calheight(r,sa,len);
      height[len+1]=-1;
      nn=n/2+1;
      min=1;max=1000;
      while(min<=max)
      {
        mid=(min+max)>>1;
        if(check(mid)) min=mid+1;
        else max=mid-1;
      }
      if(flag) printf("\n");
      else flag=1;
      if(max==0) printf("?\n");
      else for(i=1;i<=ss;i++)
      {
        k=ans[i];
        for(j=0;j<max;j++) printf("%c",r[k+j]-100);
        printf("\n");
      }
      scanf("%d",&n);
    }
    return 0;
}
