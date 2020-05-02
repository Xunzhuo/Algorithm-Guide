#include "stdio.h"
#define maxn 20001
#define maxm 1000002

int wa[maxn],wb[maxn],wv[maxn],ws[maxm];
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

int check(int n,int k,int mid)
{
    int i,s=1;
    for(i=1;i<=n;i++)
    if(height[i]>=mid)
    {
      s++;
      if(s>=k) return(1);
    }
    else s=1;
    return(0);
}

int r[maxn],sa[maxn];
int main()
{
    int i,k,n;
    int min,mid,max;
    scanf("%d %d",&n,&k);
    for(i=0;i<n;i++)
    {
      scanf("%d",&r[i]);
      r[i]++;
    }
    r[n]=0;
    da(r,sa,n+1,1000002);
    calheight(r,sa,n);
    min=1;max=n;
    while(min<=max)
    {
      mid=(min+max)/2;
      if(check(n,k,mid)) min=mid+1;
      else max=mid-1;
    }
    printf("%d\n",max);
    return 0;
}
