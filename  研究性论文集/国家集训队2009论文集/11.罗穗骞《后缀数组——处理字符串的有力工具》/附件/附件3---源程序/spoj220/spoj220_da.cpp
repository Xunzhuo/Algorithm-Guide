#include "stdio.h"
#include "string.h"
#define maxn 100011

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
int who[maxn],min[11],max[11];
int len,n;
int check(int mid)
{
    int i,j,k;
    for(i=2;i<=len;i=j+1)
    {
      for(;height[i]<mid && i<=len;i++);
      for(j=i;height[j]>=mid;j++);
      if(j-i+1<n) continue;
      for(k=1;k<=n;k++) {min[k]=1000000;max[k]=-1;}
      for(k=i-1;k<j;k++)
      {
        if(sa[k]<min[who[sa[k]]]) min[who[sa[k]]]=sa[k];
        if(sa[k]>max[who[sa[k]]]) max[who[sa[k]]]=sa[k];
      }
      for(k=1;k<=n;k++) if(max[k]-min[k]<mid) break;
      if(k>n) return 1;
    }
    return 0;
}
char st[110];
int main()
{
    int i,j,k,min,mid,max,nn;
    scanf("%d",&nn);
    while(nn-->0)
    {
      scanf("%d",&n);
      len=0;
      for(i=1;i<=n;i++)
      {
        scanf("%s",st);
        k=strlen(st);
        for(j=0;j<k;j++)
        {
          r[j+len]=st[j]+10;
          who[j+len]=i;
        }
        r[len+k]=i;
        who[len+k]=0;
        len+=k+1;
      }
      len--;
      r[len]=0;
      da(r,sa,len+1,138);
      calheight(r,sa,len);
      height[len+1]=-1;
      min=1;max=5000;
      while(min<=max)
      {
        mid=(min+max)>>1;
        if(check(mid)) min=mid+1;
        else max=mid-1;
      }
      printf("%d\n",max);
    }
    return 0;
}
