#include "stdio.h"
#include "string.h"
#define maxn 20203

#define F(x) ((x)/3+((x)%3==1?0:tb))
#define G(x) ((x)<tb?(x)*3+1:((x)-tb)*3+2)
int wa[maxn],wb[maxn],wv[maxn],ws[maxn];
int c0(int *r,int a,int b)
{return r[a]==r[b]&&r[a+1]==r[b+1]&&r[a+2]==r[b+2];}
int c12(int k,int *r,int a,int b)
{if(k==2) return r[a]<r[b]||r[a]==r[b]&&c12(1,r,a+1,b+1);
 else return r[a]<r[b]||r[a]==r[b]&&wv[a+1]<wv[b+1];}
void sort(int *r,int *a,int *b,int n,int m)
{
     int i;
     for(i=0;i<n;i++) wv[i]=r[a[i]];
     for(i=0;i<m;i++) ws[i]=0;
     for(i=0;i<n;i++) ws[wv[i]]++;
     for(i=1;i<m;i++) ws[i]+=ws[i-1];
     for(i=n-1;i>=0;i--) b[--ws[wv[i]]]=a[i];
     return;
}
void dc3(int *r,int *sa,int n,int m)
{
     int i,j,*rn=r+n,*san=sa+n,ta=0,tb=(n+1)/3,tbc=0,p;
     r[n]=r[n+1]=0;
     for(i=0;i<n;i++) if(i%3!=0) wa[tbc++]=i;
     sort(r+2,wa,wb,tbc,m);
     sort(r+1,wb,wa,tbc,m);
     sort(r,wa,wb,tbc,m);
     for(p=1,rn[F(wb[0])]=0,i=1;i<tbc;i++)
     rn[F(wb[i])]=c0(r,wb[i-1],wb[i])?p-1:p++;
     if(p<tbc) dc3(rn,san,tbc,p);
     else for(i=0;i<tbc;i++) san[rn[i]]=i;
     for(i=0;i<tbc;i++) if(san[i]<tb) wb[ta++]=san[i]*3;
     if(n%3==1) wb[ta++]=n-1;
     sort(r,wb,wa,ta,m);
     for(i=0;i<tbc;i++) wv[wb[i]=G(san[i])]=i;
     for(i=0,j=0,p=0;i<ta && j<tbc;p++)
     sa[p]=c12(wb[j]%3,r,wa[i],wb[j])?wa[i++]:wb[j++];
     for(;i<ta;p++) sa[p]=wa[i++];
     for(;j<tbc;p++) sa[p]=wb[j++];
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

int r[maxn*3],sa[maxn*3];
int who[maxn],yes[101]={0},ii=0;
int len,n;
int check(int mid)
{
    int i,j,k,t,s;
    for(i=2;i<=len;i=j+1)
    {
      for(;height[i]<mid && i<=len;i++);
      for(j=i;height[j]>=mid;j++);
      if(j-i+1<n) continue;
      ii++;s=0;
      for(k=i-1;k<j;k++)
      if((t=who[sa[k]])!=0)
      if(yes[t]!=ii) yes[t]=ii,s++;
      if(s>=n) return 1;
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
          r[j+len]=st[j]+200;
          who[j+len]=i;
        }
        r[len+k]=2*i-1;
        who[len+k]=0;
        len+=k+1;
        for(j=0;j<k;j++)
        {
          r[j+len]=st[k-1-j]+200;
          who[j+len]=i;
        }
        r[len+k]=2*i;
        who[len+k]=0;
        len+=k+1;
      }
      len--;
      r[len]=0;
      dc3(r,sa,len+1,328);
      calheight(r,sa,len);
      height[len+1]=-1;
      min=1;max=100;
      while(min<=max)
      {
        mid=(min+max)>>1;
        if(check(mid)) min=mid+1;
        else max=mid-1;
      }
      if(n==1) max=len/2;
      printf("%d\n",max);
    }
    return 0;
}
